package server.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;

import server.service.FaceServer;
import server.view.DetectionPanel;

/**
 * Controller for the interactive section of the server.
 * 
 * @SER516 SER516_ExtraCredit
 * @Version 1.0
 */
public class InteractiveController {

	JButton buttonSend;
	JSpinner emoStateInterval;
	JCheckBox checkAutoBoxReset;
	
	/**
	 * Constructor for getting constants
	 * 
	 * @param buttonSend
	 * @param emoStateInterval
	 * @param checkAutoBoxReset
	 * @param dpanel
	 */
	public InteractiveController(final JButton buttonSend, final JSpinner emoStateInterval, final JCheckBox checkAutoBoxReset,
			final DetectionPanel dpanel) {

		this.buttonSend = buttonSend;
		this.emoStateInterval = emoStateInterval;
		this.checkAutoBoxReset = checkAutoBoxReset;
		
		//Sends the selected values to the client.
		buttonSend.addActionListener(new ActionListener() {

			@Override

		    /**
		    * Sets the event action to provided message.
		    *
		    * @param event sets the event to be performed.
		    */
			public void actionPerformed(ActionEvent event) {
				
				
				if (event.getActionCommand().equals("Send")){
					if (checkAutoBoxReset.isSelected()){
						buttonSend.setText("Stop");
						emoStateInterval.setEnabled(false);
						checkAutoBoxReset.setEnabled(false);
						Double interval = (Double)emoStateInterval.getValue();
						new ThreadController(interval,dpanel);
						ThreadController.start();
					}
					else {
						FaceServer.put(dpanel.getDetectionController().createFaceDataInstance());
					}
				}else {
					ThreadController.stop();
					emoStateInterval.setEnabled(true);
					checkAutoBoxReset.setEnabled(true);
					buttonSend.setText("Send");
				}

			}
		});
	}
}
