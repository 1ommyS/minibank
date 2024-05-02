package application.services;

import domain.Account;
import domain.User;
import infrastructure.db.Database;

public class AccountService {
    private Database database;

    public AccountService(Database database) {
        this.database = database;
    }

    public boolean hasAnyAccounts(User user) {
        return database.hasUserAnAccount(user);
    }

    public void createAccount(User user) {
        Account account = new Account(user, 0, true, false);

        database.addAccount(account);
    }
}
