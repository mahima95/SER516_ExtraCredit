package client.controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.util.List;

import utility.Constants;

/**
 * Helper Class that provides common methods for expressive and affective graph
 * plotting
 * 
 */
public class PlotGraph {
	/**
	 * Generates points to be plotted on the graph
	 * 
	 * @param pointList
	 *            contains list of generated points
	 * @param doubleList
	 *            contains list of values received from server
	 * @param xScale
	 *            contains the horizontal dimension of the graph
	 * @param yScale
	 *            contains the vertical dimension of the graph
	 */
	public static void createPoints(List<Point> pointList, List<Double> doubleList, double xScale, double yScale) {
		for (int i = 0; i < doubleList.size(); i++) {
			int xCoordinate = (int) (i * xScale + Constants.BORDER_GAP);
			int yCoordinate = (int) ((1 - doubleList.get(i)) * yScale + Constants.BORDER_GAP);
			pointList.add(new Point(xCoordinate, yCoordinate));
		}
	}

	/**
	 * Generates and plots the lines on the graph
	 * 
	 * @param graphics
	 *            contains the graphic component
	 * @param stroke
	 *            contains the stroke component that is used to plot lines
	 * @param pointList
	 *            contains the list of points
	 * @param graphicsColor
	 *            contains the color values for the respective lines
	 * @return contains the stroke component that has been generated
	 */
	public static Stroke plotLines(Graphics2D graphics, Stroke stroke, List<Point> pointList, Color graphicsColor) {
		stroke = graphics.getStroke();
		graphics.setColor(graphicsColor);
		graphics.setStroke(Constants.GRAPH_STROKE);
		for (int i = 1; i < pointList.size(); i++) {
			int xCoordinate1 = pointList.get(i - 1).x;
			int yCoordinate1 = pointList.get(i - 1).y;
			int xCoordinate2 = pointList.get(i).x;
			int yCoordinate2 = pointList.get(i).y;
			graphics.drawLine(xCoordinate1, yCoordinate1, xCoordinate2, yCoordinate2);
		}
		return stroke;
	}

	/**
	 * Plots the points on the graph
	 * 
	 * @param graphics
	 *            contains the graphic component
	 * @param stroke
	 *            contains the generated stroke component
	 * @param pointList
	 *            contains the list of points
	 * @param graphicsColor
	 *            contains the color values for the respective points
	 */
	public static void plotPoints(Graphics2D graphics, Stroke stroke, List<Point> pointList, Color graphicsColor) {
		graphics.setStroke(stroke);
		graphics.setColor(graphicsColor);
		for (int i = 0; i < pointList.size(); i++) {
			int xCoordinate = pointList.get(i).x - Constants.GRAPH_POINT_WIDTH / 2;
			int yCoordinate = pointList.get(i).y - Constants.GRAPH_POINT_WIDTH / 2;
			;
			int ovalWidth = Constants.GRAPH_POINT_WIDTH;
			int ovalHeight = Constants.GRAPH_POINT_WIDTH;
			graphics.fillOval(xCoordinate, yCoordinate, ovalWidth, ovalHeight);
		}
	}
}
