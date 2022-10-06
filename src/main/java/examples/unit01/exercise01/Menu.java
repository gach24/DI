package examples.unit01.exercise01;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Menu {
    // PRIVATE FIELDS
    private Scanner in = new Scanner(System.in);
    private Map<Integer, String> options;

    // CONSTRUCTORS
    public Menu() {
        options = new HashMap<>();
    }

    // PUBLIC METHODS
    /**
     * Añade una opción a el menu
     * @param option la opción añadida
     */
    public void addOption(String option) {
        options.put(options.size() + 1, option);
    }

    public int getOption() {
        try {
            int option =  Integer.parseInt(in.nextLine());
            if (option > 0 && option <= options.size())
                return option;
            else
                return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    public int getResult() {
        try {
            int result =  Integer.parseInt(in.nextLine());
            if (result > 0 && result <= 999)
                return result;
            else
                return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    public String getTeamName() {
        return in.nextLine();
    }

    public Division getDivision() {
        try {
            int division = Integer.parseInt(in.nextLine());
            return switch (division) {
                case 1 -> Division.PRIMERA;
                case 2 -> Division.SEGUNDA;
                case 3 -> Division.TERCERA;
                default -> null;
            };
        } catch (Exception e) {
            return null;
        }
    }

    public Date getDate() {
        try {
            return new SimpleDateFormat("dd/MMM/yyyy").parse(in.nextLine());
        } catch (Exception e) {
            return null;
        }
    }


    public String getStringMenu() {
        return options.entrySet().stream()
                .map(entry -> entry.getKey() + ". " + entry.getValue() )
                .collect(Collectors.joining(System.lineSeparator()));
    }

}
