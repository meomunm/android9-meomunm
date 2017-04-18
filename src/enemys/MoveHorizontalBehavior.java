package enemys;

import models.GameRect;

/**
 * Created by ADMIN on 4/18/2017.
 */
public class MoveHorizontalBehavior extends MoveBehavior {
    private boolean isLeft = false;
    private boolean isRight = true;

    @Override
    public void move(GameRect gameRect) {

        if (gameRect.getX() > 550) {
            isLeft = true;
            isRight = false;
        }
        if (gameRect.getX() < 0) {
            isRight = true;
            isLeft = false;
        }
        if (isLeft) {
            gameRect.move(-5,0);
        }
        if (isRight) {
            gameRect.move(5,0);
        }
    }
}
