package Grafikus;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static Grafikus.MainGUI.NamesMap;
import static Grafikus.MainGUI.getKeyByValue;

public class Grafika extends JPanel {

    HashMap<String, Point> aszteroidCordinates = new HashMap<>();
    HashMap<String, Aszteroida> asteroids = new HashMap<>();
    HashMap<String, HashSet<String>> pairs = new HashMap<>();
    Point cCanvas;
    int r = 30;
    int aszterodiak;

    public Grafika(int w, int h, int AszteroidakSzama) {
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
            graphics2D.drawString(asteroids.get(name).getRetegek().toString(), c.x - r / 3, c.y);
            if(asteroids.get(name).getMag() != null){
                String caption = asteroids.get(name).getMag().getClass().getSimpleName();

                if("Uran".equals(asteroids.get(name).getMag().getClass().getSimpleName()))
                    caption += " - " + ((Uran)asteroids.get(name).getMag()).expozicio;

                graphics2D.drawString(caption, c.x - r/1.5f, c.y+r/3.0f);
            }
            else graphics2D.drawString("null", c.x - r/1.5f, c.y+r/3.0f);
            if (asteroids.get(name).napkozelben) {
                elipse = new Ellipse2D.Float(c.x - r, c.y - r, r * 2.1f, r * 2.1f);
                graphics2D.setColor(new Color(255, 201, 0));
                graphics2D.setStroke(new BasicStroke(5));
                graphics2D.draw(elipse);
            }

            ArrayList<Hajo> hajok = new ArrayList<>(asteroids.get(name).hajok);
            ArrayList<String> tp = new ArrayList<>();
            for (Mezo a2 : asteroids.get(name).getSzomszedok()) {
                if("Aszteroida".equals(a2.getClass().getSimpleName()))
                    addConnection(name, getKeyByValue(NamesMap, a2));
                else{
                    tp.add(getKeyByValue(NamesMap, a2));
                }
            }


            for (int i = 0; i < hajok.size() + tp.size(); i++) {
                float x = (float) Math.cos(2 * Math.PI / (hajok.size() + tp.size()) * (i) ) * 50;
                float y = (float) Math.sin(2 * Math.PI / (hajok.size() + tp.size()) * (i) ) * 50;
                float r = 10f;
                if(i<hajok.size()){
                    if("Telepes".equals(hajok.get(i).getClass().getSimpleName())){
                        graphics2D.setColor(new Color(0, 180, 3));
                    }else if("Robot".equals(hajok.get(i).getClass().getSimpleName())){
                        graphics2D.setColor(new Color(180, 150, 0));
                    } else if ("Ufo".equals(hajok.get(i).getClass().getSimpleName())) {
                        graphics2D.setColor(new Color(0, 180, 140));
                    }
                    Ellipse2D.Float elipse2 = new Ellipse2D.Float(Math.round(c.x + x - r), Math.round(c.y + y - r), 20, 20);
                    graphics2D.fill(elipse2);
                    graphics2D.draw(elipse2);

                    graphics2D.setColor(Color.BLACK);
                    //System.out.println(hajok.get(i).toString());
                    drawCenteredString(g, getKeyByValue(NamesMap, hajok.get(i)), elipse2.getBounds(),getFont());


                }else{
                    Rectangle.Float elipse2 = new Rectangle.Float(Math.round(c.x + x - r), Math.round(c.y + y - r), 12, 20);
                    graphics2D.setColor(new Color(0, 221, 255));
                    graphics2D.fill(elipse2);
                    graphics2D.draw(elipse2);
                    graphics2D.setColor(Color.BLACK);
                    drawCenteredString(g, tp.get(i-hajok.size()), elipse2.getBounds(),getFont());
                }


            }

        }

    }

    public void Update(List<Aszteroida> aszt){
        asteroids.clear();
        aszteroidCordinates.clear();
        for (Aszteroida a1 : aszt) {
            addAszteroida(getKeyByValue(NamesMap, a1),a1);
        }
        repaint();
    }

    public void addAszteroida(String AszteroidaName, Aszteroida a) {
        int radius = (int) Math.round(Math.min(cCanvas.getX(), cCanvas.getY()) * 2);
        float x = (float) Math.cos(2 * Math.PI / aszterodiak * aszteroidCordinates.keySet().size());
        float y = (float) Math.sin(2 * Math.PI / aszterodiak * aszteroidCordinates.keySet().size());
        Point p = new Point(this.cCanvas.x + Math.round(x * radius), this.cCanvas.x + Math.round(y * radius));
        asteroids.put(AszteroidaName, a);
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

    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Draw the String
        g.drawString(text, x, y);
    }
}
