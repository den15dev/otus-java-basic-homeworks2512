package ru.otus.java.basic.homeworks.hw18;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        MyTreeMap<Integer, String> treeMap = new MyTreeMap<>();
        treeMap.put(1, "one");
        treeMap.put(2, "two");
        treeMap.put(3, "three");
        treeMap.put(4, "four");
        treeMap.put(5, "five");

        System.out.println(treeMap);
        System.out.println("Размер TreeMap: " + treeMap.size());
        System.out.println("Значение под ключом 4: " + treeMap.get(4));

        PersonDataBase db = new PersonDataBase();
        db.add(new Person("Иван", Position.DIRECTOR));
        db.add(new Person("Пётр", Position.ENGINEER));
        db.add(new Person("Сергей", Position.JUNIOR));
        db.add(new Person("Андрей", Position.MANAGER));
        db.add(new Person("Михаил", Position.PLUMBER));
        db.add(new Person("Константин", Position.SENIOR_MANAGER));
        db.add(new Person("Евгений", Position.DRIVER));

        System.out.println("Поиск по id 4: " + db.findById(4L));
        Person person1 = db.findById(4L);
        System.out.println(person1.getName() + " менеджер? " + db.isManager(person1));
        System.out.println(db.findById(6L).getName() + " сотрудник? " + db.isEmployee(6L));
    }
}
