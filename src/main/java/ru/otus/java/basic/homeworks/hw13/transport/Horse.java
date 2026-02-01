package ru.otus.java.basic.homeworks.hw13.transport;

import ru.otus.java.basic.homeworks.hw13.terrain.Terrain;

public class Horse implements Transport {
    private double energyAmount;
    private final int energyAmountMax = 100;
    private final double energyConsumption = 0.8; // На 1 км
    private final double driverEnergyConsumption = 0.1; // На 1 км


    public Horse() {
        this.energyAmount = energyAmountMax;
    }


    @Override
    public String getName() {
        return "Лошадь";
    }


    @Override
    public boolean move(Terrain terrain, double distance) {
        if (terrain == Terrain.SWAMP) {
            System.out.println("Лошадь не пройдёт по болоту");
            return false;
        }

        double energyRequired = distance * energyConsumption;

        if (energyAmount < energyRequired) {
            double availableDistance = energyAmount / energyConsumption;
            System.out.println(
                    "Лошади не хватит энергии, чтобы проскакать " + distance +
                            " км. Хватит лишь на " + availableDistance + " км."
            );
            return false;
        }

        energyAmount -= energyRequired;

        return true;
    }


    @Override
    public double getDriverEnergyConsumptionPerKm() {
        return driverEnergyConsumption;
    }


    public void replenishEnergy(double extraEnergyAmount) {
        if (energyAmount + extraEnergyAmount > energyAmountMax) {
            energyAmount = energyAmountMax;
            return;
        }

        energyAmount += extraEnergyAmount;
    }
}
