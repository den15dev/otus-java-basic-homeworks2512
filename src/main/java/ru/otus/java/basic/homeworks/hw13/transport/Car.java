package ru.otus.java.basic.homeworks.hw13.transport;

import ru.otus.java.basic.homeworks.hw13.terrain.Terrain;

public class Car implements Transport {
    private double fuelAmount;
    private final int fuelAmountMax = 60;
    private final double fuelConsumption = 0.1; // Литров на 1 км


    public Car() {
        this.fuelAmount = fuelAmountMax;
    }


    @Override
    public String getName() {
        return "Автомобиль";
    }


    @Override
    public boolean move(Terrain terrain, double distance) {
        if (terrain == Terrain.SWAMP) {
            System.out.println("Автомобиль не проедет по болоту");
            return false;
        }

        if (terrain == Terrain.FOREST) {
            System.out.println("Автомобиль не проедет по лесу");
            return false;
        }

        double fuelRequired = distance * fuelConsumption;

        if (fuelAmount < fuelRequired) {
            double availableDistance = fuelAmount / fuelConsumption;
            System.out.println(
                "Автомомобилю не хватит топлива, чтобы проехать " + distance +
                " км. Хватит лишь на " + availableDistance + " км."
            );
            return false;
        }

        fuelAmount -= fuelRequired;

        return true;
    }


    @Override
    public double getDriverEnergyConsumptionPerKm() {
        return 0;
    }


    public void refuel(double extraFuelAmount) {
        if (fuelAmount + extraFuelAmount > fuelAmountMax) {
            fuelAmount = fuelAmountMax;
            return;
        }

        fuelAmount += extraFuelAmount;
    }
}
