package juegosProgra.juegoAdrian;

import java.util.Scanner;

import juegosProgra.juegoAdrian.Laberinto.Laberinto;

public class Menu{
    
    public static void menu(){
        System.out.println("BIENVENIDO AL LABERINTO...");
        System.out.println("1: facil");
        System.out.println("2: Medio");
        System.out.println("3: Dificil");
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do { 
            System.out.print("Elige la dificultad: ");
            opcion = scanner.nextInt();
        } while (opcion < 1 || opcion > 3);
        switch (opcion) {
            case 1:
                System.out.println("Laberinto Fácil:");
                Laberinto facil = new Laberinto(11, 11);
                jugar(facil);
                break;
            case 2:
                System.out.println("\nLaberinto Medio:");
                Laberinto medio = new Laberinto(21, 21);
                jugar(medio);
                break;
            case 3:
                System.out.println("\nLaberinto Difícil:");
                Laberinto dificil = new Laberinto(31, 31);
                jugar(dificil);
                break;
            default:
                break;
        }
    }

    public static void jugar(Laberinto lab){
        Scanner scanner = new Scanner(System.in);
        char op;
        do {
            lab.imprimirLaberinto();
            System.out.print("Ingrese la dirección (w/a/s/d) o q para salir: ");
            op = scanner.nextLine().charAt(0);
            if (op != 'q') {
                lab.moverJugador(op);
            }
        } while (op != 'q');
    }
}
