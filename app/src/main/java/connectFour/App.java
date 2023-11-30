package connectFour;

import connectFour.controller.*;
import connectFour.model.*;
import connectFour.view.*;

public class App {
    public static void main(String[] args){
        ConnectFourGrid grid = new ConnectFourGrid();
        NormalAutoPlayer autoPlayer = new NormalAutoPlayer(grid);
        ControllerInterface controller = new AutoPlayerController(grid, autoPlayer);
    }
      
}
