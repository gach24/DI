package examples.unit01.exercise01;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Menu menu = new Menu();
    private static Map<Integer, Match> matches = new HashMap<>();

    public static void main(String[] args) throws Exception {
        load();
        read();
        while (true) {
            int option = showMenu();
            switch (option) {
                case 0:
                    System.out.println("Opción incorrecta");
                    break;
                case 1:
                    addNewMatch();
                    break;
                case 2:
                    System.out.println(showMatches());
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println(showMatchesDescending());
                    break;
                case 5:
                    break;
                case 6:
                    save();
                    System.exit(0);
                    break;
            }
        }
    }

    private static void load() {
        menu.addOption("Dar de alta partido");
        menu.addOption("Mostrar el listado de partidos");
        menu.addOption("Borrar un partido");
        menu.addOption("Mostrar los partidos ordenados por fecha");
        menu.addOption("Mostar los partidos de una división seleccionada");
        menu.addOption("Salir");
    }

    private static int showMenu() {
        System.out.println("Opciones: ");
        System.out.println(menu.getStringMenu());
        System.out.println("Elija opción: ");
        return menu.getOption();
    }

    private static void addNewMatch() {
        System.out.println("Introduce equipo local: ");
        String local = menu.getTeamName();
        System.out.println(("Introduce equipo visitante: "));
        String visitor = menu.getTeamName();
        System.out.println("Introduce resultado del equipo local: ");
        int localResult = menu.getResult();
        System.out.println("Introduce resultado del equipo visitante: ");
        int visitorResult = menu.getResult();
        System.out.println("Introduce la división del partido: ");
        Division division = menu.getDivision();
        System.out.println("Introduce la fecha en formato dd/mm/aaaa");
        Date date = menu.getDate();
        matches.put(
                matches.size(),
                new Match(local, visitor, division, localResult, visitorResult, date)
        );
    }

    private static String showMatches() {
        return matches.entrySet()
                      .stream()
                      .map(entry -> (entry.getKey() + 1) + ". " + entry.getValue() )
                      .collect(Collectors.joining(System.lineSeparator()));
    }

    private static void delMatch() {
        // Todo
    }

    private static String showMatchesDescending() {
        return matches.entrySet().stream()
                .sorted((e1, e2) -> e1.getValue().getLocal().compareTo(e2.getValue().getLocal()))
                .map(entry -> (entry.getKey() + 1) + ". " + entry.getValue() )
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static String showMatchesAscending() {
        return matches.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().getDate().compareTo(e1.getValue().getDate()))
                .map(entry -> (entry.getKey() + 1) + ". " + entry.getValue() )
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static void save() throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("Partidos.dat",true)
        );
        out.writeObject(matches);
        out.close();
    }

    private static void read() throws Exception {
        File file = new File("Partidos.dat");
        if(file.exists())
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            matches = (Map<Integer, Match>) in.readObject();
            in.close();
        }
    }

}
