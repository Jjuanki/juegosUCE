package juegosProgra.FlappyBird.fb;

public class Main {
    public static void main(String[] args) {
        Pantalla pantalla = new Pantalla(8, 7);
        Bird b = new Bird(3, 1, '@');
        Bird.Obstacle o = b.new Obstacle('*', 7, 0);
        Jugar jugar = new Jugar();

        pantalla.rellenarPantalla();
        pantalla.agregarCelda(b);
        pantalla.agregarCelda(o);
        b.mover(b);
        b.mover(b);
        b.mover(b);
        pantalla.imprimirPantalla();
      
    }

}
