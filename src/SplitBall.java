import java.awt.*;
import java.util.List;

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

    private BasicBall newBall(double r, Color c) {
        SplitBall ball1 = new SplitBall(radius, color);
        ball1.rx = rx;
        ball1.ry = ry;
        ball1.vx = -vx;
        ball1.vy = vy;


        return ball1;
    }

    @Override
    public void onHit(List<BasicBall> balls) {
        balls.add(this.newBall(radius, color));
        balls.add(this.newBall(radius, color));
        this.isOut = true;
    }

}
