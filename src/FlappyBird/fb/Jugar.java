package FlappyBird.fb;

import java.util.Random;
import FlappyBird.util.ObjetoGrafico;

public class Jugar {
    Bird b = new Bird(3, 1, '@');
    Bird.Obstacle o = b.new Obstacle('*', 7, 0);

    public void validarMovimiento() {
        
        if (Pantalla.mPantalla[b.getX()][b.getY()] == o.getSimbolo()) {

            System.out.println("Has muerto");

        }
    }

}
