package juegosProgra.juegoAdrian;

import java.util.Scanner;

import juegosProgra.juegoAdrian.Laberinto.Jugador;
import juegosProgra.juegoAdrian.Laberinto.Laberinto;

public class MenuLab{
    // public Jugador[] list;

    public void menu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("BIENVENIDO AL LABERINTO...");
        System.out.println("un juego de laberintos, con 3 dificultades");
        
        // addPlayer();

        System.out.println();
        System.out.println("Dificultades: ");
        System.out.println("1: facil");
        System.out.println("2: Medio");
        System.out.println("3: Dificil");
        
        int opcion;
        System.out.print("Escoge la dificultad: ");
        do {
            opcion = scanner.nextInt();
        } while (opcion < 1 || opcion > 3);
        
        switch (opcion) {
            case 1:
                System.out.println("@@@@@@@@@@@@ Laberinto Fácil @@@@@@@@@@@@");
                Laberinto facil = new Laberinto(11, 11);
                jugar(facil);
                break;
            case 2:
                System.out.println("@@@@@@@@@@@@ Laberinto Medio @@@@@@@@@@@@");
                System.out.println("Laberinto Medio:");
                Laberinto medio = new Laberinto(21, 21);
                jugar(medio);
                break;
            case 3:
                System.out.println("@@@@@@@@@@@@ Laberinto Difícil @@@@@@@@@@@@");
                Laberinto dificil = new Laberinto(31, 31);
                jugar(dificil);
                break;
            default:
                break;
        }
    }

    private void jugar(Laberinto lab){
        Scanner scanner = new Scanner(System.in);
        String op1;
        char op;
        boolean flag = true;
        do {
            lab.imprimirLaberinto();
            System.out.print("Ingrese la dirección (w/a/s/d) o q para salir: ");
            
            do {
                op1 = scanner.next();
            } while (op1.length() < 0);

            op = op1.charAt(0);
            if (op != 'q') {
                if (lab.moverJugador(op)) {
                    flag = false;
                }
            }
        } while (flag);
        System.out.println("DE NUEVO??...");
        System.out.println("1: SI ");
        System.out.println("2: NO ");
        int opcion;
        do {
            System.out.print(": ");;
            opcion = scanner.nextInt();
        } while (opcion < 1 || opcion > 2);

        switch (opcion) {
            case 1:
                menu();
                break;
            case 2:
                System.out.println("Despedida");
                break;
            default:
                break;
        }
        // for (int i = 0; i < players.length; i++) {
        //     System.out.println("Turno de: " + players[i].name());
        //     jugar2(lab);
        // }
    }

    // private void addPlayer(){
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.println("Jugar Solo\nJugar en Pareja");
    //     System.out.println("1: Solo");
    //     System.out.println("2: Pareja");
    //     int players;
    //     do {
    //         System.out.print(": ");
    //         players = scanner.nextInt();
    //     } while (players < 1 || players > 2);
    //     Jugador n;
    //     list = new Jugador[players+1];
    //     for (int i = 0; i < players; i++) {
    //         System.out.print("Nombre del " + (i+1) + " Jugador: ");
    //         String name = scanner.next();
    //         n = new Jugador(name);
    //         list[i] = n;
    //     }
    // }
}
