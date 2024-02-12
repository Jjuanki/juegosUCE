package juegosProgra.flappyBird.fb;
import java.util.Timer;
import java.util.TimerTask;

import juegosProgra.flappyBird.util.ObjetoGrafico;
public class Jugar {

    public void validarMovimiento(ObjetoGrafico bird, ObjetoGrafico obstacle) {
        if (Pantalla.mPantalla[bird.getX()][bird.getY()] == obstacle.getSimbolo()) {

            System.out.println("Has muerto");

        }
    }

    public void jugar(){

        Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {

            @Override
            public void run() {
               
            }
            
        };

        Jugar j = new Jugar();
        Pantalla pantalla = new Pantalla(8, 7);
        Bird b = new Bird(3,1, '@');
        Bird.Obstacle o = b.new Obstacle('*', 7,0);
        Bird.Obstacle o2 = b.new Obstacle('*', 7,1);
        Bird.Obstacle o3 = b.new Obstacle('*', 7,2);
        pantalla.rellenarPantalla();
        pantalla.agregarCelda(b);
        pantalla.agregarCelda(o);
        pantalla.agregarCelda(o2);
        pantalla.agregarCelda(o3);
        pantalla.imprimirPantalla();
    }

}
