package cr.ac.lab.othello;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Board;
import model.Game;
import model.Player;
import java.util.Scanner;

public class App extends Application {
    private static Scanner sc = new Scanner(System.in);

    @Override
    public void start(Stage stage) { /* Método para JavaFX si se requiere */ }

    
    public static void main(String[] args) {
        String menuOpcon = "";
        while (!menuOpcon.equalsIgnoreCase("s")) {
            System.out.println("\n-----------------------------------------");
            System.out.println("       BIENVENIDO AL JUEGO OTHELLO       ");
            System.out.println("-----------------------------------------");
            System.out.println(" [J] - Empezar a Jugar");
            System.out.println(" [S] - Salir del Programa");
            System.out.println("-----------------------------------------");
            System.out.print(" Seleccione una opcion: ");
            menuOpcon = sc.next();

            if (menuOpcon.equalsIgnoreCase("j")) {
                iniciarPartida();
            } else if (!menuOpcon.equalsIgnoreCase("s")) {
                System.out.println("\n--- [!] Opcion invalida ---");
            }
        }
        System.out.println("\n--- Gracias por jugar. ¡Adios! ---");
        System.exit(0);
    }

    private static void iniciarPartida() {
        System.out.println("\n-----------------------------------------");
        System.out.print("Nombre Jugador 1 (Negras - X): ");
        String n1 = sc.next();
        System.out.print("Nombre Jugador 2 (Blancas - O): ");
        String n2 = sc.next();

        Board board = new Board(8, 8);
        Game othello = new Game(board, new Player(n1, 'N'), new Player(n2, 'B'));

      
   

    while (!othello.isGameOver()) {
        board.printBoard();
        System.out.println("Turno de: " + othello.getCurrentPlayer().getName());
        System.out.print("Ingrese coordenadas (Fila Letra, ej: 1 A) o 'v' para volver: ");

        String entradaFila = sc.next(); // Lee el primer dato (ej: "1" o "v")

        // Opción de volver
        if (entradaFila.equalsIgnoreCase("v")) {
            System.out.println("--- Volviendo al menu... ---");
            return;
        }

        // Leer la letra de la columna
        if (!sc.hasNext()) continue;
        String entradaCol = sc.next().toUpperCase(); // Lee la letra (ej: "A")

        try {
            // TRADUCCIÓN DE FILA: De "1-8" a índice "0-7"
            int f = Integer.parseInt(entradaFila) - 1;

            // TRADUCCIÓN DE COLUMNA: De "A-H" a índice "0-7"
            char letra = entradaCol.charAt(0);
            int c = letra - 'A';

            // VALIDACIÓN DE RANGO
            if (f < 0 || f > 7 || c < 0 || c > 7) {
                System.out.println("--- [!] Error: Use filas del 1-8 y letras de A-H ---");
                continue;
            }

            // Ejecutar jugada (La lógica interna sigue intacta)
            if (!othello.executeTurn(f, c)) {
                System.out.println("--- [!] Movimiento ilegal. No captura piezas ---");
            }

        } catch (NumberFormatException e) {
            System.out.println("--- [!] Error: Formato incorrecto. Use: Numero Letra (ej: 1 A) ---");
        }
    }
    
    // ... (Mostrar puntajes finales) ...

        board.printBoard();
        System.out.println("\n-----------------------------------------");
        System.out.println("           PARTIDA FINALIZADA            ");
        System.out.println(othello.getGameResult());
        System.out.println("-----------------------------------------");
        System.out.println("Presione cualquier tecla para continuar...");
        sc.next();
    }
}