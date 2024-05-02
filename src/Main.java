import application.services.AccountService;
import application.services.UserService;
import domain.User;
import infrastructure.db.Database;
import util.Menu;

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


        System.out.println("Выберите пункт из меню:");
        System.out.println("1. Добавить пользователя");
        System.out.println("2. Получить список всех пользователей");
        System.out.println("3. Создать счет");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {

            String input;
            do {
                input = reader.readLine();

                switch (input) {
                    case "1": {
                        Menu.createUser(reader);
                        break;
                    }
                    case "2": {
//                        Menu.printUsers();
                        break;
                    }
                    case "3": {
                        Menu.createAccount(reader);
                        break;
                    }
                    default: {
                        System.out.println("неверная команда");
                    }
                }
                System.out.println("Выберите пункт из меню:");
                System.out.println("1. Добавить пользователя");
                System.out.println("2. Получить список всех пользователей");
                System.out.println("3. Создать счет");
            } while (input != "-1");

            if (input == "-1") {
                System.out.println("Работа программы успешно завершена");
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