package juegosProgra.flappyBird.fb;

public class Main {

    public static void main(String[] args) {

        Jugar j = new Jugar();
        Pantalla pantalla = new Pantalla(10, 9);
        Bird b = new Bird(3, 2, '@');
        Bird.Obstacle o = b.new Obstacle('*', 1, 7);
        Bird.Obstacle o2 = b.new Obstacle('*', 2, 7);
        Bird.Obstacle o3 = b.new Obstacle('*', 3, 7);
        pantalla.rellenarPantalla();
        pantalla.agregarCelda(b);
        pantalla.agregarCelda(o);
        pantalla.agregarCelda(o2);
        pantalla.agregarCelda(o3);
        pantalla.imprimirPantalla();
        //j.juego();

    }

}
