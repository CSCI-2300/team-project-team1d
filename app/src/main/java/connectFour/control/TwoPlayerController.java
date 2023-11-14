package connectFour.control;

import connectFour.ControllerInterface;
import connectFour.model.*;
import connectFour.view.ConnectFourGUI;

public class TwoPlayerController implements ControllerInterface
{
    ConnectFourGrid grid;
    ConnectFourPiece currentPiece;
    ConnectFourGUI view;

    public TwoPlayerController(ConnectFourGrid grid)
    {
        this.view = new ConnectFourGUI(this, grid);
        this.grid = grid;
        this.currentPiece = ConnectFourPiece.R;
    }

    public void userPressed(int column)
    {
        grid.placePiece(currentPiece, column);
        if(currentPiece == ConnectFourPiece.R)
        {
            currentPiece = ConnectFourPiece.Y;
        }
        else
        {
            currentPiece = ConnectFourPiece.R;
        }

    }

    public int getPlayerColor(int row, int col)
    {
        ConnectFourPiece playersPiece = grid.getPlayersPiece(row, col);
        if(playersPiece == ConnectFourPiece.R){
            return 1;
        } else if(playersPiece == ConnectFourPiece.Y){
            return 2;
        } else {
            return 0;
        }
    }
}
