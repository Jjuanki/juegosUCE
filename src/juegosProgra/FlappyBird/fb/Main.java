package juegosProgra.flappyBird.fb;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {

        Timer t = new Timer();
        Jugar j = new Jugar();
        Pantalla pantalla = new Pantalla(8, 7);
        Scanner sc = new Scanner(System.in);
        Bird b = new Bird(3, 1, '@');
        Bird.Obstacle o = b.new Obstacle('*', 0, 7);
        Bird.Obstacle o2 = b.new Obstacle('*', 1, 7);
        Bird.Obstacle o3 = b.new Obstacle('*', 2, 7);
        pantalla.rellenarPantalla();
        pantalla.agregarCelda(b);
        pantalla.agregarCelda(o);
        pantalla.agregarCelda(o2);
        pantalla.agregarCelda(o3);
        pantalla.imprimirPantalla();
        j.juego();

    }

}
