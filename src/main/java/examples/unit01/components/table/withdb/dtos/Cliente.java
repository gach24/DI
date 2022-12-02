package examples.unit01.components.table.withdb.dtos;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombre;
    private String apellido;
    private Date alta;
    private String provincia;

    public Cliente() {

    }

    public Cliente(String nombre, String apellido, Date alta, String provincia) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.alta = alta;
        this.provincia = provincia;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getAlta() {
        return alta;
    }

    public void setAlta(Date alta) {
        this.alta = alta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    public Object[] getValues() {
        Object[] values = new Object[4];
        values[0] = getNombre();
        values[1] = getApellido();
        values[2] = getAlta();
        values[3] = getProvincia();
        return values;
    }
}
