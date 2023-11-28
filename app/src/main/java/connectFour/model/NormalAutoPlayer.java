package connectFour.model;

import java.util.Random;
import java.util.ArrayList;

import connectFour.AutoPlayerInterface;

public class NormalAutoPlayer implements AutoPlayerInterface{
    
    private ConnectFourPiece computerPiece;
    private ConnectFourGrid grid;
    

    public NormalAutoPlayer(ConnectFourGrid grid){
        this.computerPiece = ConnectFourPiece.Y;
        this.grid = grid;
    }

    public void makeNextMove(ConnectFourGrid grid){
        Random rand = new Random();
        ArrayList<Integer> openCols = grid.getOpenCols();
        grid.placePiece(computerPiece, openCols.get(rand.nextInt(openCols.size())));
    }
}
