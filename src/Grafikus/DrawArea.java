package Grafikus;

import javax.swing.*;
import java.awt.*;

public class DrawArea extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.BLUE);
        graphics2D.fillRect(100,50,60,80);
    }
}
