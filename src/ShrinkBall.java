import java.awt.*;

public class ShrinkBall extends BasicBall {
    private final double shrinkFactor = 2.0/3.0;
    private double originalRadius;
    private int hitCount = 0;

    public ShrinkBall(double r, Color c) {
        super(r, c);
        hitCount = 0;
        originalRadius = radius;
    }

    public boolean isHit(double x, double y) {
        boolean answer = super.isHit(x, y);
        if (answer) {
            radius = radius * shrinkFactor;
            hitCount = (hitCount + 1) % 3;
            if (hitCount == 0) {
                radius = originalRadius;
                reset();
            }
            else{
                resetLocation();
            }
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
