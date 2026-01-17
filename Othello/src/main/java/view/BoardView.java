/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view;


import model.Board;
import model.Node;

public class BoardView {
    
       
  public void printBoard(Board board) {
    // 1. Encabezado de LETRAS (arriba)
   System.out.println("\n     A    B    C    D    E    F    G    H");
  System.out.print("   ");
    for (int i = 0; i < 8 * 4 + 1; i++) System.out.print("-");
    System.out.println();

    Node rowNode = board.getStart();
    int displayRow = 1; // El usuario verá del 1 al 8

    // 2. Cuerpo del tablero con NÚMEROS a la izquierda
    while (rowNode != null) {
        System.out.print(displayRow + " | "); // Número de fila (1-8)

        Node current = rowNode;
        while (current != null) {
            if (current.isEmpty()) {
              System.out.print("[ ]  ");
                     
            } else {
                char simbolo = (current.getPiece().getColor() == 'N') ? 'X' : 'O';
             System.out.print("[" + simbolo + "]  ");
            }
            current = current.east;
        }

        System.out.println("|");
        rowNode = rowNode.south;
        displayRow++;
    }
    System.out.print("   ");
    for (int i = 0; i < 8 * 4 + 1; i++) System.out.print("-");
    System.out.println();
}

 }
