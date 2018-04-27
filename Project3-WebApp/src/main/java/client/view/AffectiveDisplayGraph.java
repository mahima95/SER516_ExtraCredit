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

import client.constants.ClientConstants;
import client.controller.PlotGraph;
import utility.Constants;

/**
 * Class to display the expressions graphs
 * @SER516 Project3_Team03
 * @Version 1.0
 */
public class AffectiveDisplayGraph extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;
    
    private List<Double> list1 = new ArrayList<Double>();
    private List<Double> list2 = new ArrayList<Double>();
    private List<Double> list3 = new ArrayList<Double>();
    private List<Double> list4 = new ArrayList<Double>();
    private List<Double> list5 = new ArrayList<Double>();
    
    private List<Point> graphPoints1;
    private List<Point> graphPoints2;
    private List<Point> graphPoints3;
    private List<Point> graphPoints4;
    private List<Point> graphPoints5;
    
    private Stroke oldStroke1;
    private Stroke oldStroke2;
    private Stroke oldStroke3;
    private Stroke oldStroke4;
    private Stroke oldStroke5;

    /**
     * Splits the values from the received array based on their indices and stores them in separate arrays.
     * @param rvalues contains values received from server after a certain time interval.
     */
    public void addValues(double[] rvalues){
        list1.add(rvalues[0]);
        list2.add(rvalues[1]);
        list3.add(rvalues[2]);
        list4.add(rvalues[3]);
        list5.add(rvalues[4]);
    }
    
    /**
     * Uses Graphics to create and plot the graphs.
     */
    @Override
    protected void paintComponent(Graphics g) {
       graphPoints1 = new ArrayList<Point>();
       graphPoints2 = new ArrayList<Point>();
       graphPoints3 = new ArrayList<Point>();
       graphPoints4 = new ArrayList<Point>();
       graphPoints5 = new ArrayList<Point>();
       
       super.paintComponent(g);
       Graphics2D g1 = (Graphics2D)g;
       g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       Graphics2D g2 = (Graphics2D)g;
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       Graphics2D g3 = (Graphics2D)g;
       g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       Graphics2D g4 = (Graphics2D)g;
       g4.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       Graphics2D g5 = (Graphics2D)g;
       g5.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

       //creates x and y axes scales.       
       double xScale = ((double) getWidth() - 2 * Constants.BORDER_GAP) / (list1.size() + Constants.MAX_LIST_SIZE - 1);
       double yScale = (double) getHeight() - 1;
       
       //calls to functions to create coordinate values from the provided lists.
       PlotGraph.createPoints(graphPoints1, list1, xScale, yScale);
       PlotGraph.createPoints(graphPoints2, list2, xScale, yScale);
       PlotGraph.createPoints(graphPoints3, list3, xScale, yScale);
       PlotGraph.createPoints(graphPoints4, list4, xScale, yScale);
       PlotGraph.createPoints(graphPoints5, list5, xScale, yScale);
       
       //creates x and y axes.
       g2.drawLine(Constants.BORDER_GAP, getHeight() - Constants.BORDER_GAP, Constants.BORDER_GAP, Constants.BORDER_GAP);
       g2.drawLine(Constants.BORDER_GAP, getHeight() - Constants.BORDER_GAP, getWidth() - Constants.BORDER_GAP, getHeight() - Constants.BORDER_GAP);

       //calls to functions to plots the lines.
       oldStroke1 = PlotGraph.plotLines(g1, oldStroke1, graphPoints1, ClientConstants.meditationColor);
       oldStroke2 = PlotGraph.plotLines(g2, oldStroke2, graphPoints2, ClientConstants.engagementColor);
       oldStroke3 = PlotGraph.plotLines(g3, oldStroke3,graphPoints3, ClientConstants.excitementstColor);
       oldStroke4 = PlotGraph.plotLines(g4, oldStroke4,graphPoints4, ClientConstants.frustationColor);
       oldStroke5 = PlotGraph.plotLines(g5, oldStroke5,graphPoints5, ClientConstants.excitementltColor);

       
       //calls to functions to plots the points.
       PlotGraph.plotPoints(g1, oldStroke1, graphPoints1, ClientConstants.meditationColor);
       PlotGraph.plotPoints(g2, oldStroke2, graphPoints2, ClientConstants.engagementColor);
       PlotGraph.plotPoints(g3, oldStroke3, graphPoints3, ClientConstants.excitementstColor);
       PlotGraph.plotPoints(g4, oldStroke4, graphPoints4, ClientConstants.frustationColor);
       PlotGraph.plotPoints(g5, oldStroke5, graphPoints5, ClientConstants.excitementltColor);

       
    }

    /**
     * Gets the dimension of the outer panel.
     */
    @Override
    public Dimension getPreferredSize() {
       return new Dimension(WIDTH, HEIGHT - 10);
    }
    
   
}
