package examples.unit01.components.table.customtable.repositories;

import examples.unit01.components.table.customtable.dtos.Cliente;
import java.util.List;

public interface IClientesRepository {
    public List<Cliente> getAll();
    public void add(Cliente cliente);
    public void delete(int i);
    public Cliente find(int i);
}
