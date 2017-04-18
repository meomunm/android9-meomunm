package enemys;

import models.GameRect;
import utils.Util;
import views.ImageRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ADMIN on 4/13/2017.
 */
public class PlayerController {
    private GameRect gameRect;
    private ImageRenderer imageRenderer;
    private boolean shootDisable;

    //ArrayList<Bullet> bullets = new ArrayList<>();

    private final int PLAYER_SPEED = 7;
    private int dx;
    private int dy;

    public PlayerController(int x, int y, Image image) {
        imageRenderer = new ImageRenderer(image);
        gameRect = new GameRect(x, y, 70, 50);
    }

    public GameRect getGameRect() {
        return gameRect;
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
//            shoot();
        }
    }

    public void draw(Graphics graphics) {
        imageRenderer.render(graphics, gameRect);
//        for (Bullet bullet : bullets) {
//            graphics.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), null);
//        }
    }

    public void update() {
        gameRect.move(dx, dy);

//        for (Bullet bullet : bullets) {
//            bullet.setY(bullet.getY() + bullet.getDy());
//        }
    }

    public void shoot() {
//        if (GameWindow.timeCountDelay <= 0) {
////            Bullet bullet = new Bullet(gameRect.getX() + 30, gameRect.getY() - 35, Util.loadImage("res/bullet.png"));
////            bullet.setDy(bullet.getDy() - 10);
////            bullets.add(bullet);
//            GameWindow.timeCountDelay = 10;
//        }
    }


}
