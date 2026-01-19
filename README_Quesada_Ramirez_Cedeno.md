# Othello

**participants of project:**  
- Carolain Quesada Soto  
- Mathew Ramirez Gomez  
- Alen Cedeno Miranda
  
**Project Description**
- This project implements the classic board game *Reversi (Othello)* using Java.
The main objective is to model the game board through *linked data structures*, avoiding the use of traditional two-dimensional arrays.
The solution emphasizes controlled traversal, directional validation, and structural reasoning, following the concepts studied in Data Structures.
  
**Data Structure Used**
The game board is implemented as a fully linked structure of nodes.
Each board cell is represented by a Node object that maintains references to its eight neighboring nodes:

* North
* South
* East
* West
* Northeast
* Northwest
* Southeast
* Southwest

**Code Organization**
**Project Structure**
src/main/java
├── controller
│   └── Game.java            # Game logic and turn control
├── cr.ac.lab.othello
│   └── App.java             # Application entry point
├── model
│   ├── Board.java           # Board representation using linked nodes
│   ├── Node.java            # Linked node structure with 8 directional references
│   ├── Piece.java           # Game piece logic (black / white)
│   └── Player.java          # Player attributes and piece color
├── view
│   └── BoardView.java       # Console-based board visualization
└── module-info.java         # Java module system configuration

This structure follows a clear separation of responsibilities, similar to the MVC (Model–View–Controller) pattern.

- **Packages and responsibilities**
- cr.ac.lab.othello: application entry point (App.java).
- controller: game logic and rule control (Game.java).
- model: data representation and linked board structure (Board, Node, Piece, Player).
- view: console-based visualization of the board (BoardView.java).

**Main Classes Description**
- Board: represents the game board as a network of interconnected nodes.
It builds and links all nodes horizontally, vertically, and diagonally, and provides access to board positions using logical row and column traversal.

- Node: It represents a single cell on the board.
It stores its logical position, the piece placed on it, and references to its eight neighboring nodes, constructed with the compass rose.

- Piece: represents a game piece with a specific color (black or white).
Includes functionality to flip the piece during captures.

- Player: represents a player in the game.
Stores the player’s name and the color of the pieces assigned.

- Game:
- Controls the main game logic:
- Turn management
- Move validation
- Directional traversal
- Capture execution
- Player switching
- Game termination detection
- Final result calculation

- BoardView: provides a console-based visualization of the board, displaying rows, columns, and piece symbols during gameplay.

- **Execution Flow**
- 1. The application starts from the App class.
- 2. The board is created and all nodes are linked in eight directions.
- 3. The initial four pieces are placed at the center of the board.
- 4. Players take turns placing pieces.
- 5. Each move is validated by traversing linked nodes in all directions.
- 6. Captured opponent pieces are flipped automatically.
- 7. Turns change after the player places a piece on a valid space.
- 8. The game ends when neither player has any valid moves or the board is full.
- 9. The winner is determined by who has more pieces on the board.
- 10. The game ends in a draw if both players have the same number of pieces.

- **Execution Evidence**
- 

  


