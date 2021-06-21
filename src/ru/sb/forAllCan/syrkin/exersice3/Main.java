package ru.sb.forAllCan.syrkin.exersice3;

import ru.sb.forAllCan.syrkin.Entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        System.out.println("Введите имя, фамилию человека: ");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("q")) {
            personList.add(new Person(sc.next(), sc.next()));
        }
        System.out.println(personList);
        sc.close();
    }
}
