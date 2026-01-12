package model;

/**
 * Represents a game piece in the board.
 * A piece has a color that identifies the player.
 *
 * @author Carolain Quesada
 */
public class Piece {

    private char color;

    /**
     *
     * @param color Character representing the piece color
     */
    public Piece(char color) {
        this.color = color;
    }

    /**
     * @return piece color
     */
    public char getColor() {
        return color;
    }
}
