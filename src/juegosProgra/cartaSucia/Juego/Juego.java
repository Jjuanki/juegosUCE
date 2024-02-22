package Juego;

import java.util.TimerTask;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

public class Juego {
	Random r = new Random();
	Timer time = new Timer();
	Scanner sc = new Scanner(System.in);
	static int p = 0;
	static int t = 0;
	static int puntaje=0;

	// ♠ ♦ ♥ ♣
	public void jugar() {
		Carta car[] = new Carta[52];
		String palos[] = new String[] { "♠", "♦", "♥", "♣" };
		String val[] = new String[] { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		for (int i = 0; i < palos.length; i++) {
			for (int j = 0; j < val.length; j++) {
				car[t++] = new Carta(val[j], palos[i]);
			}
		}
		/*TimerTask tecla = new TimerTask() {
			public void run() {
				String s = sc.next();
			}
		};*/

		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				int q = r.nextInt(52);
				System.out.println(val[p]);
				System.out.println(car[q]);
				if (p == 12) {
					p = 0;
				}
				if (val[p] == car[q].getValor()) {
					System.out.println("Ganaste un punto");
					++puntaje;
					System.out.println("Puntaje: "+ puntaje);
				}
				p++;
			}
			
			
		};

		time.schedule(tarea, 5000, 900);

	}
}
