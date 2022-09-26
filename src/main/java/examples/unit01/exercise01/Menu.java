package examples.unit01.exercise01;

import java.util.*;
import java.util.stream.Collectors;

public class Menu {
    private Scanner in = new Scanner(System.in);

    // PRIVATE FIELDS
    private Map<Integer, String> options;

    // CONSTRUCTORS
    public Menu() {
        options = new HashMap<Integer, String>();
    }

    // PUBLIC METHDOS

    /**
     * Solo para pruebas
     * @return
     */
    public Map<Integer, String> getOptions() { return options; }

    /**
     * Añade una opción a el menu
     * @param option la opción añadida
     */
    public void addOption(String option) {
        options.put(options.size() + 1, option);
    }

    public int getOpcion() {
        try {

            int opcion =  in.nextInt();
            if (opcion > 0 && opcion <= options.size() )
                return opcion;
            else
                return 0;
        } catch (Exception e) {
            return 0;
        }
    }
    /**
     * Se encarga de mostrar el menu
     */
    public String getMenu() {
        return options.entrySet().stream()
                .map(entry -> entry.getKey() + ". " + entry.getValue() )
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public Match getMatch() {
        System.out.println("Introduce equipo local: ");
        String local = in.next();
        System.out.println(("Introduce equipo visitante"));
        return null;
    }

}
