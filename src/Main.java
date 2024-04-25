import application.services.UserService;
import infrastructure.db.Database;
import lib.ArrayListCustom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*ArrayListCustom<Integer> array = new ArrayListCustom<>(4);

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        System.out.println(array);

        array.add(1, 15);
        System.out.println(array);*/

        Database db = new Database();
        UserService userService = new UserService(db);

        System.out.println("Выберите пункт из меню:");
        System.out.println("1. Добавить пользователя");
        System.out.println("2. Получить список всех пользователей");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();

            switch (input) {
                case "1": {

                    System.out.println("Введите имя");
                    System.out.println("Введите возраст");
                    System.out.println("Введите номер телефона");
                    System.out.println("Введите адрес");
                    System.out.println("Введите номер паспорта");
                    System.out.println("Введите электронную почту ");

                    String name = reader.readLine();

                    int age = Integer.parseInt(reader.readLine());
                    System.out.println(age);
                    String phoneNumber = reader.readLine();
                    String address = reader.readLine();
                    String passportNumber = reader.readLine();
                    String email = reader.readLine();

                    userService.createUser(name, age, phoneNumber, address, passportNumber, email);


                    // создавать пользователя
                    break;
                }
                case "2": {
                    userService.printUsers();
                    break;
                }
                default: {
                    System.out.println("неверная команда");
                }
            }

          /*  if (input.equals("1")) {

            } else if (input.equals("2")) {

            } else {

            }*/

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

/*
        try {
            userService.createUser("dsadsadsa", 5, "+79605587877", "dsadsadas", "dsadsadas", "dasdasdas");
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        userService.createUser("Юрий Евсеев", 15, "+79203335455", "dsadsadas", "dsadsadas", "dasdasdas");
        userService.createUser("Смыслов Алексей", 25, "+79603331122", "dsadsadas", "dsadsadas", "dasdasdas");
        userService.createUser("Березуцкий", 35, "79604445533", "dsadsadas", "dsadsadas", "dasdasdas");

        userService.printUsers();*/

    }
}