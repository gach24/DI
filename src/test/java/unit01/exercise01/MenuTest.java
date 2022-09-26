package unit01.exercise01;

import examples.unit01.exercise01.Menu;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    private final String o1 = "Opción 1";
    private final String o2 = "Opción 2";
    private final String o3 = "Opción 3";

    @Test
    void testAddOptionMenu() {
        Menu menu = new Menu();

        menu.addOption(o1);
        menu.addOption(o2);
        menu.addOption(o3);

        assertEquals(3, menu.getOptions().size());
    }

    @Test
    void testShowMenu() {
        Menu menu = new Menu();
        menu.addOption(o1);
        menu.addOption(o2);
        String expectMenu = "1. " + o1 + System.lineSeparator()
                + "2. " + o2;

        assertEquals(expectMenu, menu.getMenu());
    }

    @Test
    @Disabled
    void testGetOpcion() {
        Menu menu = new Menu();
        menu.addOption(o1);
        menu.addOption(o2);
        menu.addOption(o3);

        int opcion = menu.getOpcion();

        assertNotEquals(-1, opcion);
        assertTrue(opcion > 0);
        assertTrue(opcion <= menu.getOptions().size());
    }
}
