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
        Map<PlanetStatus, Integer> lastVisit = new HashMap<>();
        Map<PlanetStatus, Integer> visitCount = new HashMap<>();
        int iteration = 0;

        while (iteration < 1000 && !state.onKamino()) {
            PlanetStatus[] neighbours = state.neighbors();
            Set<PlanetStatus> candidates = new HashSet<>();
            Set<PlanetStatus> poorCandidates = new HashSet<>();
            
            for (PlanetStatus p : neighbours) {
                if (lastVisit.containsKey(p)) {
                    if (iteration - lastVisit.get(p) >= 40) {
                        poorCandidates.add(p);
                    }
                } else {
                    candidates.add(p);
                }
            }

            PlanetStatus best = null;
            PlanetStatus bestWorst = null;

            for (PlanetStatus p : candidates) {
                if (best == null || p.signal() > best.signal()) {
                    best = p;
                }
            }

            for (PlanetStatus p : poorCandidates) {
                if (bestWorst == null || p.signal() > bestWorst.signal()) {
                    bestWorst = p;
                }
            }

            iteration++;

            if (best != null) {
                state.moveTo(best.id());
                lastVisit.put(best, iteration);
            } else if (bestWorst != null) {
                state.moveTo(bestWorst.id());
                lastVisit.put(bestWorst, iteration);
            } else {
                state.moveTo(neighbours[0].id());
                lastVisit.put(neighbours[0], iteration);
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
