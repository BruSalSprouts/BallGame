import java.util.HashMap;
import java.util.Map;

public class Player {
    private int score;
    private Map<String, Integer> numBallsHit;

    public Player() {
        score = 0;
        numBallsHit = new HashMap<String, Integer>();
    }

    public int getScore() {
        return score;
    }

    public int increaseScore(int score) {
        this.score += score;
        return this.score;
    }

    public Map<String, Integer> getNumBallsHit() {
        return numBallsHit;
    }

    public void setNumBallsHit(Map<String, Integer> numBallsHit) {
        this.numBallsHit = numBallsHit;
    }

    public int getBallHitFailsafe(String ballType) {
        return numBallsHit.getOrDefault(ballType, 0);
    }

    public void increaseBallHits(String ballType){
        if (numBallsHit.containsKey(ballType)){
            numBallsHit.put(ballType, numBallsHit.get(ballType) + 1);
        } else {
            numBallsHit.put(ballType, 1);
        }
    }

}
