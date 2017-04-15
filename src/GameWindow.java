import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by ADMIN on 4/13/2017.
 */
public class GameWindow extends Frame {

    private Image background;

    private BufferedImage bufferedImage;

    private Graphics backBufferGraphic;

    InputManager inputManager;
    PlanePlayer planePlayer;
    PlaneEnemy enemy1;

    public static int timeCountDelay;


    public GameWindow() {
        setVisible(true);
        setSize(600, 800);
        setTitle("Game 1945");

        timeCountDelay = 10;

        inputManager = new InputManager();

        background = loadImage("res/background.png");
        bufferedImage = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backBufferGraphic = bufferedImage.getGraphics();

        planePlayer = new PlanePlayer(275, 700, this.loadImage("res/plane3.png"));
        enemy1 = new PlaneEnemy(this.loadImage("res/enemy-green-3.png"));

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                System.out.println("windowClosing");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        inputManager.setUpPressed(true);
                        break;
                    case KeyEvent.VK_DOWN:
                        inputManager.setDownPressed(true);
                        break;
                    case KeyEvent.VK_LEFT:
                        inputManager.setLeftPressed(true);
                        break;
                    case KeyEvent.VK_RIGHT:
                        inputManager.setRightPressed(true);
                        break;
                    case KeyEvent.VK_SPACE:
                        inputManager.setSpacePressed(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        inputManager.setUpPressed(false);
                        break;
                    case KeyEvent.VK_DOWN:
                        inputManager.setDownPressed(false);
                        break;
                    case KeyEvent.VK_LEFT:
                        inputManager.setLeftPressed(false);
                        break;
                    case KeyEvent.VK_RIGHT:
                        inputManager.setRightPressed(false);
                        break;
                    case KeyEvent.VK_SPACE:
                        inputManager.setSpacePressed(false);
                        break;
                }
            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        timeCountDelay--;
                        repaint();
                        Thread.sleep(17);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    planePlayer.planeKeyPressed(inputManager.isUpPressed(), inputManager.isDownPressed(), inputManager.isLeftPressed(), inputManager.isRightPressed(), inputManager.isSpacePressed());
                    planePlayer.update();
                    enemy1.planeEnemyMove();
                }
            }
        });
        thread.start();
    }

    @Override
    public void update(Graphics g) {
        backBufferGraphic.drawImage(background, 0, 0, 600, 800, null);
        planePlayer.draw(backBufferGraphic);
        enemy1.draw(backBufferGraphic);

        g.drawImage(bufferedImage, 0, 0, 600, 800, null);
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
