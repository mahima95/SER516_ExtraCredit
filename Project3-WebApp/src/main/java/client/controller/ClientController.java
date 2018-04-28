package client.controller;

import java.awt.event.WindowEvent;

import client.view.ClientUi;

/**
 * Main Controller that invokes the client UI
 * 
 * @SER516_ExtraCredit
 * @version 1.0
 */
public class ClientController {
	static ClientUi clientui;
	ExpressiveController expressiveController;
	AffectiveController affectiveController;

	/**
	 * Run the client UI. Adds clientUI as an observer for change in values sent by
	 * server
	 */
	public ClientController() {

		expressiveController = new ExpressiveController();
		affectiveController = new AffectiveController();
		clientui = new ClientUi(expressiveController, affectiveController);
		FaceDataObservable.getFaceDataObservableInstance().addObserver(clientui);
		clientui.setVisible(true);

	}

	/**
	 * Closes the client UI.
	 */
	public static void close() {
		clientui.dispatchEvent(new WindowEvent(clientui, WindowEvent.WINDOW_CLOSING));
	}
}
