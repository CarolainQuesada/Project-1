# Othello

**participants of project:**  
- Carolain Quesada Soto  
- Mathew Ramirez Gomez  
- Alen Cedeno Miranda

- This project implements the board game Reversi (Othello). The main objective is to model the game board using linked data structures, avoiding the use of traditional two-dimensional arrays, and applying controlled traversals and structural reasoning.

- **Code Organization**
- **Packages and responsibilities**
- cr.ac.lab.othello: application entry point (App.java).
- controller: game logic and rule control (Game.java).
- model: data representation and linked board structure (Board, Node, Piece, Player).
- view: console-based visualization of the board (BoardView.java).

- **Main Files**
- App.java
- Game.java
- Board.java
- Node.java
- Piece.java
- Player.java
- BoardView.java
-
- **Class Description**
- Board: represents the game board as a network of interconnected nodes.
It builds and links all nodes horizontally, vertically, and diagonally, and provides access to board positions using logical row and column traversal.

- Node: It represents a single cell on the board.
It stores its logical position, the piece placed on it, and references to its eight neighboring nodes, constructed with the compass rose.

- Piece: represents a game piece with a specific color (black or white).
Includes functionality to flip the piece during captures.

- Player: represents a player in the game.
Stores the player’s name and the color of the pieces assigned.

-Game: controls the game logic, including turn management, move validation, directional traversal, capture execution, player switching, game termination detection, and final result calculation.

- BoardView: provides a console-based visualization of the board, displaying rows, columns, and piece symbols during gameplay.




