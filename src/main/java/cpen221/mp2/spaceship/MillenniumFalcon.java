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

    private HunterStage hState = null;
    private Set<Integer> discovered = new HashSet<>();
    private int earthid = 0;

    @Override
    public void hunt(HunterStage state) {
        hState = state;
        earthid = state.currentID();

        DFS(earthid);
    }

    private void DFS(int id) {
        discovered.add(id);

        //TODO: organize neighbors so that the best one is chosen first
        for (PlanetStatus p2 : hState.neighbors()) {
            if (!discovered.contains(p2.id())) {
                if (hState.onKamino()) {
                    return;
                }
                hState.moveTo(p2.id());

                DFS(p2.id());

                if (hState.onKamino()) {
                    return;
                }
                hState.moveTo(id);
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
