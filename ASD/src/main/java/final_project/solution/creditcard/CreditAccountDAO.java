package final_project.solution.creditcard;

import final_project.solution.framework.Account;
import final_project.solution.framework.AccountDAO;

import java.util.ArrayList;
import java.util.Collection;

public class CreditAccountDAO implements AccountDAO {
    private static volatile CreditAccountDAO instance;
    Collection<Account> accountlist = new ArrayList<>();

    public static CreditAccountDAO getInstance() {
        if (instance == null) {
            synchronized (CreditAccountDAO.class) {
                if (instance == null) {
                    instance = new CreditAccountDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public void saveAccount(Account account) {
        accountlist.add(account);
        System.out.println("Saving account " + account.getAccountNumber() + " for customer " + account.getCustomer().getName());
    }

    @Override
    public void updateAccount(Account account) {
        Account accountexist = loadAccount(account.getAccountNumber());
        if (accountexist != null) {
            accountlist.remove(accountexist); // remove the old
            accountlist.add(account); // add the new
        }
        System.out.println("Updating account " + account.getAccountNumber() + " for customer " + account.getCustomer().getName());
    }

    @Override
    public Account loadAccount(String accountNumber) {
        for (Account account : accountlist) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }

    @Override
    public Collection<Account> getAccounts() {
        return accountlist;
    }
}
