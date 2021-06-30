package app;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphPanel extends JPanel {
    public int size;
    String[][] points = new String[size][2];
    String[][] clusters = new String[size][2];

    public GraphPanel(int size,String[][] points,String[][] clusters){
        this.size = size;
        this.points = points;
        this.clusters = clusters;
        this.setSize(700, 700);
    }
    private void drawBackground(Graphics2D g){
        g.setColor(Color.white);
        g.fillRect(0, 0, 700, 700);
    }
    private void drawGraph(Graphics2D g){
        g.setColor(Color.black);
        g.fillRect(348, 0, 4, 700);
        g.fillRect(0, 348, 700, 4);
    }
    public void draw(Graphics2D g){
        drawBackground(g);
        drawGraph(g);
        drawPoints(g);
        drawClusters(g);
        repaint();
    }
    public void drawPoints(Graphics2D g){
        g.setColor(Color.green);
        for(int i = 0;i<size;i++){
            g.fillOval(Integer.parseInt(points[i][0]),Integer.parseInt(points[i][1]),12,12);
        }
    }
    public void drawClusters(Graphics2D g){
        g.setColor(Color.CYAN);
        for(int i = 0;i<size/10;i++){
            g.fillOval(Integer.parseInt(clusters[i][0]),Integer.parseInt(clusters[i][1]),18,18);
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        draw(g2d);
    }

}
