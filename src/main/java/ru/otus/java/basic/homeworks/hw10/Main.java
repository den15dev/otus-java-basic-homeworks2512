package ru.otus.java.basic.homeworks.hw10;

public class Main {
    public static void main(String[] args) {
        User[] users = new User[10];

        fillUsers(users);
        printInfoOfOlderThan40(users);

        System.out.println();

        Box box1 = new Box(30, 40, 50, "Серый", 10);
        box1.open();
        box1.putThing("Наушники");
        box1.putThing("Кроссовки");
        box1.putThing("Игрушка");
        box1.printInfo();
    }


    private static void fillUsers(User[] users) {
        for (int i = 0; i < users.length; i++) {
            int birthYear = (int) (2026 - 70 + Math.random() * 70);

            users[i] = new User(
                    "Фамилия" + (i + 1),
                    "Имя" + (i + 1),
                    "Отчество" + (i + 1),
                    birthYear,
                    "mail" + (i + 1) + "@example.com"
            );
        }
    }


    private static void printInfoOfOlderThan40(User[] users) {
        for (User user : users) {
            if (user.getBirthYear() < 2026 - 40) {
                user.printInfo();
                System.out.println();
            }
        }
    }
}
