
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame{
    
    private Model model;
    private GamePanel gamePanel;
    private SplashPanel splashPanel;
    private OptionsPanel optionsPanel;
    private InstructionsPanel instructionsPanel;
    private CreditsPanel creditsPanel;
    private JButton test;
    
    View(Model model){
        
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(Color.BLACK);
        test = new JButton();
        add(test);
        
        model = new Model();
        gamePanel = new GamePanel();
        splashPanel = new SplashPanel();
        optionsPanel = new OptionsPanel();
        instructionsPanel = new InstructionsPanel();
        creditsPanel = new CreditsPanel();
        addSplashPanel();//this is temporary
        
    }
    public void addActionListeners(ActionListener al){
        this.splashPanel.addActionListeners(al);
        this.gamePanel.addActionListeners(al);
        this.optionsPanel.addActionListeners(al);
        this.instructionsPanel.addActionListeners(al);
        this.creditsPanel.addActionListeners(al);
        this.test.addActionListener(al);
    }
    public JButton getTest(){
        return this.test;
    }
    public JButton getSplashGame(){
        return splashPanel.getGame();
    }
    public JButton getSplashOptions(){
        return splashPanel.getOptions();
    }
    public JButton getSplashInstructions(){
        return splashPanel.getInstructions();
    }
    public JButton getSplashCredits(){
        return splashPanel.getCredits();
    }
    public JButton getGameBack(){
        return gamePanel.getBack();
    }
    public JButton getOptionsBack(){
        return optionsPanel.getBack();
    }
    public JButton getInstructionsBack(){
        return instructionsPanel.getBack();
    }
    public JButton getCreditsBack(){
        return creditsPanel.getBack();
    }
    
    public void addSplashPanel(){
        add(splashPanel);
        remove(gamePanel);
        remove(optionsPanel);
        remove(instructionsPanel);
        remove(creditsPanel);
        splashPanel.isFocusable();
        setContentPane(splashPanel);
        revalidate();
        repaint();
    }
    public void addGamePanel(){
        add(gamePanel);
        remove(splashPanel);
        remove(optionsPanel);
        remove(instructionsPanel);
        remove(creditsPanel);
        gamePanel.isFocusable();
        setContentPane(gamePanel);
        revalidate();
        repaint();
    }
    public void addOptionsPanel(){
        add(optionsPanel);
        remove(gamePanel);
        remove(splashPanel);
        remove(instructionsPanel);
        remove(creditsPanel);
        optionsPanel.isFocusable();
        setContentPane(optionsPanel);
        revalidate();
        repaint();
    }
    public void addInstuctionsPanel(){
        add(instructionsPanel);
        remove(gamePanel);
        remove(splashPanel);
        remove(optionsPanel);
        remove(creditsPanel);
        instructionsPanel.isFocusable();
        setContentPane(instructionsPanel);
        revalidate();
        repaint();
    }
    public void addCreditsPanel(){
        add(creditsPanel);
        remove(gamePanel);
        remove(splashPanel);
        remove(optionsPanel);
        remove(instructionsPanel);
        creditsPanel.isFocusable();
        setContentPane(creditsPanel);
        revalidate();
        repaint();
    }
      
}
