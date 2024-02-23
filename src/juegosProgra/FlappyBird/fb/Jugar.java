package juegosProgra.flappyBird.fb;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Jugar extends Timer {

    Scanner sc = new Scanner(System.in);
    Pantalla pantalla = new Pantalla(10, 9);
    Bird b = new Bird(4, 2, '@');
    Bird.Obstacle o = b.new Obstacle('*', 1, 9);
    Bird.Obstacle o2 = b.new Obstacle('*', 2, 9);
    Bird.Obstacle o3 = b.new Obstacle('*', 3, 9);
    Bird.Obstacle o4 = b.new Obstacle('*', 5, 2);
    Bird.Obstacle o5 = b.new Obstacle('*', 6, 2);
    Bird.Obstacle o6 = b.new Obstacle('*', 7, 2);

    public void juego() {
        pantalla.rellenarPantalla();
        pantalla.agregarCelda(b);
        pantalla.agregarCelda(o);
        pantalla.agregarCelda(o2);
        pantalla.agregarCelda(o3);
        pantalla.agregarCelda(o4);
        pantalla.agregarCelda(o5);
        pantalla.agregarCelda(o6);

        scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!b.colision() && !b.validarMovimiento()) {
                    b.caida();

                    o.mover();
                    o2.mover();
                    o3.mover();
                    o4.mover();
                    o5.mover();
                    o6.mover();
                    pantalla.imprimirPantalla();

                } else {
                    System.out.println("has muerto");
                    cancel();
                }
            }
        }, 0, 2000);

        Scanner sc = new Scanner(System.in);
        while (true) {
            String inp = sc.nextLine();
            if (inp.equals("")) {
                b.mover();
                b.mover();
            }

        }
    }

}
