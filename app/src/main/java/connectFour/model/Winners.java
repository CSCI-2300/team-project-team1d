package connectFour.model;

import java.io.Serializable;

public class Winners implements Serializable {
    public int numOfRedWins;
    public int numOfYellowWins;

    public Winners(){
        numOfRedWins = 0;
        numOfYellowWins = 0;
    }

    public int increaseRedWins(){
        numOfRedWins++;
        return numOfRedWins;
    }

    public int increaseYellowWins(){
        numOfYellowWins++;
        return numOfYellowWins;
    }

    public int returnRedWins(){
        return numOfRedWins;
    }

    public int returnYellowWins(){
        return numOfYellowWins;
    }
}
