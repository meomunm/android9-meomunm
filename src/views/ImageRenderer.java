package views;

import models.GameRect;
import utils.Util;

import java.awt.*;

/**
 * Created by ADMIN on 4/15/2017.
 */
public class ImageRenderer {
    private Image image;

    public ImageRenderer(Image image) {
        this.image = image;
    }

    public ImageRenderer(String path) {
        this.image = Util.loadImage(path);
    }

    public void render(Graphics graphics, GameRect gameRect){
        graphics.drawImage(image, gameRect.getX(), gameRect.getY(), gameRect.getWidth(), gameRect.getHeight(), null);
    }
}
