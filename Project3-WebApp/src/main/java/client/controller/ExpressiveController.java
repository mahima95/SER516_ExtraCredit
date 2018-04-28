package client.controller;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import client.view.DisplayGraph;
import client.view.ExpressiveView;
import client.view.FacePaint;
import model.FaceData;
import model.FaceExpressionData;
import utility.Constants;

/**
 * Initializes the expressive view panel Responsible for change of expression on
 * face and corresponding graphs on change of data Implements the Builder
 * pattern to initialize the Expressive View
 * 
 * @SER516 SER516_ExtraCredit
 * @version 1.0
 */
public class ExpressiveController {
	private JPanel blinkGraph;
	private JPanel rgtWinkGraph;
	private JPanel lftWinkGraph;
	private JPanel looklftGraph;
	private JPanel lookrgtGraph;
	private JPanel furrowGraph;
	private JPanel raiseGraph;
	private JPanel smileGraph;
	private JPanel lftSmirkGraph;
	private JPanel rgtSmirkGraph;
	private JPanel clenchGraph;
	private JPanel laughGraph;
	private FacePaint facePaint;
	private DisplayGraph blinkDisplayGraph;
	private DisplayGraph rightWinkDisplayGraph;
	private DisplayGraph leftWinkDisplayGraph;
	private DisplayGraph lookRightDisplayGraph;
	private DisplayGraph lookLeftDisplayGraph;
	private DisplayGraph furrowDisplayGraph;
	private DisplayGraph raiseDisplayGraph;
	private DisplayGraph smileDisplayGraph;
	private DisplayGraph clenchDisplayGraph;
	private DisplayGraph leftSmirkDisplayGraph;
	private DisplayGraph rightSmirkDisplayGraph;
	private DisplayGraph laughDisplayGraph;
	JPanel facePanel;
	JPanel graphPanel;
	double graphValues[] = new double[13];
	JLabel timeValue;

	public ExpressiveView expressiveView;

	/**
	 * Initializes the panels, labels and the graphs with the initial values
	 */
	public ExpressiveController() {
		initializePanels();

		expressiveView = new ExpressiveView.ExpressionViewBuilder(facePanel, graphPanel, blinkGraph, rgtWinkGraph,
				lftWinkGraph, looklftGraph, lookrgtGraph, furrowGraph, raiseGraph, smileGraph, clenchGraph,
				lftSmirkGraph, rgtSmirkGraph, laughGraph).createExpressiveView();

		Constants.faceLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		Constants.faceLabel.setBounds(0, 3, 336, 26);
		expressiveView.add(Constants.faceLabel);

		Constants.timeLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		Constants.timeLabel.setBounds(0, 310, 100, 20);
		expressiveView.add(Constants.timeLabel);

		timeValue = new JLabel("0.0");
		timeValue.setFont(new Font("Tahoma", Font.BOLD, 12));
		timeValue.setBounds(120, 310, 30, 20);
		expressiveView.add(timeValue);

		Constants.graphLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		Constants.graphLabel.setBounds(336, 0, 357, 29);
		expressiveView.add(Constants.graphLabel);
		facePaint = new FacePaint();
		initializeGraphs();

		addValuesToGraphs(this.graphValues);

		panelRepaint();

	}

	/**
	 * Method to initialize panels which will hold expressive value graphs
	 */
	private void initializePanels() {
		this.facePanel = new JPanel();
		this.graphPanel = new JPanel();
		this.blinkGraph = new JPanel();
		this.rgtWinkGraph = new JPanel();
		this.lftWinkGraph = new JPanel();
		this.looklftGraph = new JPanel();
		this.lookrgtGraph = new JPanel();
		this.furrowGraph = new JPanel();
		this.raiseGraph = new JPanel();
		this.smileGraph = new JPanel();
		this.clenchGraph = new JPanel();
		this.lftSmirkGraph = new JPanel();
		this.smileGraph = new JPanel();
		this.rgtSmirkGraph = new JPanel();
		this.laughGraph = new JPanel();

	}

	/**
	 * Method to initialize the expressive value graphs
	 */

	private void initializeGraphs() {

		this.blinkDisplayGraph = new DisplayGraph();
		this.rightWinkDisplayGraph = new DisplayGraph();
		this.leftWinkDisplayGraph = new DisplayGraph();
		this.lookRightDisplayGraph = new DisplayGraph();
		this.lookLeftDisplayGraph = new DisplayGraph();
		this.furrowDisplayGraph = new DisplayGraph();
		this.raiseDisplayGraph = new DisplayGraph();
		this.smileDisplayGraph = new DisplayGraph();
		this.clenchDisplayGraph = new DisplayGraph();
		this.leftSmirkDisplayGraph = new DisplayGraph();
		this.rightSmirkDisplayGraph = new DisplayGraph();
		this.laughDisplayGraph = new DisplayGraph();

		this.facePanel.add(facePaint, BorderLayout.CENTER);
		this.blinkGraph.add(blinkDisplayGraph, BorderLayout.CENTER);
		this.rgtWinkGraph.add(rightWinkDisplayGraph, BorderLayout.CENTER);
		this.lftWinkGraph.add(leftWinkDisplayGraph, BorderLayout.CENTER);
		this.lookrgtGraph.add(lookRightDisplayGraph, BorderLayout.CENTER);
		this.looklftGraph.add(lookLeftDisplayGraph, BorderLayout.CENTER);
		this.furrowGraph.add(furrowDisplayGraph, BorderLayout.CENTER);
		this.raiseGraph.add(raiseDisplayGraph, BorderLayout.CENTER);
		this.smileGraph.add(smileDisplayGraph, BorderLayout.CENTER);
		this.clenchGraph.add(clenchDisplayGraph, BorderLayout.CENTER);
		this.lftSmirkGraph.add(leftSmirkDisplayGraph, BorderLayout.CENTER);
		this.rgtSmirkGraph.add(rightSmirkDisplayGraph, BorderLayout.CENTER);
		this.laughGraph.add(laughDisplayGraph, BorderLayout.CENTER);

	}

	/**
	 * Method to add the changed values to corresponding graphs
	 * 
	 * @param graphValues
	 *            are the changed values for expressive data
	 */

	private void addValuesToGraphs(double[] graphValues) {
		this.blinkDisplayGraph.addValues(graphValues[8]);
		this.rightWinkDisplayGraph.addValues(graphValues[10]);
		this.leftWinkDisplayGraph.addValues(graphValues[9]);
		this.lookRightDisplayGraph.addValues(graphValues[12]);
		this.lookLeftDisplayGraph.addValues(graphValues[11]);
		this.furrowDisplayGraph.addValues(graphValues[2]);
		this.raiseDisplayGraph.addValues(graphValues[1]);
		this.smileDisplayGraph.addValues(graphValues[3]);
		this.clenchDisplayGraph.addValues(graphValues[4]);
		this.leftSmirkDisplayGraph.addValues(graphValues[5]);
		this.rightSmirkDisplayGraph.addValues(graphValues[6]);
		this.laughDisplayGraph.addValues(graphValues[7]);

	}

	/**
	 * Updates the Face and the Graph on the basis of received values
	 * 
	 * @param fed
	 *            Contains the latest expression values
	 */
	public void updateGraph(FaceExpressionData fed) {
		graphValues = fed.fetchVectors();
		facePaint.changeVector(graphValues);
		addValuesToGraphs(graphValues);
		panelRepaint();
	}

	/**
	 * Updates the time value based on the received data.
	 * 
	 * @param data
	 *            Contains all the data values.
	 */
	public void updateTime(FaceData data) {
		timeValue.setText(data.getTimeElapsed().toString());
	}

	/**
	 * Method to repaint all the panels on of graph update
	 */

	private void panelRepaint() {
		facePanel.repaint();
		blinkGraph.repaint();
		rgtWinkGraph.repaint();
		lftWinkGraph.repaint();
		lookrgtGraph.repaint();
		looklftGraph.repaint();
		furrowGraph.repaint();
		raiseGraph.repaint();
		smileGraph.repaint();
		clenchGraph.repaint();
		lftSmirkGraph.repaint();
		rgtSmirkGraph.repaint();
		laughGraph.repaint();
	}

}
