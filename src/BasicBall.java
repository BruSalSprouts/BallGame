/******************************************************************************
 *  Compilation:  javac ColoredBall.java
 *  Execution:    java ColoredBall
 *  Dependencies: StdDraw.java
 *
 *  Implementation of a 2-d ball moving in square with coordinates
 *  between -1 and +1. Bounces off the walls upon collision.
 *  
 *
 ******************************************************************************/

import java.awt.Color;

public class BasicBall { 
    protected double rx, ry;         // position
    protected double vx, vy;         // velocity
    protected double radius;   // radius
    protected final Color color;     // color
    public boolean isOut;
    

    // constructor
    public BasicBall(double r, Color c) {
        rx = 0.0;
        ry = 0.0;
        vx = StdRandom.uniform(-0.01, 0.01);
        vy = StdRandom.uniform(-0.01, 0.01);
        radius = r;
        color = c;
        isOut = false;
    }
   
   
    // move the ball one step
    public void move() {
        rx = rx + vx;
        ry = ry + vy;
        if ((Math.abs(rx) > 1.0) || (Math.abs(ry) > 1.0)) 
        	isOut = true;
    }

    // draw the ball
    public void draw() { 
    	if ((Math.abs(rx) <= 1.0) && (Math.abs(ry) <= 1.0)) {
    		StdDraw.setPenColor(color);
    		StdDraw.filledCircle(rx, ry, radius);
    	} else
    		isOut = true;
    	
    }

    // reset the ball to a random position
    protected void resetLocation(){
        rx = 0.0;
        ry = 0.0;
    }

    // reset the ball to a random speed
    protected void resetSpeed(){
        vx = StdRandom.uniform(-0.01, 0.01);
        vy = StdRandom.uniform(-0.01, 0.01);
    }

    // reset the ball to a random position and speed
    public int reset() {
        resetLocation();
        // TO DO: assign a random speed
        resetSpeed();
        return 1;
    }

    // check if the ball is hit by a click at (x, y)
    public boolean isHit(double x, double y) {
    	if ((Math.abs(rx-x)<=radius) && (Math.abs(ry-y)<=radius)){
            return true;
        }
		else return false;

    }

    // return the score of the ball
    public int getScore() {
        System.out.println("Basic Ball Scored!");
    	return 25;
    }

    // return the radius of the ball
    public double getRadius() {
    	return radius;
    }

    // return the name of the ball
    public String getName(){
        	return "BasicBall";
    }
}
