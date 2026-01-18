package cr.ac.lab.othello;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Board;
import controller.Game;
import model.Player;
import java.util.Scanner;
import view.BoardView;

/**
 * Entry point of the Othello application.
 * This class provides a console-based menu and controls the game flow,
 * including player input, turn execution, and game termination.
 *
 * JavaFX is included only as a requirement, but the game is executed
 * entirely through the console.
 *
 * @author Carolain Quesada
 */
public class App extends Application {

    /** Scanner used to read user input from the console */
    private static Scanner sc = new Scanner(System.in);

    /**
     * JavaFX start method.
     * Not used in this console-based implementation.
     *
     * @param stage Primary stage
     */
    @Override
    public void start(Stage stage) {
        /* JavaFX entry point (not used) */
    }

    /**
     * Application main method.
     * Displays the main menu and allows the user to start or exit the game.
     *
     * @param args Command-line arguments
     */
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

    /**
     * Initializes and executes a complete Othello match.
     * Handles player creation, board initialization, turn execution,
     * move validation, and final result display.
     */
    private static void iniciarPartida() {

        System.out.println("\n-----------------------------------------");
        System.out.print("Nombre Jugador 1 (Negras - X): ");
        String n1 = sc.next();

        System.out.print("Nombre Jugador 2 (Blancas - O): ");
        String n2 = sc.next();

        // Create game components
        Board board = new Board(8, 8);
        BoardView view = new BoardView();
        Game othello = new Game(board, new Player(n1, 'N'), new Player(n2, 'B'));

        // Main game loop
        while (!othello.isGameOver()) {

            view.printBoard(board);
            System.out.println("Turno de: " + othello.getCurrentPlayer().getName());
            System.out.print("Ingrese coordenadas (Fila Letra, ej: 1 A) o 'v' para volver: ");

            String entradaFila = sc.next();

            // Option to return to the main menu
            if (entradaFila.equalsIgnoreCase("v")) {
                System.out.println("--- Volviendo al menu... ---");
                return;
            }

            if (!sc.hasNext()) {
                continue;
            }

            String entradaCol = sc.next().toUpperCase();

            try {
                // Translate row from 1–8 to 0–7
                int f = Integer.parseInt(entradaFila) - 1;

                // Translate column from A–H to 0–7
                char letra = entradaCol.charAt(0);
                int c = letra - 'A';

                // Validate board limits
                if (f < 0 || f > 7 || c < 0 || c > 7) {
                    System.out.println("--- [!] Error: Use filas del 1-8 y letras de A-H ---");
                    continue;
                }

                // Execute move
                if (!othello.executeTurn(f, c)) {
                    System.out.println("--- Movimiento ilegal. No captura piezas ---");
                }

            } catch (NumberFormatException e) {
                System.out.println("--- Error: Formato incorrecto. Use: Numero Letra (ej: 1 A) ---");
            }
        }

        // Display final results
        view.printBoard(board);
        System.out.println("\n-----------------------------------------");
        System.out.println("           PARTIDA FINALIZADA            ");
        System.out.println(othello.getGameResult());
        System.out.println("-----------------------------------------");
        System.out.println("Presione cualquier tecla para continuar...");
        sc.next();
    }
}
