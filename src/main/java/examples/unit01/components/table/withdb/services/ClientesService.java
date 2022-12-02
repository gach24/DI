package examples.unit01.components.table.withdb.services;

import examples.unit01.components.table.withdb.dtos.Cliente;
import examples.unit01.components.table.withdb.repositories.ClientesRepository;
import examples.unit01.components.table.withdb.repositories.IClientesRepository;

import java.util.List;


public class ClientesService implements IClientesService {
    
    private final IClientesRepository clientesRepository;
    private static IClientesService instance;
    
    private ClientesService() { 
        clientesRepository = new ClientesRepository();
    }
   
    public static IClientesService getInstance() { 
        if (instance == null)
            instance = new ClientesService();
        return instance; 
    }
    
    @Override
    public List<Cliente> getAll() {
        return clientesRepository.getAll();
    }

    @Override
    public void add(Cliente cliente) {
        clientesRepository.add(cliente);
    }

    @Override
    public void delete(int i) {
        clientesRepository.delete(i);
    }
    
    @Override
    public Cliente find(int i) {
        return clientesRepository.find(i);
    }

}
