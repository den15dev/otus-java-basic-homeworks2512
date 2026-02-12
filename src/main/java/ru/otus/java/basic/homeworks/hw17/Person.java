package ru.otus.java.basic.homeworks.hw17;

import java.util.Objects;

public class Person {
    private final String lastName;
    private final String middleName;
    private final String firstName;


    Person(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }


    public String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;

        return Objects.equals(lastName, person.lastName)
                && Objects.equals(firstName, person.firstName)
                && Objects.equals(middleName, person.middleName);
    }


    @Override
    public int hashCode() {
        return Objects.hash(lastName, middleName, firstName);
    }
}
