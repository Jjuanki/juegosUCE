package juegosProgra.flappyBird.fb;

import juegosProgra.flappyBird.util.Mover;
import juegosProgra.flappyBird.util.ObjetoGrafico;

public class Bird extends ObjetoGrafico implements Mover {

    Pantalla p = new Pantalla(8, 7);
    public Bird(int ejeX, int ejeY, char bird) {
        setX(ejeX);
        setY(ejeY);
        setSimbolo(bird);
    }

    @Override
    public void mover() {

        p.borrarCelda(getX(), getY());
        Pantalla.mPantalla[getX() - 1][getY()] = getSimbolo();
        setX(getX() - 1);
    }

    public class Obstacle extends ObjetoGrafico implements Mover {

        public Obstacle(char obstacle, int ejeX, int ejeY) {
            setX(ejeX);
            setY(ejeY);
            setSimbolo(obstacle);
        }

        @Override
        public void mover() {

            p.borrarCelda(getX(), getY());
            Pantalla.mPantalla[getX()][getY()-1] = getSimbolo();
            setY(getY() - 1);

        }

        public void caida(ObjetoGrafico ob) {
            p.borrarCelda(getX(), getY());
        }

    }
}
