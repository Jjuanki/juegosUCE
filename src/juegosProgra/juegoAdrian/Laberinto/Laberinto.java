package juegosProgra.juegoAdrian.Laberinto;

import java.util.Random;

public class Laberinto {
    private int filas;
    private int columnas;
    private final char[][] laberinto;

    // que sea de uno o 2 jugadores
    // llevar el tiempo que los jugadores se demoran en realisar el lab
    // saber quien gano
    // cambiar de dificultad o no, despues de terminar el lab
    // puntaje
    
    public Laberinto(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.laberinto = new char[filas][columnas];
        
        generarLaberinto();
    }

    

    private void generarLaberinto() {
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[i].length; j++) {
                if (i == 0 && j == 1) {
                    laberinto[i][j] = 'J'; 
                } else if (i % 2 == 0 || j % 2 == 0) {
                    laberinto[i][j] = '|';
                } else {
                    laberinto[i][j] = ' '; 
                }
            }
        }
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
    }

    public boolean moverJugador(char direccion) {
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

        if (nuevaFila >= 0 && nuevaFila < filas && nuevaColumna >= 0 && nuevaColumna < columnas && laberinto[nuevaFila][nuevaColumna] == ' ') {
            laberinto[filaActual][columnaActual] = ' ';
            laberinto[nuevaFila][nuevaColumna] = 'J';
            if (comprobarWin(nuevaFila, nuevaColumna)) {
                System.out.println("HAZ SALIDOOOO!!!!!");
                return true;
            }
        } else {
            System.out.println("¡No puedes pasar por ahí!");
        }
        return false;
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

    private boolean comprobarWin(int x, int y){
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[i].length; j++) {
                if (i == laberinto.length - 1 || j == laberinto[i].length - 1) {
                    if (laberinto[i][j] == 'J') {
                        return true;
                    }
                } 
            }
        }
        return false;
    }
}

