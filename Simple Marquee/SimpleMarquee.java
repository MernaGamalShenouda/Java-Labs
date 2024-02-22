import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;

public class SimpleMarquee extends JFrame {

    private JLabel marqueeLabel;

    public SimpleMarquee() {
        marqueeLabel = new JLabel("Java World");
        marqueeLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        add(marqueeLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 100);
        centerOnScreen();
        setTitle("Simple Marquee Application");

        // Start the marquee thread
        MarqueeThread marqueeThread = new MarqueeThread();
        marqueeThread.start();
    }

    private void centerOnScreen() {
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
        setLocation(x, y);
    }

    private class MarqueeThread extends Thread {
        @Override
        public void run() {
            int screenWidth = getWidth();
            int labelWidth = marqueeLabel.getWidth();

            while (true) {
                // Get the current location
                int currentX = marqueeLabel.getLocation().x;

                // Calculate the new location
                int newX = (currentX + 1 + screenWidth) % (screenWidth + labelWidth);

                // Update the label's location on the EDT
                javax.swing.SwingUtilities.invokeLater(() -> {
                    marqueeLabel.setLocation(newX, 0);
                });

                try {
                    Thread.sleep(10); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            SimpleMarquee marqueeApp = new SimpleMarquee();
            marqueeApp.setVisible(true);
        });
    }
}
