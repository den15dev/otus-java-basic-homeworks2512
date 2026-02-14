package ru.otus.java.basic.homeworks.hw18;

import java.util.EnumSet;
import java.util.HashMap;

public class PersonDataBase {
    private final HashMap<Long, Person> persons;
    private long id;
    private final EnumSet<Position> managerSet = EnumSet.of(
            Position.MANAGER,
            Position.DIRECTOR,
            Position.BRANCH_DIRECTOR,
            Position.SENIOR_MANAGER
    );


    public PersonDataBase() {
        this.persons = new HashMap<>();
        this.id = 1;
    }


    public void add(Person person) {
        person.setId(this.id);
        persons.put(id, person);
        id++;
    }


    public Person findById(Long id) {
        return persons.get(id);
    }


    public boolean isManager(Person person) {
        return managerSet.contains(person.getPosition());
    }


    public boolean isEmployee(long id) {
        Person person = persons.get(id);

        return !managerSet.contains(person.getPosition());
    }
}
