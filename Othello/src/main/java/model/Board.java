/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    Node rowNode = start; // Asegúrate de que 'start' no sea null

    while (rowNode != null) {
        Node current = rowNode;

        while (current != null) {
            // Verificamos si hay una pieza antes de pedir su color
            if (current.getPiece() == null) {
                System.out.print("[ ] ");
            } else {
                char color = current.getPiece().getColor();
                if (color == 'B') {
                    System.out.print("[B] ");
                } else {
                    System.out.print("[N] ");
                }
            }
            current = current.east; // Avanzar a la derecha
        }

        System.out.println(); // Salto de línea al terminar la fila
        rowNode = rowNode.south; // Avanzar a la fila de abajo
    }
}
    
    public Node getStart() {
    return start;
}
    public Node getNode(int row, int col) {
    Node current = start;
    // Bajar hasta la fila deseada
    for (int i = 0; i < row; i++) {
        current = current.south;
    }
    // Moverse a la derecha hasta la columna deseada
    for (int j = 0; j < col; j++) {
        current = current.east;
    }
    return current;
    }
}//
