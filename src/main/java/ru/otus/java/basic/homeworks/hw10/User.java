package ru.otus.java.basic.homeworks.hw10;

public class User {
    private String lastName;
    private String firstName;
    private String surname;
    private int birthYear;
    private String email;

    User(
        String lastName,
        String firstName,
        String surname,
        int birthYear,
        String email
    ) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.surname = surname;
        this.birthYear = birthYear;
        this.email = email;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void printInfo() {
        System.out.println("ФИО: " + lastName + " " + firstName + " " + surname);
        System.out.println("Год рождения: " + birthYear);
        System.out.println("e-mail: " + email);
    }
}
