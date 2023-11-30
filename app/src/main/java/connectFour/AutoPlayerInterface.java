package connectFour;

import connectFour.model.*;

public interface AutoPlayerInterface {
    public void makeNextMove(ConnectFourGrid grid);
    public void setPlayerLastMove(int lastMove);
}
