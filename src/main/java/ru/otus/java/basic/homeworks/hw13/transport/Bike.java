package ru.otus.java.basic.homeworks.hw13.transport;

import ru.otus.java.basic.homeworks.hw13.terrain.Terrain;

public class Bike implements Transport {
    private final double driverEnergyConsumption = 2; // На 1 км


    @Override
    public String getName() {
        return "Велосипед";
    }


    @Override
    public boolean move(Terrain terrain, double distance) {
        if (terrain == Terrain.SWAMP) {
            System.out.println("Велосипед не проедет по болоту");
            return false;
        }

        return true;
    }


    @Override
    public double getDriverEnergyConsumptionPerKm() {
        return driverEnergyConsumption;
    }
}
