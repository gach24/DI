package examples.unit01.components.table.withdb.consola;

import examples.unit01.components.table.withdb.dtos.Cliente;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SingleTable");
        EntityManager em = emf.createEntityManager();
        
        
        Cliente c1 = new Cliente("Nombre 1", "Apellido 1", new Date(), "Asturias");
        Cliente c2 = new Cliente("Nombre 2", "Apellido 2", new Date(), "Teruel");
        Cliente c3 = new Cliente("Nombre 3", "Apellido 3", new Date(), "Huesca");
        Cliente c4 = new Cliente("Nombre 4", "Apellido 4", new Date(), "La Rioja");
        
        em.getTransaction().begin();
        
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
    }
}
