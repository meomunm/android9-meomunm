/**
 * Created by ADMIN on 4/13/2017.
 */
public class InputManager {
    boolean isUpPressed;
    boolean isDownPressed;
    boolean isLeftPressed;
    boolean isRightPressed;
    static boolean isSpacePressed;

    public boolean isSpacePressed() {
        return isSpacePressed;
    }

    public void setSpacePressed(boolean spacePressed) {
        isSpacePressed = spacePressed;
    }

    public void setUpPressed(boolean upPressed) {
        isUpPressed = upPressed;
    }

    public void setDownPressed(boolean downPressed) {
        isDownPressed = downPressed;
    }

    public void setLeftPressed(boolean leftPressed) {
        isLeftPressed = leftPressed;
    }

    public void setRightPressed(boolean rightPressed) {
        isRightPressed = rightPressed;
    }

    public boolean isUpPressed() {
        return isUpPressed;
    }

    public boolean isDownPressed() {
        return isDownPressed;
    }

    public boolean isLeftPressed() {
        return isLeftPressed;
    }

    public boolean isRightPressed() {
        return isRightPressed;
    }
}
