package examples.unit01.components.table.customtable.services;

import examples.unit01.components.table.customtable.dtos.Alumno;

import java.util.List;

public interface IClientesService {
    
    public List<Alumno> getAll();
    public void add(Alumno alumno);
    
    
    
}
