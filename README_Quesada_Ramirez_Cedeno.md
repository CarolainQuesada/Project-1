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
├── Source Packages
│   ├── <default package>
│   │   └── module-info.java
│   ├── cr.ac.lab.othello
│   │   └── App.java
│   ├── cr.ac.lab.othello.controller
│   │   └── Game.java
│   └── cr.ac.lab.othello.model
│       ├── Board.java
│       ├── Node.java
│       ├── Piece.java
│       └── Player.java
├── cr.ac.lab.othello.view
│   └── BoardView.java
├── Test Packages
├── Dependencies
├── Java Dependencies
│   └── JDK 21 (Default)
└── Project Files
    ├── pom.xml
    └── nbactions.xml

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

      
- **Execution Flow**

- **Installation**
 1. Clone the repository:
 2. Build the project
3. using Maven execute the project 

- Game Home and Menu
  
  <img width="1013" height="714" alt="image" src="https://github.com/user-attachments/assets/07117643-6b13-4485-b3c8-618cb4ac9ca3" />
  
- Valid Moves
  
<img width="671" height="525" alt="image" src="https://github.com/user-attachments/assets/957b7f7a-539a-4942-a8be-6ad28a343e0e" />

<img width="671" height="535" alt="image" src="https://github.com/user-attachments/assets/3a681da2-3f5c-4b2c-a7bb-f448347eaacf" />

<img width="683" height="582" alt="image" src="https://github.com/user-attachments/assets/166e0818-1b5a-4353-8bad-a5b39eebe5f4" />

<img width="677" height="622" alt="image" src="https://github.com/user-attachments/assets/b54e8c15-8737-47eb-ab3f-3ee7be48ff1b" />

-Invalid moves and imput errors:

<img width="970" height="763" alt="image" src="https://github.com/user-attachments/assets/4eac237c-2f10-4492-b66f-7a8dddf4b1ca" />

-End of Game and Determine Winner

<img width="922" height="872" alt="image" src="https://github.com/user-attachments/assets/bc483c8b-94b3-44c6-b223-802edd633753" />
