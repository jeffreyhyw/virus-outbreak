package ui;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UIFactory  {
	
	public JComponent makePanel(String panelName) {
        if(panelName == "ability")
        {
        	return new ConfigAbilityPanel().makeTextPanel();
        }
        else if(panelName == "symptom")
        {
        	return new ConfigSymptomPanel().makeTextPanel();
        }
        else if(panelName == "transmission")
        {
        	return new ConfigTransmissionPanel().makeTextPanel();
        }
        else
        {
            throw new NullPointerException("No panel exist"); 
        }
    }
    
}
