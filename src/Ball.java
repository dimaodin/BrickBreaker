import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;

public class Ball {

    private int x, y, xVel, yVel;
    private boolean isMoving;

    public Ball() {
        x = (800 - 25) / 2;
        y = (600 - 25) / 2;
        xVel = (int) (Math.random() * 7 - 3);
        yVel = 7;
        isMoving = false;
    }

    public void startMoving() {
        isMoving = true;
    }

    public void move() {
        if (isMoving) {
            x += xVel;
            y += yVel;
            checkWallCollision();
        }
    }

    private void checkWallCollision() {
        if (x < 0) {
            x = 0;
            xVel = -xVel;
        }
        if (x > 780) {
            x = 780;
            xVel = -xVel;
        }
        if (y < 0) {
            y = 0;
            yVel = -yVel;
        }
    }

    public void setXVel(int x) {
        xVel = x;
    }

    public void setYVel(int y) {
        yVel = y;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public int getXVel() {
        return xVel;
    }

    public int getYVel() {
        return yVel;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void reverseXVelocity() {
        xVel = -xVel;
    }

    public void reverseYVelocity() {
        yVel = -yVel;
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(x, y, 20, 20);
    }
}