package examples.unit08.models;

import java.math.BigDecimal;
import java.util.Objects;

import examples.unit08.util.exceptions.InsufficientMoneyException;

/**
 *
 * @author German
 */
public class Account {
    private String personName;
    private BigDecimal balance;
    private Bank bank;
    /**
     * Build an account without values
     */
    public Account() { }
    
    /**
     * Build an Account
     * @param pn Person Name
     * @param b Balance
     */
    public Account(String pn, BigDecimal b) {
        this.personName = pn;
        this.balance = b; 
    }

    /**
     * @return the personaName
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * @param personaName the personaName to set
     */
    public void setPersonName(String personaName) {
        this.personName = personaName;
    }

    /**
     * @return the balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Bank getBank() { return bank; }

    public void setBank(Bank bank) { this.bank = bank; }

    public void debit(BigDecimal amount) {
        BigDecimal tempBalance =  balance.subtract(amount);
        if (tempBalance.compareTo(BigDecimal.ZERO) < 0)
            throw new InsufficientMoneyException("Dinero insuficiente");
        this.balance = tempBalance;
    }
    
    public void credit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) 
            return true;
        if (o == null || getClass() != o.getClass()) 
            return false;
        Account account = (Account) o;
        return Objects.equals(
                getPersonName(), account.getPersonName()) 
                && Objects.equals(getBalance(), account.getBalance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonName(), getBalance());
    }
}
