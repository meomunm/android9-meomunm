import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ADMIN on 4/14/2017.
 */
public class PlaneEnemy {
    private int x = 0;
    private int y = 40;
    private Image image;
    private static final int SPEED_ENEMY = 5;

    ArrayList<Bullet> bulletsEnemy;

    public PlaneEnemy(Image image) {
        this.image = image;
        bulletsEnemy = new ArrayList<>();
    }

    public void planeEnemyMove() {
        this.x += SPEED_ENEMY;
        if (x % 100 == 0) {
            Bullet bulletEnemy = new Bullet(this.x + 14 - 16, this.y + 35, loadImage("res/enemy_bullet.png"));
            bulletsEnemy.add(bulletEnemy);
        }
        if (this.x >= 610) {
            this.x = -30;
            this.y = 50;
        }
        for (Bullet bulletEnemy : bulletsEnemy) {
            bulletEnemy.setY(bulletEnemy.getY() + 6);
        }
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(image, x, y, 70, 51, null);
        for (Bullet bulletEnemy : bulletsEnemy) {
            graphics.drawImage(bulletEnemy.getImage(), bulletEnemy.getX(), bulletEnemy.getY(), null);
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
