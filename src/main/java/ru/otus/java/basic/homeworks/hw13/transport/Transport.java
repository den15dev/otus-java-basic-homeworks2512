package ru.otus.java.basic.homeworks.hw13.transport;

import ru.otus.java.basic.homeworks.hw13.terrain.Terrain;

public interface Transport {
    String getName();
    boolean move(Terrain terrain, double distance);
    double getDriverEnergyConsumptionPerKm();
}
