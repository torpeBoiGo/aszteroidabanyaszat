package Grafikus;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.HashSet;

public class Rectangle extends JPanel {

    HashMap<String, Point> aszteroidCordinates = new HashMap<>();
    HashMap<String, HashSet<String>> pairs = new HashMap<>();
    Point cCanvas;
    int r = 40;
    int aszterodiak;

    public Rectangle(int w, int h, int AszteroidakSzama) {
        aszterodiak = AszteroidakSzama;
        super.setSize(w, h);
        cCanvas = new Point(super.getWidth() / 2, super.getHeight() / 2);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.BLUE);

        //Draw Aszteroid
        for (String name : aszteroidCordinates.keySet()) {
            Point c = aszteroidCordinates.get(name);
            Ellipse2D.Float elipse = new Ellipse2D.Float(c.x - r, c.y - r, r * 2, r * 2);
            graphics2D.draw(elipse);
            graphics2D.drawString(name, c.x, c.y);
        }
        //Draw connection
        for (String a1 : pairs.keySet()) {
            for (String a2 : pairs.keySet()) {
                if (!a1.equals(a2)) {
                    if (aszteroidCordinates.containsKey(a1) && aszteroidCordinates.containsKey(a2)) {
                        if (pairs.get(a1).contains(a2))
                            graphics2D.drawLine(aszteroidCordinates.get(a1).x, aszteroidCordinates.get(a1).y, aszteroidCordinates.get(a2).x, aszteroidCordinates.get(a2).y);
                    }
                }
            }
        }

    }

    public void addAszteroida(String AszteroidaName) {
        int radius = (int) Math.round(Math.min(cCanvas.getX(), cCanvas.getY()) * 2);
        float x = (float) Math.cos(2 * Math.PI / aszterodiak * aszteroidCordinates.keySet().size());
        float y = (float) Math.sin(2 * Math.PI / aszterodiak * aszteroidCordinates.keySet().size());
        Point p = new Point(this.cCanvas.x + Math.round(x * radius), this.cCanvas.x + Math.round(y * radius));
        aszteroidCordinates.put(AszteroidaName, p);
    }

    public void addConnection(String a1, String a2) {
        if (pairs.get(a1) != null) {
            pairs.get(a1).add(a2);
        } else {
            HashSet<String> set = new HashSet<>();
            set.add(a2);
            pairs.put(a1, set);
        }
    }
}
