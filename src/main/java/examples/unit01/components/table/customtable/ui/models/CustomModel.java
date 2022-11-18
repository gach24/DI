package com.german.ui.models;

import javax.swing.table.DefaultTableModel;

public class CustomModel extends DefaultTableModel {
    
    private String[] columnas = new String[] {
        "Nombre",
        "Apellido",
        "Alta",
        "Provincia"
    };
       
    public CustomModel() {
        this.setColumnIdentifiers(columnas);
    }
    
    @Override
    public void setValueAt(Object obj, int r, int c) {
        super.setValueAt(obj, r, c);
        
        System.out.println(obj);
    }
    
    
}
