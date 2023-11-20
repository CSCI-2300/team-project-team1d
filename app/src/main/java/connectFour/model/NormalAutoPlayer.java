package connectFour.model;

import connectFour.AutoPlayerInterface;

public class NormalAutoPlayer implements AutoPlayerInterface
{
    private ConnectFourPiece computerPiece;

    public NormalAutoPlayer()
    {
        this.computerPiece = ConnectFourPiece.Y;
    }

    public boolean makeNextMove(ConnectFourGrid grid)
    {
        return true;
    }
}
