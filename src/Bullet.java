import java.awt.*;

/**
 * Created by ADMIN on 4/14/2017.
 */
public class Bullet {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private Image image;

    public Bullet(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.dx = 0;
        this.dy = 0;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
