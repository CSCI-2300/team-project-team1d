package connectFour;

import connectFour.model.ConnectFourPiece;

public interface AutoPlayerInterface 
{
    public ConnectFourPiece getPiece();
    public boolean makeNextMove();
}
