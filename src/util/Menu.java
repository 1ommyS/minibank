package util;

import application.services.AccountService;
import application.services.UserService;
import domain.User;
import infrastructure.db.Database;

import java.io.BufferedReader;
import java.io.IOException;


/*
переменная или функция помеченная статиком доступа в статик функциях и в не статик
переменная НЕ помеченная статиком доступа только в не статик функциях
 */
public class Menu {
    private static Database database = new Database();
    private static AccountService accountService = new AccountService(database);
    private static UserService userService = new UserService(database);


    public static void createUser(BufferedReader reader) throws IOException {
        System.out.println("Введите имя");
        System.out.println("Введите возраст");
        System.out.println("Введите номер телефона");
        System.out.println("Введите адрес");
        System.out.println("Введите номер паспорта");
        System.out.println("Введите электронную почту ");

        String name = reader.readLine();

        int age = Integer.parseInt(reader.readLine());
        String phoneNumber = reader.readLine();
        String address = reader.readLine();
        String passportNumber = reader.readLine();
        String email = reader.readLine();

        userService.createUser(name, age, phoneNumber, address, passportNumber, email);
    }

    public static void createAccount(BufferedReader reader) throws IOException {
        System.out.println("Введите имя владельца счета");
        System.out.println("Налоговым рецензентом какой стран(-ы) является владелец счета?");

                        /*
                        1) есть ли у нас такой пользователь?
                        2) живет ли он в России? ( по адресу )
                        3) есть ли у него счета?
                         */

        String userFullName = reader.readLine();
        boolean isUserExists = userService.isUserExists(userFullName);

        if (!isUserExists) {
            System.out.println("Такого пользователя еще нет");
            return;
        }

        String userCountryRecenzent = reader.readLine();
        boolean isUserRecenzentHisCountry = userService.isUserRecenzentHisCountry(userFullName, userCountryRecenzent);

        if (!isUserRecenzentHisCountry) {
            System.out.println("Владелец счета не является рецензентом этой страны");
            return;
        }
        // какой сервис, как называется функция, что мы в нее передаем
        User user = userService.getUser(userFullName);

        boolean hasAnyAccounts = accountService.hasAnyAccounts(user);

        if (hasAnyAccounts) {
            System.out.println("У этого пользователя уже есть счет");
            return;
        }

        accountService.createAccount(user);
        System.out.println("Счет создан успешно");
        return;
    }
}
