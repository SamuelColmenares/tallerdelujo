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
public class Cliente {
    int cliente;
    String nombre;
    String Apellido;
    String tipoPago;
    int telefono;

    public Cliente(int cliente, String nombre, String Apellido, String tipoPago, int telefono) {
        this.cliente = cliente;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.tipoPago = tipoPago;
        this.telefono = telefono;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
}
