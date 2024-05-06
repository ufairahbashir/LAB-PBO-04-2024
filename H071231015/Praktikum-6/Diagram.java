import javax.swing.*;
import java.awt.*;

class Diagram {
    static void TampilkanMenu() {
        JFrame jf = new JFrame("Diagram");

        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel() {
            private Image backgroundImage;

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage == null) {
                    ImageIcon imageIcon = new ImageIcon("Diagram.jpg");
                    backgroundImage = imageIcon.getImage();
                }
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        jf.setContentPane(panel);
        jf.setLayout(null);
        jf.setVisible(true);
    }
}