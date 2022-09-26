package examples.unit08.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    // PRIVATE MEMBERS
    private String name;
    private List<Account> accountList;

    // CONSTRUCTORS
    public Bank() { accountList = new ArrayList<>(); }

    public Bank(String name) {
        this();
        this.name = name;
    }

    // PUBLIC METHODS
    /**
     * @return the Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public void addAccount(Account account) {
        if (account != null) {
            accountList.add(account);
            account.setBank(this);
        }
    }
    public List<Account> getAccounts() { return accountList; }

    /**
     * Transfer amount from source account to the destiny account
     * @param from
     * @param to
     * @param amount
     */
    public void transer(Account from, Account to, BigDecimal amount) {
        from.debit(amount);
        to.credit(amount);
    }
}
