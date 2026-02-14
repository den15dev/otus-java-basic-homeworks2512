package ru.otus.java.basic.homeworks.hw18;

public class Person {
    private Long id;
    private final String name;
    private final Position position;


    public Person(String name, Position position) {
        this.name = name;
        this.position = position;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public String toString() {
        return name + " (" + position + ")";
    }
}
