package model;

/**
 * Represents a single cell of the game board.
 * Each node stores its position, the piece placed on it,
 * and references to its neighboring nodes in all directions.
 *
 * @author Carolain Quesada
 */
public class Node {

    /** Row index of the node in the board */
    private int row;

    /** Column index of the node in the board */
    private int column;

    /** Piece currently placed on this node, or null if empty */
    private Piece piece;

    /** Reference to the node located to the north */
    public Node north;

    /** Reference to the node located to the south */
    public Node south;

    /** Reference to the node located to the east */
    public Node east;

    /** Reference to the node located to the west */
    public Node west;

    /** Reference to the node located to the north-east */
    public Node northEast;

    /** Reference to the node located to the north-west */
    public Node northWest;

    /** Reference to the node located to the south-east */
    public Node southEast;

    /** Reference to the node located to the south-west */
    public Node southWest;

    /**
     * Creates an empty node with no piece assigned.
     * Neighbor references are initialized to null.
     */
    public Node() {
        piece = null;
    }

    /**
     * Creates a node with a specific position on the board.
     *
     * @param row Row index of the node
     * @param column Column index of the node
     */
    public Node(int row, int column) {
        this.row = row;
        this.column = column;
        this.piece = null;
    }

    /**
     * Checks whether the node is empty.
     *
     * @return true if the node has no piece, false otherwise
     */
    public boolean isEmpty() {
        return piece == null;
    }

    /**
     * Places a piece on this node.
     *
     * @param piece Piece to be placed on the node
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * Returns the piece stored in this node.
     *
     * @return Stored piece, or null if the node is empty
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Returns the row index of the node.
     *
     * @return Row index
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the column index of the node.
     *
     * @return Column index
     */
    public int getColumn() {
        return column;
    }

    /**
     * Removes the piece from this node.
     */
    public void clear() {
        piece = null;
    }
}
