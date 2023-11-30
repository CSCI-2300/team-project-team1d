package connectFour.model;

import java.util.Random;
import java.util.ArrayList;

import connectFour.AutoPlayerInterface;

public class NormalAutoPlayer implements AutoPlayerInterface{
    
    private ConnectFourPiece computerPiece;
    private ConnectFourGrid grid;
    private int computerLastMove;
    private int playerLastMove;
    private int offensiveEmphasis;
    private int defenseiveEmphasis;

    public NormalAutoPlayer(ConnectFourGrid grid){
        this.computerPiece = ConnectFourPiece.Y;
        this.grid = grid;
        Random rand = new Random();
        this.computerLastMove = rand.nextInt(6);
        this.playerLastMove = rand.nextInt(6);
        this.offensiveEmphasis = 100;
        this.defenseiveEmphasis = 0;
    }

    public void makeNextMove(ConnectFourGrid grid){
        Random rand = new Random();
        ArrayList<Integer> possibleMoves = this.buildPossibleMoves();
        int nextMove = -1;
        while(!grid.getOpenCols().contains(nextMove)){
            nextMove = possibleMoves.get(rand.nextInt(possibleMoves.size()));
        }
        computerLastMove = nextMove;
        grid.placePiece(computerPiece, nextMove);
    }

    private ArrayList<Integer> buildPossibleMoves()
    {
        ArrayList<Integer> possibleMoves = grid.getOpenCols();
        possibleMoves.add(playerLastMove);
        possibleMoves.addAll(this.buildStrategicMoves(playerLastMove, defenseiveEmphasis));
        possibleMoves.addAll(this.buildStrategicMoves(computerLastMove, offensiveEmphasis));
        return possibleMoves;
    }

    private ArrayList<Integer> buildStrategicMoves(int lastMove, int emphasis){
        ArrayList<Integer> strategicMoves = new ArrayList<Integer>();
        for(int i = 0; i < emphasis; i++){
            strategicMoves.add(lastMove);
            strategicMoves.add(lastMove);
            if(lastMove == 0){
                strategicMoves.add(1);
            }
            else if(lastMove == 5){
                strategicMoves.add(4);
            }
            else{
                strategicMoves.add(lastMove + 1);
                strategicMoves.add(lastMove - 1);
            }
        }

        return strategicMoves;
    }

    public void setPlayerLastMove(int col){
        playerLastMove = col;
    }

    
}
