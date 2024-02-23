import javax.swing.*;
import java.awt.*;

class BallPanel extends JPanel implements Runnable {
    private Image ballImage;
    private int ballX, ballY;
    private final int BALL_SIZE = 50;
    private final int FRAME_WIDTH = 600;
    private final int FRAME_HEIGHT = 400;
    private final int DELAY = 10; 
    private int dx = 1; //increment x,y ball position 
    private int dy = 1; 

    public BallPanel() {
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setBackground(Color.WHITE);

        
        ballImage = new ImageIcon("E:/iti/java/ball/ball.png").getImage(); 
        ballX = FRAME_WIDTH / 2;
        ballY = FRAME_HEIGHT / 2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ballImage, ballX, ballY, BALL_SIZE, BALL_SIZE, this);
    }

    @Override
    public void run() {
        while (true) {
            moveBall();
            repaint(); 
            try {
                Thread.sleep(DELAY); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void moveBall() {
        int maxX = getWidth() - BALL_SIZE;
        int maxY = getHeight() - BALL_SIZE;

        ballX += dx;
        ballY += dy;

        
        if (ballX >= maxX || ballX <= 0) {
            dx *= -1; 
        }

        
        if (ballY >= maxY || ballY <= 0) {
            dy *= -1; 
        }
    }
}
