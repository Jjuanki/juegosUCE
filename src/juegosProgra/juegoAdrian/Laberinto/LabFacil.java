package juegosProgra.juegoAdrian.Laberinto;

import java.util.Random;

public class LabFacil {
    private char[][] mapa;
    private int filas;
    private int columnas;
    public LabFacil(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        mapa = new char[filas][columnas];
        inicializarMapa();
    }

   private void inicializarMapa() {
        Random random = new Random();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i % 2 == 0 || j % 2 == 0) {
                    mapa[i][j] = '#';
                } else {
                    mapa[i][j] = ' ';
                }
            }
        }
       
        mapa[0][1] = 'S';
        mapa[filas - 1][columnas - 2] = 'E'; 
    }

    public void imprimirLaberinto() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(mapa[i][j] + " ");
            }
            System.out.println();
        }
    }
}
