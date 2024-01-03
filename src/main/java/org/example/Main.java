package org.example;


public class Main {
    public static void main(String[] args) {

        Person mom = new PersonBuilder()

                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .setSurname("Вольф")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);


        try {
            Person test = new PersonBuilder()
                    .setAge(125)
                    .setAddress("Ленина")
                    .build();
        } catch (IllegalStateException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }


        try {
            Person test = new PersonBuilder()
                    .setName("Иван")
                    .setSurname("Иванов")
                    .setAge(-100)
                    .setAddress("ул.Восстания")
                    .build();
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

}
