package ru.otus.java.basic.homeworks.hw13.transport;

import ru.otus.java.basic.homeworks.hw13.terrain.Terrain;

public class ATV implements Transport {
    private double fuelAmount;
    private final int fuelAmountMax = 80;
    private final double fuelConsumption = 0.3; // Литров на 1 км


    public ATV() {
        this.fuelAmount = fuelAmountMax;
    }


    @Override
    public String getName() {
        return "Вездеход";
    }


    @Override
    public boolean move(Terrain terrain, double distance) {
        double fuelRequired = distance * fuelConsumption;

        if (fuelAmount < fuelRequired) {
            double availableDistance = fuelAmount / fuelConsumption;
            System.out.println(
                    "Вездеходу не хватит топлива, чтобы проехать " + distance +
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
