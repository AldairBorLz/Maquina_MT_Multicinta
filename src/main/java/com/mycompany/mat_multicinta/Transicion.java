/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mat_multicinta;

/**
 *
 * @author aldair
 */
public class Transicion {
    private String nuevoEstado;
    private char[] simbolosEscribir;
    private int[] movimientos;

    public Transicion(String nuevoEstado, char[] simbolosEscribir, int[] movimientos) {
        this.nuevoEstado = nuevoEstado;
        this.simbolosEscribir = simbolosEscribir;
        this.movimientos = movimientos;
    }

    public String getNuevoEstado() {
        return nuevoEstado;
    }

    public char[] getSimbolosEscribir() {
        return simbolosEscribir;
    }

    public int[] getMovimientos() {
        return movimientos;
    }
}

