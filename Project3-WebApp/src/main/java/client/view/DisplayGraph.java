package client.view;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import client.controller.PlotGraph;
import utility.Constants;

/**
 * Class to display the expressions graphs
 * 
 * @SER516 Project3_Team03
 * @Version 1.0
 */
public class DisplayGraph extends JPanel  {
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 255;
    private static final int HEIGHT = 20;
    
    private List<Double> list1 = new ArrayList<Double>();
    private List<Point> graphPoints1;
    private Stroke oldStroke1;

    /**
     * Adds the received values to an arraylist.
     * @param rvalues contains values received from server after a certain time interval.
     */
    public void addValues(double rvalues){
        list1.add(rvalues);
    }
    
    /**
     * Uses Graphics to create and plot the graphs.
     */
    @Override
    protected void paintComponent(Graphics g) {
       graphPoints1 = new ArrayList<Point>();
       super.paintComponent(g);
       Graphics2D g2 = (Graphics2D)g;
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

       //creates x and y axes scales.
       double xScale = ((double) getWidth() - 2 * Constants.BORDER_GAP) / (list1.size() + Constants.MAX_LIST_SIZE - 1);
       double yScale = (double) getHeight() - 2;
       
       //calls to functions to create coordinate values from the provided lists.
       PlotGraph.createPoints(graphPoints1, list1, xScale, yScale);
       
       //creates x and y axes.
       g2.drawLine(Constants.BORDER_GAP, getHeight() - Constants.BORDER_GAP, Constants.BORDER_GAP, Constants.BORDER_GAP);
       g2.drawLine(Constants.BORDER_GAP, getHeight() - Constants.BORDER_GAP, getWidth() - Constants.BORDER_GAP, getHeight() - Constants.BORDER_GAP);

       //calls to functions to plots the lines.
       oldStroke1 = PlotGraph.plotLines(g2, oldStroke1, graphPoints1, Color.BLUE);

       //calls to functions to plots the points.
       PlotGraph.plotPoints(g2, oldStroke1, graphPoints1, Color.BLUE);
       
    }

    /**
     * Gets the dimension of the outer panel.
     */
    @Override
    public Dimension getPreferredSize() {
       return new Dimension(WIDTH, HEIGHT - 10);
    }
    
    
    
    
    
}
