package juegosProgra.Menu;

import java.util.Scanner;

import juegosProgra.FlappyBird.fb.MenuFlappy;
import juegosProgra.ParesCartas.Logica.JuegoPares;
import juegosProgra.Trivia.Principal;
import juegosProgra.cartaSucia.Juego.Main;
import juegosProgra.juegoAdrian.MenuLab;

public class Menu {
    public static void main(String[] args) {
        

        Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("BIENVENIDO A JUEGOS JUAN...");
        System.out.println("TENEMOS 5 JUEGOS");
        System.out.println();
        System.out.println("Dificultades: ");
        System.out.println("1: Carta Sucia");
        System.out.println("2: FlappyBird");
        System.out.println("3: Laberinto");
        System.out.println("4: Pares de Cartas");
        System.out.println("5: Trivia");
        
        int opcion;
        
        do {
            System.out.print("Cual Quieres jugar?: ");
            opcion = scanner.nextInt();
        } while ((opcion < 1 || opcion > 3) && !scanner.hasNextInt());
        
        switch (opcion) {
            case 1:
                Main.main(args);
                break;
            case 2:
                new MenuFlappy();
                break;
            case 3:
                MenuLab menu = new MenuLab();
                menu.menu();
                break;
            case 4:
                JuegoPares obj= new JuegoPares(16);		
                obj.jugar();
                break;
            case 5:
                Principal.main(args);
                break;
            default:
                break;
        }
    }
}
