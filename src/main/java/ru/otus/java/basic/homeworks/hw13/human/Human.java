package ru.otus.java.basic.homeworks.hw13.human;

import ru.otus.java.basic.homeworks.hw13.terrain.Terrain;
import ru.otus.java.basic.homeworks.hw13.transport.Transport;

public class Human {
    public String name;
    private Transport currentTransport;
    private double energyAmount;
    private final double walkEnergyConsumption = 3; // На 1 км


    public Human(String name) {
        this.name = name;
        this.energyAmount = 100;
    }


    public void setCurrentTransport(Transport transport) {
        this.currentTransport = transport;

        if (currentTransport != null) {
            System.out.println(name + " сел в " + currentTransport.getName() + ".");
        } else {
            System.out.println(name + " покинул транспорт.");
        }
    }


    public Transport getCurrentTransport() {
        return currentTransport;
    }


    public void drive(Terrain terrain, int distance) {
        boolean driveSuccess = false;

        if (currentTransport == null) {
            double requiredEnergy = distance * walkEnergyConsumption;

            if (requiredEnergy > energyAmount) {
                double maxWalkDistance = energyAmount / walkEnergyConsumption;
                System.out.println(
                    name + " пошёл пешком по " + terrain.getNameDative() +
                    " и смог пройти только " + maxWalkDistance + " км из " + distance + "."
                );
                energyAmount = 0;
                return;
            }

            System.out.println(name + " прошёл пешком по " + terrain.getNameDative() + " " + distance + " км.");
            energyAmount -= requiredEnergy;
            return;
        }

        double requiredHumanEnergy = distance * currentTransport.getDriverEnergyConsumptionPerKm();

        if (requiredHumanEnergy > energyAmount) {
            double maxDistance = energyAmount / currentTransport.getDriverEnergyConsumptionPerKm();

            driveSuccess = currentTransport.move(terrain, maxDistance);
            if (driveSuccess) {
                System.out.println(
                    name + " смог проехать на " +
                    currentTransport.getName() + " только " + maxDistance +
                    " км из " + distance + ", на больше у него не хватило энергии."
                );
                energyAmount = 0;
            }
            return;
        }

        driveSuccess = currentTransport.move(terrain, distance);
        if (driveSuccess) {
            System.out.println(
                name + " проехал на " + currentTransport.getName() +
                " по " + terrain.getNameDative() + " " + distance + " км."
            );
            energyAmount -= currentTransport.getDriverEnergyConsumptionPerKm();
        }
    }
}
