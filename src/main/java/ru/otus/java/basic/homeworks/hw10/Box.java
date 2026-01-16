package ru.otus.java.basic.homeworks.hw10;

public class Box {
    private int sizeW, sizeH, sizeL;
    private String color;
    private boolean isOpened = false;
    private String[] things;
    private int maxThings;

    Box(int sizeW, int sizeH, int sizeL, String color, int maxThings) {
        this.sizeW = sizeW;
        this.sizeH = sizeH;
        this.sizeL = sizeL;
        this.color = color;
        this.maxThings = maxThings;
        this.things = new String[maxThings];
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void open() {
        isOpened = true;
        System.out.println("Коробка открыта.");
    }

    public void close() {
        isOpened = false;
        System.out.println("Коробка закрыта.");
    }

    public void putThing(String thing) {
        if (!isOpened) {
            System.out.println("Коробка закрыта. Чтобы положить вещь, сначала откройте её.");
            return;
        }

        if (isInBox(thing)) {
            System.out.println("Такая вещь уже есть в коробке.");
            return;
        }

        if (isFull()) {
            System.out.println("В коробке больше нет места.");
            return;
        }

        int freeIndex = getFreeIndex();
        things[freeIndex] = thing;
        System.out.println("Положили " + thing);
        System.out.println("Теперь в коробке " + countThings() + " вещей.");
    }

    public void takeThing(String thing) {
        if (!isOpened) {
            System.out.println("Коробка закрыта. Чтобы достать вещь, сначала откройте её.");
            return;
        }

        if (!isInBox(thing)) {
            System.out.println("Такой вещи нет в коробке.");
            return;
        }

        for (int i = 0; i < things.length; i++) {
            if (things[i].equals(thing)) {
                things[i] = null;
                System.out.println("Достали " + thing + " из коробки.");
            }
        }
    }

    private boolean isInBox(String newThing) {
        for (String thing : things) {
            if (thing != null && thing.equals(newThing)) {
                return true;
            }
        }

        return false;
    }

    private boolean isFull() {
        for (String thing : things) {
            if (thing == null) {
                return false;
            }
        }

        return true;
    }

    private int getFreeIndex() {
        for (int i = 0; i < things.length; i++) {
            if (things[i] == null) {
                return i;
            }
        }

        return -1;
    }

    private int countThings() {
        int count = 0;

        for (String thing : things) {
            if (thing != null) {
                count++;
            }
        }

        return count;
    }

    public void printInfo() {
        System.out.println("Размер (W x H x L): " + sizeW + " x " + sizeH + " x " + sizeL);
        System.out.println("Цвет: " + color);

        if (countThings() == 0) {
            System.out.println("Коробка пуста.");
        } else {
            System.out.println("Вещи: " + getThingsCommaSeparated());
        }
    }

    private String getThingsCommaSeparated() {
        StringBuilder sb = new StringBuilder();

        for (String thing : things) {
            if (thing != null) {
                if (!sb.isEmpty()) {
                    sb.append(", ");
                }
                sb.append(thing);
            }
        }

        return sb.toString();
    }
}
