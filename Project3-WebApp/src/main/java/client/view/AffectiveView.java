package client.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import client.controller.ChangeColorController;
import utility.Constants;

/**
 * View for the Affective View of the client
 * 
 * @SER516 SER516_ExtraCredit
 * @Version 1.0
 */
public class AffectiveView extends JPanel {

	private static final long serialVersionUID = 1L;
	private ColorSelectorButton meditationButton;
	private ColorSelectorButton engagementButton;
	private ColorSelectorButton excitementstButton;
	private ColorSelectorButton frustationButton;
	private ColorSelectorButton excitementltButton;
	
	/**
	 * Initializes the Affective panel with the left, affective Graph and color panel
	 * @param leftPanel
	 * @param affectiveGraph
	 * @param colPanel
	 */

	public AffectiveView(JPanel leftPanel, JPanel affectiveGraph, JPanel colPanel) {

		this.setLayout(null);
		leftPanel.setBounds(0, 28, 326, 313);
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		leftPanel.setLayout(null);
		this.add(leftPanel);

		affectiveGraph.setBounds(0, 0, 320, 300);
		affectiveGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		affectiveGraph.setBackground(Constants.GRAPHPANEL);
		leftPanel.add(affectiveGraph);

		colPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		colPanel.setBounds(350, 30, 343, 311);

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.ipadx = 50;
		gridBagConstraints.ipady = 50;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new Insets(10, 10, 10, 10);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;

		meditationButton = new ColorSelectorButton(Constants.meditationColor, Constants.MEDITATION);
		new ChangeColorController(meditationButton);
		colPanel.add(meditationButton, gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;

		engagementButton = new ColorSelectorButton(Constants.engagementColor, Constants.ENGAGEMENT);
		new ChangeColorController(engagementButton);
		colPanel.add(engagementButton, gridBagConstraints);

		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;

		excitementstButton = new ColorSelectorButton(Constants.excitementstColor, Constants.EXCITEMENTST);
		new ChangeColorController(excitementstButton);
		colPanel.add(excitementstButton, gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;

		frustationButton = new ColorSelectorButton(Constants.frustationColor, Constants.FRUSTATION);
		new ChangeColorController(frustationButton);
		colPanel.add(frustationButton, gridBagConstraints);

		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;

		excitementltButton = new ColorSelectorButton(Constants.excitementltColor, Constants.EXCITEMENTLT);
		new ChangeColorController(excitementltButton);
		colPanel.add(excitementltButton, gridBagConstraints);

		this.add(colPanel);

		Constants.perfLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		Constants.perfLabel.setBounds(0, 0, 350, 32);
		this.add(Constants.perfLabel);

		Constants.colLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		Constants.colLabel.setBounds(350, 0, 343, 32);
		this.add(Constants.colLabel);

	}

}
