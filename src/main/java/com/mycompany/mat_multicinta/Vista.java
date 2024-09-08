/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mat_multicinta;
import java.util.Scanner;
/**
 *
 * @author aldair
 */
public class Vista {
    private Scanner scanner = new Scanner(System.in);

    public int solicitarNumeroCintas() {
        System.out.print("Ingrese el número de cintas: ");
        return scanner.nextInt();
    }

    public String solicitarEstadoInicial() {
        System.out.print("Ingrese el estado inicial: ");
        return scanner.next();
    }

    public String solicitarEstadoFinal() {
        System.out.print("Ingrese el estado final: ");
        return scanner.next();
    }

    public String solicitarCadena(int indiceCinta) {
        System.out.print("Ingrese la cadena para la cinta " + (indiceCinta + 1) + ": ");
        return scanner.next();
    }

    public String[] solicitarTransicion() {
        System.out.print("Ingrese la transición (estado actual, símbolos actuales, nuevo estado, símbolos a escribir, movimientos): ");
        scanner.nextLine(); // Limpiar el buffer
        String input = scanner.nextLine();
        return input.split(", ");
    }

    public void mostrarResultado(boolean aceptada) {
        if (aceptada) {
            System.out.println("Cadena aceptada.");
        } else {
            System.out.println("Cadena no aceptada.");
        }
    }

}
