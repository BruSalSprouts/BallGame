import java.awt.*;

public class SplitBall extends BasicBall {
    public SplitBall(double r, Color c) {
        super(r, c);
    }

    public int getScore() {
        System.out.println("Split Ball Scored!");
        return 10;
    }
    public double getRadius() {
        return radius;
    }
    public String getName(){
        return "SplitBall";
    }
}
