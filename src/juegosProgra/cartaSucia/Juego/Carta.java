package juegosProgra.cartaSucia.Juego;

public class Carta {

	private String valor;
	private String palo;

	public Carta(String valor, String palo) {
		this.valor = valor;
		this.palo = palo;
	}

	public String getValor() {
		return valor;
	}

	public String getPalo() {
		return palo;
	}

	@Override
	public String toString() {
		return  "┌───────┐\n" +
				"│ " + valor +"     │\n" +
				"│       │\n" + 
				"│   " + palo + "   │\n" + 
				"│       │\n"+
				"│     "+ valor +" │\n" +
				"└───────┘";
	}
}
