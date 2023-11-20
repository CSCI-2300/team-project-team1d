package connectFour.controller;

import connectFour.ControllerInterface;
import connectFour.model.*;
import connectFour.view.ConnectFourGUI;
import connectFour.AutoPlayerInterface;

public class AutoPlayerController implements ControllerInterface
{
    private ConnectFourGrid grid;
    private ConnectFourPiece currentPiece;
    private ConnectFourGUI view;
    private AutoPlayerInterface autoPlayer;

    public AutoPlayerController(ConnectFourGrid grid, AutoPlayerInterface autoPlayer)
    {
        this.grid = grid;
        this.view = new ConnectFourGUI(this, grid);
        this.currentPiece = ConnectFourPiece.R;
        this.autoPlayer = autoPlayer;
    }

    public void userPressed(int col)
    {
        grid.placePiece(currentPiece, col);
        if(!grid.isGameOver())
        {
            autoPlayer.makeNextMove();
        }

    }

    public int getPlayerColor(int row, int col)
    {
        ConnectFourPiece playersPiece = grid.getPlayersPiece(row, col);

        if(playersPiece == ConnectFourPiece.R){
            return 1;
        } else if(playersPiece == ConnectFourPiece.Y){
            return 2;
        } else{
            return 0;
        }
    }

    public void resetGame()
    {
        grid.clear();
    }

    
}
