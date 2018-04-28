package client.view;

import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import client.controller.AffectiveController;
import client.controller.ExpressiveController;
import client.controller.MenuItemController;
import model.FaceData;

/**
 * @SER516 SER516_ExtraCredit
 * @Version 1.0
 */
@SuppressWarnings("serial")
/**
 * 
 * Initializes the ClientUI This class acts an observer for the values that are
 * sent from the server Once notified it updates the both expressive and
 * affective graphs along with expressions
 *
 */
public class ClientUi extends JFrame implements Observer {

	private ExpressiveController expressiveController;
	private AffectiveController affectiveController;
	final JPanel panel = new JPanel();
	final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	final JMenuBar menuBar = new JMenuBar();
	final JMenu menuFile = new JMenu("File");
	final JMenu menuApplication = new JMenu("Application");
	final JMenu menuConnection = new JMenu("Connection");
	final JMenuItem serverConsole = new JMenuItem("Open Server");
	JPanel facePanel;

	/**
	 * Creates the application
	 * 
	 * @param expressiveController
	 *            Contains the expression controller object
	 */
	public ClientUi(ExpressiveController expressiveController, AffectiveController affectiveController) {
		this.expressiveController = expressiveController;
		this.affectiveController = affectiveController;
		initialize(expressiveController.expressiveView, affectiveController.affectiveView);
		this.setBounds(new Rectangle(0, 0, 710, 432));
		this.getContentPane().setLayout(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JPanel expressiveView, JPanel affectiveView) {

		panel.setBounds(0, 0, 698, 402);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		tabbedPane.setBounds(0, 22, 698, 380);
		panel.add(tabbedPane);

		tabbedPane.addTab("Expressive", null, expressiveView, null);

		tabbedPane.addTab("Affective", null, affectiveView, null);

		menuBar.setBounds(0, 0, 698, 22);
		panel.add(menuBar);

		menuBar.add(menuFile);

		menuFile.add(menuApplication);

		menuFile.add(menuConnection);

		menuApplication.add(serverConsole);

		JMenuItem serverConnect = new JMenuItem("Connect to Server");
		menuConnection.add(serverConnect);

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		menuFile.add(exitMenuItem);

		new MenuItemController(serverConnect, serverConsole, exitMenuItem);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	@Override
	/**
	 * Method on being invoked changes the values of the graphs and expressions
	 * accordingly
	 */
	public void update(Observable o, Object arg) {

		FaceData faceData = (FaceData) arg;
		this.expressiveController.updateTime(faceData);
		this.expressiveController.updateGraph(faceData.getFaceExpressionData());
		this.affectiveController.updateGraph(faceData.getFaceAffectiveData());

	}

}
