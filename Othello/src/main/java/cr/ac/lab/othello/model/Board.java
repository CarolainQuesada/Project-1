package cr.ac.lab.othello.model;

/**
 * Represents the game board for Othello.
 * The board is implemented as a grid of interconnected nodes,
 * where each node keeps references to its neighbors in all directions.
 *
 * @author Carolain Quesada
 */
public class Board {

    /** Reference to the top-left node of the board */
    private Node start;

    /** Number of rows in the board */
    private int rows;

    /** Number of columns in the board */
    private int columns;

    /**
     * Creates a board with the specified number of rows and columns.
     * Automatically builds the internal node structure.
     *
     * @param rows Number of rows
     * @param columns Number of columns
     */
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        buildBoard();
    }

    /**
     * Builds the board by creating and linking all nodes.
     * Nodes are connected horizontally, vertically, and diagonally.
     */
    /**
 * behavior and complexity buildBoard():
 * Main Behavior: Weaves the network: Creates each node and manually connects its 8 pointers (N, S, E, W, and diagonals).

Time Complexity: O(R x C) or O(N^2)

Space Complexity: O(R x C) or O(N^2)
 * @author alenc
 */
    private void buildBoard() {

        /** Reference to the first node of the previous row */
        Node previousRowStart = null;

        // Iterate row by row
        for (int r = 0; r < rows; r++) {

            /** Previous node in the current row (for horizontal links) */
            Node current = null;

            /** First node of the current row */
            Node currentRowStart = null;

            /** Node above the one being created */
            Node upperNode = previousRowStart;

            // Iterate column by column
            for (int c = 0; c < columns; c++) {

                // Create a new node with logical position
                Node newNode = new Node(r, c);

                // Set the top-left corner of the board
                if (start == null) {
                    start = newNode;
                }

                // Connect left ↔ right
                if (current != null) {
                    current.east = newNode;
                    newNode.west = current;
                } else {
                    // First node in the row
                    currentRowStart = newNode;
                }

                // Connect up ↔ down
                if (upperNode != null) {
                    upperNode.south = newNode;
                    newNode.north = upperNode;

                    // Connect diagonal: north-west ↔ south-east
                    if (upperNode.west != null) {
                        upperNode.west.southEast = newNode;
                        newNode.northWest = upperNode.west;
                    }

                    // Connect diagonal: north-east ↔ south-west
                    if (upperNode.east != null) {
                        upperNode.east.southWest = newNode;
                        newNode.northEast = upperNode.east;
                    }

                    // Move to the next node in the upper row
                    upperNode = upperNode.east;
                }

                // Move to the next node in the current row
                current = newNode;
            }

            // Prepare for the next row
            previousRowStart = currentRowStart;
        }
    }

    /**
     * Returns the starting node (top-left corner) of the board.
     *
     * @return Starting node of the board
     */
    public Node getStart() {
        return start;
    }

    /**
     * Checks if a position is within the board limits.
     *
     * @param row Row index
     * @param col Column index
     * @return true if the position is valid, false otherwise
     */
    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < rows &&
               col >= 0 && col < columns;
    }

    /**
     * Returns the node located at the specified position.
     * If the position is outside the board limits, the method returns null.
     *
     * @param row Row index
     * @param col Column index
     * @return Node at the given position or null if invalid
     */
    /**
     * behavior and complexity getNode()
     * Behavior: Sequential navigation: Walk from the start, moving down rows and across columns until reaching the destination.

Time Complexity: O(R + C) or O(N^2)
Space Complexity: O(1)
     * @param row
     * @param col
     * @return 
     */
    public Node getNode(int row, int col) {

        if (!isValidPosition(row, col)) {
            return null;
        }

        Node current = start;

        // Move down to the desired row
        for (int i = 0; i < row; i++) {
            if (current == null) return null;
            current = current.south;
        }

        // Move right to the desired column
        for (int j = 0; j < col; j++) {
            if (current == null) return null;
            current = current.east;
        }

        return current;
    }

    /**
     * Returns the number of rows of the board.
     *
     * @return Number of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * Returns the number of columns of the board.
     *
     * @return Number of columns
     */
    public int getColumns() {
        return columns;
    }
}
