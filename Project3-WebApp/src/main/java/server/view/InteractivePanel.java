package server.view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import server.controller.InteractiveController;

/**
 * Class for displaying the Interactive Panel
 * 
 * @SER516 SER516_ExtraCredit
 * @Version 1.0
 */
@SuppressWarnings("serial")
public class InteractivePanel extends JPanel {

	private JSpinner spinnerEmoStateInterval;
	private JCheckBox chckbxAutoReset;
	private JButton btnSend;
	private JComboBox comboBoxPlayer;
	private JLabel labelStateInterval;
	private JLabel labelSeconds;
	DetectionPanel dpanel;

	/**
	 * Initialize the Interaction panel window
	 * 
	 * @param dpanel
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public InteractivePanel(DetectionPanel dpanel) {

		this.dpanel = dpanel;
		this.setLayout(null);
		JLabel lblPlayer = new JLabel("Player");
		lblPlayer.setBounds(12, 26, 56, 16);
		this.add(lblPlayer);

		comboBoxPlayer = new JComboBox();
		comboBoxPlayer.setBounds(60, 23, 96, 22);
		comboBoxPlayer.setModel(new DefaultComboBoxModel(new String[] { "0", "1" }));
		this.add(comboBoxPlayer);

		labelStateInterval = new JLabel("EmoStateInterval");
		labelStateInterval.setBounds(219, 20, 118, 28);
		this.add(labelStateInterval);

		spinnerEmoStateInterval = new JSpinner();
		spinnerEmoStateInterval
		.setModel(new SpinnerNumberModel(new Double(0.25), new Double(0.25), null, new Double(0.25)));
		spinnerEmoStateInterval.setBounds(349, 23, 75, 22);
		this.add(spinnerEmoStateInterval);

		labelSeconds = new JLabel("Sec");
		labelSeconds.setBounds(436, 26, 35, 16);
		this.add(labelSeconds);

		chckbxAutoReset = new JCheckBox("Auto Resend");
		chckbxAutoReset.setBounds(219, 58, 113, 25);
		this.add(chckbxAutoReset);

		btnSend = new JButton("Send");
		btnSend.setBounds(337, 58, 119, 25);
		this.add(btnSend);

		new InteractiveController(btnSend, spinnerEmoStateInterval, chckbxAutoReset, dpanel);
	}
}
