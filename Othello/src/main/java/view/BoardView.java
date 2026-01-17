/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view;


import model.Board;
import model.Node;

public class BoardView {
    
     public void printBoard(Board board) {

    // ===== Imprimir encabezado de columnas =====
    System.out.print("    ");
    for (int c = 0; c < board.getColumns(); c++) {
        System.out.print(c + "   ");
    }
    System.out.println();

    System.out.print("  ");
    for (int i = 0; i < board.getColumns () * 4 + 1; i++) {
        System.out.print("-");
    }
    System.out.println();

    Node rowNode = board.getStart();
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

    }
