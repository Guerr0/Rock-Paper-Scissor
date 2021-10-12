package game;

public class Player {

    private int victories;

    public Player()
    {
        this.victories=0;
    }

    public void mancheWon()
    {
        this.victories = victories+1;
    }

    public int getVictories() {
        return victories;
    }
}
