/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examples.unit01.components.table.withdb.repositories;

import examples.unit01.components.table.withdb.dtos.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author German
 */
public class ClientesRepository implements IClientesRepository{
    private List<Cliente> clientes;
            
    public ClientesRepository() {
        
        clientes = new ArrayList<>(Arrays.asList(
                new Cliente("Nombre 1", "Apellido 1", new Date(), "Asturias"),
                new Cliente("Nombre 2", "Apellido 2", new Date(), "Teruel"),
                new Cliente("Nombre 3", "Apellido 3", new Date(), "Huesca"),
                new Cliente("Nombre 4", "Apellido 4", new Date(), "La Rioja")                
        ));
    }

    @Override
    public List<Cliente> getAll() {
        List<Cliente> result = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SingleTable");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("SELECT c FROM Cliente c");
        
        result = (List<Cliente>)query.getResultList();
        
        em.close();
        emf.close();
        return result;
    }

    @Override
    public void add(Cliente cliente) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SingleTable");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(cliente);
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public void delete(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SingleTable");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Cliente cliente = em.find(Cliente.class, id);
        em.remove(cliente);
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    @Override
    public Cliente find(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SingleTable");
        EntityManager em = emf.createEntityManager();
        
        Cliente cliente = em.find(Cliente.class, id);
        
        em.close();
        emf.close();
        return cliente;
    }
    
    
}
