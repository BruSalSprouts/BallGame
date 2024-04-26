import java.awt.*;

public class ShrinkBall extends BasicBall {
    private final double shrinkFactor = 2.0/3.0;
    private double originalRadius;

    // Constructor for ShrinkBall
    public ShrinkBall(double r, Color c) {
        super(r, c);
        originalRadius = radius;
    }

    public boolean isHit(double x, double y) {
        boolean answer = super.isHit(x, y);
        if (answer) {
            radius = radius * shrinkFactor;
            // If the radius is less than 25% of the original radius, reset the radius to the original radius
            if (radius <= originalRadius * 0.25) {
                radius = originalRadius;
            }
            resetLocation();
        }
        return answer;
    }

    public int getScore() {
        System.out.println("Shrink ball Scored!");
        return 20;
    }
    public double getRadius() {
        return radius;
    }
    public String getName(){
        return "ShrinkBall";
    }
}
