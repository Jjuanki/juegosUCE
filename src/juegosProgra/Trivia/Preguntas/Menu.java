
import java.util.Scanner;

public class Menu {

    private static String []bancoPreguntasFacil;
    private static String []bancoPreguntasMedio;
    private static String []bancoPreguntasDificil;

    // de la posicon cada 4 son opciones de la primera pos de bancoPreguntas
    private static int []respuestasFacil;
    private static int []respuestasMedio;
    private static int []respuestasDificil;
        

    public void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inicio");
        System.out.println("un juego de PREGUNTAS, con 3 dificultades");

        System.out.println();
        System.out.println("Dificultades: ");
        System.out.println("1: facil");
        System.out.println("2: Medio");
        System.out.println("3: Dificil");
        
        int opcion;
        do {
            System.out.print("Escoge la dificultad: ");
            opcion = scanner.nextInt();
        } while (opcion < 1 || opcion > 3);

        switch (opcion) {
            case 1:
               System.out.println("@@@@@@@@@@@@ PREGUNTAS FACIL @@@@@@@@@@@@");
                preguntas(opcion);
                break;
            case 2:
                System.out.println("@@@@@@@@@@@@ PREGUNTAS Medio @@@@@@@@@@@@");
                preguntas(opcion);
                break;
            case 3:
                System.out.println("@@@@@@@@@@@@ PREGUNTAS Difícil @@@@@@@@@@@@");
                preguntas(opcion);
                break;
            default:
                break;
        }
    }

    public void preguntas(int Dificultad){
        switch(Dificultad){
            case 1:
                printPreguntas(bancoPreguntasFacil, respuestasFacil);
                break;
            case 2:
                printPreguntas(bancoPreguntasMedio, respuestasMedio);
                
                break;
            case 3:
                printPreguntas(bancoPreguntasDificil, respuestasDificil);
                
                break;
            default:
                break;
        }
    }

    private void printPreguntas(String[] pregunta, String[] respuesta){
        int count = 0;
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);

     do{
           System.out.println(pregunta[count]);
        System.out.println("1. a: ");
        System.out.println("2. b: ");
        System.out.println("3. c: ");
        System.out.println("4. d: ");
        int opcion;
        do{
            System.out.print(": ");
            opcion = scanner.nextInt();
        }while(opcion < 1 || opcion > 4);
        if(validar(respuesta, opcion, count)){
            System.out.println("Correcto");
        }else{
            System.out.println("Incorrecto");
        }
        count++;
     }while(count < pregunta.length);

    }

    private boolean validar(int[] respuestas, int respuesta, int posicion){
        if(respuestas[posicion] == respuesta){
            return true;
        }
        return false;
    }
}