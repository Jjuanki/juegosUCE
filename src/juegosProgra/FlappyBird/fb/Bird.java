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
    public void mover(ObjetoGrafico ob) {

        p.borrarCelda(ob.getX(), ob.getY());
        Pantalla.mPantalla[ob.getX() - 1][ob.getY()] = getSimbolo();
        setX(getX() - 1);
    }

    public class Obstacle extends ObjetoGrafico implements Mover {

        public Obstacle(char obstacle, int ejeY, int ejeX) {
            setX(ejeX);
            setY(ejeY);
            setSimbolo(obstacle);
        }

        @Override
        public void mover(ObjetoGrafico ob) {

            p.borrarCelda(ob.getX(), ob.getY());
            Pantalla.mPantalla[ob.getX() - 1][ob.getY()] = getSimbolo();
            ob.setX(ob.getX() - 1);

        }

        public void caida(ObjetoGrafico ob) {
            p.borrarCelda(getX(), getY());
        }

    }
}
