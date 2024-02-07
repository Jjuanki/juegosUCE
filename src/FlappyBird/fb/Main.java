package FlappyBird.fb;

import FlappyBird.util.Mover;

public class Main {
    public static void main(String[] args) {
        Bird b = new Bird(3 , 1, '@');
        Pantalla pantalla = new Pantalla(8,7);
        pantalla.rellenarPantalla();
        pantalla.agregarCelda(b);
        pantalla.imprimirPantalla();
       System.out.println("hola");
    }

}
