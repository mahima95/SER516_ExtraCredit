package client.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import client.controller.PlotGraph;
import utility.Constants;

/**
 * Class to display the expressions graphs
 * 
 * @SER516 SER516_ExtraCredit
 * @Version 1.0
 */
public class AffectiveDisplayGraph extends JPanel {
	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	private List<Double> meditationList = new ArrayList<Double>();
	private List<Double> engagementList = new ArrayList<Double>();
	private List<Double> excitementList = new ArrayList<Double>();
	private List<Double> frustrationList = new ArrayList<Double>();
	private List<Double> longTermExcitementList = new ArrayList<Double>();

	private List<Point> meditationGraphPoints;
	private List<Point> engagementGraphPoints;
	private List<Point> excitementGraphPoints;
	private List<Point> frustrationGraphPoints;
	private List<Point> longTermExcitementGraphPoints;

	private Stroke meditationStroke;
	private Stroke engagementStroke;
	private Stroke excitementStroke;
	private Stroke frustrationStroke;
	private Stroke longTermExcitementStroke;

	/**
	 * Splits the values from the received array based on their indices and stores
	 * them in separate arrays.
	 * 
	 * @param receivedvalues
	 *            contains values received from server after a certain time
	 *            interval.
	 */
	public void addValues(double[] receivedValues) {
		meditationList.add(receivedValues[0]);
		engagementList.add(receivedValues[1]);
		excitementList.add(receivedValues[2]);
		frustrationList.add(receivedValues[3]);
		longTermExcitementList.add(receivedValues[4]);
	}

	/**
	 * Uses Graphics to create and plot the graphs.
	 */
	@Override
	protected void paintComponent(Graphics graphics) {
		meditationGraphPoints = new ArrayList<Point>();
		engagementGraphPoints = new ArrayList<Point>();
		excitementGraphPoints = new ArrayList<Point>();
		frustrationGraphPoints = new ArrayList<Point>();
		longTermExcitementGraphPoints = new ArrayList<Point>();

		super.paintComponent(graphics);
		Graphics2D meditationGraph = (Graphics2D) graphics;
		meditationGraph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Graphics2D engagementGraph = (Graphics2D) graphics;
		engagementGraph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Graphics2D excitementGraph = (Graphics2D) graphics;
		excitementGraph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Graphics2D frustrationGraph = (Graphics2D) graphics;
		frustrationGraph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Graphics2D longTermExcitementGraph = (Graphics2D) graphics;
		longTermExcitementGraph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// creates x and y axes scales.
		double xScale = ((double) getWidth() - 2 * Constants.BORDER_GAP)
				/ (meditationList.size() + Constants.MAX_LIST_SIZE - 1);
		double yScale = (double) getHeight() - 1;

		// calls to functions to create coordinate values from the provided lists.
		PlotGraph.createPoints(meditationGraphPoints, meditationList, xScale, yScale);
		PlotGraph.createPoints(engagementGraphPoints, engagementList, xScale, yScale);
		PlotGraph.createPoints(excitementGraphPoints, excitementList, xScale, yScale);
		PlotGraph.createPoints(frustrationGraphPoints, frustrationList, xScale, yScale);
		PlotGraph.createPoints(longTermExcitementGraphPoints, longTermExcitementList, xScale, yScale);

		// creates x and y axes.
		engagementGraph.drawLine(Constants.BORDER_GAP, getHeight() - Constants.BORDER_GAP, Constants.BORDER_GAP,
				Constants.BORDER_GAP);
		engagementGraph.drawLine(Constants.BORDER_GAP, getHeight() - Constants.BORDER_GAP,
				getWidth() - Constants.BORDER_GAP, getHeight() - Constants.BORDER_GAP);

		// calls to functions to plots the lines.
		meditationStroke = PlotGraph.plotLines(meditationGraph, meditationStroke, meditationGraphPoints,
				Constants.meditationColor);
		engagementStroke = PlotGraph.plotLines(engagementGraph, engagementStroke, engagementGraphPoints,
				Constants.engagementColor);
		excitementStroke = PlotGraph.plotLines(excitementGraph, excitementStroke, excitementGraphPoints,
				Constants.excitementstColor);
		frustrationStroke = PlotGraph.plotLines(frustrationGraph, frustrationStroke, frustrationGraphPoints,
				Constants.frustationColor);
		longTermExcitementStroke = PlotGraph.plotLines(longTermExcitementGraph, longTermExcitementStroke,
				longTermExcitementGraphPoints, Constants.excitementltColor);

		// calls to functions to plots the points.
		PlotGraph.plotPoints(meditationGraph, meditationStroke, meditationGraphPoints, Constants.meditationColor);
		PlotGraph.plotPoints(engagementGraph, engagementStroke, engagementGraphPoints, Constants.engagementColor);
		PlotGraph.plotPoints(excitementGraph, excitementStroke, excitementGraphPoints, Constants.excitementstColor);
		PlotGraph.plotPoints(frustrationGraph, frustrationStroke, frustrationGraphPoints, Constants.frustationColor);
		PlotGraph.plotPoints(longTermExcitementGraph, longTermExcitementStroke, longTermExcitementGraphPoints,
				Constants.excitementltColor);

	}

	/**
	 * Gets the dimension of the outer panel.
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT - 10);
	}

}
