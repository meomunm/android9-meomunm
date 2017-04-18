import enemys.*;
import utils.Util;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by ADMIN on 4/13/2017.
 */
public class GameWindow extends Frame {

    private Image background;

    private BufferedImage bufferedImage;

    private Graphics backBufferGraphic;

    private InputManager inputManager;
    private EnemyController enemyController;
    private PlayerController playerController;
    private PlaneEnemy enemy1;

    ArrayList<BulletPlayerController> bulletPlayerControllers;
    ArrayList<BulletEnemyController> bulletEnemyControllers;

    public static int timeCountDelay;

    public GameWindow() {
        setVisible(true);
        setSize(600, 800);
        setTitle("Game 1945");

        // bulletsPlayer = new ArrayList<>();

        timeCountDelay = 0;

        //TODO: BUMBUMBUM
        bulletPlayerControllers = new ArrayList<>();
        bulletEnemyControllers = new ArrayList<>();

        inputManager = new InputManager();

        background = Util.loadImage("res/background.png");
        bufferedImage = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backBufferGraphic = bufferedImage.getGraphics();


        enemyController = new EnemyController(300, 200, 70, 51, Util.loadImage("res/enemy_plane_white_1.png"));
        playerController = new PlayerController(275, 700, Util.loadImage("res/plane3.png"));
        enemy1 = new PlaneEnemy(Util.loadImage("res/enemy-green-3.png"));
        enemyController.setMoveBehavior(new MoveHorizontalBehavior());

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
                    //TODO: xet va cham trong ham run, bullets o trong gamewindow
                    try {
                        timeCountDelay++;
                        repaint();
                        Thread.sleep(17);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    playerController.planeKeyPressed(
                            inputManager.isUpPressed(),
                            inputManager.isDownPressed(),
                            inputManager.isLeftPressed(),
                            inputManager.isRightPressed(),
                            inputManager.isSpacePressed()
                    );
                    enemyController.update();
                    playerController.update();
                    enemy1.planeEnemyMove();

                    if (InputManager.isSpacePressed && timeCountDelay % 10 == 0) {
                        BulletPlayerController bulletPlayer = new BulletPlayerController(
                                playerController.getGameRect().getX() + 30,
                                playerController.getGameRect().getY() - 35, 13, 33, Util.loadImage("res/bullet.png"));
                        bulletPlayerControllers.add(bulletPlayer);
                    }

                    if (timeCountDelay % 20 == 0) {
                        BulletEnemyController bulletEnemy = new BulletEnemyController(
                                enemyController.getGameRect().getX() + 35 - 16,
                                enemyController.getGameRect().getY() + 35,
                                32, 32, Util.loadImage("res/enemy_bullet.png")
                        );
                        bulletEnemyControllers.add(bulletEnemy);
                    }
                    for (int i = bulletEnemyControllers.size() - 1; i >= 0; i--) {
                        bulletEnemyControllers.get(i).update();
                        if (bulletEnemyControllers.get(i).getGameRect().getY() > 800) {
                            bulletEnemyControllers.remove(i);
                        }
                    }
                    updateCheckAndRemove(bulletPlayerControllers);
                }
            }
        });
        thread.start();
    }

    public void updateCheckAndRemove(ArrayList<BulletPlayerController> bulletPlayerControllers) {
        for (int i = bulletPlayerControllers.size() - 1; i >= 0; i--) {
            bulletPlayerControllers.get(i).update();
            bulletPlayerControllers.get(i).checkVaCham(enemyController);
            if (bulletPlayerControllers.get(i).getGameRect().getY() <= 0) {
                bulletPlayerControllers.remove(i);
                System.out.println("REMOVE BULLETS DONE");
            }
        }
    }

    @Override
    public void update(Graphics g) {
        backBufferGraphic.drawImage(background, 0, 0, 600, 800, null);
        playerController.draw(backBufferGraphic);
        enemyController.draw(backBufferGraphic);
        enemy1.draw(backBufferGraphic);

        for (BulletPlayerController bulletPlayer : bulletPlayerControllers) {
            bulletPlayer.draw(backBufferGraphic);
        }

        for (BulletEnemyController bulletEnemy : bulletEnemyControllers){
            bulletEnemy.draw(backBufferGraphic);
        }

        g.drawImage(bufferedImage, 0, 0, 600, 800, null);
    }
}

