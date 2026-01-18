package model;

/**
 * Represents a game piece on the board.
 * Each piece belongs to a player and is identified by its color.
 *
 * @author Carolain Quesada
 */
public class Piece {

    /** Character that represents the piece color ('N' or 'B') */
    private char color;

    /**
     * Creates a new piece with the specified color.
     *
     * @param color Character representing the piece color
     */
    public Piece(char color) {
        this.color = color;
    }

    /**
     * Returns the color of the piece.
     *
     * @return Character representing the piece color
     */
    public char getColor() {
        return color;
    }

    /**
     * Flips the piece to the opposite color.
     * If the piece is black ('N'), it becomes white ('B'),
     * and vice versa.
     */
    public void flip() {
        this.color = (this.color == 'B') ? 'N' : 'B';
    }
}
