package ru.sb.forAllCan.syrkin.exersice5;

import ru.sb.forAllCan.syrkin.Entity.Person;

import java.util.*;


public class Main {
    static List<Person> personList = new ArrayList<>();

    public static void showMenu() {
        System.out.println("====================");
        System.out.println("Menu:");
        System.out.println("1.Add");
        System.out.println("2.Show");
        System.out.println("3.SortDist");
        System.out.println("4.Exit");
        System.out.println("====================");
    }

    public static List<Person> sortedUnique(List<Person> personList) {
        List<Person> sortedList = new ArrayList<>(personList);
        if (personList.size() != 0) {
            Set<String> tempSet = new HashSet<>(sortedList.size());
            sortedList.removeIf(p -> !tempSet.add(p.getLastName()));
            sortedList.sort(Comparator.comparing(Person::getLastName, String::compareToIgnoreCase));
            System.out.println("Список отсортирован: ");
            for (Person p : sortedList) {
                System.out.println(p);
            }
        } else {
            System.out.println("Список пуст!");
        }
        return sortedList;
    }

    public static void main(String[] args) {
        showMenu();

        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext("4")) {
            switch (sc.next()) {
                case ("1"):
                    System.out.println("Введите имя, фамилию: ");
                    personList.add(new Person(sc.next(), sc.next()));
                    System.out.println("Пользователь добавлен.");
                    showMenu();
                    break;
                case ("2"):
                    for (Person p : personList) {
                        System.out.print(p);
                    }
                    showMenu();
                    break;
                case ("3"):
                    sortedUnique(personList);
                    showMenu();
                    break;
                default:
                    System.out.println("Некорректный пункт меню, введите номер пункта.");
                    showMenu();
            }
        }
        sc.close();
    }
}
