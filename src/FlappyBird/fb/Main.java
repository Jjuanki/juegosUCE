package FlappyBird.fb;

import FlappyBird.util.Mover;

public class Main {
    public static void main(String[] args) {
        Bird b = new Bird(3 , 1, '@');
        Bird.Obstacle o   = b.new Obstacle('*', 4, 2);
        Pantalla pantalla = new Pantalla(8,7);
        
        pantalla.agregarCelda(b);
        pantalla.agregarCelda(o);
        pantalla.imprimirPantalla();

      
    }

}
