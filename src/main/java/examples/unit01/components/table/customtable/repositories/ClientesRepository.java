/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examples.unit01.components.table.customtable.repositories;

import examples.unit01.components.table.customtable.dtos.Alumno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author German
 */
public class ClientesRepository implements IClientesRepository{
    private List<Alumno> alumnos;
            
    public ClientesRepository() {
        
        alumnos = new ArrayList<>(Arrays.asList(
                new Alumno("Luis", "SI"),
                new Alumno("Pedro", "SGBC"),
                new Alumno("Maite", "DDI"),
                new Alumno("Francisco", "PROGRAMACIÓN")                
        ));
    }

    @Override
    public List<Alumno> getAll() {
        return alumnos;
    }

    @Override
    public void add(Alumno alumno) {
        alumnos.add(alumno);
    }
    
    
}
