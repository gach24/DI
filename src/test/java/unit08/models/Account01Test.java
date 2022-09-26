package unit08.models;

import examples.unit08.models.*;
import examples.unit08.util.exceptions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Account 01 tests
 * Show how to work different assert and annotations
 * - assertEquals
 * - assertTrue
 * - assertFalse
 * - assertNotNull
 * - assertThrows
 * - assertAll
 * - @DisplayName
 * - @Disabled
 * @author German Carreño
 */
public class Account01Test {
    /*
     * Test to demonstrate the operation of:
     * - assertEquals
     * - assertTrue
     */
    @Test
    void testNameAccount() {
        // Create object to test
        Account account = new Account();
        
        // Set name
        account.setPersonName("Andres");
        
        // Expected value
        String expectedName = "Andres";
        // Get current name of instance
        String currentName = account.getPersonName();
        
        /*
         * If it doesn't run any any assert. The test is ok
         */
        
        // Test for equals both expected and real values
        // Assertions.assertEquals(expectedName, currentName);
        assertEquals(expectedName, currentName);
        assertTrue(expectedName.compareTo(currentName) == 0);
    }

    /*
     * Test to demonstrate the operation of:
     * - assertEquals
     * - assertFalse
     */
    @Test
    void testBalanceAccount() {
        Account account = 
                new Account("Andres", new BigDecimal("1000.12345"));
        
        double expectedBalance = 1000.12345;
        assertEquals(expectedBalance, account.getBalance().doubleValue());
        assertFalse(account.getBalance().compareTo(BigDecimal.ZERO) < 0);
    }

    /*
     * Test to demonstrate the operation of:
     * - assertEquals
     */
    @Test
    void testAccountReference() {
        Account a1 = 
            new Account("John Doe", new BigDecimal("1000.12345"));
        Account a2 = 
            new Account("John Doe", new BigDecimal("1000.12345"));
        
        // assertNotEquals(a1, a2);
        assertEquals(a1, a2);
    }

    /*
     * Test to demonstrate the operation of:
     * - assertNotNull
     * - assertEquals
     */
    @Test
    void testDebitAccount() {
        Account account = 
            new Account("German", new BigDecimal("1000.12345"));
        account.debit(new BigDecimal(100));
        
        // Expected value
        int intExpectedBalance = 900;
        
        // Assert current value is not null
        BigDecimal currentBalance = account.getBalance();
        assertNotNull(currentBalance);
        
        // Assert current value equals expected value
        int intCurrentBalance = account.getBalance().intValue();        
        assertEquals(intExpectedBalance, intCurrentBalance);
        
        String strExpectedBalance = "900.12345";
        String strCurrentBalance = account.getBalance().toPlainString();
        assertEquals(strExpectedBalance, strCurrentBalance);
    }

    /*
     * Test to demonstrate the operation of:
     * - assertNotNull
     * - assertEquals
     */
    @Test
    void testCreditAccount() {
        Account account = 
            new Account("German", new BigDecimal("1000.12345"));
        account.credit(new BigDecimal(100));
        
        // Expected value
        int intExpectedBalance = 1100;
        
        // Assert current value is not null
        BigDecimal currentBalance = account.getBalance();
        assertNotNull(currentBalance);
        
        // Assert current value equals expected value
        int intCurrentBalance = account.getBalance().intValue();        
        assertEquals(intExpectedBalance, intCurrentBalance);
        
        String strExpectedBalance = "1100.12345";
        String strCurrentBalance = account.getBalance().toPlainString();
        assertEquals(strExpectedBalance, strCurrentBalance);
    }

    /*
     * Test to demonstrate the operation of:
     * - assertThrows
     */
    @Test
    void testInsufficientBalance() {
        Account account = 
            new Account("German", new BigDecimal("1000.12345"));
        
        Exception e = assertThrows(InsufficientMoneyException.class, () ->
           account.debit(new BigDecimal("1000.12346"))
        );
        String currentMessageException = e.getMessage();
        String expectedMessageException = "Dinero insuficiente";
        
        assertEquals(expectedMessageException, currentMessageException);
    }

    /*
     * Test to demonstrate the operation of:
     * - assertEquals
     */
    @Test
    void testTransfer() {
        Account fromAccount = new Account("John Doe", new BigDecimal("2500"));
        Account toAccount   = new Account("Andrés", new BigDecimal("1500.8989"));

        Bank bank = new Bank("FED");
        bank.transer(fromAccount, toAccount, new BigDecimal("500"));

        assertEquals("2000", fromAccount.getBalance().toPlainString());
        assertEquals("2000.8989", toAccount.getBalance().toPlainString());
    }

    /*
     * Test to demonstrate the operation of:
     * - assertEquals
     * - assertTrue
     * if fail the first assert doesn't run the rest
     */
    @Test
    void testAddAccountsToBank() {
        Account a1 = new Account("John Doe", new BigDecimal("2500"));
        Account a2   = new Account("Andres", new BigDecimal("1500.8989"));

        String bankName = "FED";
        Bank bank = new Bank(bankName);
        bank.addAccount(a1);
        bank.addAccount(a2);
        assertEquals(2, bank.getAccounts().size());
        assertEquals(bankName, a1.getBank().getName());
        assertEquals(bankName, a2.getBank().getName());
        /*
        assertTrue(bank.getAccounts()
                        .stream()
                        .filter(a-> a.getPersonName().equals("Andres"))
                        .findFirst()
                        .isPresent());
         */

        /*
         * Ejemplo de utilización de la API stream y expresiones lambda
         */
        assertTrue(bank.getAccounts()
                .stream()
                .anyMatch(a -> a.getPersonName().equals("Andres")));

        assertTrue(bank.getAccounts()
                .stream()
                .anyMatch(a -> a.getPersonName().equals("John Doe")));
    }

    /*
     * Test to demonstrate the operation of:
     * - assertAll
     * if fail the first assert runs the rest
     */
    @Test
    void testAddAccountsToBankV2() {
        Account a1 = new Account("John Doe", new BigDecimal("2500"));
        Account a2   = new Account("Andres", new BigDecimal("1500.8989"));

        String bankName = "FEDS";
        Bank bank = new Bank(bankName);
        bank.addAccount(a1);
        bank.addAccount(a2);

        assertAll(
                () -> assertEquals(2, bank.getAccounts().size()),
               // () -> assertEquals("FED", a1.getBank().getName()),
               // () -> assertEquals("FED", a2.getBank().getName()),
               /* () -> assertTrue(bank.getAccounts()
                        .stream()
                        .anyMatch(a -> a.getPersonName().equals("Andrés"))),*/
                () -> assertTrue(bank.getAccounts()
                        .stream()
                        .anyMatch(a -> a.getPersonName().equals("John Doe")))
        );
    }

    /*
     * Test to show how to work descriptive message in assertion
     * if assertion fail show descriptive message
     */
    @Test
    void testWithMessage() {
        /*
         Account account = new Account();
         assertNotNull(account.getPersonName(), "La cuenta no puede ser nula");
         assertEquals("Germans", account.getPersonName(), "El nombre de la cuenta no es el esperado");
         */
        /*
        Account account = new Account();
        assertNotNull(
                account.getPersonName(),
                () -> "La cuenta no puede ser nula");
        assertEquals(
                "Germans",
                account.getPersonName(),
                () -> "El nombre de la cuenta no es el esperado");

         */
    }

    /*
     * Test to show how to work descriptive message when test runs
     * Display descriptive message when runs the test
     */
    @Test
    @DisplayName("Probando nombre de la cuenta")
    void testWithDisplayMessage() {
        Account account = new Account("German", new BigDecimal("1000.12345"));
        assertEquals("German", account.getPersonName());
    }

    /*
     * Test to show how to disable test and make to fail test
     */
    @Test
    @Disabled
    void testWithDisabledRunning() {
        fail();
    }



}
