import java.awt.*;

public class ShrinkBall extends BasicBall {
    public ShrinkBall(double r, Color c) {
        super(r, c);
    }

    public int getScore() {
        return 20;
    }
    public double getRadius() {
        return radius;
    }
    public String getName(){
        return "ShrinkBall";
    }
}
