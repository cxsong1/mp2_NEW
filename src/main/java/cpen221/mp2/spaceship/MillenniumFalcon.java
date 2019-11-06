package cpen221.mp2.spaceship;

import cpen221.mp2.controllers.GathererStage;
import cpen221.mp2.controllers.HunterStage;
import cpen221.mp2.controllers.Spaceship;
import cpen221.mp2.graph.ImGraph;
import cpen221.mp2.models.Link;
import cpen221.mp2.models.Planet;
import cpen221.mp2.models.PlanetStatus;
import cpen221.mp2.util.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.NoSuchElementException;

/**
 * An instance implements the methods needed to complete the mission.
 */
public class MillenniumFalcon implements Spaceship {
    long startTime = System.nanoTime(); // start time of rescue phase

    @Override
    public void hunt(HunterStage state) {
        Set<Integer> traps = new HashSet<>();
        Map<PlanetStatus, Integer> visits = new HashMap<>();
        int iteration = 0;

        while (iteration++ < 10000 && !state.onKamino()) {
            PlanetStatus[] neighbours = state.neighbors();

            if (neighbours.length == 1) {
                traps.add(state.currentID());
                state.moveTo(neighbours[0].id());
                continue;
            }

            Set<PlanetStatus> good = new HashSet<>();
            Set<PlanetStatus> bad = new HashSet<>();

            for (PlanetStatus p : neighbours) {
                if (visits.containsKey(p)) {
                    if (iteration - visits.get(p) < 100) {
                        bad.add(p);
                        continue;
                    }
                }

                good.add(p);
            }

            PlanetStatus bestGood = null;
            PlanetStatus bestBad = null;
            int trapCount = 0;

            for (PlanetStatus p : good) {
                if (bestGood == null || p.signal() > bestGood.signal()) {
                    bestGood = p;
                }
            }

            for (PlanetStatus p : good) {
                if (traps.contains(p)) {
                    trapCount++;
                    continue;
                }

                if (bestGood == null || p.signal() > bestGood.signal()) {
                    bestGood = p;
                    continue;
                }

                if (bestBad == null || p.signal() > bestBad.signal()) {
                    bestBad = p;
                }
            }

            if (trapCount == neighbours.length - 1) {
                traps.add(state.currentID());
            }

            if (bestGood != null) {
                state.moveTo(bestGood.id());
                visits.put(bestGood, iteration);
            } else if (bestBad != null) {
                state.moveTo(bestBad.id());
                visits.put(bestBad, iteration);
            } else {
                for (PlanetStatus p : neighbours) {
                    if (!traps.contains(p.id())) {
                        state.moveTo(p.id());
                        visits.put(p, iteration);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void gather(GathererStage state) {
        ImGraph graph = state.planetGraph();
        List<Planet> path = graph.shortestPath(state.currentPlanet(), state.earth());

        for (Planet p : path) {
            state.moveTo(p);
        }
    }
}
