package juegosProgra.Trivia.Preguntas;

import java.util.Scanner;

public class Menu {
    private int puntaje = 0;
    private static String[][] bancoPreguntasFacil =  {
        {"¿Qué significa HTML?", "a) Hyper Text Markup Language", "b) High Tech Multimedia Language", "c) Hyperlink and Text Management Language", "d) Home Tool Markup Language", "a"},
        {"¿Cuál es el lenguaje de programación más utilizado para crear páginas web interactivas?", "a) JavaScript", "b) Python", "c) Java", "d) Ruby", "a"},
        {"¿Cuál de las siguientes opciones es un lenguaje de programación de alto nivel?", "a) Assembly", "b) C++", "c) Python", "d) JavaScript", "c"},
        {"¿Qué significa CSS?", "a) Computer Style Sheets", "b) Cascading Style Sheets", "c) Creative Style Selector", "d) Content Structure Styling", "b"},
        {"¿Qué hace el siguiente código en JavaScript?\nconsole.log(\"Hola mundo!\");", "a) Imprime \"Hola mundo!\" en la consola del navegador.", "b) Muestra un mensaje emergente con \"Hola mundo!\".", "c) Crea una variable llamada \"Hola mundo!\".", "d) Ninguna de las anteriores.", "a"}
    };    
    private static String[][] bancoPreguntasMedio = 
    {
        {"¿Cuál es la diferencia entre == y === en JavaScript?", "a) == compara el valor y el tipo de datos, mientras que === solo compara el valor.", "b) === compara el valor y el tipo de datos, mientras que == solo compara el valor.", "c) == y === son iguales y se pueden usar indistintamente.", "d) === compara solo el valor, mientras que == compara el valor y el tipo de datos.", "b"},
        {"¿Qué hace el método slice() en JavaScript?", "a) Divide un array en dos arrays separados.", "b) Devuelve una copia de parte de un array dentro de un nuevo array.", "c) Reemplaza elementos en un array por otros elementos.", "d) Elimina elementos duplicados de un array.", "b"},
        {"¿Cuál es el resultado de la siguiente expresión en Python?\n5 + 4 * 3 / 2 - 1", "a) 11", "b) 13", "c) 8.5", "d) 12", "a"},
        {"¿Qué es una variable de instancia en Java?", "a) Una variable que se puede acceder sin crear una instancia de la clase.", "b) Una variable que se puede acceder desde cualquier método en la clase.", "c) Una variable que se puede acceder solo dentro del método en el que se declara.", "d) Una variable que se asocia con una instancia específica de una clase.", "d"},
        {"¿Qué significa MVC en el contexto de desarrollo web?", "a) Model-View-Configuration", "b) Model-View-Controller", "c) Model-View-Component", "d) Model-View-Connection", "b"}
    };
    private static String[][] bancoPreguntasDificil =
    {
        {"¿Qué es la recursión en programación?", "a) Un método que se llama a sí mismo dentro de su cuerpo.", "b) Un método que llama a otro método dentro de su cuerpo.", "c) Un método que tiene una implementación compleja.", "d) Un método que se ejecuta en un bucle infinito.", "a"},
        {"¿Cuál es la complejidad temporal del algoritmo de ordenamiento quicksort en el peor caso?", "a) O(n)", "b) O(n log n)", "c) O(n^2)", "d) O(log n)", "c"},
        {"¿Cuál es la diferencia entre una clase abstracta y una interfaz en Java?", "a) Una interfaz puede tener métodos implementados, mientras que una clase abstracta no.", "b) Una clase abstracta puede tener variables miembro, mientras que una interfaz no puede.", "c) Una clase abstracta puede heredar de múltiples clases, mientras que una interfaz no puede.", "d) Una interfaz puede tener constantes definidas, mientras que una clase abstracta no.", "a"},
        {"¿Qué es un puntero en C++?", "a) Una variable que almacena la dirección de memoria de otra variable.", "b) Una variable que almacena el valor de otra variable.", "c) Una variable que almacena el resultado de una operación aritmética.", "d) Una variable que almacena un valor booleano.", "a"},
        {"¿Qué es la recursión mutua en programación?", "a) Dos funciones se llaman entre sí dentro de sus cuerpos.", "b) Una función se llama a sí misma varias veces en un bucle.", "c) Una función llama a otra función que luego llama a la primera función.", "d) Dos funciones tienen el mismo nombre pero diferentes parámetros.", "a"}
    };
    

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
                printPreguntas(bancoPreguntasFacil);
                break;
            case 2:
                printPreguntas(bancoPreguntasMedio);
                
                break;
            case 3:
                printPreguntas(bancoPreguntasDificil);
                
                break;
            default:
                break;
        }
    }

    private void printPreguntas(String[][] preguntas){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < preguntas.length; i++) {
            System.out.println("PREGUNTA " + (i + 1) + ": " + preguntas[i][0]);
            // Mostrar las opciones
            for (int j = 1; j < preguntas[i].length - 1; j++) {
                System.out.println(preguntas[i][j]);
            }
            
            System.out.println("respuesta: ");

            String respuestaUsuario = scanner.nextLine().toLowerCase();

            if (respuestaUsuario.equals(preguntas[i][preguntas[i].length - 1])) {
                System.out.println("¡Respuesta correcta!");
                puntaje++;
            } else {
                System.out.println("Respuesta incorrecta. La respuesta correcta es: " + preguntas[i][preguntas[i].length - 1]);
            }
            System.out.println();
        }
        System.out.println("=======================");
        System.out.println("Correctas: " + puntaje);
        System.out.println("Incorrectas: " + (preguntas.length - puntaje));
        System.out.println("=======================");
        System.out.println("DE NUEVO??...");
        System.out.println("1: SI ");
        System.out.println("2: NO ");
        int opcion;
        do {
            System.out.print(": ");;
            opcion = scanner.nextInt();
        } while (opcion < 1 || opcion > 2);

        switch (opcion) {
            case 1:
                menu();
                break;
            case 2:
                System.out.println("CHAOOOO...");
                break;
            default:
                break;
        }
    }
}