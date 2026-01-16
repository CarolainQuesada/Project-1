package model;

/**
 * Represents a single cell of the board.
 *
 * @author Carolain Quesada
 */
public class Node {

    private Piece piece;

    public Node north;
    public Node south;
    public Node east;
    public Node west;

    public Node northEast;
    public Node northWest;
    public Node southEast;
    public Node southWest;

    /**
     * Creates an empty node with no links.
     */
    public Node() {
        piece = null;
    }

    /**     *
     * @return true if the node has no piece
     */
    public boolean isEmpty() {
        return piece == null;
    }

    /**
     *
     * @param piece piece to be placed
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     *
     * @return stored piece, or null if empty
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Removes the piece from this node.
     */
    public void clear() {
        piece = null;
    }
}
