package ru.otus.java.basic.homeworks.hw17;

import java.util.*;

public class PhoneBook {
    private final Map<Person, Set<String>> phoneBook = new HashMap<>();


    public void add(Person person, String phone) {
        Set<String> personsPhones = phoneBook.get(person);

        if (personsPhones == null) {
            personsPhones = new HashSet<>();
            phoneBook.put(person, personsPhones);
        }

        personsPhones.add(phone);
    }


    public Set<String> find(Person person) {
        return phoneBook.getOrDefault(person, Collections.emptySet());
    }


    public boolean containsPhoneNumber(String phone) {
        for (Set<String> phones : phoneBook.values()) {
            if (phones.contains(phone)) {
                return true;
            }
        }

        return false;
    }
}
