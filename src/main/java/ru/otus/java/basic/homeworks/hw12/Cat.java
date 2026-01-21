package ru.otus.java.basic.homeworks.hw12;

public class Cat {
    final private String name;
    private int appetite;
    public boolean isHungry;


    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isHungry = true;
    }


    public String getName() {
        return name;
    }


    public int getAppetite() {
        return appetite;
    }


    public void eatFrom(Plate plate) {
        int initAppetite = appetite;
        int initFoodAmount = plate.getFoodAmount();

        if (initAppetite == 0) {
            System.out.println("Кот " + name + " не голоден.");
            return;
        }

        System.out.print("Кормим кота " + name + ": ");

        if (initFoodAmount == 0) {
            System.out.println("Тарелка пуста, кот нисколько не поел.");
            return;
        }

        if (initFoodAmount > initAppetite) {
            plate.takeFood(initAppetite);
            appetite = 0;
            isHungry = false;
            System.out.print("Кот полностью наелся. ");
            plate.printFoodInfo();
            return;
        }

        plate.takeFood(initAppetite);
        this.appetite -= initFoodAmount;
        System.out.print("Кот покушал " + initFoodAmount + " еды, но не наелся. Ещё бы съел " + appetite + ". ");
        plate.printFoodInfo();
    }


    @Override
    public String toString() {
        return "Name: " + name + ", Appetite: " + appetite + ", isHungry: " + isHungry;
    }
}
