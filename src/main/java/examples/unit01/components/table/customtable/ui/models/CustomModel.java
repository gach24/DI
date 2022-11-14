package examples.unit01.components.table.customtable.ui.models;

import examples.unit01.components.table.customtable.dtos.Alumno;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CustomModel extends AbstractTableModel {

    private String[] columnas = { "Nombre", "Curso" };
    
    private List<Alumno> alumnos;
    
    public CustomModel(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    
    @Override
    public int getRowCount() {
        return alumnos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: 
                return alumnos.get(rowIndex).getNombre();
            case 1: 
                return alumnos.get(rowIndex).getCurso();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    
     
}
