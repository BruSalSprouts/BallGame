import java.awt.*;

public class SplitBall extends BasicBall {
    public SplitBall(double r, Color c) {
        super(r, c);
    }

    // return the score for the ball
    public int getScore() {
        System.out.println("Split Ball Scored!");
        return 10;
    }
    // return the radius of the ball
    public double getRadius() {
        return radius;
    }
    // return the name of the ball
    public String getName(){
        return "SplitBall";
    }
}
