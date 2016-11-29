
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class OptionsPanel extends JPanel{
    
    private JSlider difficultySlider;
    private JLabel characterNameLabel;
    private JTextField characterNameField;
    private JButton back, setInfo;
    private GridLayout grid;
    private Model model;
    
    public OptionsPanel(){
        grid = new GridLayout(3,2);
        setLayout(grid);

        difficultySlider = new JSlider(JSlider.HORIZONTAL, 1, 20, 10);
        difficultySlider.setMajorTickSpacing(1);
        difficultySlider.setPaintTicks(true);
        difficultySlider.setPaintLabels(true);
        add(difficultySlider);

        characterNameLabel = new JLabel("Character Name: ");
        add(characterNameLabel);

        characterNameField = new JTextField("Enter Name");
        add(characterNameField);
        
        back = new JButton("Back");
        add(back);
        
        setInfo = new JButton("Set Info");
        add(setInfo);
        
    }
    public void addActionListeners(ActionListener al){
        this.back.addActionListener(al);
        this.setInfo.addActionListener(al);
    }
    public JButton getBack(){
        return this.back;
    }
    public JButton getInfo(){
        return this.setInfo;
    }
    public int getDifficulty(){
        return difficultySlider.getValue();
    }
    public String getPlayerName(){
        String name = characterNameField.getText();
        System.out.println(name);
        return name;
    }
    public void setNameLabel(String name){
        this.characterNameLabel.setText(name);
    }
    
    
}
