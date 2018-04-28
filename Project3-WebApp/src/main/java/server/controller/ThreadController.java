package server.controller;

import model.FaceData;
import server.service.FaceServer;
import server.view.DetectionPanel;

/**
 * Controller for sending multiple values in certain time durations
 * 
 * @SER516 SER516_ExtraCredit
 * @Version 1.0
 */
public class ThreadController implements Runnable {

		static Thread thread;
		DetectionPanel dpanel ; 
		Double emointerval = 1.0;
		Double timeElapsed = 0.0;
		
		/**
		 * Handles Server threads
		 * 
		 * @param emointerval
		 * @param detetctionpanel
		 */
		
		public ThreadController(Double emointerval, DetectionPanel detectionpanel ){	
		thread= new Thread(this);
		this.dpanel=detectionpanel;
		this.emointerval= emointerval;
		timeElapsed = Double.parseDouble(dpanel.timeElapsedTextbox.getText());
	}
	
	public void run() {
		while(true){
			timeElapsed += emointerval;
		
			try {
				Thread.sleep((long) (1000 * emointerval));
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			dpanel.timeElapsedTextbox.setText(timeElapsed+"");
			FaceData faceData = dpanel.getDetectionController().createFaceDataInstance();
			faceData.setTimeElapsed(timeElapsed);
			FaceServer.put(faceData);
		}
	}
	
	/**
	 * Stops the thread
	 */
	@SuppressWarnings("deprecation")
	public static void stop() {
		thread.stop();
	}
	
	/**
	 * Starts the thread
	 */
	public static void start(){
	
		thread.start();
	}
}
