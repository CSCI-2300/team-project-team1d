package connectFour.model;

public class ConnectFourGrid 
{
    private ConnectFourPiece[][] grid;

    public ConnectFourGrid()
    {
        this.grid = new ConnectFourPiece[6][7];
    }

    public int getNextSpace(int column)
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

    public boolean placePiece(ConnectFourPiece piece, int column)
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

    public void show()
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
