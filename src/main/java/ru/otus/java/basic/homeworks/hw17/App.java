package ru.otus.java.basic.homeworks.hw17;

public class App {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add(new Person("Иванов", "Пётр", "Сергеевич"), "89254662784");
        phoneBook.add(new Person("Петров", "Иван", "Владимирович"), "89256292784");
        phoneBook.add(new Person("Сергеев", "Николай", "Петрович"), "89059002738");
        phoneBook.add(new Person("Иванов", "Иван", "Алексеевич"), "89101172877");
        phoneBook.add(new Person("Иванов", "Иван", "Алексеевич"), "89101253545");
        phoneBook.add(new Person("Сидоров", "Александр", "Иванович"), "89159942280");

        Person targetPerson1 = new Person("Сергеев", "Николай", "Петрович");
        System.out.println(targetPerson1.getFullName() + ": " + phoneBook.find(targetPerson1));

        Person targetPerson2 = new Person("Иванов", "Иван", "Алексеевич");
        System.out.println(targetPerson2.getFullName() + ": " + phoneBook.find(targetPerson2));

        String number1 = "89059002738";
        System.out.println("Присутствует ли номер " + number1 + ": " + phoneBook.containsPhoneNumber(number1));
    }
}
