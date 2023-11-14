package connectFour.model;

import connectFour.Observer;

import java.util.ArrayList;

public class ConnectFourGrid 
{
    private ConnectFourPiece[][] grid;
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public ConnectFourGrid()
    {
        this.grid = new ConnectFourPiece[6][7];     //6 rows and 7 columns
    }

    public int getNextSpace(int column)     //returns index of lowest open space in column or -1 if column is full
    {
        for(int row = 5; row >= 0; row--)
        {
            if(grid[row][column] == null)
            {
                return row;
            }
        }
        return -1;
    }

    public boolean placePiece(ConnectFourPiece piece, int column)   //returns true if piece is placed successfully
    {
        int row = getNextSpace(column);
        if(row != -1)
        {
            grid[row][column] = piece;
            notifyObservers();
            return true;
        }
        else
        {
            notifyObservers();
            return false;
        }
        
    }

    public void show()      //Displays board to terminal for testing.
    {
        for(int row = 0; row < 6; row ++)
        {
            String rowPieces = "";
            for(int col = 0; col < 7; col++)
            {
                if(grid[row][col] == null)
                {
                    rowPieces += "_";
                }
                else
                {
                    rowPieces += grid[row][col];
                }
            }
            System.out.println(rowPieces);
        }
    }

    public boolean isFull()
    {
        for(int col = 0; col < 7; col++)
        {
            if(getNextSpace(col) != -1)
            {
                return false;
            }
        }
        return true;
    }

    public ConnectFourPiece getWinner(){
        ConnectFourPiece winner = getVerticalWinner();

        if (winner == null)
        {
            winner = getHorizontalWinner();
        }
        if (winner == null)
        {
            winner = getDiagonalWinner();
        }

        return winner;   
    }

    public ConnectFourPiece getVerticalWinner(){
        ConnectFourPiece winner = null;
        int count = 1;

        for (int j = 0; j < 7; j++)
        {
            winner = this.grid[0][j];
            for (int i = 0; i < 6; i++)
            {
                if(this.grid[i][j] != winner)
                {
                    winner = null;
                }
                else{
                    count++;
                }
                if(count == 4)
                {
                    winner = this.grid[i][j];
                    break;
                }
            }
      }
      return winner;
    }

    public ConnectFourPiece getHorizontalWinner(){
        ConnectFourPiece winner = null;
        int count = 1;

        for(int i = 0; i < 6; i++)
        {
            winner = this.grid[i][0];
            for (int j = 0; j < 7; j++)
            {
                if (this.grid[i][j] != winner)
                {
                    winner = null;
                }
                else{
                    count++;
                }
                if(count == 4)
                {
                    winner = this.grid[i][j];
                    break;
                }
            }
        }
        return winner;
    }

    public ConnectFourPiece getDiagonalWinner(){
        ConnectFourPiece winner = this.grid[0][0];

        return winner;
    }

    public boolean isGameOver(){
        if(this.getWinner() != null || !this.isFull())
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public void register(Observer observer)
    {
        observers.add(observer);
    }

    public void notifyObservers()
    {
      for(Observer observer: observers)
      {
        observer.update();
      }
   }

   public ConnectFourPiece getPlayersPiece(int row, int col){
    return grid[row][col];
   }
}
