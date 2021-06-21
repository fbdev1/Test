package ru.sb.forAllCan.syrkin;

import ru.sb.forAllCan.syrkin.Entity.Person;
import sun.tools.tree.SynchronizedStatement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        if (args.length == 2) {
            person1.setFirstName(args[0]);
            person1.setLastName(args[1]);
            System.out.println("Передан человек: " + person1.getFirstName() + " " + person1.getLastName());
        } else {
            System.out.println("Неверное количество параметров!");
        }
    }
}
