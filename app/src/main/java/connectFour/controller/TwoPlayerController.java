package connectFour.control;

import connectFour.ControllerInterface;
import connectFour.model.*;

public class TwoPlayerController implements ControllerInterface
{
    ConnectFourGrid grid;
    ConnectFourPiece currentPiece;

    public TwoPlayerController(ConnectFourGrid grid)
    {
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
}
