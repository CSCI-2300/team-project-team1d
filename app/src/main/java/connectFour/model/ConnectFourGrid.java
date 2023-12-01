package connectFour.model;

import connectFour.Observer;

import java.util.ArrayList;


public class ConnectFourGrid {
    private ConnectFourPiece[][] grid;
    public Winners winners;
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public ConnectFourGrid(){
        this.grid = new ConnectFourPiece[6][7];     //6 rows and 7 columns
        this.winners = new Winners();
    }

    public int getNextSpace(int column){    //returns index of lowest open space in column or -1 if column is full
        for(int row = 5; row >= 0; row--){
            if(grid[row][column] == null){
                return row;
            }
        }
        return -1;
    }

    public ArrayList<Integer> getOpenCols()
    {
        ArrayList<Integer> openCols = new ArrayList<Integer>();
        for(int col = 0; col < 7; col++)
        {
            if(this.getNextSpace(col) != -1)
            {
                openCols.add(col);
            }
        }
        return openCols; 
    }

    public boolean placePiece(ConnectFourPiece piece, int column){   //returns true if piece is placed successfully
        int row = getNextSpace(column);
        if(row != -1){
            grid[row][column] = piece;
            notifyObservers();
            return true;
        } else{
            notifyObservers();
            return false;
        } 
    }

    public void show(){      //Displays board to terminal for testing.
        for(int row = 0; row < 6; row ++){
            String rowPieces = "";
            for(int col = 0; col < 7; col++){
                if(grid[row][col] == null){
                    rowPieces += "_";
                } else{
                    rowPieces += grid[row][col];
                }
            }
            System.out.println(rowPieces);
        }
    }

    public boolean isFull(){
        for(int col = 0; col < 7; col++){
            if(getNextSpace(col) != -1){
                return false;
            }
        }
        return true;
    }

    public ConnectFourPiece getWinner(){
        ConnectFourPiece winner = getVerticalWinner();

        if (winner == null){
            winner = getHorizontalWinner();
        }

        if (winner == null){
            winner = getDiagonalWinner();
        }
        
        return winner;   
    }

    public ConnectFourPiece getVerticalWinner(){
        ConnectFourPiece winner = null;

        for (int j = 0; j < 7; j++){
            int count = 1;
            for (int i = 0; i < 5; i++){
                if((this.grid[i][j]!=null) && (this.grid[i][j]==this.grid[i+1][j])){
                    count++;
                } else{
                    count = 1;
                }

                if(count >= 4){
                    winner = this.grid[i][j];
                }
            }
        }

        return winner;
    }

    public ConnectFourPiece getHorizontalWinner(){
        ConnectFourPiece winner = null;

        for(int i = 0; i < 6; i++){
            int count = 1;
            for (int j = 0; j < 6; j++){
                if ((this.grid[i][j]!=null) && (this.grid[i][j]==this.grid[i][j+1])){
                    count++;
                    if(count >= 4){
                        winner = this.grid[i][j];
                    }
                } else{
                    count = 1;
                }
            }
        }

        return winner;
    }

    public ConnectFourPiece getDiagonalWinner(){
        ConnectFourPiece winner = null;

        //Top left to bottom right rows 0-2
        for (int i = 0; i<3; i++){
            int count = 1;
            for(int row = i, col = 0; row<5 && col<7; row++, col++){
                if((this.grid[row][col]!=null) && (this.grid[row][col] == this.grid[row+1][col+1])){
                    count++;
                    if(count>=4){
                        winner = this.grid[row][col];
                        return winner;
                    }
                } else{
                    count = 1;
                }
            }
        }

        //Top left to bottom right columns 1-3
        for (int j = 1; j<4; j++){
            int count = 1;
            for(int row = 0, col = j; row<6 && col<6; row++, col++){
                if((this.grid[row][col]!=null) && (this.grid[row][col] == this.grid[row+1][col+1])){
                    count++;
                    if(count>=4){
                        winner = this.grid[row][col];
                        return winner;
                    }
                } else{
                    count = 1;
                }
            }
        }

        //Top right to bottom left rows 0-2
        for (int i = 0; i<3; i++){
            int count = 1;
            for(int row = i, col = 6; row<5 && col>0; row++, col--){
                if((this.grid[row][col]!=null) && (this.grid[row][col] == this.grid[row+1][col-1])){
                    count++;
                    if(count>=4){
                        winner = this.grid[row][col];
                        return winner;
                    }
                } else{
                    count = 1;
                }
            }
        }

        //Top right to bottom left columns 1-5
        for (int j = 1; j<4; j++){
            int count = 1;
            for(int row = 0, col = 5; row<6 && col>0; row++, col--){
                if((this.grid[row][col]!=null) && (this.grid[row][col] == this.grid[row+1][col-1])){
                    count++;
                    if(count>=4){
                        winner = this.grid[row][col];
                        return winner;
                    }
                } else{
                    count = 1;
                }
            }
        }
        
        return winner;
    }

    public void recordWin(){
        if(this.getWinner() == ConnectFourPiece.R){
            this.winners.increaseRedWins();
        }
        else if(this.getWinner() == ConnectFourPiece.Y){
            this.winners.increaseYellowWins();
        }
    }

    public boolean isGameOver(){
        if((this.getWinner() != null) || (this.isFull())){
            recordWin();
            return true;
        } else{
            return false;
        }
    }

    public void register(Observer observer){
        observers.add(observer);
    }

    public void notifyObservers(){
      for(Observer observer: observers){
        observer.update();
      }
    }

    public ConnectFourPiece getPlayersPiece(int row, int col){
        return grid[row][col];
    }

    public void clear(){
        for(int col = 0; col < 7; col++){
            for(int row = 0; row < 6; row++){
                grid[row][col] = null;
            }
        }
        notifyObservers();
    }
}