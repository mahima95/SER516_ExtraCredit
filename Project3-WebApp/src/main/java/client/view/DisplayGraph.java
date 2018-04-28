package client.view;

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

import utility.Constants;

/**
 * Class to display the expressions graphs
 * 
 * @SER516 SER516_ExtraCredit
 * @Version 1.0
 */
public class DisplayGraph extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 255;
	private static final int HEIGHT = 20;

	private List<Double> receivedValues = new ArrayList<Double>();
	private List<Point> graphPointsList;
	private Stroke oldGraphStroke;

	/**
	 * Adds the received values to an arraylist.
	 * 
	 * @param rvalues
	 *            contains values received from server after a certain time
	 *            interval.
	 */
	public void addValues(double rvalues) {
		receivedValues.add(rvalues);
	}

	/**
	 * Uses Graphics to create and plot the graphs.
	 */
	@Override
	protected void paintComponent(Graphics graphics) {
		graphPointsList = new ArrayList<Point>();
		super.paintComponent(graphics);
		Graphics2D newGraphics = (Graphics2D) graphics;
		newGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// creates x and y axes scales.
		double xScale = ((double) getWidth() - 2 * Constants.BORDER_GAP)
				/ (receivedValues.size() + Constants.MAX_LIST_SIZE - 1);
		double yScale = (double) getHeight() - 2;

		// calls to functions to create coordinate values from the provided lists.
		PlotGraph.createPoints(graphPointsList, receivedValues, xScale, yScale);

		// creates x and y axes.
		newGraphics.drawLine(Constants.BORDER_GAP, getHeight() - Constants.BORDER_GAP, Constants.BORDER_GAP,
				Constants.BORDER_GAP);
		newGraphics.drawLine(Constants.BORDER_GAP, getHeight() - Constants.BORDER_GAP,
				getWidth() - Constants.BORDER_GAP, getHeight() - Constants.BORDER_GAP);

		// calls to functions to plots the lines.
		oldGraphStroke = PlotGraph.plotLines(newGraphics, oldGraphStroke, graphPointsList, Color.BLUE);

		// calls to functions to plots the points.
		PlotGraph.plotPoints(newGraphics, oldGraphStroke, graphPointsList, Color.BLUE);

	}

	/**
	 * Gets the dimension of the outer panel.
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT - 10);
	}

}
