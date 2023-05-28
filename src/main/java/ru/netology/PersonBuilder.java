package ru.netology;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException, IllegalArgumentException {

        if (this.name == null) {
            throw new IllegalStateException("Не указано имя");
        }
        if (this.surname == null) {
            throw new IllegalStateException("Не указана фамилия");
        }
        if (this.age < 0) {
            throw new IllegalArgumentException("Не корректно указан возраст. Вы указали возраст меньше 0");
        }


        return new Person(this.name, this.surname, this.age, this.address);

    }

}
