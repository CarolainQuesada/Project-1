
package model;

/**
 *
 * @author Usuario
 */
public class Board {
    private Node start;
    private int rows;
    private int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        buildBoard();
    }
    
    private void buildBoard(){
        //Nodo que está justo encima del que vamos a crear.
        Node previousRowStart= null;
        //Itera fila por fila.
        for(int r=0;r<rows;r++){
            //Nodo anterior en la misma fila (para enlaces horizontales).
            Node current= null;
            //Primer nodo de esta fila.
            Node currentRowStart=null;
            //Nodo que está justo encima del que vamos a crear.
            Node upperNode = previousRowStart;
            //Itera columna por columna.
           for(int c=0;c<columns;c++){
               //Crea un nodo con posición lógica.
               Node newNode = new Node(r,c);
               //Solo ocurre una vez: define la esquina superior izquierda.
               if(start==null){
                   start = newNode;
               }
              // Conecta izquierda ↔ derecha.
               if(current!=null){
                   current.east= newNode;
                   newNode.west= current;
               }
               //Si es el primero de la fila, lo guardamos.
               else{
                   currentRowStart= newNode;
               }
               //Conecta arriba ↔ abajo.
               if(upperNode!=null){
                   upperNode.south = newNode;
                   newNode.north = upperNode;
               
               //enlaces diagonales
               if(upperNode.west!=null){
                   upperNode.west.southEast=newNode;
                   newNode.northWest = upperNode.west;
               }
                //enlaces diagonales
               if(upperNode.east!=null){
                   upperNode.east.southWest = newNode;
                   newNode.northEast = upperNode.east;
               }
               //Avanza al siguiente nodo de la fila superior.
                 upperNode = upperNode.east;
           }
            //El nodo actual pasa a ser el anterior.
           current = newNode;
        }
           //Prepara la referencia para la siguiente fila.
        previousRowStart = currentRowStart;
    }   
   }
   public void printBoard() {

    // ===== Imprimir encabezado de columnas =====
    System.out.print("    ");
    for (int c = 0; c < columns; c++) {
        System.out.print(c + "   ");
    }
    System.out.println();

    System.out.print("  ");
    for (int i = 0; i < columns * 4 + 1; i++) {
        System.out.print("-");
    }
    System.out.println();

    Node rowNode = start;
    int rowIndex = 0;

    // ===== Imprimir filas =====
    while (rowNode != null) {

        // Número de fila a la izquierda
        System.out.print(rowIndex + " | ");

        Node current = rowNode;
        while (current != null) {

            if (current.getPiece() == null) {
                System.out.print("[ ] ");
            } else {
                char color = current.getPiece().getColor();
                System.out.print("[" + color + "] ");
            }

            current = current.east;
        }

        System.out.println();
        rowNode = rowNode.south;
        rowIndex++;
    }
}

    
    public Node getStart() {
    return start;
}
    
    public boolean isValidPosition(int row, int col) {
    return row >= 0 && row < rows &&
           col >= 0 && col < columns;
}
   //  If the position is outside the board limits, the method returns null.

    public Node getNode(int row, int col) {

    if (!isValidPosition(row, col)) {
        return null;
    }

    Node current = start;

    for (int i = 0; i < row; i++) {
        if (current == null) return null;
        current = current.south;
    }

    for (int j = 0; j < col; j++) {
        if (current == null) return null;
        current = current.east;
    }

    return current;
}

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
    
}//
