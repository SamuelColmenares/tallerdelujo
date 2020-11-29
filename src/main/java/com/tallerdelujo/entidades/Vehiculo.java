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
public class Vehiculo {
    int idMatricula;
    String marca;
    int modelo;
    long chasis;

    public Vehiculo(int idMatricula, String marca, int modelo, long chasis) {
        this.idMatricula = idMatricula;
        this.marca = marca;
        this.modelo = modelo;
        this.chasis = chasis;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public long getChasis() {
        return chasis;
    }

    public void setChasis(long chasis) {
        this.chasis = chasis;
    }    
}
