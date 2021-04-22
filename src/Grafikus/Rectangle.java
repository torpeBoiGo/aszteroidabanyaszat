package Grafikus;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.HashSet;

public class Rectangle extends JPanel {

    HashMap<String, Point> aszteroidCordinates = new HashMap<>();
    HashMap<String, Integer> aszteroidHejak = new HashMap<>();
    HashMap<String, String> aszteroidMag = new HashMap<>();
    HashMap<String, Boolean> aszteroidNapkozelben = new HashMap<>();
    HashMap<String, HashSet<String>> pairs = new HashMap<>();
    Point cCanvas;
    int r = 30;
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
        //Draw Aszteroid
        for (String name : aszteroidCordinates.keySet()) {
            Point c = aszteroidCordinates.get(name);

            Ellipse2D.Float elipse = new Ellipse2D.Float(c.x - r, c.y - r, r * 2, r * 2);
            graphics2D.setColor(new Color(210, 180, 140));
            graphics2D.fill(elipse);
            graphics2D.setColor(Color.BLACK);

            graphics2D.drawString(name, c.x - r / 3, c.y - r / 3);
            graphics2D.drawString(aszteroidHejak.get(name).toString(), c.x - r / 3, c.y);
            graphics2D.drawString(aszteroidMag.get(name), c.x - r/1.5f, c.y+r/3.0f);
            if (aszteroidNapkozelben.get(name)) {
                elipse = new Ellipse2D.Float(c.x - r, c.y - r, r * 2.1f, r * 2.1f);
                graphics2D.setColor(new Color(255, 201, 0));
                graphics2D.setStroke(new BasicStroke(5));
                graphics2D.draw(elipse);
            }

        }

    }

    public void addAszteroida(String AszteroidaName, Aszteroida a) {
        int radius = (int) Math.round(Math.min(cCanvas.getX(), cCanvas.getY()) * 2);
        float x = (float) Math.cos(2 * Math.PI / aszterodiak * aszteroidCordinates.keySet().size());
        float y = (float) Math.sin(2 * Math.PI / aszterodiak * aszteroidCordinates.keySet().size());
        Point p = new Point(this.cCanvas.x + Math.round(x * radius), this.cCanvas.x + Math.round(y * radius));
        aszteroidCordinates.put(AszteroidaName, p);
        aszteroidHejak.put(AszteroidaName, a.getRetegek());
        aszteroidNapkozelben.put(AszteroidaName, a.NapkozelbenE());
        aszteroidMag.put(AszteroidaName, a.getMag() == null ? "null" : a.getMag().print());
    }

    public void removeAszteroida(String AszteroidaName) {
        if (aszteroidCordinates.containsKey(AszteroidaName)) {
            aszteroidCordinates.remove(AszteroidaName);
            aszteroidHejak.remove(AszteroidaName);
            aszteroidNapkozelben.remove(AszteroidaName);
            aszteroidMag.remove(AszteroidaName);
        }
    }

    public void setAszteroidaNapkozelben(String AszteroidName, boolean mire) {
        if (aszteroidNapkozelben.containsKey(AszteroidName)) {
            aszteroidNapkozelben.replace(AszteroidName, mire);
        }
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
