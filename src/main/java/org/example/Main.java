package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        Scanner scn2 = new Scanner(System.in);
        List<String> jugadores = new ArrayList<>();

        boolean flag = true;

        do {
            int opcion1;

            System.out.println("\n\tMenú iniciar\n\n1) Añadir jugador\n2) Empezar juego\nopcion:");
            opcion1 = scn.nextInt();

            switch (opcion1){
                case 1:
                    System.out.println("\n\nIngresar nombre del jugador: ");
                    jugadores.add(scn2.next());
                    break;
                case 2:
                    if (jugadores.toArray().length < 2) {
                        System.out.println("\n\nNumero invalido de jugadores");
                    } else {
                        flag = false;
                    }
                    break;
            }
        } while (flag);

        System.out.println("\n\n\tInciando juego");
        RuletaRusa ruletaRusa = new RuletaRusa();
        ruletaRusa.cargarJugadores(jugadores);

        do {
            //System.out.println(ruletaRusa.toString());
            ruletaRusa.disparar(ruletaRusa.getJugadorActual());
            ruletaRusa.siguienteTirador();
            int num = scn.nextInt();
        } while (ruletaRusa.isVivoMuerto());

        System.out.println("\n\n\tFin del juego");

    }
}