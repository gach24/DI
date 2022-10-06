package examples.unit01.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMap {
    public static void main(String[] args) {
        // oldMethod();
        newMethod();
    }

    public static void oldMethod() {
        User u1 = new User("John");
        User u2 = new User("Mark");

        u1.add(new Invoice("Compras de tecnología"));
        u1.add(new Invoice("Compras de muebles"));

        u2.add(new Invoice("Compra de bicicleta"));
        u2.add(new Invoice("Compra de notebook"));

        List<User> users = Arrays.asList(u1, u2);

        for (User user: users)
            for(Invoice invoice: user.getInvoices())
                System.out.println(invoice.getDescription());
    }

    public static void newMethod() {
        User u1 = new User("John");
        User u2 = new User("Mark");

        u1.add(new Invoice("Compras de tecnología"));
        u1.add(new Invoice("Compras de muebles"));

        u2.add(new Invoice("Compra de bicicleta"));
        u2.add(new Invoice("Compra de notebook"));

        List<User> users = Arrays.asList(u1, u2);

        users.stream()
                .flatMap(user -> user.getInvoices().stream())
                .forEach(System.out::println);
    }

    private static class User {
        private String name;
        private List<Invoice> invoices = new ArrayList<>();

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void add(Invoice invoice) {
            this.invoices.add(invoice);
        }

        public List<Invoice> getInvoices() {
            return invoices;
        }
    }

    private static class Invoice {
        private String description;

        public Invoice(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "Invoice{" +
                    "description='" + description + '\'' +
                    '}';
        }
    }
}
