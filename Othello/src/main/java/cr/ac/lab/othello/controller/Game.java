package cr.ac.lab.othello.controller;

import cr.ac.lab.othello.model.Board;
import cr.ac.lab.othello.model.Node;
import cr.ac.lab.othello.model.Piece;
import cr.ac.lab.othello.model.Player;

/**
 * Controls the game logic for an Othello match.
 * This class manages turns, move validation, captures,
 * player switching, and game termination conditions.
 *
 * @author Carolain Quesada
 */
public class Game {

    /** Game board */
    private Board board;

    /** First player */
    private Player player1;

    /** Second player */
    private Player player2;

    /** Player whose turn is currently active */
    private Player currentPlayer;

    /**
     * Creates a new game with the given board and players.
     * Black pieces ('N') always start the game.
     *
     * @param board Game board
     * @param p1 First player
     * @param p2 Second player
     */
    public Game(Board board, Player p1, Player p2) {
        this.board = board;
        this.player1 = p1;
        this.player2 = p2;
        this.currentPlayer = (p1.getPieceColor() == 'N') ? p1 : p2;
        setupInitialPieces();
    }

    /**
     * Places the initial four pieces at the center of the board
     * following standard Othello rules.
     */
    private void setupInitialPieces() {
        if (board.getNode(3, 3) != null) {
            board.getNode(3, 3).setPiece(new Piece('B'));
            board.getNode(4, 4).setPiece(new Piece('B'));
            board.getNode(3, 4).setPiece(new Piece('N'));
            board.getNode(4, 3).setPiece(new Piece('N'));
        }
    }

    /**
     * Attempts to make a move at the specified position.
     * A move is valid only if it captures at least one opponent piece.
     *
     * @param row Row index
     * @param col Column index
     * @return true if the move was successful, false otherwise
     */
    public boolean makeMove(int row, int col) {
        Node target = board.getNode(row, col);

        if (target == null || !target.isEmpty()) {
            return false;
        }

        boolean captureMade = false;

        // Check all 8 possible directions
        for (int i = 0; i < 8; i++) {
            if (canCapture(target, i, currentPlayer.getPieceColor())) {
                doCapture(target, i, currentPlayer.getPieceColor());
                captureMade = true;
            }
        }

        if (captureMade) {
            target.setPiece(new Piece(currentPlayer.getPieceColor()));
            handleTurnTransition();
            return true;
        }

        return false;
    }

    /**
     * Executes a turn by attempting to make a move.
     * This method exists to match the application interface.
     *
     * @param row Row index
     * @param col Column index
     * @return true if the move was successful, false otherwise
     */
    /*
    behavior and complexity exuteTurn():
    
    behavior and complexity exuteTurn():
    Behavior: Game logic: Validates the move,
    searches for captures in 8 directions, and
    changes the player's turn.

Time Complexity: O(1)*

Space Complexity: O(1)
    
    */
    
   
    public boolean executeTurn(int row, int col) {
        return makeMove(row, col);
    }

    /**
     * Handles the transition between turns.
     * If the next player has no valid moves, the turn is skipped.
     */
    private void handleTurnTransition() {
        switchPlayer();
        if (!hasValidMoves(currentPlayer)) {
            switchPlayer();
        }
    }

    /**
     * Switches the current player.
     */
    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    /**
     * Determines whether a capture is possible in a given direction.
     *
     * @param start Starting node
     * @param dir Direction index (0–7)
     * @param color Current player's piece color
     * @return true if a capture is possible, false otherwise
     */
    private boolean canCapture(Node start, int dir, char color) {
        Node next = getNeighbor(start, dir);

        if (next == null || next.isEmpty() || next.getPiece().getColor() == color) {
            return false;
        }

        next = getNeighbor(next, dir);
        while (next != null && !next.isEmpty()) {
            if (next.getPiece().getColor() == color) {
                return true;
            }
            next = getNeighbor(next, dir);
        }

        return false;
    }

    /**
     * Executes the capture of opponent pieces in a given direction.
     *
     * @param start Starting node
     * @param dir Direction index (0–7)
     * @param color Current player's piece color
     */
    private void doCapture(Node start, int dir, char color) {
        Node next = getNeighbor(start, dir);

        while (next != null && next.getPiece().getColor() != color) {
            next.getPiece().flip();
            next = getNeighbor(next, dir);
        }
    }

    /**
     * Checks whether the game has ended.
     *
     * @return true if no player has valid moves, false otherwise
     */
    public boolean isGameOver() {
        return !hasValidMoves(player1) && !hasValidMoves(player2);
    }

    /**
     * Determines whether the specified player has at least one valid move.
     *
     * @param p Player to check
     * @return true if the player has valid moves, false otherwise
     */
    private boolean hasValidMoves(Player p) {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Node n = board.getNode(r, c);
                if (n != null && n.isEmpty()) {
                    for (int i = 0; i < 8; i++) {
                        if (canCapture(n, i, p.getPieceColor())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Returns the neighboring node in the specified direction.
     *
     * @param node Reference node
     * @param dirIndex Direction index (0–7)
     * @return Neighboring node or null if none exists
     */
    private Node getNeighbor(Node node, int dirIndex) {
        switch (dirIndex) {
            case 0: return node.north;
            case 1: return node.south;
            case 2: return node.east;
            case 3: return node.west;
            case 4: return node.northEast;
            case 5: return node.northWest;
            case 6: return node.southEast;
            case 7: return node.southWest;
            default: return null;
        }
    }

    /**
     * Returns the player whose turn is currently active.
     *
     * @return Current player
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Counts the number of pieces of a given color on the board.
     *
     * @param color Piece color ('N' or 'B')
     * @return Number of pieces of the given color
     */
    public int countPieces(char color) {
        int count = 0;

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Node n = board.getNode(r, c);
                if (n != null && !n.isEmpty()
                        && n.getPiece().getColor() == color) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Determines the game result based on the number of pieces
     * owned by each player.
     *
     * @return A string describing the game result
     */
    public String getGameResult() {
        int blackCount = countPieces('N');
        int whiteCount = countPieces('B');

        if (blackCount > whiteCount) {
            return player1.getName() + " wins (" + blackCount + " vs " + whiteCount + ")";
        } else if (whiteCount > blackCount) {
            return player2.getName() + " wins (" + whiteCount + " vs " + blackCount + ")";
        } else {
            return "Draw (" + blackCount + " vs " + whiteCount + ")";
        }
    }
}
