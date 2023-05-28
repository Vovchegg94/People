package ru.netology;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return this.age != 0;
    }

    public boolean hasAddress() {
        return this.address != null;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {
        if (this.hasAge()) {
            return OptionalInt.of(this.age);
        } else {
            return OptionalInt.empty();
        }

    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        this.age++;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Имя: " + this.name + " Фамилия: " + this.surname);
        if (this.getAge().isPresent()) {
            info.append(" Возраст: " + this.getAge().getAsInt());
        }
        if (this.hasAddress()) {
            info.append(" Адрес: " + this.address);
        }
        return info.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }


    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(this.surname);
        child.setAge(0);
        child.setAddress(this.address);
        return child;

    }
}


