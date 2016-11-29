
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Master
 */
public class InstructionsPanel extends JPanel{
    
    JLabel instructionsText;
    BorderLayout layout;
    
    InstructionsPanel(){
        layout = new BorderLayout();
        setLayout(layout);
        //instructionsText.setText("Stay back from enemies navigate the maze");
        //add(instructionsText);
    }
}
