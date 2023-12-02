package connectFour.controller;

import java.io.*;

import connectFour.ControllerInterface;
import connectFour.model.*;
import connectFour.view.ConnectFourGUI;
import connectFour.view.FileSelector;

public class TwoPlayerController implements ControllerInterface{
    
    private ConnectFourGrid grid;
    private ConnectFourPiece currentPiece;
    private Winners winners;

    public TwoPlayerController(ConnectFourGrid grid){
        try{
            loadFromFile();
        }
        catch (Exception error){
            System.out.println(error.getMessage());
        }
        this.grid = grid;
        this.winners = this.grid.winners;
        this.currentPiece = ConnectFourPiece.R;
    }

    public void userPressed(int column){
        if(grid.getOpenCols().contains(column)){
            grid.placePiece(currentPiece, column);

            if(currentPiece == ConnectFourPiece.R){
                currentPiece = ConnectFourPiece.Y;
            } else{
                currentPiece = ConnectFourPiece.R;
            }
        }
        
    }

    public int getPlayerColor(int row, int col){
        ConnectFourPiece playersPiece = grid.getPlayersPiece(row, col);

        if(playersPiece == ConnectFourPiece.R){
            return 1;
        } else if(playersPiece == ConnectFourPiece.Y){
            return 2;
        } else{
            return 0;
        }
    }

    public void resetGame(){
        grid.clear();
    }

    public void userQuit(){
        try{
            //String filePath = FileSelector.selectFileToSave();
            FileOutputStream fileOutputStream = new FileOutputStream("winners.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.grid.winners);
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void loadFromFile() throws IOException, ClassNotFoundException{
        //String filePath = FileSelector.selectFileToLoad();
        FileInputStream fileInputStream = new FileInputStream("winners.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        this.grid.winners = (Winners)objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        System.out.println("Loaded from file");
    }
}
