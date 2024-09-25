package practica.model;

import java.sql.Date;

public class Lector {

    private int id;
    private String nombre;
    private String ciudad;
    private Date fecha_alta;

    public Lector(int id, String nombre, String ciudad, Date fecha_alta) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fecha_alta = fecha_alta;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }
}//cierra clase
