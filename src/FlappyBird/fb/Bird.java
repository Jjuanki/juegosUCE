package FlappyBird.fb;

import FlappyBird.util.Mover;
import FlappyBird.util.ObjetoGrafico;

public class Bird extends ObjetoGrafico implements Mover {
    private int ejeX;
    private int ejeY;
    private char bird;

    Pantalla p = new Pantalla(8, 7);

    public Bird(int ejeX, int ejeY, char bird) {
        setX(ejeX);
        setY(ejeY);
        setSimbolo(bird);
    }

    @Override
    public void mover (ObjetoGrafico ob) {
        p.borrarCelda(ob.getX(), ob.getY());
        p.mPantalla[ob.getX()-1][ob.getY()] = getSimbolo();
    }

    public class Obstacle extends ObjetoGrafico implements Mover {

        private char obstacle;
        private int ejeY;
        private int ejeX;

        public Obstacle(char obstacle, int ejeY, int ejeX) {
            setX(ejeX);
            setY(ejeY);
            setSimbolo(obstacle);
        }

        @Override
        public void mover(ObjetoGrafico ob) {

            p.mPantalla[ob.getX()][ob.getY()-1] = getSimbolo();

     
        }


    }

    
}