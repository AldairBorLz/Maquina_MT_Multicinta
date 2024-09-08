/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mat_multicinta;

/**
 *
 * @author aldair
 */
public class MaT_Multicinta {

    public static void main(String[] args) {
        Vista vista = new Vista();
        Modelo modelo = null; // Se inicializa en el controlador
        Controlador controlador = new Controlador(modelo, vista);
        controlador.iniciar();
    }
}
