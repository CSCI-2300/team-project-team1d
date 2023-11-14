
package connectFour;
import connectFour.control.TwoPlayerController;
import connectFour.model.*;
import connectFour.view.*;
import java.util.Random;

public class App {
    public static void main(String[] args)
    {
        ConnectFourGrid grid = new ConnectFourGrid();
        ControllerInterface controller = new TwoPlayerController(grid);
        //ConnectFourGUI gui = new ConnectFourGUI(controller);

        /*Random rand = new Random();
        int input = 1;
        while(!grid.isFull())
        {
            controller.userPressed(input);
            grid.show();
            input = rand.nextInt(7);
        }*/
    }
      
}
