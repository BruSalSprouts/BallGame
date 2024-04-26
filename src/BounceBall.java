import java.awt.*;

public class BounceBall extends BasicBall {
private int bounceCount; // number of times the ball has bounced off the wall

    /// Constructor for BounceBall
    public BounceBall(double r, Color c) {
        super(r, c);
        bounceCount = 0;
    }

    /// Returns the score for the BounceBall
    public int getScore() {
        System.out.println("Bounce Ball Scored!");
        return 15;
    }

    /// Returns the radius of the BounceBall
    public double getRadius() {
        return radius;
    }

    /// Moves the BounceBall
    public void move() {
        rx = rx + vx;
        ry = ry + vy;
    }

    /* Draws the BounceBall. If it hits the edge it bounces,
    unless it has bounced 3 times, in which case it is out.
    */
    public void draw() {
        if ((Math.abs(rx) <= 1.0) && (Math.abs(ry) <= 1.0)) {
            StdDraw.setPenColor(color);
            StdDraw.filledCircle(rx, ry, radius);
        } else {
            bounceCount++;
            if (bounceCount == 3){
                isOut = true;
            }
            else {
                if (Math.abs(rx) > 1.0) {
                    vx = -vx;
                }
                if (Math.abs(ry) > 1.0) {
                    vy = -vy;
                }
            }
        }
    }
    // Return the name of the ball
    public String getName(){
        return "BounceBall";
    }
}
