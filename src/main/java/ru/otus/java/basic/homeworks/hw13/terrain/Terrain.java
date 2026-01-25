package ru.otus.java.basic.homeworks.hw13.terrain;

public enum Terrain {
    FOREST("лес", "лесу"),
    PLAIN("равнина", "равнине"),
    SWAMP("болото", "болоту");

    private final String name;
    private final String nameDative;

    Terrain(String name, String nameDative) {
        this.name = name;
        this.nameDative = nameDative;
    }

    public String getName() {
        return name;
    }

    public String getNameDative() {
        return nameDative;
    }
}
