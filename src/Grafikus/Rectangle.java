package Grafikus;

import javax.swing.*;
import java.awt.*;

public class Rectangle extends JPanel {
    int x, y;
    public Rectangle(int x_in, int y_in){
        x= x_in;
        y=y_in;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.BLUE);
        graphics2D.fillRect(x,y,60,80);
    }
}
