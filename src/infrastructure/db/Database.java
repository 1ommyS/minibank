package infrastructure.db;

import domain.Account;
import domain.Transaction;
import domain.User;
import lib.ArrayListCustom;


public class Database {
    private ArrayListCustom<User> users;
    private ArrayListCustom<Transaction> transactions;
    private ArrayListCustom<Account> accounts;

    public Database() {
        users = new ArrayListCustom<>(10);
        accounts = new ArrayListCustom<>(10);
        transactions = new ArrayListCustom<>(1000);
    }

    public void addUser(User user) {
        /*for (User u : users) */

        for (int i = 0; i < users.getSize(); i++) {
            if (
                    user.equals(
                            users.get(i)
                    )
            ) {
                throw new IllegalArgumentException("Такой пользователь уже есть");
            }
        }

        users.add(user);
    }

    public void printUsers() {
        for (int i = 0; i < users.getSize(); i++) {
            System.out.println(users.get(i));
        }
    }
}
