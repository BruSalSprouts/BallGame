/******************************************************************************
 *  Compilation:  javac BallGame.java
 *  Execution:    java BallGame n
 *  Dependencies: BasicBall.java StdDraw.java
 *
 *  Creates a BasicBall and animates it
 *
 *  Part of the animation code is adapted from Computer Science:   An Interdisciplinary Approach Book
 *  
 *  Run the skeleton code with arguments : 1  basic  0.08
 *******************************************************************************/
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class BallGame { 
    public static List<BasicBall> balls = new ArrayList<>();
    private static int numBalls;
    private static int numBallsInGame;

    public static void main(String[] args) {
  
    	// number of bouncing balls
    	numBalls = Integer.parseInt(args[0]);
    	//ball types
    	String ballTypes[] = new String[numBalls];
    	//sizes of balls
    	double ballSizes[] = new double[numBalls];
    	
    	//retrieve ball types
    	int index =1;
    	for (int i=0; i<numBalls; i++) {
    		ballTypes[i] = args[index];
    		index = index+2;
    	}
    	//retrieve ball sizes
    	index = 2;
    	for (int i=0; i<numBalls; i++) {
    		ballSizes[i] = Double.parseDouble(args[index]);
    		index = index+2;
    	}
     
    	//Create a Player object and initialize the player game stats.
    	Player player = new Player();
    	
    	//number of active balls
    	numBallsInGame = 0;
        StdDraw.enableDoubleBuffering();

        StdDraw.setCanvasSize(800, 800);
        // set boundary to box with coordinates between -1 and +1
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);

           for (int i = 0; i < numBalls; i++) {
               switch (ballTypes[i]){
                   case "basic":
                       balls.add(new BasicBall(ballSizes[i], Color.RED));
                       break;
                   case "bounce":
                       balls.add(new BounceBall(ballSizes[i], Color.BLUE));
                       break;
                   case "shrink":
                       balls.add(new ShrinkBall(ballSizes[i], Color.GREEN));
                       break;
                    case "split":
                       balls.add(new SplitBall(ballSizes[i], Color.YELLOW));
                       break;
               }
           }
   		//Initialize the numBallsinGame
   		numBallsInGame = balls.size();
        
        // do the animation loop
        StdDraw.enableDoubleBuffering();

        while (numBallsInGame > 0) {

            for (BasicBall b : balls) {
                b.move();
            }

            //Check if the mouse is clicked
            if (StdDraw.isMousePressed()) {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                //TODO: check whether a ball is hit. Check each ball.
                int tempLen = balls.size();
                for (int i = 0; i < tempLen; i++) {
                    BasicBall ball = balls.get(i);
                    System.out.println("Checking ball: " + ball.getName());
                    if (ball.isHit(x,y)) {
                        ball.reset();
                        //TO DO: Update player statistics
                        player.increaseBallHits(ball.getName());
                        player.increaseScore(ball.getScore());
                        ball.onHit(balls);

                    }
                }
            }
                
            numBallsInGame = 0;
            // draw the n balls
            StdDraw.clear(StdDraw.GRAY);
            StdDraw.setPenColor(StdDraw.BLACK);
            
            //Check each ball and see if they are still visible. numBallsinGame should hold the number of visible balls in the game.
            for (BasicBall ball : balls){
                if (!ball.isOut){
                    ball.draw();
                    numBallsInGame++;
                }
            }

            //Print the game progress
            StdDraw.setPenColor(StdDraw.YELLOW);
            Font smallerFont = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(smallerFont);
            StdDraw.text(-0.65, 0.90, "Number of balls in game: "+ String.valueOf(numBallsInGame));
            // Print the player's score
            StdDraw.text(-0.65, 0.80, "Score: " + String.valueOf(player.getScore()));
            StdDraw.show();
            StdDraw.pause(20);
        }
            StdDraw.setPenColor(StdDraw.BLUE);
            Font font = new Font("Arial", Font.BOLD, 60);
            Font smallerFont = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            StdDraw.text(0, 0, "GAME OVER");
            StdDraw.setFont(smallerFont);
            StdDraw.setPenColor(StdDraw.ORANGE);

            // Number of hits for all types of balls is given by Player.getNumBallsHit()
            StdDraw.text(0, -0.10, "Number of hits for each ball type: ");
            StdDraw.text(0, -0.17, "Basic Ball Hits: " + player.getBallHitFailsafe("BasicBall") + "\r\n");
            StdDraw.text(0, -0.24, "Split Ball Hits: " + player.getBallHitFailsafe("SplitBall") + "\r\n");
            StdDraw.text(0, -0.31, "Shrink Ball Hits: " + player.getBallHitFailsafe("ShrinkBall") + "\r\n");
            StdDraw.text(0, -0.38, "Bounce Ball Hits: " + player.getBallHitFailsafe("BounceBall") + "\r\n");

            StdDraw.show();
            StdDraw.pause(10);           

        
    }

    public static void addSplitBall(SplitBall b) {
        balls.add(b);
        numBallsInGame++;
    }
}
