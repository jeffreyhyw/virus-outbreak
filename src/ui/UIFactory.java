package ui;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.MainController;
import object.Game;

public class UIFactory  {
	

    public static Game game;
	
	public JComponent makePanel(String panelName) {
        if(panelName == "ability")
        {
        	return new ConfigAbilityPanel().makeTextPanel(game);
        }
        else if(panelName == "symptom")
        {
        	return new ConfigSymptomPanel().makeTextPanel(game);
        }
        else if(panelName == "transmission")
        {
        	return new ConfigTransmissionPanel().makeTextPanel(game);
        }
        else
        {
            throw new NullPointerException("No panel exist"); 
        }
    }
    
}
