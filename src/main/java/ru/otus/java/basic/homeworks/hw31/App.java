package ru.otus.java.basic.homeworks.hw31;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        int[] arr1 = {4, 23, 3, 1, 2, 59, 1, 7, 9, 25};
        int[] outArr1 = getElementsAfterLastOne(arr1);
        System.out.println(Arrays.toString(outArr1));

        int[] arr2 = {1, 2};
        System.out.println(doesContainOneAndTwo(arr2));
    }


    public static int[] getElementsAfterLastOne(int[] inputArr) {
        int lastOneIndex = -1;

        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == 1) {
                lastOneIndex = i;
            }
        }

        if (lastOneIndex == -1) {
            throw new RuntimeException("Массив не содержит единиц.");
        }

        int newSize = inputArr.length - 1 - lastOneIndex;
        if (newSize == 0) {
            return new int[0];
        }

        int[] outArr = new int[newSize];

        for (int i = 0; i < outArr.length; i++) {
            outArr[i] = inputArr[lastOneIndex + 1 + i];
        }

        return outArr;
    }


    public static boolean doesContainOneAndTwo(int[] inputArr) {
        Set<Integer> fixedSet = Set.of(1, 2);
        Set<Integer> removeSet = new HashSet<>(Set.of(1, 2));

        for (int elem : inputArr) {
            if (!fixedSet.contains(elem)) {
                return false;
            }

            removeSet.remove(elem);
        }

        return removeSet.isEmpty();
    }
}
