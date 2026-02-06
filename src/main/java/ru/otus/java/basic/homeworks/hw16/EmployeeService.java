package ru.otus.java.basic.homeworks.hw16;

import java.util.ArrayList;

public class EmployeeService {
    public ArrayList<String> getEmployeeNames(ArrayList<Employee> employees) {
        ArrayList<String> names = new ArrayList<>();

        for (Employee employee : employees) {
            names.add(employee.getName());
        }

        return names;
    }


    public ArrayList<Employee> getEmployeeNamesOlderThan(
        ArrayList<Employee> employees,
        int age
    ) {
        ArrayList<Employee> oldEmployees = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getAge() >= age) {
                oldEmployees.add(employee);
            }
        }

        return oldEmployees;
    }


    public boolean isMiddleAgeExceeded(
        ArrayList<Employee> employees,
        int middleAge
    ) {
        if (employees.isEmpty()) {
            throw new IllegalArgumentException("Список сотрудников пуст.");
        }

        double currentMiddleAge;
        int ageSum = 0;

        for (Employee employee : employees) {
            ageSum += employee.getAge();
        }

        currentMiddleAge = (double) ageSum / employees.size();

        return currentMiddleAge >= middleAge;
    }


    public Employee getYoungestEmployee(ArrayList<Employee> employees) {
        Employee youngestEmployee = employees.getFirst();

        for (Employee employee : employees) {
            if (employee.getAge() < youngestEmployee.getAge()) {
                youngestEmployee = employee;
            }
        }

        return youngestEmployee;
    }
}
