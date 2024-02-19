package juegosProgra.juegoAdrian.Laberinto;
import java.util.Random;
import java.util.Scanner;

public class Laberinto {
    private int filas;
    private int columnas;
    private final char[][] laberinto;
    
    int contador = 0;
    private int[][] posicionesCumplidas;
    boolean flag = true;

    public Laberinto(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.laberinto = new char[filas][columnas];
        this.posicionesCumplidas = new int[filas][columnas];
        generarLaberinto();
    }

    private void generarLaberinto() {
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[i].length; j++) {
                if (i == 0 && j == 1) {
                    laberinto[i][j] = 'J'; 
                } else if (i == laberinto.length - 1 && j == laberinto[i].length - 1) {
                    laberinto[i][j] = 'S'; 
                }else if (i % 2 == 0 || j % 2 == 0) {
                    laberinto[i][j] = '|';
                } else {
                    laberinto[i][j] = ' '; 
                }
            }
        }
        // Crear caminos aleatorios
        Random random = new Random();
        for (int i = 1; i < laberinto.length - 1; i += 2) {
            for (int j = 1; j < laberinto[i].length - 1; j += 2) {
                if (random.nextBoolean()) {
                    laberinto[i][j + 1] = ' ';
                } else {
                    laberinto[i + 1][j] = ' ';
                }
            }
        }
    }

    public void imprimirLaberinto() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(laberinto[i][j]);
            }
            System.out.println();
        }
        if (flag) {
            guardarUbi();
            flag = false;
        }
        
    }

    public void guardarUbi(){
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == laberinto.length - 1) {
                    if (laberinto[i][j] == ' ') {
                        posicionesCumplidas[contador][contador] = i; 
                        posicionesCumplidas[contador][contador] = j; 
                        contador++;
                    }
                } 
            }
        }
         // for (int i = 0; i < posicionesCumplidas.length; i++) {
        //     for (int j = 0; j < posicionesCumplidas[i].length; j++) {
        //     }
        // }
    }

    public void moverJugador(char direccion) {
        int[] posicionActual = encontrarPosicionJugador();
        int filaActual = posicionActual[0];
        int columnaActual = posicionActual[1];

        int nuevaFila = filaActual;
        int nuevaColumna = columnaActual;
        switch (direccion) {
            case 'w':
                nuevaFila--;
                break;
            case 's': 
                nuevaFila++;
                break;
            case 'a':
                nuevaColumna--;
                break;
            case 'd':
                nuevaColumna++;
                break;
        }

        if (esPosicionValida(nuevaFila, nuevaColumna)) {
            laberinto[filaActual][columnaActual] = ' ';
            laberinto[nuevaFila][nuevaColumna] = 'J';
        } else {
            System.out.println("¡No puedes pasar por ahí!");
        }
    }
    private boolean esPosicionValida(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas && laberinto[fila][columna] == ' ';
    }

    private int[] encontrarPosicionJugador() {
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[i].length; j++) {
                if (laberinto[i][j] == 'J') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}

