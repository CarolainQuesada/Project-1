package cr.ac.lab.othello;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Board;
import java.util.Scanner;
import java.io.IOException;
import model.Game;
import model.Player;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        // 1. Inicializar el Tablero (8x8)
        Board board = new Board(8, 8);

        // 2. Crear los Jugadores (Negras 'N' son X, Blancas 'B' son O)
        // Usamos los colores internos 'N' y 'B' para que la lógica de Game funcione,
        // pero en el printBoard se verán como X y O.
        Player p1 = new Player("Jugador 1", 'N'); 
        Player p2 = new Player("Jugador 2", 'B');

        // 3. Inicializar el Juego
        Game othello = new Game(board, p1, p2);
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Inicio del Juego de Othello ---");

        // Ciclo principal protegido
        while (!othello.isGameOver()) {
            board.printBoard();
            System.out.println("Turno de: " + othello.getCurrentPlayer().getName());
            System.out.print("Ingrese fila y columna (o una letra para salir): ");

            // PROTECCIÓN: Verifica si la entrada es un número
            if (!sc.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor use números.");
                sc.next(); // Limpia la entrada incorrecta (la letra)
                continue;  // Regresa al inicio del while
            }
            int f = sc.nextInt();

            if (!sc.hasNextInt()) {
                System.out.println("Falta la columna. Intente de nuevo.");
                sc.next(); // Limpia la entrada
                continue;
            }
            int c = sc.nextInt();

            // Ejecutar turno
            if (!othello.executeTurn(f, c)) {
                System.out.println("Movimiento no permitido. ¡Intenta de nuevo!");
            }
        }

        System.out.println("\n--- JUEGO TERMINADO ---");
        board.printBoard();
        
         // El launch se deja comentado por si se usa consola
        // launch(args);
    }
}