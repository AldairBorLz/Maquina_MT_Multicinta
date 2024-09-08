package com.mycompany.mat_multicinta;
import java.util.Scanner;
import java.util.Arrays;

public class Controlador {

    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de cintas: ");
        int numCintas = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        System.out.print("Ingrese el estado inicial: ");
        String estadoInicial = scanner.nextLine();

        System.out.print("Ingrese el estado final: ");
        String estadoFinal = scanner.nextLine();

        Modelo modelo = new Modelo(numCintas, estadoInicial, estadoFinal);

        for (int i = 0; i < numCintas; i++) {
            System.out.print("Ingrese la cadena para la cinta " + (i + 1) + ": ");
            String cadena = scanner.nextLine();
            modelo.setCinta(i, cadena);
        }

        while (true) {
            System.out.print("Ingrese la transición (estado actual, símbolos actuales, nuevo estado, símbolos a escribir, movimientos) o 'fin' para terminar: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("fin")) {
                break;
            }

            String[] partes = input.split(",\\s*");
            if (partes.length < 5) {
                System.out.println("Formato incorrecto. Asegúrate de ingresar todos los parámetros.");
                continue;
            }

            String estadoActual = partes[0];
            char[] simbolosActuales = partes[1].toCharArray();
            String nuevoEstado = partes[2];
            char[] simbolosEscribir = partes[3].toCharArray();
            String[] movimientosStr = partes[4].split("\\s+");

            // Verifica si los movimientos coinciden con el número de cintas
            if (movimientosStr.length != numCintas) {
                System.out.println("El número de movimientos no coincide con el número de cintas.");
                continue;
            }

            int[] movimientos = new int[numCintas];
            try {
                for (int i = 0; i < movimientosStr.length; i++) {
                    movimientos[i] = Integer.parseInt(movimientosStr[i]);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir los movimientos. Asegúrate de ingresar números.");
                continue;
            }

            Transicion transicion = new Transicion(nuevoEstado, simbolosEscribir, movimientos);
            modelo.agregarTransicion(estadoActual, simbolosActuales, transicion);
        }

        if (modelo.procesar()) {
            System.out.println("Cadena aceptada.");
        } else {
            System.out.println("Cadena rechazada.");
        }
    }
}
