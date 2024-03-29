package juegosProgra.FlappyBird.fb;

import juegosProgra.FlappyBird.util.ObjetoGrafico;

public class Pantalla {

    public static char[][] mPantalla;

        public Pantalla(int ancho, int alto) {
        mPantalla = new char[alto][ancho];
    }

    public void rellenarPantalla() {
        for (int i = 0; i < mPantalla.length; i++) {
            for (int j = 0; j < mPantalla[i].length; j++) {
                if (i == mPantalla.length-1 || i == 0|| j == 0)  {
                    mPantalla[i][j] = '#';
                } else{
                    
                    mPantalla[i][j] = '.';
                }
            }
        }

    }


    public void imprimirPantalla() {
        System.out.println("--------------");
        for (int i = 0; i < mPantalla.length; i++) {
            for (int j = 0; j < mPantalla[i].length; j++) {
                System.out.print(mPantalla[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------");

    }

    public void borrarCelda(int x, int y) {
        mPantalla[x][y] = '.';
    }

    public void agregarCelda(ObjetoGrafico og) {

        mPantalla[og.getX()][og.getY()] = og.getSimbolo();
    }

}
