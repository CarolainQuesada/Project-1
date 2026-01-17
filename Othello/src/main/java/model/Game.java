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
        // Inician las negras ('N') por regla oficial
        this.currentPlayer = (p1.getPieceColor() == 'N') ? p1 : p2;
        setupInitialPieces();
    }

    private void setupInitialPieces() {
        int mid = 3; 
        if (board.getNode(mid, mid) != null) {
            board.getNode(mid, mid).setPiece(new Piece('B'));
            board.getNode(mid + 1, mid + 1).setPiece(new Piece('B'));
            board.getNode(mid, mid + 1).setPiece(new Piece('N'));
            board.getNode(mid + 1, mid).setPiece(new Piece('N'));
        }
    }

    public boolean executeTurn(int row, int col) {
        Node target = board.getNode(row, col);
        if (target == null || !target.isEmpty()) {
            return false; 
        }

        boolean captureMade = false;
        char colorActual = currentPlayer.getPieceColor();

        for (int i = 0; i < 8; i++) {
            if (canCapture(target, i, colorActual)) {
                doCapture(target, i, colorActual);
                captureMade = true;
            }
        }

        if (captureMade) {
            target.setPiece(new Piece(colorActual));
            handleTurnTransition();
            return true;
        }
        return false;
    }

    private void handleTurnTransition() {
        switchPlayer();
        if (!hasValidMoves(currentPlayer)) {
            if (!isGameOver()) {
                System.out.println("\n--- [!] " + currentPlayer.getName() + " no tiene movimientos. SALTA TURNO ---");
                switchPlayer();
            }
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean canCapture(Node start, int dir, char color) {
        Node next = getNeighbor(start, dir);
        if (next == null || next.isEmpty() || next.getPiece().getColor() == color) {
            return false;
        }
        next = getNeighbor(next, dir);
        while (next != null && !next.isEmpty()) {
            if (next.getPiece().getColor() == color) return true;
            next = getNeighbor(next, dir);
        }
        return false;
    }

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

    public int countPieces(char color) {
        int count = 0;
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Node n = board.getNode(r, c);
                if (n != null && !n.isEmpty() && n.getPiece().getColor() == color) {
                    count++;
                }
            }
        }
        return count;
    }

    public String getGameResult() {
        int n = countPieces('N');
        int b = countPieces('B');
        String res = "\nMarcador: " + player1.getName() + " (X): " + n + " | " + player2.getName() + " (O): " + b;
        if (n > b) return res + "\n¡GANADOR: " + player1.getName() + "!";
        if (b > n) return res + "\n¡GANADOR: " + player2.getName() + "!";
        return res + "\n¡EMPATE!";
    }

    private Node getNeighbor(Node node, int dirIndex) {
        switch (dirIndex) {
            case 0: return node.north; case 1: return node.south;
            case 2: return node.east;  case 3: return node.west;
            case 4: return node.northEast; case 5: return node.northWest;
            case 6: return node.southEast; case 7: return node.southWest;
            default: return null;
        }
    }

    public Player getCurrentPlayer() { return currentPlayer; }
}