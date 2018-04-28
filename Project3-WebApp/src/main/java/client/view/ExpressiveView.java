package client.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import utility.Constants;

/**
 * View for the Expression Section of the client
 * 
 * @SER516 SER516_ExtraCredit
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ExpressiveView extends JPanel {
	private JLabel blinkLabel;
	private JLabel rgtWinkLabel;
	private JLabel lftWinkLabel;
	private JLabel looklftLabel;
	private JLabel lookrgtLabel;
	private JLabel furrowLabel;
	private JLabel raiseLabel;
	private JLabel smileLabel;
	private JLabel clenchLabel;
	private JLabel lftSmirkLabel;
	private JLabel rgtSmirkLabel;
	private JLabel laughLabel;
	private JPanel blinkGraphPanel;
	private JPanel rgtWinkGraphPanel;
	private JPanel lftWinkGraphPanel;
	private JPanel rgtSmrGraphPanel;
	private JPanel lftSmrGraphPanel;
	private JPanel clenchGraphPanel;
	private JPanel laughGraphPanel;
	private JPanel smileGraphPanel;
	private JPanel raiseGraphPanel;
	private JPanel furrowGraphPanel;
	private JPanel lookGraphPanel;

	/**
	 * Parametrized Constructor and positions the panels and the graphs in the
	 * expressive view panel in clientUI
	 * 
	 * @param facePanel
	 * @param graphPanel
	 * @param blinkGraph
	 * @param rgtWinkGraph
	 * @param lftWinkGraph
	 * @param looklftGraph
	 * @param lookrgtGraph
	 * @param furrowGraph
	 * @param raiseGraph
	 * @param smileGraph
	 * @param clenchGraph
	 * @param lftSmirkGraph
	 * @param rgtSmirkGraph
	 * @param laughGraph
	 */
	private ExpressiveView(JPanel facePanel, JPanel graphPanel, JPanel blinkGraph, JPanel rgtWinkGraph,
			JPanel lftWinkGraph, JPanel looklftGraph, JPanel lookrgtGraph, JPanel furrowGraph, JPanel raiseGraph,
			JPanel smileGraph, JPanel clenchGraph, JPanel lftSmirkGraph, JPanel rgtSmirkGraph, JPanel laughGraph) {

		this.setLayout(null);
		facePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		facePanel.setBounds(0, 28, 326, 280);
		this.add(facePanel);

		graphPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		graphPanel.setBounds(325, 28, 368, 313);
		graphPanel.setLayout(null);
		this.add(graphPanel);

		blinkGraph.setBounds(90, 10, 260, 20);
		blinkGraph.setBackground(Constants.GRAPHPANEL);
		blinkGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(blinkGraph);

		blinkLabel = new JLabel("Blink\r\n");
		blinkLabel.setForeground(Constants.GRAPHLABEL_FOREGROUND);
		blinkLabel.setOpaque(true);
		blinkLabel.setBackground(Constants.GRAPHLABEL_BACKGROUND);
		blinkLabel.setHorizontalAlignment(SwingConstants.LEFT);
		blinkLabel.setBounds(10, 10, 75, 20);
		graphPanel.add(blinkLabel);

		rgtWinkGraph.setBounds(90, 35, 260, 20);
		rgtWinkGraph.setBackground(Constants.GRAPHPANEL);
		rgtWinkGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(rgtWinkGraph);

		rgtWinkLabel = new JLabel("Right Wink");
		rgtWinkLabel.setBackground(Constants.GRAPHLABEL_BACKGROUND);
		rgtWinkLabel.setForeground(Constants.GRAPHLABEL_FOREGROUND);
		rgtWinkLabel.setOpaque(true);
		rgtWinkLabel.setHorizontalAlignment(SwingConstants.LEFT);
		rgtWinkLabel.setBounds(10, 35, 75, 20);
		graphPanel.add(rgtWinkLabel);

		lftWinkGraph.setBounds(90, 60, 260, 20);
		lftWinkGraph.setBackground(Constants.GRAPHPANEL);
		lftWinkGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(lftWinkGraph);

		lftWinkLabel = new JLabel("Left Wink");
		lftWinkLabel.setOpaque(true);
		lftWinkLabel.setForeground(Constants.GRAPHLABEL_FOREGROUND);
		lftWinkLabel.setBackground(Constants.GRAPHLABEL_BACKGROUND);
		lftWinkLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lftWinkLabel.setBounds(10, 60, 75, 20);
		graphPanel.add(lftWinkLabel);

		looklftGraph.setBounds(90, 85, 260, 20);
		looklftGraph.setBackground(Constants.GRAPHPANEL);
		looklftGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(looklftGraph);

		looklftLabel = new JLabel("Look left");
		looklftLabel.setOpaque(true);
		looklftLabel.setForeground(Constants.GRAPHLABEL_FOREGROUND);
		looklftLabel.setBackground(Constants.GRAPHLABEL_BACKGROUND);
		looklftLabel.setHorizontalAlignment(SwingConstants.LEFT);
		looklftLabel.setBounds(10, 85, 75, 20);
		graphPanel.add(looklftLabel);

		lookrgtGraph.setBounds(90, 110, 260, 20);
		lookrgtGraph.setBackground(Constants.GRAPHPANEL);
		lookrgtGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(lookrgtGraph);

		lookrgtLabel = new JLabel("Look right");
		lookrgtLabel.setOpaque(true);
		lookrgtLabel.setForeground(Constants.GRAPHLABEL_FOREGROUND);
		lookrgtLabel.setBackground(Constants.GRAPHLABEL_BACKGROUND);
		lookrgtLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lookrgtLabel.setBounds(10, 110, 75, 20);
		graphPanel.add(lookrgtLabel);

		furrowGraph.setBounds(90, 135, 260, 20);
		furrowGraph.setBackground(Constants.GRAPHPANEL);
		furrowGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(furrowGraph);

		furrowLabel = new JLabel("Furrow Brow\r\n");
		furrowLabel.setOpaque(true);
		furrowLabel.setForeground(Constants.GRAPHLABEL_FOREGROUND);
		furrowLabel.setBackground(Constants.GRAPHLABEL_BACKGROUND);
		furrowLabel.setHorizontalAlignment(SwingConstants.LEFT);
		furrowLabel.setBounds(10, 135, 75, 20);
		graphPanel.add(furrowLabel);

		raiseGraph.setBounds(90, 160, 260, 20);
		raiseGraph.setBackground(Constants.GRAPHPANEL);
		raiseGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(raiseGraph);

		raiseLabel = new JLabel("Raise Brow");
		raiseLabel.setOpaque(true);
		raiseLabel.setForeground(Constants.GRAPHLABEL_FOREGROUND);
		raiseLabel.setBackground(Constants.GRAPHLABEL_BACKGROUND);
		raiseLabel.setBounds(10, 160, 75, 20);
		graphPanel.add(raiseLabel);

		smileGraph.setBounds(90, 185, 260, 20);
		smileGraph.setBackground(Constants.GRAPHPANEL);
		smileGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(smileGraph);

		smileLabel = new JLabel("Smile");
		smileLabel.setOpaque(true);
		smileLabel.setForeground(Constants.GRAPHLABEL_FOREGROUND);
		smileLabel.setBackground(Constants.GRAPHLABEL_BACKGROUND);
		smileLabel.setBounds(10, 185, 75, 20);
		graphPanel.add(smileLabel);

		clenchGraph.setBounds(90, 210, 260, 20);
		clenchGraph.setBackground(Constants.GRAPHPANEL);
		clenchGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(clenchGraph);

		clenchLabel = new JLabel("Clench");
		clenchLabel.setOpaque(true);
		clenchLabel.setForeground(Constants.GRAPHLABEL_FOREGROUND);
		clenchLabel.setBackground(Constants.GRAPHLABEL_BACKGROUND);
		clenchLabel.setBounds(10, 210, 75, 20);
		graphPanel.add(clenchLabel);

		lftSmirkGraph.setBounds(90, 235, 260, 20);
		lftSmirkGraph.setBackground(Constants.GRAPHPANEL);
		lftSmirkGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(lftSmirkGraph);

		lftSmirkLabel = new JLabel("Left Smirk");
		lftSmirkLabel.setOpaque(true);
		lftSmirkLabel.setForeground(Constants.GRAPHLABEL_FOREGROUND);
		lftSmirkLabel.setBackground(Constants.GRAPHLABEL_BACKGROUND);
		lftSmirkLabel.setBounds(10, 235, 75, 20);
		graphPanel.add(lftSmirkLabel);

		rgtSmirkGraph.setBounds(90, 260, 260, 20);
		rgtSmirkGraph.setBackground(Constants.GRAPHPANEL);
		rgtSmirkGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(rgtSmirkGraph);

		rgtSmirkLabel = new JLabel("Right Smirk");
		rgtSmirkLabel.setOpaque(true);
		rgtSmirkLabel.setForeground(Constants.GRAPHLABEL_FOREGROUND);
		rgtSmirkLabel.setBackground(Constants.GRAPHLABEL_BACKGROUND);
		rgtSmirkLabel.setBounds(10, 260, 75, 20);
		graphPanel.add(rgtSmirkLabel);

		laughGraph.setBounds(90, 285, 260, 20);
		laughGraph.setBackground(Constants.GRAPHPANEL);
		laughGraph.setBorder(BorderFactory.createLineBorder(Color.black));
		graphPanel.add(laughGraph);

		laughLabel = new JLabel("Laugh");
		laughLabel.setOpaque(true);
		laughLabel.setForeground(Constants.GRAPHLABEL_FOREGROUND);
		laughLabel.setBackground(Constants.GRAPHLABEL_BACKGROUND);
		laughLabel.setBounds(10, 285, 75, 20);
		graphPanel.add(laughLabel);

		blinkGraphPanel = new JPanel();
		blinkGraphPanel.setBounds(82, 11, 276, 20);
		graphPanel.add(blinkGraphPanel);

		rgtWinkGraphPanel = new JPanel();
		rgtWinkGraphPanel.setBounds(82, 36, 276, 20);
		graphPanel.add(rgtWinkGraphPanel);

		lftWinkGraphPanel = new JPanel();
		lftWinkGraphPanel.setBounds(82, 65, 276, 20);
		graphPanel.add(lftWinkGraphPanel);

		lookGraphPanel = new JPanel();
		lookGraphPanel.setBounds(82, 90, 276, 20);
		graphPanel.add(lookGraphPanel);

		furrowGraphPanel = new JPanel();
		furrowGraphPanel.setBounds(82, 115, 276, 20);
		graphPanel.add(furrowGraphPanel);

		raiseGraphPanel = new JPanel();
		raiseGraphPanel.setBounds(82, 140, 276, 20);
		graphPanel.add(raiseGraphPanel);

		smileGraphPanel = new JPanel();
		smileGraphPanel.setBounds(82, 165, 276, 20);
		graphPanel.add(smileGraphPanel);

		clenchGraphPanel = new JPanel();
		clenchGraphPanel.setBounds(82, 190, 276, 20);
		graphPanel.add(clenchGraphPanel);

		lftSmrGraphPanel = new JPanel();
		lftSmrGraphPanel.setBounds(82, 215, 276, 20);
		graphPanel.add(lftSmrGraphPanel);

		rgtSmrGraphPanel = new JPanel();
		rgtSmrGraphPanel.setBounds(82, 245, 276, 20);
		graphPanel.add(rgtSmrGraphPanel);

		laughGraphPanel = new JPanel();
		laughGraphPanel.setBounds(82, 276, 276, 18);
		graphPanel.add(laughGraphPanel);

	}

	/*
	 * Builder Class for ExpressionView
	 */

	public static class ExpressionViewBuilder {
		JPanel buildfacePanel;
		JPanel buildgraphPanel;
		JPanel buildblinkGraph;
		JPanel buildrgtWinkGraph;
		JPanel buildlftWinkGraph;
		JPanel buildlooklftGraph;
		JPanel buildlookrgtGraph;
		JPanel buildfurrowGraph;
		JPanel buildraiseGraph;
		JPanel buildsmileGraph;
		JPanel buildclenchGraph;
		JPanel buildlftSmirkGraph;
		JPanel buildrgtSmirkGraph;
		JPanel buildlaughGraph;

		public ExpressionViewBuilder(JPanel facePanel, JPanel graphPanel, JPanel blinkGraph, JPanel rgtWinkGraph,
				JPanel lftWinkGraph, JPanel looklftGraph, JPanel lookrgtGraph, JPanel furrowGraph, JPanel raiseGraph,
				JPanel smileGraph, JPanel clenchGraph, JPanel lftSmirkGraph, JPanel rgtSmirkGraph, JPanel laughGraph) {
			this.buildfacePanel = facePanel;
			this.buildgraphPanel = graphPanel;
			this.buildblinkGraph = blinkGraph;
			this.buildrgtWinkGraph = rgtWinkGraph;
			this.buildlftWinkGraph = lftWinkGraph;
			this.buildlooklftGraph = looklftGraph;
			this.buildlookrgtGraph = lookrgtGraph;
			this.buildfurrowGraph = furrowGraph;
			this.buildraiseGraph = raiseGraph;
			this.buildsmileGraph = smileGraph;
			this.buildclenchGraph = clenchGraph;
			this.buildlftSmirkGraph = lftSmirkGraph;
			this.buildrgtSmirkGraph = rgtSmirkGraph;
			this.buildlaughGraph = laughGraph;

		}

		/**
		 * Builder Class implementation
		 * 
		 * @return
		 */

		public ExpressiveView createExpressiveView() {
			return new ExpressiveView(buildfacePanel, buildgraphPanel, buildblinkGraph, buildrgtWinkGraph,
					buildlftWinkGraph, buildlooklftGraph, buildlookrgtGraph, buildfurrowGraph, buildraiseGraph,
					buildsmileGraph, buildclenchGraph, buildlftSmirkGraph, buildrgtSmirkGraph, buildlaughGraph);
		}

	}
}
