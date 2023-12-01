package connectFour;

public interface ControllerInterface {
    public void userPressed(int col);
    public int getPlayerColor(int row, int col);
    public void resetGame();
    public void userQuit();
}
