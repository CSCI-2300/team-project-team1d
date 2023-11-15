
package connectFour;
import connectFour.controller.TwoPlayerController;
import connectFour.model.*;
import connectFour.view.*;
import java.util.Random;

public class App {
    public static void main(String[] args)
    {
        ConnectFourGrid grid = new ConnectFourGrid();
        ControllerInterface controller = new TwoPlayerController(grid);
        System.out.println("Winner is: " + grid.getWinner());
    }
      
}
