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

    public void addAccount(Account account) {
        accounts.add(account);
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

    public User getUser(String fullName) throws IllegalArgumentException {
        for (int i = 0; i < users.getSize(); i++) {
            if (users
                    .get(i)
                    .getFullName()
                    .equals(fullName)
            ) {
                return users.get(i);
            }
        }

        throw new IllegalArgumentException("Такого пользователя не существует");
    }

    public boolean isUserExists(String fullName) {
        for (int i = 0; i < users.getSize(); i++) {
            if (users
                    .get(i)
                    .getFullName()
                    .equals(fullName)
            ) {
                return true;
            }
        }

        return false;
    }

    public boolean hasUserAnAccount(User user) {
        for (int i = 0; i < accounts.getSize(); i++) {
            if (
                    accounts
                            .get(i)
                            .getOwner()
                            .equals(user)
            ) {
                return true;
            }
        }
        return false;
    }
}
