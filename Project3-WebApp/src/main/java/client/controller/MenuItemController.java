package client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import client.service.FaceClient;
import server.ServerMainHandler;

/**
 * Controller for the menu that enables the server to be opened from client and
 * provides an option to connect to server
 * 
 * @SER516 SER516_ExtraCredit
 * @Version 1.0
 */
public class MenuItemController {
	private JTextField host;
	private JTextField port;
	private int input;

	/**
	 * Initializes the menu on the client
	 * 
	 */
	public MenuItemController(JMenuItem serverConnect, JMenuItem serverConsole, JMenuItem exit) {

		serverConnect.addActionListener(new ActionListener() {
			/**
			 * Activated when user selects to connect to server Displays a pop up window
			 * with local host and port number On establishing the connection notifies the
			 * user about the established connection
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
				host = new JTextField();
				host.setText("localhost");
				port = new JTextField();
				port.setText("8000");

				Object[] fields = { "Host Name", host, "Port", port };
				input = JOptionPane.showConfirmDialog(null, fields, "Connect To Server", JOptionPane.OK_CANCEL_OPTION);
				if (input == JOptionPane.OK_OPTION) {
					try {
						FaceClient.connect(host.getText(), port.getText());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, FaceClient.isConnected() ? "Connected to " + host.getText()
					: "Not connected to " + host.getText());
				}
			}
		});

		/**
		 * Closes the application
		 * 
		 */
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientController.close();
			}
		});

		/**
		 * Opens the server window
		 * 
		 */
		serverConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ServerMainHandler();
			}
		});
	}

}
