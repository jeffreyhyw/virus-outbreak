package ui;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfigTransmissionPanel {
	public JComponent makeTextPanel() {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel("Transmission Panel");
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
}
