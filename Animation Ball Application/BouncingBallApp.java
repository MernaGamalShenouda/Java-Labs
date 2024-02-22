import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouncingBallApp extends JFrame {
    private JLabel ballLabel;
    private int x = 0, y = 0;
    private int xSpeed = 10, ySpeed = 10;

    public BouncingBallApp() {
        super("Bouncing Ball App");
		ImageIcon originalIcon = new ImageIcon("ball.png"); // Replace with the path to your ball image
		Image scaledImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		ballLabel = new JLabel(scaledIcon);
        ballLabel.setSize(ballLabel.getPreferredSize());

        BallMovementThread ballThread = new BallMovementThread();
        ballThread.start();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800, 600); // Initial screen size
        setLocationRelativeTo(null);
        add(ballLabel);

        setVisible(true);
    }

    private class BallMovementThread extends Thread {
        @Override
        public void run() {
            while (true) {
                moveBall();
                repaint(); // Repaint the GUI to update the ball's position
                try {
                    Thread.sleep(50); // Pause for 50 milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void moveBall() {
        x += xSpeed;
        y += ySpeed;

        if (x < 0) {
			x = 0;
			xSpeed = -xSpeed;
		} 
		else if (x + ballLabel.getWidth() > getWidth()) {
			x = getWidth() - ballLabel.getWidth();
			xSpeed = -xSpeed; 
		}

		if (y < 0) {
			y = 0;
			ySpeed = -ySpeed; 
		} 
		else if (y + ballLabel.getHeight() > getHeight()) {
			y = getHeight() - ballLabel.getHeight();
			ySpeed = -ySpeed;
		}

        ballLabel.setLocation(x, y);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BouncingBallApp());
    }
}
