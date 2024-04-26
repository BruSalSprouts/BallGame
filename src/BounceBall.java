import java.awt.*;

public class BounceBall extends BasicBall {

    public BounceBall(double r, Color c) {
        super(r, c);
    }

    public int getScore() {
        System.out.println("Bounce Ball Scored!");
        return 15;
    }
    public double getRadius() {
        return radius;
    }

    public String getName(){
        return "BounceBall";
    }
}
