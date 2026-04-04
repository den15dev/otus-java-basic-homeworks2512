package ru.otus.java.basic.homeworks.hw31;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class AppTest {
    @MethodSource("elementsAfterLastOneCases")
    @ParameterizedTest
    void getElementsAfterLastOne(int[] inputArr, int[] expectedArr) {
        Assertions.assertArrayEquals(expectedArr, App.getElementsAfterLastOne(inputArr));
    }

    public static Stream<Arguments> elementsAfterLastOneCases() {
        List<Arguments> list = new ArrayList<>();

        list.add(Arguments.arguments(new int[]{3, 1, 2, 59, 1, 7, 9, 25}, new int[]{7, 9, 25}));
        list.add(Arguments.arguments(new int[]{3, 1, 2, 59, 5, 7, 1, 25}, new int[]{25}));
        list.add(Arguments.arguments(new int[]{3, 4, 2, 59, 5, 7, 1}, new int[]{}));
        list.add(Arguments.arguments(new int[]{1}, new int[]{}));

        return list.stream();
    }


    @Test
    void getElementsAfterLastOneException() {
        int[] inputArr = {2, 3, 4, 5};

        Assertions.assertThrows(RuntimeException.class, () -> App.getElementsAfterLastOne(inputArr));
    }

    @MethodSource("doesContainOneAndTwoCases")
    @ParameterizedTest
    void doesContainOneAndTwo(int[] inputArr, boolean expected) {
        Assertions.assertEquals(expected, App.doesContainOneAndTwo(inputArr));
    }

    public static Stream<Arguments> doesContainOneAndTwoCases() {
        List<Arguments> list = new ArrayList<>();

        list.add(Arguments.arguments(new int[]{1, 2}, true));
        list.add(Arguments.arguments(new int[]{1, 1}, false));
        list.add(Arguments.arguments(new int[]{2, 2}, false));
        list.add(Arguments.arguments(new int[]{1, 3}, false));
        list.add(Arguments.arguments(new int[]{1, 2, 2, 1}, true));

        return list.stream();
    }
}