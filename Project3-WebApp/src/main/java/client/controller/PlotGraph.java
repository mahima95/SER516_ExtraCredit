package client.controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.util.List;

import utility.Constants;

public class PlotGraph {
	/**
     * Generates points to be plotted on the graph
     * @param p contains list of generated points
     * @param l contains list of values received from server
     * @param xScale contains the horizontal dimension of the graph
     * @param yScale contains the vertical dimension of the graph
     */   
	public static void createPoints(List<Point> p, List<Double> l, double xScale, double yScale){
	      for (int i = 0; i < l.size(); i++) {
	            int x1 = (int) (i * xScale + Constants.BORDER_GAP);
	            int y1 = (int) ((1- l.get(i)) * yScale  + Constants.BORDER_GAP);
	            p.add(new Point(x1, y1));
	         }
	    }
	/**
     * Generates and plots the lines on the graph
     * @param ga contains the graphic component
     * @param s contains the stroke component that is used to plot lines
     * @param p contains the list of points
     * @param gc contains the color values for the respective lines
     * @return contains the stroke component that has been generated
     */
    public static Stroke plotLines(Graphics2D ga, Stroke s, List<Point> p, Color gc){
      s = ga.getStroke();
      ga.setColor(gc);
        ga.setStroke(Constants.GRAPH_STROKE);
        for (int i = 1; i < p.size(); i++) {
           int x1 = p.get(i-1).x;
           int y1 = p.get(i-1).y;
           int x2 = p.get(i).x;
           int y2 = p.get(i).y;
           ga.drawLine(x1, y1, x2, y2);         
        }
        return s;
    }
    
    /**
     * Plots the points on the graph
     * @param ga contains the graphic component
     * @param s contains the generated stroke component 
     * @param p contains the list of points
     * @param gc contains the color values for the respective points
     */
    public static void plotPoints(Graphics2D ga, Stroke s, List<Point> p, Color gc){
        ga.setStroke(s);      
        ga.setColor(gc);
        for (int i = 0; i < p.size(); i++) {
           int x = p.get(i).x - Constants.GRAPH_POINT_WIDTH / 2;
           int y = p.get(i).y - Constants.GRAPH_POINT_WIDTH / 2;;
           int ovalW = Constants.GRAPH_POINT_WIDTH;
           int ovalH = Constants.GRAPH_POINT_WIDTH;
           ga.fillOval(x, y, ovalW, ovalH);
        }
    }
	}


