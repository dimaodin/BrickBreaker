import java.awt.Color;
import java.awt.Graphics;

public class Brick
{
    public final static int WIDTH = 50;
    final int Y = 5;
    private Ball ball;
    private int x;

    public Brick(Ball b, int x) {
        ball = b;
        this.x = x;
    }

    public void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, Y, WIDTH, 15);

        g.setColor(Color.blue.darker());
        g.fillRect(x, Y+10, WIDTH, 15);

        g.setColor(Color.red);
        g.fillRect(x, Y+20, WIDTH, 15);

        g.setColor(Color.red.darker());
        g.fillRect(x, Y+30, WIDTH, 10);
    }

    public boolean checkBallCollision() {
        int ballX = ball.getX() + 10;
        if (ball.getY() <= 15 && ball.getY() >= 5) {
            if (ballX >= x && ballX <= x + WIDTH) {
                ball.reverseYVelocity();
                return true;
            }
        }
        return false;
    }
}