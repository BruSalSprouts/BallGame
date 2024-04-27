import java.awt.*;

public class SplitBall extends BasicBall {
    private BallGame ballGame; // reference to the BallGame class

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

    // If the ball is hit, split the ball into two balls of half the radius, reset the ball, and return true
    public boolean isHit(double x, double y) {
        boolean answer = super.isHit(x, y);
        if (answer) {
            SplitBall ball2 = new SplitBall(radius / 2.0, color);
            ball2.rx = rx;
            ball2.ry = ry;
            ball2.vx = vx;
            ball2.vy = -vy;
            // Add the new ball to the list of balls. However, the list of balls is not accessible from this class.
            // To do this, I will need to add a method to the BallGame class that adds a ball to the list of balls.
            // And is called from here.
            BallGame.addSplitBall(ball2);
            reset();
        }
        return answer;
    }

    //
}
