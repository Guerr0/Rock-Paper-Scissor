package game;

import java.util.Random;

public class Game {

    public enum ObjectType {
        ROCK, SCISSOR, PAPER;
    }

    private int manche;

    public Game() {
        this.manche = 0;
    }

    public void nextManche() {
        this.manche = manche++;
    }

    public ObjectType getRandomObject() {
        Random random = new Random();
        int numberOfObjects = ObjectType.values().length;
        return ObjectType.values()[random.nextInt(numberOfObjects)];
    }


}
