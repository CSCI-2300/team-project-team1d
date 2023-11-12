package connectFour.control;

import connectFour.model.*;

public class TwoPlayerController 
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
