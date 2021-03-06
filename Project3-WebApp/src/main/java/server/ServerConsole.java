package server;

import javax.swing.JScrollPane;

/**
 * @SER516 Project3_Team03
 * @Version 1.0
 */

import javax.swing.JTextArea;

/**
* This class is used for logging messages to the 
* GUI console.
* 
*  @SER516 SER516_ExtraCredit
 * @Version 1.0
*/
public  class ServerConsole {

    protected JTextArea serverconsolePane;
    protected JScrollPane scrollPane;
    private static ServerConsole instance = null;
    
    /**
    * Sets the GUI console text to the provided message.
    *
    * @param msg text to display in the GUI console.
    */
  
    public void print(String msg) {
        this.serverconsolePane.setText("Console: " + msg);
    }

    /**
    * Setter for the target GUI element.
    *
    * @param consolePane the pane to which logged messages will appear.
    */
    
    public void setJtextArea(JTextArea consolePane) {
        this.serverconsolePane = consolePane;
        
    }
    
    /**
     * Setter for the target GUI element.
     *
     * @param scrollPane the pane to which logged messages will appear.
     */
    public void setJScrollPane(JScrollPane scrollPane)
    {
    	this.scrollPane = scrollPane;
    }
    
    /**
     * getInstance returns the ServerConsole object
     *
     */
     
     public static ServerConsole getInstance() {
         if (instance == null) {
             instance = new ServerConsole();
         }
         return instance;
     }
     
 }


