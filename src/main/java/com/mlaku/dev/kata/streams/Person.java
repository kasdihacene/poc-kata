package com.mlaku.dev.kata.streams;

import java.util.Arrays;
import java.util.List;

public class Person {

    private String name;
    private int age;
    private Profession profession;

    public Person(String name, int age, Profession profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Profession getProfession() {
        return profession;
    }

    public boolean isSameProfession(Profession profession){
        return profession.equals(this.profession);
    }

    public static List<Person> init() {
        return Arrays.asList(
                new Person("Arnold", 22, Profession.SOFTWARE_ENGINEER),
                new Person("Phillipe", 42, Profession.ARCHITECT),
                new Person("Léa", 27, Profession.MANAGER),
                new Person("Luise", 32, Profession.NETWORK_ADMINISTRATOR),
                new Person("Yun", 56, Profession.SOFTWARE_ENGINEER)
        );
    }

    @Override
    public String toString() {
        return "{" +
                "name= " + name  + " | profession= " + profession +
                '}';
    }
}
