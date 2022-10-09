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
            int option = menu.getOptionMenu();
            switch (option) {
                case 0 -> System.out.println("Opción incorrecta");
                case 1 -> addMatch();
                case 2 -> System.out.println(showMatches());
                case 3 -> delMatch();
                case 4 -> System.out.println(showMatchesDescending());
                case 5 -> System.out.println(showMarchesByDivison());
                case 6 -> {
                    save();
                    System.exit(0);
                }
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

    private static String showMatches() {
        return matches.entrySet()
                      .stream()
                      .map(entry -> (entry.getKey()) + ". " + entry.getValue() )
                      .collect(Collectors.joining(System.lineSeparator()));
    }

    private static void addMatch() {
        Match match = menu.getNewMatch();
        matches.put(matches.size() + 1, match);
    }

    private static void delMatch() {
        int numMatch = menu.getNumMatch();
        matches.remove(numMatch);
    }

    private static String showMatchesDescending() {
        return matches.entrySet().stream()
                .sorted((e1, e2) -> e1.getValue().getDate().compareTo(e2.getValue().getLocal()))
                .map(entry -> (entry.getKey() + 1) + ". " + entry.getValue() )
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static String showMarchesByDivison() {
        System.out.println("Division: ");
        Division division = menu.getDivision();
        return matches.entrySet().stream()
                .filter(entry -> entry.getValue().getDivision() == division)
                .map(entry -> (entry.getKey() + 1) + ". " + entry.getValue() )
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static void save() throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("Partidos.dat",false)
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
