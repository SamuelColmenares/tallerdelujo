/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tallerdelujo.entidades;

/**
 *
 * @author Samu-Pc
 */
public class Empleado {
    int idEmpleado;
    String Nombre;
    String Apellido;
    String cargo;
    String direccion;
    int telefono;

    public Empleado(int idEmpleado, String Nombre, String Apellido, String cargo, String direccion, int telefono) {
        this.idEmpleado = idEmpleado;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.cargo = cargo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
}
