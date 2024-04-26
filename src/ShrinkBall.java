import java.awt.*;

public class ShrinkBall extends BasicBall {
    private final double shrinkFactor = 2.0/3.0;
    private double originalRadius;

    // Constructor for ShrinkBall
    public ShrinkBall(double r, Color c) {
        super(r, c);
        originalRadius = radius;
    }

    // If the ball is hit, shrink the radius by the shrink factor (until it reaches 25% of the original radius,
    // then reset radius to original radius), reset the ball, and return true
    public boolean isHit(double x, double y) {
        boolean answer = super.isHit(x, y);
        if (answer) {
            radius = radius * shrinkFactor;
            // If the radius is less than 25% of the original radius, reset the radius to the original radius
            if (radius <= originalRadius * 0.25) {
                radius = originalRadius;
            }
            reset();
        }
        return answer;
    }

    // Returns the score for the ShrinkBall
    public int getScore() {
        System.out.println("Shrink ball Scored!");
        return 20;
    }
    // Returns the radius of the ShrinkBall
    public double getRadius() {
        return radius;
    }
    // Returns the name of the ball
    public String getName(){
        return "ShrinkBall";
    }
}
