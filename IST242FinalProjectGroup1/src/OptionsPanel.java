
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class OptionsPanel extends JPanel{
    
    private JSlider difficultySlider;
    private JLabel characterNameLabel;
    private JTextField characterNameField;
    private Model model;
    private Controller controller;
    
    public OptionsPanel(){
    GridLayout grid = new GridLayout(3,1);
    setLayout(grid);
    
    difficultySlider = new JSlider(JSlider.HORIZONTAL, 1, 20, 10);
    difficultySlider.setMajorTickSpacing(1);
    difficultySlider.setPaintTicks(true);
    difficultySlider.setPaintLabels(true);
    add(difficultySlider);
    
    characterNameLabel = new JLabel("Character Name: ");
    add(characterNameLabel);
    
    characterNameField = new JTextField("Enter Name");
}
  
    public int getDifficulty(){
        return difficultySlider.getValue();
    }
    
    public String getName(){
        return characterNameField.getText();
    }
    
}
