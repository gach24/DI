package examples.unit01.components.table.withdb.services;

import examples.unit01.components.table.withdb.dtos.Cliente;

import java.util.List;

public interface IClientesService {
    
    public List<Cliente> getAll();
    public Cliente find(int i);
    public void add(Cliente cliente);
    public void delete(int i);
    
    
    
}
