package connectFour;

import java.io.IOException;

public interface ControllerInterface {
    public void userPressed(int col);
    public int getPlayerColor(int row, int col);
    public void resetGame();
    public void userQuit();
    public void loadFromFile() throws IOException, ClassNotFoundException;
    public int getRedWins();
    public int getYellowWins();
}
