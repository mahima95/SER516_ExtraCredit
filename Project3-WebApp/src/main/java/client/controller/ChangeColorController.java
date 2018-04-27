package client.controller;

import java.awt.Color;

import client.view.ColorSelectorButton;
import client.view.ColorSelectorButton.ColorChangedListener;
import utility.Constants;

/**
 * Controller for changing the color of the graph
 * 
 * @SER516 SER516_ExtraCredit
 * @version 1.0
 */
public class ChangeColorController {
	public ChangeColorController(final ColorSelectorButton button) {
		button.addColorChangedListener(new ColorChangedListener() {
			
			/**
			 * Changing colors according to Affectiveness 
			 * 
			 * 
			 */
			
		    public void colorChanged(Color newColor) {
		    		if(button.getName() == "Meditation"){
		    			Constants.meditationColor = newColor;
		    		}
		    		else if(button.getName() == "Engagement"){
		    			Constants.engagementColor = newColor;
		    		}
		    		else if(button.getName() == "Frustation"){
		    			Constants.frustationColor = newColor;
		    		}
		    		else if(button.getName() == "Excitement Short Term"){
		    			Constants.excitementstColor = newColor;
		    		}
		    		else if(button.getName() == "Excitement Long Term"){
		    			Constants.excitementltColor = newColor;
		    		}
		    }
		});
	}
}
