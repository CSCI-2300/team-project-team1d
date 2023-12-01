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
    public void checkDiagonalWinSlopeDown(){
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
    public void checkDiagonalWinSlopeUp(){
        ConnectFourGrid grid = new ConnectFourGrid();
        grid.placePiece(ConnectFourPiece.Y, 6);
        grid.placePiece(ConnectFourPiece.Y, 6);
        grid.placePiece(ConnectFourPiece.Y, 6);
        grid.placePiece(ConnectFourPiece.Y, 5);
        grid.placePiece(ConnectFourPiece.Y, 5);
        grid.placePiece(ConnectFourPiece.Y, 4);
        for(int i=3; i<7; i++){
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

    @Test
    public void checkGameOverFalse(){
        ConnectFourGrid grid = new ConnectFourGrid();
        grid.placePiece(ConnectFourPiece.Y, 0);
        assertFalse(grid.isGameOver());
    }

    @Test
    public void checkGameOverTrueWinner(){
        ConnectFourGrid grid = new ConnectFourGrid();
        for(int i=0; i<5; i++){
            grid.placePiece(ConnectFourPiece.R, i);
        }
        assertTrue(grid.isGameOver());
    }

    @Test 
    public void checkGameOverTrueBoardFull(){
        ConnectFourGrid grid = new ConnectFourGrid();
        for(int i=0; i<7; i++){
            for(int j=0; j<3; j++){
                grid.placePiece(ConnectFourPiece.R, i);
            }
            for(int j=0; j<3; j++){
                grid.placePiece(ConnectFourPiece.Y, i);
            }
        }
        assertTrue(grid.isGameOver());
    }
}
