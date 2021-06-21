package ru.sb.forAllCan.syrkin.exersice7;

import ru.sb.forAllCan.syrkin.Entity.Person;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);


        menu.items.get(0).exec.exec(personList);
        menu.items.get(1).exec.exec(personList);


    }

    @FunctionalInterface
    private interface Exec {
        void exec(List<Person> data) throws Exception;
    }

    private static class MenuItem { // Наименование пункта меню
        private String name;    // Доступное действие
        private Exec exec;
    }

    private static class Menu {
        private List<MenuItem> items;
        private Scanner scanner;

        Menu(Scanner scanner) {

            items = new ArrayList<>();

            MenuItem menuItem = new MenuItem();

            menuItem.name = "1";
            menuItem.exec = this::addPerson;
            items.add(menuItem);


            menuItem.name = "2";
            menuItem.exec = this::show;
            items.add(menuItem);
                    items.add(menuItem);
                    menuItem.name = "3";
                    menuItem.exec = this::sortedUnique;

        }



        public void addPerson(List<Person> data) {
            System.out.println("Введите имя, фамилию: ");
            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNext("q")) {
                data.add(new Person(scanner.next(), scanner.next()));
            }
            System.out.println("Пользователь добавлен.");
        }

        public void show(List<Person> data) {
            for (Person p : data) {
                System.out.println(p);
            }
        }

        public void sortedUnique(List<Person> data) {
            List<Person> sortedList = new ArrayList<>(data);
            if (data.size() != 0) {
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

        }
    }
}