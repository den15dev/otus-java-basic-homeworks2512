package ru.otus.java.basic.homeworks.hw16;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Lister lister = new Lister();
        ArrayList<Integer> intList = new ArrayList<>(List.of(12, 4, 23, 11, 2, 7, 18));

        ArrayList<Integer> list1 = lister.fillRange(12, 21);
        System.out.println(list1);

        System.out.println();
        ArrayList<Integer> intList1 = new ArrayList<>(intList);
        System.out.println("Сумма элементов больше 5: " + lister.getSumOfGreaterThanFive(intList1));

        System.out.println();
        ArrayList<Integer> intList2 = new ArrayList<>(intList);
        System.out.println("Заполняем список числом 3: " + lister.fillListWithNumber(3, intList2));

        System.out.println();
        ArrayList<Integer> intList3 = new ArrayList<>(intList);
        System.out.println("Увеличиваем каждый элемент на 7: " + lister.increaseElementsWithNumber(7, intList3));

        EmployeeService employeeService = new EmployeeService();
        ArrayList<Employee> employees = new ArrayList<>(List.of(
            new Employee("Александр", 23),
            new Employee("Виталий", 36),
            new Employee("Владимир", 47),
            new Employee("Геннадий", 42),
            new Employee("Пётр", 21)
        ));

        System.out.println();
        System.out.println("Имена сотрудников:\n" +
            employeeService.getEmployeeNames(employees)
        );

        System.out.println();
        System.out.println("Сотрудники старше 40 лет:\n" +
            employeeService.getEmployeeNamesOlderThan(employees, 40)
        );

        System.out.println();
        final int middleAge = 35;
        boolean isMiddleAgeExceeded = employeeService.isMiddleAgeExceeded(employees, middleAge);
        if (isMiddleAgeExceeded) {
            System.out.println("Средний возраст сотрудников превышает " + middleAge + " лет.");
        } else {
            System.out.println("Средний возраст сотрудников ниже " + middleAge + " лет.");
        }

        System.out.println();
        System.out.println("Самый молодой сотрудник: " +
            employeeService.getYoungestEmployee(employees)
        );
    }
}
