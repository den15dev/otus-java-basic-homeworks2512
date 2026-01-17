package ru.otus.java.basic.homeworks.hw11.animals;

public abstract class Animal {
    protected String species;
    protected String name;
    protected int runSpeed;
    protected int swimSpeed;
    protected int endurance;
    protected Integer runEndurancePerMeter = 1;
    protected Integer swimEndurancePerMeter;


    Animal(
        String species,
        String name,
        int runSpeed,
        int swimSpeed,
        int initEndurance,
        Integer swimEndurancePerMeter
    ) {
        this.species = species;
        this.name = name;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.endurance = initEndurance;
        this.swimEndurancePerMeter = swimEndurancePerMeter;
    }


    public double run(int distance) {
        int requiredEndurance = distance * runEndurancePerMeter;

        if (requiredEndurance > endurance) {
            System.out.println(species + " " + name + " слишком устал, чтобы пробежать" + distance + " метров.");
            return -1;
        }

        this.endurance -= requiredEndurance;
        System.out.println(species + " " + name + " пробежал " + distance +
                " метров и потратил " + requiredEndurance + " выносливости. Осталось " +
                this.endurance + ".");

        return (double) distance / runSpeed;
    }


    public double swim(int distance) {
        int requiredEndurance = distance * swimEndurancePerMeter;

        if (requiredEndurance > endurance) {
            System.out.println(species + " " + name + " слишком устал, чтобы проплыть " + distance + " метров.");
            return -1;
        }

        this.endurance -= requiredEndurance;
        System.out.println(species + " " + name + " проплыл " + distance +
                " метров и потратил " + requiredEndurance + " выносливости. Осталось " +
                this.endurance + ".");

        return (double) distance / swimSpeed;
    }


    public void info() {
        System.out.println("Животное: " + species);
        System.out.println("Кличка: " + name);
        System.out.println("Скорость бега (м/с): " + runSpeed);
        System.out.println("Скорость плаванья (м/с): " + swimSpeed);
        System.out.println("Выносливость: " + endurance);
        System.out.println("Затраты выносливости на метр бега: " + runEndurancePerMeter);
        System.out.println("Затраты выносливости на метр плаванья: " + swimEndurancePerMeter);
    }
}
