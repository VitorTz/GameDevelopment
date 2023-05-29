package ougi.window;

import ougi.commands.CommandHistory;
import ougi.scene.LevelScene;
import ougi.scene.Scene;
import ougi.util.Constants;
import ougi.util.Time;
import javax.swing.JFrame;
import java.awt.*;


public class Window extends JFrame implements Runnable {

    private static Window window = null;
    private boolean isRunning;
    private Image doubleBufferImage;
    private Scene currentScene = null;

    private Window() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.addKeyListener(new KL());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static Window getWindow() {
        if (Window.window == null) {
            Window.window = new Window();
            Window.window.init();
        }
        return Window.window;
    }

    private void init() {
        this.isRunning = true;
        this.currentScene = new LevelScene();
    }

    private void update(double deltaTime) {
        CommandHistory.run();
        this.currentScene.update(deltaTime);
        this.draw(this.getGraphics());
    }

    private void renderOffScreen(Graphics2D g2) {
        g2.setColor(new Color(13, 17, 23));
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        this.currentScene.draw(g2);
    }

    private void draw(Graphics g) {
        Dimension d = this.getSize();
        if (this.doubleBufferImage == null) {
            this.doubleBufferImage = this.createImage(d.width, d.height);
        }
        this.renderOffScreen((Graphics2D) this.doubleBufferImage.getGraphics());

        g.drawImage(this.doubleBufferImage, 0, 0, d.width, d.height, null);
    }

    @Override
    public void run() {
        while (this.isRunning) {
            try {
                double deltaTime = Time.getDeltaTime();
                this.update(deltaTime);
                Time.sleep(Constants.FRAME_IN_MILLIS);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }

}
