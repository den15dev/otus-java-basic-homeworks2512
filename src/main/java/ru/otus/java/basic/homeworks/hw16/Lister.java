package ru.otus.java.basic.homeworks.hw16;

import java.util.ArrayList;

public class Lister {
    public ArrayList<Integer> fillRange(int min, int max) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            list.add(i);
        }

        return list;
    }


    public int getSumOfGreaterThanFive(ArrayList<Integer> list) {
        int sum = 0;

        for (Integer elem : list) {
            if (elem > 5) {
                sum += elem;
            }
        }

        return sum;
    }


    public ArrayList<Integer> fillListWithNumber(int num, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, num);
        }

        return list;
    }


    public ArrayList<Integer> increaseElementsWithNumber(int num, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + num);
        }

        return list;
    }
}
