package client.controller;

import client.view.AffectiveDisplayGraph;
import client.view.AffectiveView;
import model.FaceAffectiveData;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * Controller for the Affective View
 * 
 * @SER516 SER516_ExtraCredit
 * @version 1.0
 */
public class AffectiveController {

	private JPanel affectiveGraph;
	private AffectiveDisplayGraph affectiveGraphPlot;
	JPanel leftPanel;
	JPanel performancePanel;
	double graphValues[] = new double[6];
	public AffectiveView affectiveView;

	/**
	 * Initializes the Affective view panel
	 * 
	 */
	public AffectiveController() {
		leftPanel = new JPanel();
		affectiveGraph = new JPanel();
		performancePanel = new JPanel();

		affectiveView = new AffectiveView(leftPanel, affectiveGraph, performancePanel);
		affectiveGraphPlot = new AffectiveDisplayGraph();
		affectiveGraph.add(affectiveGraphPlot, BorderLayout.CENTER);

		affectiveGraphPlot.addValues(graphValues);
		affectiveGraph.repaint();

	}

	/**
	 * Updates Graph on the basis of received values
	 * 
	 * @param fed
	 *            Contains the latest affective values
	 */
	public void updateGraph(FaceAffectiveData faceAffectiveData) {

		graphValues = faceAffectiveData.fetchVectors();
		affectiveGraphPlot.addValues(graphValues);
		affectiveGraph.repaint();

	}

}
