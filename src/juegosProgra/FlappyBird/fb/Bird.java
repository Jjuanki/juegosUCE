package juegosProgra.flappyBird.fb;

import juegosProgra.flappyBird.util.Mover;
import juegosProgra.flappyBird.util.ObjetoGrafico;

public class Bird extends ObjetoGrafico implements Mover {

    Pantalla p = new Pantalla(10, 9);

    public Bird(int ejeX, int ejeY, char bird) {

        setX(ejeX);
        setY(ejeY);
        setSimbolo(bird);
    }

    @Override
    public boolean validarMovimiento() {
        if (getX() == Pantalla.mPantalla.length-1 || getX() == 0|| getY() == 0)  {
            return true;
        } else{
            
            return false;
        }
    }

    @Override
    public void mover() {

        p.borrarCelda(getX(), getY());
        Pantalla.mPantalla[getX() - 1][getY()] = getSimbolo();
        setX(getX() - 1);
    }

    public void caida() {
        p.borrarCelda(getX(), getY());
        Pantalla.mPantalla[getX() + 1][getY()] = getSimbolo();
        setX(getX() + 1);
    }

    public boolean colision() {
        if (Pantalla.mPantalla[getX()][getY()] == '*') {

            return true;
        } else {
            return false;
        }
    }

    @Override
    public void reset() {

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
            Pantalla.mPantalla[getX()][getY() - 1] = getSimbolo();
            setY(getY() - 1);

        }

        public void replaceBordes() {
            Pantalla.mPantalla[getX()][getY()] = '#';
        }

        @Override
        public void reset() {
            setX(getX());
            setY(getY());
        }

        @Override
        public boolean validarMovimiento() {
            if (getY() == 0)  {
                return true;
            } else{
                
                return false;
            }
        }

    }

}
