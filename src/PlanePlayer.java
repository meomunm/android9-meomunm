import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ADMIN on 4/13/2017.
 */
public class PlanePlayer {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private Image image;

    private final int PLAYER_SPEED = 7;

    ArrayList<Bullet> bullets = new ArrayList<>();

    public PlanePlayer(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.dx = 0;
        this.dy = 0;
        //bullets = new ArrayList<>();
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

    public void planeKeyPressed(boolean isUpPressed, boolean isDownPressed, boolean isLeftPressed, boolean isRightPressed, boolean isSpacePressed) {
        dx = 0;
        dy = 0;

        if (isUpPressed) {
            this.dy -= PLAYER_SPEED;
        }
        if (isDownPressed) {
            this.dy += PLAYER_SPEED;
        }
        if (isLeftPressed) {
            this.dx -= PLAYER_SPEED;
        }
        if (isRightPressed) {
            this.dx += PLAYER_SPEED;
        }
        if (isSpacePressed) {
            shoot();
        }
    }

    public void shoot(){
        if (GameWindow.timeCountDelay <= 0) {
            Bullet bullet = new Bullet(this.getX() + 30, this.getY() - 35, loadImage("res/bullet.png"));
            bullet.setDy(bullet.getDy() - 10);
            bullets.add(bullet);
            GameWindow.timeCountDelay = 10;
        }
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(image, x, y, null);
        for (Bullet bullet : bullets) {
            graphics.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), null);
        }
    }

    public void update() {
        this.x += dx;
        this.y += dy;
        for (Bullet bullet : bullets) {
            bullet.setY(bullet.getY() + bullet.getDy());
        }
    }

    public Image loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
