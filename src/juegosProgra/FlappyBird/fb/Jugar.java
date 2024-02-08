package juegosProgra.flappyBird.fb;

import java.util.Random;

import juegosProgra.FlappyBird.util.ObjetoGrafico;
public class Jugar {

    public void validarMovimiento(ObjetoGrafico bird, ObjetoGrafico obstacle) {
        if (Pantalla.mPantalla[obstacle.getX()][bird.getY()] == obstacle.getSimbolo()) {

            System.out.println("Has muerto");

        }
    }

}
