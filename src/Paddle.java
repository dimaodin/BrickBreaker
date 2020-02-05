import java.awt.Color;
import java.awt.Graphics;

public class Paddle
{

    private int x;
    final int YPOS = 550, WIDTH = 100, HEIGHT = 20, SPEED = 10;
    private Ball ball;

    public Paddle(Ball b) {
        x = (800 - WIDTH) / 2;
        ball = b;
    }

    public void move(int mouseX) {
        mouseX = mouseX - 50;
        int diff = Math.abs(x - mouseX);
        if (mouseX > this.x) { // going right
            if (diff < 5)
                x = mouseX;
            else
                x += SPEED;
        } else if (mouseX < this.x) { // going left
            if (diff < 5)
                x = mouseX;
            else
                x -= SPEED;
        }
        checkOutsideBounds();
    }

    /**
     * Called during each iteration of the run() method. Determines if the ball has
     * collided with the paddle. If a collision occurs, the ball's x-velocity is
     * altered.
     */
    public void checkBallCollision() {
        int ballX = ball.getX() + 10;
        if (ball.getY() >= 530 && ball.getY() <= 534) {
            if (ballX > this.x && ballX < this.x + 100) {
                ball.reverseYVelocity();
                alterXVelocity();
            }
        }
    }

    /**
     * Alters the x-velocity of the ball according to where the ball strikes the
     * paddle.
     */
    public void alterXVelocity() {
        int ballX = ball.getX() + 10;
        if (ballX >= x && ballX < x + 10)
            ball.setXVel(-6);
        if (ballX >= x + 10 && ballX < x + 20)
            ball.setXVel(-4);
        if (ballX >= x + 20 && ballX < x + 30)
            ball.setXVel(-3);
        if (ballX >= x + 30 && ballX < x + 40)
            ball.setXVel(-2);
        if (ballX >= x + 40 && ballX < x + 60)
            ball.setXVel(0);
        if (ballX >= x + 60 && ballX < x + 70)
            ball.setXVel(2);
        if (ballX >= x + 60 && ballX < x + 80)
            ball.setXVel(3);
        if (ballX >= x + 80 && ballX < x + 90)
            ball.setXVel(4);
        if (ballX >= x + 90 && ballX < x + 100)
            ball.setXVel(6);

        System.out.println("Collision occured");
        System.out.println("Ball xVel = " + ball.getXVel());
    }

    private void checkOutsideBounds() {
        if (x < 0)
            x = 0;
        if (x > 700)
            x = 700;
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, YPOS, WIDTH, HEIGHT);
    }
}