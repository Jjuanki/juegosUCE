package juegosProgra.flappyBird.fb;

import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Jugar extends Timer {

    Scanner sc = new Scanner(System.in);
    Pantalla pantalla = new Pantalla(8, 7);
    Bird b = new Bird(3, 1, '@');
    Bird.Obstacle o = b.new Obstacle('*', 0, 7);
    Bird.Obstacle o2 = b.new Obstacle('*', 1, 7);
    Bird.Obstacle o3 = b.new Obstacle('*', 2, 7);


    public void juego() {

       
        scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!b.colision()) {
                    b.caida();
                    o.mover();
                    o2.mover();
                    o3.mover();
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
