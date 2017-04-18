import java.awt.*;

/**
 * Created by ADMIN on 4/14/2017.
 */
public class Bullet {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private boolean isShotEnable;
//    private
    private Image image;

    public Bullet(int x, int y, Image image, boolean shotEnable) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.dx = 0;
        this.dy = 0;
        this.isShotEnable = shotEnable;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void setShotEnable(boolean shotEnable) {
        isShotEnable = shotEnable;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public boolean isShotEnable() {
        return isShotEnable;
    }

    public Image getImage() {
        return image;
    }

    public void shoot(){
        if (isShotEnable){

        }
    }
}
