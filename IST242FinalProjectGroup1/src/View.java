
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame{
    
    private Model model;
    private GamePanel gamePanel;
    private SplashPanel splashPanel;
    private OptionsPanel optionsPanel;
    private InstructionsPanel instructionsPanel;
    
    View(Model model){
        
        
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(Color.BLACK);
        
        model = new Model();
        gamePanel = new GamePanel();
        splashPanel = new SplashPanel();
        optionsPanel = new OptionsPanel();
        //instructionsPanel = new InstructionsPanel();
        addGamePanel();//this is temporary
        
    }
    public void addSplashPanel(){
        add(splashPanel);
        remove(gamePanel);
        remove(optionsPanel);
        remove(instructionsPanel);
        splashPanel.isFocusable();
        getContentPane().add(splashPanel);
        revalidate();
        repaint();
    }
    public void addGamePanel(){
        add(gamePanel);
        remove(splashPanel);
        remove(optionsPanel);
        remove(instructionsPanel);
        gamePanel.isFocusable();
        getContentPane().add(gamePanel);
        revalidate();
        repaint();
    }
    public void addOptionsPanel(){
        add(optionsPanel);
        remove(gamePanel);
        remove(splashPanel);
        remove(instructionsPanel);
        splashPanel.isFocusable();
        getContentPane().add(splashPanel);
        revalidate();
        repaint();
    }
    public void addInstuctionsPanel(){
        add(instructionsPanel);
        remove(gamePanel);
        remove(splashPanel);
        remove(instructionsPanel);
        splashPanel.isFocusable();
        getContentPane().add(splashPanel);
        revalidate();
        repaint();
    }
      
}
