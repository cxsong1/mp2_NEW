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
import java.util.Stack;
import java.util.NoSuchElementException;

/**
 * An instance implements the methods needed to complete the mission.
 */
public class MillenniumFalcon implements Spaceship {
    long startTime = System.nanoTime(); // start time of rescue phase

    @Override
    public void hunt(HunterStage state) {
        Set<Integer> discovered = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> roots = new HashMap<>();

        int earth = state.currentID();

        stack.push(state.currentID());

        while (!state.onKamino()) {
            int id = stack.pop();

            if (id != earth) {
                state.moveTo(id);
            }

            PlanetStatus[] neighbors = state.neighbors();

            if (neighbors.length == 1) {
                state.moveTo(roots.get(id));
                continue;
            }

            if (!discovered.contains(id)) {
                discovered.add(id);

                for (PlanetStatus n : neighbors) {
                    if (discovered.contains(n.id())) {
                        continue;
                    }

                    stack.push(n.id());
                    roots.put(id, n.id());
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
