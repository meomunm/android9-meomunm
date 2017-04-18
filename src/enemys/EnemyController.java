package enemys;

import models.GameRect;
import views.ImageRenderer;

import java.awt.*;

/**
 * Created by ADMIN on 4/15/2017.
 */
public class EnemyController {
    private GameRect gameRect;
    private ImageRenderer imageRenderer;
    private MoveBehavior moveBehavior;

    public EnemyController(int x, int y, int width, int height, Image image) {
        gameRect = new GameRect(x, y, width, height);
        imageRenderer = new ImageRenderer(image);
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public GameRect getGameRect() {
        return gameRect;
    }

    public ImageRenderer getImageRenderer() {
        return imageRenderer;
    }

    public void update() {
        if (moveBehavior != null) {
            moveBehavior.move(gameRect);
        }
    }

    public void draw(Graphics graphic) {
        imageRenderer.render(graphic, gameRect);
    }

}
