package examples.unit01.exercise01;

public class Main {
    private static Menu menu = new Menu();

    public static void main(String[] args) {
        load();
        int opcion = showMenu();
        while (opcion >= 0 && opcion <= menu.getOptions().size()) {
            switch (opcion) {
                case 0:
                    System.out.println("Opción incorrecta");
                    break;
                case 1:
                    newUser();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
            opcion = showMenu();
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

    public static int showMenu() {
        System.out.println("Opciones: ");
        System.out.println(menu.getMenu());
        System.out.println("Elija opción: ");
        return menu.getOpcion();
    }

    public static void newUser() {

    }
}
