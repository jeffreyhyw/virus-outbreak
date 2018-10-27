package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import controller.MainController;

public class GameStart {
    private static JPanel mainPanel = new JPanel();

    public static Boolean valid = false; // Hi

    public static JPanel createAndShowGUI() {
        buildUI();
        return mainPanel;
    }

    private static void buildUI() {

        JPanel gameStartPanel = new JPanel();
        gameStartPanel.setLayout(new BoxLayout(gameStartPanel, BoxLayout.PAGE_AXIS));


        String[] labelName = {"VIRUS", "Virus Name", "---", "Born Country", "---", "Start"};

        int testNumber = 10;

        String[] testData = new String[testNumber + 1];
        testData[0] = "---";

        for (int i = 1; i <= testNumber; i++) {
            testData[i] = "mo_" + String.valueOf(i);
        }

        for (int i = 0; i < 6; i++) {
            JPanel rowPanel = new JPanel();
            if (i == 0 || i == 1 || i == 3) {
                JLabel jlabel = new JLabel(labelName[i]);
                if (i == 0) {
                    jlabel.setFont(new Font("sans serif", Font.BOLD, 16));
                }
                rowPanel.add(jlabel);
            } else if (i == 2) {
                JTextField jTextField = new JTextField(20);
                rowPanel.add(jTextField);
            } else if (i == 4) {
                final JComboBox<String> cb = new JComboBox<>(testData);
                cb.setVisible(true);
                rowPanel.add(cb);
            } else {
                JButton jButton = new JButton(labelName[i]);
                jButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (Component gameStartComponent : gameStartPanel.getComponents()) {
                            Component rowComponent = ((JPanel) gameStartComponent).getComponent(0);
                            if (rowComponent.getClass().equals(JTextField.class)) {
                                valid = checkTextFiled(rowComponent);
                            } else if (rowComponent.getClass().equals(JComboBox.class) && valid) {
                                valid = checkComboBox(rowComponent);
                            }
                        }
                        
                        //Go to Main UI if valid
                        if(valid) 
                        {
                        	EventQueue.invokeLater(new Runnable() {
            				    @Override
            				    public void run() {
            				    	MainController.frame.getContentPane().removeAll();
            						MainController.frame.getContentPane().add(Main.createAndShowGUI());
            						MainController.frame.revalidate();
            				    }
            				});
                        }
                    }
                });
                rowPanel.add(jButton);
            }
            gameStartPanel.add(rowPanel);
            mainPanel.add(gameStartPanel);
        }
    }

    private static boolean checkTextFiled(Component rowComponent){
        JTextField tx = (JTextField) rowComponent;
        if (tx.getText().trim().isEmpty()) {
            System.out.println("\u001B "+"ERROR : EMPTY STRING"+"\u001B");
            return false;
        } else {
            System.out.println("\u001B "+"DEBUG : Input String is "+"\u001B "+"\""+ tx.getText()+"\""+"\u001B");
            return true;
        }
    }

    private static boolean checkComboBox(Component rowComponent){
        JComboBox jComboBox = (JComboBox) rowComponent;
        if (jComboBox.getSelectedIndex() == 0) {
            System.out.println("\u001B "+"ERROR : DO NOT SELECT ZERO ITEM"+"\u001B");
            return false;
        } else {
            System.out.println("\u001B "+"DEBUG : Selected index : "+"\u001B" + String.valueOf(jComboBox.getSelectedIndex())+"\u001B");
            System.out.println("\u001B "+"DEBUG : Selected item : "+"\u001B" + String.valueOf(jComboBox.getSelectedItem())+"\u001B");
            return true;
        }
    }

}
