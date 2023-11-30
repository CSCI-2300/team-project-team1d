package connectFour;

import org.junit.Test;
import static org.junit.Assert.*;

import connectFour.controller.*;
import connectFour.model.*;

public class AppTest {
    @Test
    public void checkVerticalWin(){
        ConnectFourGrid grid = new ConnectFourGrid();
        for(int i=0; i<5; i++){
            grid.placePiece(ConnectFourPiece.R, 1);
        }
        assertTrue(grid.getWinner() == ConnectFourPiece.R);
    }

    @Test
    public void checkHorizontalWin(){
        ConnectFourGrid grid = new ConnectFourGrid();
        for(int i=0; i<5; i++){
            grid.placePiece(ConnectFourPiece.R, i);
        }
        assertTrue(grid.getWinner() == ConnectFourPiece.R);
    }

    @Test
    public void checkDiagonalWin(){
        ConnectFourGrid grid = new ConnectFourGrid();
        grid.placePiece(ConnectFourPiece.Y, 0);
        grid.placePiece(ConnectFourPiece.Y, 0);
        grid.placePiece(ConnectFourPiece.Y, 0);
        grid.placePiece(ConnectFourPiece.Y, 1);
        grid.placePiece(ConnectFourPiece.Y, 1);
        grid.placePiece(ConnectFourPiece.Y, 2);
        for(int i=0; i<5; i++){
            grid.placePiece(ConnectFourPiece.R, i);
        }
        assertTrue(grid.getWinner() == ConnectFourPiece.R);
    }

    @Test
    public void checkNoWinner(){
        ConnectFourGrid grid = new ConnectFourGrid();
        grid.placePiece(ConnectFourPiece.Y, 0);
        grid.placePiece(ConnectFourPiece.Y, 0);
        grid.placePiece(ConnectFourPiece.Y, 0);
        grid.placePiece(ConnectFourPiece.R, 0);
        assertTrue(grid.getWinner() == null);
    }
}
