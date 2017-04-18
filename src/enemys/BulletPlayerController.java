package enemys;

import enemys.EnemyController;
import models.GameRect;
import views.ImageRenderer;

import java.awt.*;

/**
 * Created by ADMIN on 4/17/2017.
 */
public class BulletPlayerController {
    private GameRect gameRect;
    private ImageRenderer imageRenderer;

    public BulletPlayerController(int x, int y,int width, int height, Image image) {
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
        gameRect.move(0, -10);
    }

    public void draw(Graphics graphics) {
        imageRenderer.render(graphics, gameRect);
    }

    public void checkVaCham(EnemyController enemyController) {
        if (this.gameRect.getX() >= enemyController.getGameRect().getX()
                && enemyController.getGameRect().getX() + 70 >= this.gameRect.getX()
                && this.gameRect.getY() >= enemyController.getGameRect().getY()
                && enemyController.getGameRect().getY() + 51 >= this.gameRect.getY()) {
            System.out.println("NICE SHOT :) EnemyPlane has gone to hell with bugs");
        }
    }
}
