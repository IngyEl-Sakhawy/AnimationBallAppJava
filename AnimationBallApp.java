import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class AnimationBallApp extends JFrame {
    private BallPanel ballPanel;

    public AnimationBallApp() {
        setTitle("Animation Ball Application");
        setSize(600, 400);
        ballPanel = new BallPanel();
        add(ballPanel);
        Thread animationThread = new Thread(ballPanel);
        animationThread.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AnimationBallApp().setVisible(true));
    }
}


