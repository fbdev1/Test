package ru.sb.forAllCan.syrkin.exersice2;

import ru.sb.forAllCan.syrkin.Entity.Person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("Введите имя, фамилию человека: ");
        Scanner sc = new Scanner(System.in);
        person.setFirstName(sc.next());
        person.setLastName(sc.next());
        System.out.println("Введен человек: " + person.getFirstName() + " " + person.getLastName());
        sc.close();
    }
}
