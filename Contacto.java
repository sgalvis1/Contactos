package com.sebastian.contactos;

import java.lang.ref.SoftReference;

/**
 * Created by Sebastian on 2016-11-06.
 */
public class Contacto {
    private String Nombre;
    private String Telefono;
    private String Correo;

    public Contacto(String nombre,String telefono, String correo) {
        Telefono = telefono;
        Nombre = nombre;
        Correo = correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }
}
