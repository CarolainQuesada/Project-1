package model;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(Board board, Player p1, Player p2) {
        this.board = board;
        this.player1 = p1;
        this.player2 = p2;
        // Inician las negras
        this.currentPlayer = (p1.getPieceColor() == 'N') ? p1 : p2;
        setupInitialPieces();
    }

    private void setupInitialPieces() {
        // Asumiendo tablero de 8x8 para las posiciones estándar
        if (board.getNode(3, 3) != null) {
            board.getNode(3, 3).setPiece(new Piece('B'));
            board.getNode(4, 4).setPiece(new Piece('B'));
            board.getNode(3, 4).setPiece(new Piece('N'));
            board.getNode(4, 3).setPiece(new Piece('N'));
        }
    }

    // Cambiamos el nombre a makeMove para que coincida con tu App.java
    public boolean makeMove(int row, int col) {
        Node target = board.getNode(row, col);

        if (target == null || !target.isEmpty()) {
            return false;
        }
        

        boolean captureMade = false;
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
    public boolean executeTurn(int row, int col) {
        return makeMove(row, col);
    }

    private void handleTurnTransition() {
        switchPlayer();
        if (!hasValidMoves(currentPlayer)) {
            switchPlayer(); // Salta turno
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    // Método de validación (antes canCaptureForSim)
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

    // Método para ejecutar la captura (antes doCapture)
    private void doCapture(Node start, int dir, char color) {
        Node next = getNeighbor(start, dir);
        while (next != null && next.getPiece().getColor() != color) {
            next.getPiece().flip();
            next = getNeighbor(next, dir);
        }
    }

    public boolean isGameOver() {
        return !hasValidMoves(player1) && !hasValidMoves(player2);
    }

    private boolean hasValidMoves(Player p) {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Node n = board.getNode(r, c);
                if (n != null && n.isEmpty()) {
                    for (int i = 0; i < 8; i++) {
                        if (canCapture(n, i, p.getPieceColor())) return true;
                    }
                }
            }
        }
        return false;
    }

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

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}