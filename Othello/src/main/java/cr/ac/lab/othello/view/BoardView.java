/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.lab.othello.view;

import cr.ac.lab.othello.model.Board;
import cr.ac.lab.othello.model.Node;

/**
 * Provides a console-based visual representation of the Othello board.
 * This class is responsible only for displaying the board state,
 * including row numbers and column letters.
 * 
 * @author Carolain Quesada
 */
public class BoardView {

    /**
     * Prints the current state of the board to the console.
     * Columns are labeled with letters (A–H) and rows with numbers (1–8).
     * Empty positions are shown as [ ] and occupied positions as [X] or [O].
     *
     * @param board The board to be displayed
     */
    
    /**
     * behavior and complexity printBoard():
     * Main Behavior: Grid traversal: Jumps from node to node using east and 
     * south to draw the board in the console.

     Time Complexity O(R x C) or O(N^2)

   Space Complexity O(1)
    
     
     */
    public void printBoard(Board board) {

        // Print column headers (A–H)
        System.out.println("\n     A    B    C    D    E    F    G    H");
        System.out.print("   ");
        for (int i = 0; i < 8 * 4 + 1; i++) {
            System.out.print("-");
        }
        System.out.println();

        Node rowNode = board.getStart();
        int displayRow = 1; // Rows are displayed from 1 to 8

        // Print each row of the board
        while (rowNode != null) {
            System.out.print(displayRow + " | ");

            Node current = rowNode;
            while (current != null) {

                // Print empty or occupied cell
                if (current.isEmpty()) {
                    System.out.print("[ ]  ");
                } else {
                    char symbol = (current.getPiece().getColor() == 'N') ? 'N' : 'B';
                    System.out.print("[" + symbol + "]  ");
                }

                current = current.east;
            }

            System.out.println("|");
            rowNode = rowNode.south;
            displayRow++;
        }

        // Print bottom border
        System.out.print("   ");
        for (int i = 0; i < 8 * 4 + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
