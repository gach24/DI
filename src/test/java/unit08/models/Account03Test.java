package unit08.models;

import examples.unit08.models.Account;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Account 03 tests
 * Show how to work different annotations
 * - @EnabledOnOs
 * - @DisableOnOS
 * - @EnabledOnJre
 * - @DisableOnJre
 * - @EnabledIfSystemProperty
 * -´@DisableIfSystemProperty
 * - @EnabledIfEnvironmentVariable
 * - @DisabledIfEnvironmentVariable
 * - assumeTrue
 * - @RepeatedTest
 */
public class Account03Test {

    /*
     * Operating System tests
     */
    @Nested
    @DisplayName("Operating System Tests: ")
    class OperationSystemTest {
        /*
         * Show how to enable test on Linux
         */
        @Test
        // @EnabledOnOs(OS.WINDOWS)
        @EnabledOnOs(OS.LINUX)
        // @EnabledOnOs({ OS.WINDOWS, OS.LINUX })
        void testEnabledOnOperationSystem() {
        }

        /*
         * Show how to disable test on Windows
         */
        @Test
        @DisabledOnOs(OS.WINDOWS)
        void testDisabledOnOperatingSystem() { }
    }

    /*
     * JRE tests
     */
    @Nested
    @DisplayName("JRE Test: ")
    class JRETest {
        /*
         * Show how to enable test on Java 10
         */
        @Test
        @EnabledOnJre(JRE.JAVA_10)
        void testEnableOnJRE() { }

        /**
         * Show how to disable test on Java 17
         */
        @Test
        @DisabledOnJre(JRE.JAVA_17)
        void testDisableOnJRE() { }
    }

    /*
     * System properties test
     */
    @Nested
    @DisplayName("System Properties Test: ")
    class SystemPropertyTest {
        /*
         * Show how to enable test when system property matches with something
         */
        @Test
        @EnabledIfSystemProperty(named = "os.arch", matches = "32")
        void testEnableOnProperty() {
            System.getProperties().forEach((k, v) -> System.out.println(k + ": " + v));
        }

        /*
         * Show how to enable test when system property matches with something
         * -ea -D ENV=dev
         */
        @Test
        @DisabledIfSystemProperty(named = "os.arch", matches = "amd64")
        void testDisableOnProperty() {
            System.getProperties().forEach((k, v) -> System.out.println(k + ": " + v));
        }

        /*
         * Show how to enable test when system property matches with System property
         * -ea -D ENV=dev
         */
        @Test
        @EnabledIfSystemProperty(named = "DEV", matches = "dev")
        void testEnableWhenSystemPropertyDev() {
            System.getProperties().forEach((k, v) -> System.out.println(k + ": " + v));
        }
    }

    /*
     * Environment variables tests
     */
    @Nested
    @DisplayName("Environment Variables Test: ")
    class EnvironmentVariableTest {
        /*
         * Show how to enable test when environment variable matches with something
         */
        @Test
        @EnabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "dev")
        void testEnableWhenEnvironmentVariable() {
            System.getenv().forEach((k, v)-> System.out.println(k + ": " + v));
        }
    }

    /*
     * Assumption tests
     */
    @Nested
    @DisplayName("Assumption Test: ")
    @Tag("assumption")
    class AssumptionTest {

        /*
         * Show how to work assumptions
         * -ea -D ENV=dev
         */
        @Test
        void testAssumption() {
            // boolean isDevelopment = System.getProperty("ENV").equals("dev");
            boolean isDevelopment = System.getProperty("ENV").equals("prod");
            Assumptions.assumeTrue(isDevelopment);
            assertTrue(true);
        }
        /*
         * Show how to work assumption
         * -ea -D ENV=dev
         */
        @Test
        void testPartAssumption() {
            // boolean isDevelopment = System.getProperty("ENV").equals("dev");
            boolean isDevelopment = System.getProperty("ENV").equals("dev");
            assertTrue(true);
            Assumptions.assumingThat(isDevelopment, () -> {
                assertTrue(true);
            });
        }
    }

    /*
     * Repeated and parameterized test
     */
    @Nested
    @DisplayName("Repeated and Parameterized Test:")
    class RepeatedAndParameterizedTest {
        /*
         * Show how to work RepeatedTest Attribute
         * Usually uses when there is something aleatory
         */
        @Tag("repeated")
        @DisplayName("Probando:")
        @RepeatedTest(value = 5, name = "{displayName} Repetición número = {currentRepetition} de {totalRepetitions}")
        void testRepeated(RepetitionInfo info) {
            if (info.getCurrentRepetition() == 3)
                System.out.println("La 3!!!");
        }

        @Tag("parameterized")
        /*
         * Show how to work ParameterizedTest Attribute
         * The array of values can be strings, ints, doubles, ...
         */
        @ParameterizedTest(name = "Numero {index} con valor {argumentsWithNames}")
        @ValueSource(strings = {"100", "200", "300", "500", "700", "1500.12345"})
        void testParameterized(String amount) {
            Account account = new Account("German", new BigDecimal("1500.12345"));
            account.debit(new BigDecimal(amount));
            assertNotNull(account.getBalance());
            assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) >= 0);
        }

        @Tag("parameterized")
        /*
         * Show how to work ParameterizedTest Attribute
         * The array of values is in cvs format
         */
        @ParameterizedTest(name = "Numero {index} con balance: {0}, debito: {1} y nombre: {2}")
        @CsvSource({"100,100,German","200,200,Raquel", "330,300,Samuel", "401,400,Daniel", "500,500,Maria", "6000,1000.12345,Vanesa"})
        // @CsvFileSource(resources = "/data.cvs")
        // @MethodSource(value = "amountList")
        void testParameterizedWithCVS(String balance, String value, String name) {
            Account account = new Account("German", new BigDecimal("1500.12345"));
            account.setPersonName(name);
            account.setBalance(new BigDecimal(balance));
            account.debit(new BigDecimal(value));
            assertNotNull(account.getBalance());
            assertEquals(name, account.getPersonName());
            assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) >= 0);
        }
    }

    @Test
    void testInfo(TestInfo info, TestReporter reporter) {
        reporter.publishEntry("Ejecutando: " + info.getDisplayName());
        reporter.publishEntry("Etiquetas: " + info.getTags());
    }

    @Nested
    @Tag("timeout")
    class TimeOutTest {
        @Test
        @Timeout(5)
        void testTimeOutInSeconds() throws InterruptedException {
            TimeUnit.SECONDS.sleep(4);
        }


        @Test
        @Timeout(value = 1500, unit = TimeUnit.MILLISECONDS)
        void testTimeOutInMilliseconds() throws InterruptedException {
            TimeUnit.SECONDS.sleep(1);
        }

        @Test
        void testTimeOutWithAssertion() {
            assertTimeout(Duration.ofSeconds(4), () -> {
                TimeUnit.SECONDS.sleep(3);
            });
        }
    }
}
