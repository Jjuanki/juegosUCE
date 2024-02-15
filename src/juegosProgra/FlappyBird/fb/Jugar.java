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
        
        public void juego() {
        pantalla.rellenarPantalla();
        pantalla.agregarCelda(b);
        pantalla.agregarCelda(o);
        pantalla.agregarCelda(o2);
        pantalla.agregarCelda(o3);
        
        scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!b.colision()) {
                    b.caida();
                    if (!b.validarMovimiento(b)) {
                        
                        if (!o.validarMovimiento(o)) {
                            o.mover();
                            o2.mover();
                            o3.mover();
                            pantalla.imprimirPantalla();
                        } 
                    }else {
                        System.out.println("te comiste la pared");
                        cancel();
                    }

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
