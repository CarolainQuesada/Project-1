package cr.ac.lab.othello.model;

/**
 * Represents a player in the Othello game.
 * Each player has a name and a piece color.
 *
 * @author Mathew Ramirez
 * @author Carolain Quesada
 * @author Alen Cedeño
 */
public class Player {

    /** Player's name */
    private String name;

    /** Character representing the player's piece color ('N' or 'B') */
    private char pieceColor;

    /**
     * Creates a new player with the specified name and piece color.
     *
     * @param name The player's name
     * @param pieceColor Character representing the player's piece color
     */
    public Player(String name, char pieceColor) {
        this.name = name;
        this.pieceColor = pieceColor;
    }

    /**
     * Returns the name of the player.
     *
     * @return Player name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the piece color assigned to the player.
     *
     * @return Character representing the player's piece color
     */
    public char getPieceColor() {
        return pieceColor;
    }

    /**
     * Returns a string representation of the player.
     *
     * @return Player information including name and piece color
     */
    @Override
    public String toString() {
        return name + " (" + (pieceColor == 'N' ? "Negras" : "Blancas") + ")";
    }
}
