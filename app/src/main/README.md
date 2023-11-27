# Connect Four Project

## Project Objectives
Group members consist of Nicole Orphan, Emra Meduseljac, and Daniel Leeper. The objective of this project is to build a version of the board game Connect Four.
### Update
As of 11/20/2023, the Deliverable 2 responsibilities are:

Nicole: The testing and the saving state for total player wins

Emra: Initial state UI, adding different windows to the UI

Daniel: Auto-player functionality

## Overview
Run the code with: ``gradle run``. You will click on a column to take your turn of placing a piece down, the first player who gets four in a row (vertically, horizontally, or diagonally) will win. If no one has four of the same color in a row, and the board is full, then the game will end in a tie. You may start a new game at any time.
### Update
You will eventually have the option of playing versus another player, or against the computer. 
As of 11/20/2023, this has not been implemented yet.

## Code Details
There's App.java, the ControllerInterface and Observer, along with the controller, model, and view subdirectories. The model is where the Connect Four Grid, or the  actual board itself, is defined and is in charge of keeping track where the players have placed their pieces.
The Connect Four grid is a 6 by 7 grid. 
### Update
As of 11/20/2023, it displays a Connect Four grid in the console for testing purposes.

In the view directory, there is ConnectFourGUI and CircleButton. CircleButton is in charge of creating the visual of having circle slots within the Connect Four board. These are the buttons utilized within the ConnectFourGUI, which handles the actual aesthetic and draws the Connect Four board.
### Update
As of 11/20/2023, the only buttons implemented are the the circle slots where the colored pieces are  displayed, and the "Start New Game" button. Later, we will implement the Total Player Wins button which would display how many wins "Blue" has and how many wins "Red" has. This will be implemented by saving data through serialization. Additionally, later we will implement when having clicked the "Start New Game" button, a new window will pop up and ask you whether you would like to play a Two Player game, or against the computer.

The columns within the board and the "Start New Game" button have their own action listeners, and display different outputs. Clicking a column places your piece at the lowest available spot in that column. Clicking "Start New Game" clears the board of any placed pieces and allows you to start from the beginning, whether or not you have finished the game you were playing or not.