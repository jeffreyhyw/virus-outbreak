import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import ui.VirusConfigMainPanel;

public class MainController {
	
	public static void main(String[] args) {
	

		//Schedule a job for the event dispatch thread:
        //creating and showing config application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				VirusConfigMainPanel.createAndShowGUI();
            }
        });
	}

}
