package ru.otus.java.basic.homeworks.hw12;

public class Plate {
    private final int maxFoodAmount;
    private int foodAmount;


    Plate(int maxFoodAmount) {
        this.maxFoodAmount = maxFoodAmount;
        this.foodAmount = maxFoodAmount;
    }


    public int getFoodAmount() {
        return foodAmount;
    }


    public int addFood(int amount) {
        int initFoodAmount = foodAmount;

        foodAmount += amount;
        if (foodAmount > maxFoodAmount) {
            foodAmount = maxFoodAmount;
        }

        System.out.println("В тарелку добавили " + (foodAmount - initFoodAmount) + " еды");

        return foodAmount;
    }


    public boolean takeFood(int amount) {
        if (amount < foodAmount) {
            foodAmount -= amount;
            return true;
        }

        foodAmount = 0;

        return false;
    }


    public void printFoodInfo() {
        if (foodAmount > 0) {
            System.out.println("В тарелке осталось " + foodAmount + " еды. ");
            return;
        }

        System.out.println("В тарелке больше не осталось еды. ");
    }
}
