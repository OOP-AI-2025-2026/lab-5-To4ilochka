package ua.opnu;

import ua.opnu.model.Lecturer;
import ua.opnu.model.Person;
import ua.opnu.model.Student;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> universityPeople = List.of(
                new Person("Мельник", "Сергій", 35),
                new Student("Ткаченко", "Анна", 20, "ПМ-231", "KC91234567"),
                new Student("Поліщук", "Дмитро", 19, "ПМ-232", "KC90987654"),
                new Lecturer("Гончаренко", "Олена", 52, "Комп'ютерних наук", 31000.75),
                new Lecturer("Савченко", "Ігор", 41, "Кібербезпеки", 29500.00)
        );

        System.out.println("--- Список осіб в університеті ---");

        // Виводимо інформацію про кожну особу
        universityPeople.forEach(System.out::println);
    }
}