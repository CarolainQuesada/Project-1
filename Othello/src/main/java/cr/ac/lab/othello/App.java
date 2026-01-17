package cr.ac.lab.othello;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Board;
import model.Node;
import model.Piece; // solo si ya existe

import java.io.IOException;

/**
 * JavaFX App
 */
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
   




        // Crear un tablero 5x5
        Board board = new Board(5, 5);

        // Imprimir tablero vacío
        System.out.println("Tablero vacío:");
        board.printBoard();

        // Colocar piezas manualmente para probar
        Node start = board.getStart();

        // Colocar una pieza en (0,0)
        start.setPiece(new Piece('c'));

        // Moverse a (0,2)
        Node node02 = board.getNode(0, 2);
        node02.setPiece(new Piece('c'));

        // Moverse a (2,3)
       Node node23 = board.getNode(2, 3); 
 
        // 2. Le pones la pieza al nodo guardado
       node23.setPiece(new Piece('V'));

        // Imprimir tablero con piezas
        System.out.println("\nTablero con piezas:");
        board.printBoard();
    }
}