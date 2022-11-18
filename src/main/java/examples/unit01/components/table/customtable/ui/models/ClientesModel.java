package examples.unit01.components.table.customtable.ui.models;

import examples.unit01.components.table.customtable.dtos.Cliente;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ClientesModel extends AbstractTableModel {

    /*
     * Array con el nombre de las columnas
     */
    public String[] columnas = {
        "Id", 
        "Nombre", 
        "Apellidos", 
        "Fecha Alta", 
        "Provincia"};
    
    /*
     * Tipos de cada columna para la validación
     */
    private final Class[] columnClass = new Class[] {
        Integer.class, 
        String.class, 
        String.class, 
        Date.class, 
        String.class
    };
    
    /*
     * Fuente de datos 
     */
    private final List<Cliente> clientes;
    
    
    public ClientesModel(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                return clientes.get(rowIndex).getId();
            }
            case 1 -> {
                return clientes.get(rowIndex).getNombre();
            }
            case 2 -> {
                return clientes.get(rowIndex).getApellido(); 
            }
            case 3 -> {
                return clientes.get(rowIndex).getAlta();
            }
            case 4 -> {
                return clientes.get(rowIndex).getProvincia();
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        return column != 0;
    }
    
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex)
    {
        Cliente cliente = clientes.get(rowIndex);
        switch (columnIndex) {
            case 1 -> {
                cliente.setNombre((String)value);
            }
            case 2 -> {
                cliente.setApellido((String)value);
            }
            case 3 -> {
                cliente.setAlta((Date)value);
            }
            case 4 -> {
               cliente.setProvincia((String)value);
            }
        }       
   }
    
    
}
