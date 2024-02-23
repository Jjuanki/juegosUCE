package juegosProgra.FlappyBird.fb;

import java.util.Scanner;

public class Menu {
	Scanner sc = new Scanner(System.in);
	Jugar juego = new Jugar();
	String validar = "j";
	public Menu(){
		System.out.println("presione la 'j' para iniciar");
		
		if((sc.nextLine().toLowerCase()).equals(validar)){
			juego.juego();	
		}
		else { 
			System.out.println("hasta luego");
		}
	}	
}
