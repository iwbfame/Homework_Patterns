package org.example;

import java.util.OptionalInt;
import java.util.Objects;



public class Person {
    protected final String name;
    protected final String surname;
    protected final OptionalInt age;
    private String address;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.empty();
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.address = address;
    }

    public boolean hasAge() {
        return getAge().isPresent();

    }

    public boolean hasAddress() {
        return getAddress() != null;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;

    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (age.isPresent()) {
            System.out.println("С днем рожденья! Тебе исполнилось " + (age.getAsInt() + 1) + "!");
        } else {
            System.out.println("С днем рожденья!");
        }
    }


    @Override
    public String toString() {
        return "org.example.Person{name='" + name + "', surname='" + surname + "', address='" + address + "'}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, address);
    }
    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setName(name).setSurname(surname).setAge(0).setAddress(address);
    }
}
