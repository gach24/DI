package unit08.ejercicio01;


import examples.unit08.exercise.Pila;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PilaTest {

    Pila pila;

    @BeforeEach
    void setUp() {
        pila = new Pila();
        pila.push(5);
        pila.push(8);
    }

    @Test
    public void testPushNoAdd1() {
        pila.push(1);
        assertEquals(2, pila.size());
    }

    /*
     * No añade elemento (mayor que 20) a una pila con 2 elementos previos
     */
    @Test
    public void testPushNoAdd2() {
        pila.push(30);
        assertEquals(2, pila.size());
    }

    /*
     * Añade elemento a una pila con 2 elementos previos
     */
    @Test
    public void testPushAnade() {
        pila.push(10);
        assertEquals(3, pila.size());
    }

    /*
     * No añade elemento(menor que 2) a una lista con 0 elementos previos
     */
    @Test
    public void testPushNoAnadeVacio1() {
        Pila p = new Pila();
        p.push(1);
        assertTrue(p.isEmpty());
    }

    /*
     * No añade elemento (mayor que 20) a una lista con 0 elementos previos
     */
    @Test
    public void testPushNoAddEmpty2() {
        Pila p = new Pila();
        p.push(30);
        assertTrue(p.isEmpty());
    }

    /*
     * Añade elemento a una lista con 0 elementos previos
     */
    @Test
    public void testPushAddEmpty() {
        Pila p = new Pila();
        p.push(10);
        assertEquals(1, p.size());
    }

    /*
     * Ocurre una excepción cuando no entra null como parámetro
     */
    @Test
    public void testPushNull() {
        assertThrows(NullPointerException.class, () -> pila.push(null));
    }

    /*
     * Extrae último elemento de la pila no vacía
     */
    @Test
    public void testPop() {
        Integer expected = 8;
        Integer tmp = pila.pop();
        assertTrue(tmp.equals(expected) && pila.size() == 1);
    }

    /*
     * Extrae último elemento de la pila vacía, es decir, devuelve null
     */
    @Test
    public void testPopEmpty() {
        Pila p = new Pila();
        Integer expected = null;
        Integer tmp = p.pop();

        assertTrue(tmp == expected && p.isEmpty());
    }

    /*
     * La pila no está vacía
     */
    @Test
    public void testIsEmpty() {
        assertFalse(pila.isEmpty());
    }

    /*
     * La pila está vacía
     */
    @Test
    public void testIsEmptyWhenEmpty() {
        Pila p = new Pila();
        assertTrue(p.isEmpty());
    }

    /*
     * Muestra (sin extraer) último elemento de la pila no vacía
     */
    @Test
    public void testTop() {
        Integer expectedValue = 8;
        int expectedSize = 2;
        assertTrue(pila.top().equals(expectedValue) && pila.size() == expectedSize);
    }

    /*
    * Muestra (sin extraer) último elemento de la pila vacía
    */
    @Test
    public void testTopEmpty() {
        Pila p = new Pila();
        Integer expectedValue = null;
        int expectedSize = 0;
        assertTrue(p.top() == expectedValue && p.size() == expectedSize);
    }
}