package connectFour.model;

public class ConnectFourGrid 
{
    private ConnectFourPiece[][] grid;

    public ConnectFourGrid()
    {
        this.grid = new ConnectFourPiece[6][7];     //6 rows and 7 columns
    }

    public int getNextSpace(int column)     //returns index of lowest open space in column or -1 if column is full
    {
        for(int row = 5; row >= 0; row--)
        {
            if(grid[row][column] == null)
            {
                return row;
            }
        }
        return -1;
    }

    public boolean placePiece(ConnectFourPiece piece, int column)   //returns true if piece is placed successfully
    {
        int row = getNextSpace(column);
        if(row != -1)
        {
            grid[row][column] = piece;
            return true;
        }
        else
        {
            return false;
        }
        
    }

    public void show()      //Displays board to terminal for testing.
    {
        for(int row = 0; row < 6; row ++)
        {
            String rowPieces = "";
            for(int col = 0; col < 7; col++)
            {
                if(grid[row][col] == null)
                {
                    rowPieces += "_";
                }
                else
                {
                    rowPieces += grid[row][col];
                }
            }
            System.out.println(rowPieces);
        }
    }

    public boolean isFull()
    {
        for(int col = 0; col < 7; col++)
        {
            if(getNextSpace(col) != -1)
            {
                return false;
            }
        }
        return true;
    }
}
