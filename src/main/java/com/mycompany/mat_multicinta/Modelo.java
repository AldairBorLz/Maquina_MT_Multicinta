/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mat_multicinta;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author aldair
 */
public class Modelo {
    private int numCintas;
    private Map<String, Map<String, Transicion>> transiciones;
    private List<StringBuilder> cintas;
    private int[] posicionesCabeza;
    private String estadoActual;
    private String estadoFinal;

    public Modelo(int numCintas, String estadoInicial, String estadoFinal) {
        this.numCintas = numCintas;
        this.estadoActual = estadoInicial;
        this.estadoFinal = estadoFinal;
        this.transiciones = new HashMap<>();
        this.cintas = new ArrayList<>();
        this.posicionesCabeza = new int[numCintas];
        for (int i = 0; i < numCintas; i++) {
            cintas.add(new StringBuilder("B"));
            posicionesCabeza[i] = 0;
        }
    }

    public void agregarTransicion(String estado, char[] simbolos, Transicion transicion) {
        transiciones.putIfAbsent(estado, new HashMap<>());
        // Cambiado para usar new String(simbolos) como clave
        transiciones.get(estado).put(new String(simbolos), transicion);
    }

    public void setCinta(int indice, String cadena) {
        cintas.set(indice, new StringBuilder(cadena + "B"));
    }

    public boolean procesar() {
        while (!estadoActual.equals(estadoFinal)) {
            char[] simbolosActuales = new char[numCintas];
            for (int i = 0; i < numCintas; i++) {
                simbolosActuales[i] = cintas.get(i).charAt(posicionesCabeza[i]);
            }

            Map<String, Transicion> transicionesEstado = transiciones.get(estadoActual);
            // Cambiado para usar new String(simbolosActuales) como clave
            if (transicionesEstado == null || !transicionesEstado.containsKey(new String(simbolosActuales))) {
                return false; // No hay transición para los símbolos actuales
            }

            Transicion transicion = transicionesEstado.get(new String(simbolosActuales));
            estadoActual = transicion.getNuevoEstado();
            for (int i = 0; i < numCintas; i++) {
                cintas.get(i).setCharAt(posicionesCabeza[i], transicion.getSimbolosEscribir()[i]);
                posicionesCabeza[i] += transicion.getMovimientos()[i];
                if (posicionesCabeza[i] == cintas.get(i).length()) {
                    cintas.get(i).append('B');
                } else if (posicionesCabeza[i] < 0) {
                    cintas.get(i).insert(0, 'B');
                    posicionesCabeza[i] = 0;
                }
            }
        }
        return true; // Cadena aceptada
    }
    
}
