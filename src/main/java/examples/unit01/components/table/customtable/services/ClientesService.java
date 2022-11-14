
package examples.unit01.components.table.customtable.services;


import examples.unit01.components.table.customtable.dtos.Alumno;
import examples.unit01.components.table.customtable.repositories.ClientesRepository;
import examples.unit01.components.table.customtable.repositories.IClientesRepository;

import java.util.List;

/**
 *
 * @author German
 */
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
    public List<Alumno> getAll() {
        return clientesRepository.getAll();
    }

    @Override
    public void add(Alumno alumno) {
        clientesRepository.add(alumno);
    }

}
