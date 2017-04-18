package enemys;

import models.GameRect;
import views.ImageRenderer;

import java.awt.*;

/**
 * Created by ADMIN on 4/17/2017.
 */
public class BulletEnemyController{
    private GameRect gameRect;
    private ImageRenderer imageRenderer;

    public BulletEnemyController(int x, int y,int width, int height, Image image) {
        this.gameRect = new GameRect(x, y, width, height); //   32 x 32
        this.imageRenderer = new ImageRenderer(image);
    }

    public GameRect getGameRect() {
        return gameRect;
    }

    public ImageRenderer getImageRenderer() {
        return imageRenderer;
    }

    public void update() {
        gameRect.move(0, 10);
    }

    public void draw(Graphics graphics) {
        imageRenderer.render(graphics, gameRect);
    }

    public void checkVaCham(PlayerController playerController) {
        if (this.gameRect.getX() >= playerController.getGameRect().getX()
                && playerController.getGameRect().getX() + 70 >= this.gameRect.getX()
                && this.gameRect.getY() >= playerController.getGameRect().getY()
                && playerController.getGameRect().getY() + 51 >= this.gameRect.getY()) {
            System.out.println("NICE SHOT :) EnemyPlane has gone to hell with bugs");
        }
    }
}
