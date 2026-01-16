package model;

/**
 * Represents a player in the game.
 *
 * @author Carolain Quesada
 */
public class Player {

    private String name;
    private char pieceColor;

    /**
     * 
     *
     * @param name the player's name
     * @param pieceColor character representing the player's piece color
     */
    public Player(String name, char pieceColor) {
        this.name = name;
        this.pieceColor = pieceColor;
    }

    /**
     *
     * @return player name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return piece color
     */
    public char getPieceColor() {
        return pieceColor;
    }
}
