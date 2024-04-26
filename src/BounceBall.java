import java.awt.*;

public class BounceBall extends BasicBall {

    public BounceBall(double r, Color c) {
        super(r, c);
    }

    public int getScore() {
        return 15;
    }
    public double getRadius() {
        return radius;
    }

    public String getName(){
        return "BounceBall";
    }
}
