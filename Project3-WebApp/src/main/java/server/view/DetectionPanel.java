package server.view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpringLayout;

import model.FaceAffectiveData;
import model.FaceExpressionData;
import server.ServerConsole;
import server.controller.DetectionController;



/**
 * View for the Detection Panel.
 * @SER516 SER516_ExtraCredit
 * @Version 1.0
 */
@SuppressWarnings("serial")
public class DetectionPanel extends JPanel {

	public JTextField timeElapsedTextbox;
	public JSpinner spinnerEmoStateInterval, spinnerUpperFace, spinnerLowerFace, spinnerAffective;
	public JCheckBox checkboxEyeAutoReset;
	public JTextArea textAreaEmoLogs;
	public JScrollPane scroll;
	public JButton buttonSend, buttonClearLogs;
	@SuppressWarnings("rawtypes")
	public JComboBox comboUpperFace, comboLowerFace, comboEye, comboAffective;
	public JRadioButton radiobuttonActive;
	public FaceExpressionData faceExpressionData;
	public FaceAffectiveData faceAffectiveData;
	public JLabel labelEmoState,labelTime,labelSeconds,labelUpperFace,labelEye,labelLowerface,labelAffective,labelEmoengineLogs;
	public SpringLayout springpanel;
	public ServerConsole serverconsole;
	public DetectionController detectionController=new DetectionController();

	/**
	 * Constructor of detetction Panel
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DetectionPanel() {
		
		springpanel = new SpringLayout();
		this.setLayout(springpanel);

		faceAffectiveData = new FaceAffectiveData();
		faceExpressionData = new FaceExpressionData();
		labelEmoState = new JLabel("EMOTION STATE");
		labelTime = new JLabel("TIME: ");
		labelSeconds = new JLabel("Seconds");
		labelUpperFace = new JLabel("Upperface:");
		labelLowerface = new JLabel("Lowerface:");
		comboLowerFace = new JComboBox();
		radiobuttonActive = new JRadioButton("Active");
		checkboxEyeAutoReset = new JCheckBox("Auto Reset");
		labelEmoengineLogs = new JLabel("EmoEngine Logs");
		buttonClearLogs = new JButton("Clear Logs");
		labelAffective = new JLabel("Affective:");
		labelEye = new JLabel("Eye:");
		
		
		timeElapsedTextbox = new JTextField();
		timeElapsedTextbox.setEditable(false);
		timeElapsedTextbox.setText("0.0");
		timeElapsedTextbox.setColumns(10);
		
		comboUpperFace = new JComboBox();
		comboUpperFace.setModel(new DefaultComboBoxModel(new String[] { "Raise Brow", "Furrow Brow" }));
		
		spinnerUpperFace = new JSpinner();
		spinnerUpperFace.setModel(new SpinnerListModel(
				new String[] { "0", "0.10", "0.20", "0.30", "0.40", "0.50", "0.60", "0.70", "0.80", "0.90", "1" }));
		
		comboLowerFace.setModel(
				new DefaultComboBoxModel(new String[] { "Smile", "Clench", "Smirk Left", "Smirk Right", "Laugh" }));
		
		spinnerLowerFace = new JSpinner();
		spinnerLowerFace.setModel(new SpinnerListModel(
				new String[] { "0", "0.10", "0.20", "0.30", "0.40", "0.50", "0.60", "0.70", "0.80", "0.90", "1" }));
		
		comboEye = new JComboBox();
		comboEye.setModel(new DefaultComboBoxModel(
				new String[] { "Blink", "Wink Left", "Wink Right", "Look Left", "Look Right" }));
		
		textAreaEmoLogs = new JTextArea();
		textAreaEmoLogs.setEditable(true);
		textAreaEmoLogs.setRows(5);
		
		comboAffective = new JComboBox();
		comboAffective.setModel(new DefaultComboBoxModel(new String[] { "Meditation", "Engagement Boredom",
				"Excitement ShortTerm", "Frustration", "Excitement LongTerm" }));
		
		spinnerAffective = new JSpinner();
		spinnerAffective.setModel(new SpinnerListModel(
				new String[] { "0", "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1.0" }));
		
		serverconsole = ServerConsole.getInstance();
		serverconsole.setJtextArea(textAreaEmoLogs);
				
		scroll = new JScrollPane(textAreaEmoLogs);
		serverconsole.setJScrollPane(scroll);
		
		setComponentLayout();
		addComponent();
		
		
		 detectionController = detectionController.new DetectionControllerBuilder( spinnerUpperFace,  spinnerLowerFace,
				spinnerAffective,  comboUpperFace, comboLowerFace,
					comboAffective, comboEye,  checkboxEyeAutoReset,
					radiobuttonActive,textAreaEmoLogs, buttonClearLogs,  faceAffectiveData,
					 faceExpressionData).createDetectionControl();
		
		
	}
	
	/*
	 * Layout of server components
	 */
	
	public void setComponentLayout(){
		springpanel.putConstraint(SpringLayout.NORTH, comboLowerFace, 144, SpringLayout.NORTH, this);
		
		springpanel.putConstraint(SpringLayout.NORTH, labelEmoState, 13, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, labelEmoState, 12, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, labelEmoState, 88, SpringLayout.WEST, this);

		springpanel.putConstraint(SpringLayout.NORTH, labelTime, 47, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, labelTime, 22, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, labelTime, 70, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.NORTH, timeElapsedTextbox, 44, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, timeElapsedTextbox, 74, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.NORTH, labelSeconds, 47, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, labelSeconds, 202, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, labelSeconds, 258, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.WEST, labelUpperFace, 0, SpringLayout.WEST, labelEmoState);
		springpanel.putConstraint(SpringLayout.EAST, labelUpperFace, 88, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.SOUTH, labelUpperFace, -6, SpringLayout.NORTH, comboUpperFace);
		springpanel.putConstraint(SpringLayout.NORTH, comboUpperFace, 144, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, comboUpperFace, 12, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, comboUpperFace, 111, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.NORTH, spinnerUpperFace, 144, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, spinnerUpperFace, 125, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, spinnerUpperFace, 190, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.NORTH, labelLowerface, 0, SpringLayout.NORTH, labelUpperFace);
		springpanel.putConstraint(SpringLayout.WEST, labelLowerface, 276, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, labelLowerface, -126, SpringLayout.EAST, this);
	
		springpanel.putConstraint(SpringLayout.EAST, comboLowerFace, -10, SpringLayout.WEST, spinnerLowerFace);
		springpanel.putConstraint(SpringLayout.NORTH, spinnerLowerFace, 144, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, spinnerLowerFace, 402, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, spinnerLowerFace, 458, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.WEST, labelEye, 0, SpringLayout.WEST, labelEmoState);
		springpanel.putConstraint(SpringLayout.EAST, labelEye, -2, SpringLayout.EAST, labelTime);
		
		springpanel.putConstraint(SpringLayout.SOUTH, labelEye, -6, SpringLayout.NORTH, comboEye);
		springpanel.putConstraint(SpringLayout.NORTH, comboEye, 238, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, comboEye, 0, SpringLayout.WEST, labelEmoState);
		springpanel.putConstraint(SpringLayout.EAST, comboEye, 0, SpringLayout.EAST, comboUpperFace);
		
		springpanel.putConstraint(SpringLayout.NORTH, radiobuttonActive, -1, SpringLayout.NORTH, comboEye);
		springpanel.putConstraint(SpringLayout.WEST, radiobuttonActive, 120, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, radiobuttonActive, 0, SpringLayout.EAST, timeElapsedTextbox);
		
		springpanel.putConstraint(SpringLayout.NORTH, checkboxEyeAutoReset, 6, SpringLayout.SOUTH, comboEye);
		springpanel.putConstraint(SpringLayout.WEST, checkboxEyeAutoReset, 0, SpringLayout.WEST, labelEmoState);
		springpanel.putConstraint(SpringLayout.EAST, checkboxEyeAutoReset, -359, SpringLayout.EAST, this);
		
		springpanel.putConstraint(SpringLayout.NORTH, labelEmoState, 316, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, labelEmoState, 25, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, labelEmoState, 124, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.NORTH, scroll, 345, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, scroll, 22, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.SOUTH, scroll, 474, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.EAST, scroll, 458, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.NORTH, buttonClearLogs, 487, SpringLayout.NORTH, this);
		springpanel.putConstraint(SpringLayout.WEST, buttonClearLogs, 185, SpringLayout.WEST, this);
		springpanel.putConstraint(SpringLayout.EAST, buttonClearLogs, 282, SpringLayout.WEST, this);
		
		springpanel.putConstraint(SpringLayout.NORTH, labelAffective, 0, SpringLayout.NORTH, labelEye);
		springpanel.putConstraint(SpringLayout.WEST, labelAffective, 0, SpringLayout.WEST, labelLowerface);
		
		springpanel.putConstraint(SpringLayout.WEST, comboLowerFace, 0, SpringLayout.WEST, comboAffective);
		springpanel.putConstraint(SpringLayout.WEST, comboAffective, 47, SpringLayout.EAST, radiobuttonActive);
		springpanel.putConstraint(SpringLayout.NORTH, comboAffective, 238, SpringLayout.NORTH, this);
		
		springpanel.putConstraint(SpringLayout.EAST, comboAffective, -10, SpringLayout.WEST, spinnerAffective);
		springpanel.putConstraint(SpringLayout.NORTH, spinnerAffective, 0, SpringLayout.NORTH, radiobuttonActive);
		springpanel.putConstraint(SpringLayout.WEST, spinnerAffective, 0, SpringLayout.WEST, spinnerLowerFace);
		springpanel.putConstraint(SpringLayout.EAST, spinnerAffective, 0, SpringLayout.EAST, spinnerLowerFace);
		
	}
	
	/*
	 * Adds components to server
	 */

	public void addComponent() {
		
		add(labelEmoState);
		add(spinnerAffective);
		add(comboAffective);
		add(labelAffective);
		add(buttonClearLogs);
		add(scroll);
		add(labelEmoengineLogs);
		add(checkboxEyeAutoReset);
		add(radiobuttonActive);
		add(comboEye);
		add(labelEye);
		add(spinnerLowerFace);
		add(comboLowerFace);
		add(labelLowerface);
		add(spinnerUpperFace);
		add(comboUpperFace);
		add(labelUpperFace);
		add(labelSeconds);
		add(timeElapsedTextbox);
		add(labelTime);
	}

	/**
	 * 
	 * @return detection control object
	 */
	public DetectionController getDetectionController() {
		return this.detectionController;
	}

}
