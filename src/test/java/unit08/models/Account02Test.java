package unit08.models;

import examples.unit08.models.Account;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

/**
 * Account 02 tests
 * Show how to work different annotations
 * - @BeforeAll
 * - @BeforeEach
 * - @AfterEach
 * - @AfterAll
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Force one instance for all test method
// @TestInstance(TestInstance.Lifecycle.PER_METHOD) // One instance for each test method (default value)
public class Account02Test {

    private Account account;

    /*
     * This method runs before all test methods
     * It can be used to init database connections ...
     */
    @BeforeAll
    static void beforeAll() {
        System.out.println("Running beforeAll");
    }

    /*
     * This method runs before each test method
     */
    @BeforeEach
    void beforeEach() {
        System.out.println("Running beforeEach method ...");
        System.out.println("Instance of Account");
        account = new Account();
        System.out.println("End of beforeEach method");
    }

    @Test
    @DisplayName("Account name test")
    void testNameAccount() {
        /*
         * It's not necessary
         * Account account = new Account();
         */
        account.setPersonName("Andres");

        // Asserts
        Assertions.assertEquals("Andres", account.getPersonName());
    }

    @Test
    @DisplayName("Account balance test")
    void testBalanceAccount() {
        /*
         * It's not necessary
         * Account account = new Account();
         */
        account.setPersonName("Andres");
        account.setBalance(new BigDecimal("1000.12345"));

        double expectedBalance = 1000.12345;
        assertEquals(expectedBalance, account.getBalance().doubleValue());
    }

    /*
     * This method runs after each test methods
     */
    @AfterEach
    void afterEach() {
        System.out.println("Running afterEach method ...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Running afterAll method ...");
    }
}
