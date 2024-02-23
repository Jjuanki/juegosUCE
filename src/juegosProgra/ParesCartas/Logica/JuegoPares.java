package juegosProgra.ParesCartas.Logica;

import java.util.Random;
import java.util.Scanner;
import juegosProgra.ParesCartas.utils.Colores;


public class JuegoPares {
	Random rand;
	Scanner sc;
	static int count = 0;
	static char[] posiciones;
	static char[] reversos;
	int cuadrados;
	int intentos;
	Simbolos simb;
	static char[] caracteres;
	public JuegoPares(int num) {
		sc= new Scanner(System.in);
		simb= new Simbolos();
		cuadrados = num;
		rand=new Random();
		posiciones = new char[num];
		reversos = new char[num];
		caracteres = new char[num];
		iniciarPosiciones();
		intentos=num/2;
	}
	private void iniciaCaracteres(){
		for (int i = 0; i < caracteres.length; i++) {
			caracteres[i]= Simbolos.simbolos[i];
		}
	}
	private void iniciarPosiciones() {
		char aux1= 49;
		char aux2=65;
		for (int i = 0; i < cuadrados; i++) {
			if(i>8) {
				posiciones[i]=aux2++;
			}else {
				posiciones[i]=aux1++;
			}	
		}
	}

	private void lineaSuperior(int x) {
		for (int i = 0; i < x; i++) {
			print(1, "╔");
			print(3, "═");
			print(1, "╗");
			print(2, " ");
		}
		System.out.println();
	}

	private void lineaMedia(int x) {
		for (int aux = count; aux < x; aux++) {
			if (aux > 8) {
				print(1, "║");
				if(posiciones[aux]>1000) {
					System.out.print(""+ Colores.verde + posiciones[aux]+ Colores.b + " ");
				}
				else {
					System.out.print(" "+ Colores.celeste + posiciones[aux] + Colores.b + " ");
				}
				print(1, "║");
				print(2, " ");

			} else {
				print(1, "║");
				if(posiciones[aux]>1000) {
					System.out.print(" "+ Colores.verde + posiciones[aux]+ Colores.b + " ");
				}else {
					System.out.print(" "+ Colores.celeste + posiciones[aux] + Colores.b + " ");
				}
				
				print(1, "║");
				print(2, " ");
			}
			count = aux + 1;
		}
		System.out.println();	
	}

	private void lineaInferior(int x) {
		for (int i = 0; i < x; i++) {
			print(1, "╚");
			print(3, "═");
			print(1, "╝");
			print(2, " ");
		}
		System.out.println();
	}

	private void print(int n, String txt) {
		for (int i = 0; i < n; i++) {
			System.out.print(txt);
		}
	}

	public void dibujar() {
		System.out.println(Colores.celeste+"Numero de intentos: "+intentos+Colores.b);
		for (int i = 0; i < cuadrados / 4; i++) {
			lineaSuperior(4);
			lineaMedia((i + 1) * 4);
			lineaInferior(4);
		}
		count=0;

	}

	private void reemplazar(char pos, char[] cambio) {
		for (int i = 0; i < posiciones.length; i++) {
		 if(posiciones[i]== pos || reversos[i]== pos ) {
			 posiciones[i]= cambio[i];
			 break;
		 }
			
		}
	}

	private void restaurarReversos() {
	    for (int i = 0; i < posiciones.length; i++) {
	        posiciones[i] = reversos[i];
	    }
	}

	private int obtenerPosicion(char n) {
		for (int i = 0; i < reversos.length; i++) {
			if (reversos[i] == n){
				return i;
			}
		}
		return 100;
	}

	private boolean validar(String a, String b) {
		return (posiciones[(obtenerPosicion(a.charAt(0)))]==posiciones[(obtenerPosicion(b.charAt(0)))]);
	}

	private void inicializarReverso(){
		for (int i = 0; i < posiciones.length; i++) {
			reversos[i]=posiciones[i];
		}
	}

	public void jugar() {
		inicializarReverso();
		boolean continuar = true;
		System.out.println("Encuentra los pares de cartas!");

		do {
			dibujar();
			System.out.println("Elige una carta para voltear>>");
			String txt=(sc.next()).toUpperCase();
			reemplazar(txt.charAt(0),Simbolos.simbolos);
			dibujar();
			System.out.println("Elige una carta para voltear>>");
			String txt1= (sc.next()).toUpperCase();
			reemplazar(txt1.charAt(0),Simbolos.simbolos);
			dibujar();
			if(validar(txt,txt1)) {
				inicializarReverso();
				System.out.println("Correcto");
				continue;
			}else {
				System.out.println("Incorrecto, -1 intento");
				restaurarReversos();
				--intentos;
			}

			if(intentos==0) {
				System.out.println("Perdiste");
				continuar=false;
			}
		}while(continuar);
	
	}
	public record Simbolos(){
		
		public static char[] simbolos;
		 public Simbolos() {
		        simbolos = new char[16];
		        simbolos[0] = '\u2600';
		        simbolos[1] = '\u2601';
		        simbolos[2] = '\u2602';
		        simbolos[3] = '\u2603';
		        simbolos[4] = '\u2604';
		        simbolos[5] = '\u2640';
		        simbolos[6] = '\u2641';
				simbolos[7] = '\u2642';

				simbolos[8] = '\u2600';
				simbolos[9] = '\u2601';
				simbolos[10] = '\u2602';
				simbolos[11] = '\u2603';
				simbolos[12] = '\u2604';
				simbolos[13] = '\u2640';
				simbolos[14] = '\u2641';
				simbolos[15] = '\u2642';
		       /* simbolos[8] = '\u2643';
		        simbolos[9] = '\u2644';
		        simbolos[10] = '\u2645';
			 	simbolos[11] = '\u2646';
			 	simbolos[12] = '\u2647';
			 	simbolos[13] = '\u2648';
			 	simbolos[14] = '\u2649';
			 	simbolos[15] = '\u2649'; */

		    }
		
	}

}