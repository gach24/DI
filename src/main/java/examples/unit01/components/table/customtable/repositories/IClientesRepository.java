
package examples.unit01.components.table.customtable.repositories;

import examples.unit01.components.table.customtable.dtos.Alumno;

import java.util.List;

/**
 *
 * @author German
 */
public interface IClientesRepository {
    public List<Alumno> getAll();
    public void add(Alumno alumno);
}
