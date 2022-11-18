package examples.unit01.components.table.customtable.repositories;

import examples.unit01.components.table.customtable.dtos.Cliente;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class ClientesRepository implements IClientesRepository{
    private final List<Cliente> clientes;
            
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
        return clientes;
    }

    @Override
    public void add(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void delete(int i) {
        clientes.removeIf(c -> c.getId() == i);
    }
    
    @Override
    public Cliente find(int i) {
        return clientes.get(i);
    }
    
    
}
