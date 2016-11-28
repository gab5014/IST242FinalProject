
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame{
    
    private Model model;
    private GamePanel gamePanel;
    // add main panel
    // add options panel
    
    View(Model model){
        
        
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(Color.BLACK);
        
        model = new Model();
        gamePanel = new GamePanel();
        gamePanel.isFocusable();
        addGamePanel(gamePanel);//this is temporary
        
    }
    public void addGamePanel(GamePanel gamePanel){
        
        this.gamePanel = gamePanel;
        //remove main panel
        //remove options panel
        getContentPane().add(gamePanel);
        revalidate();
        repaint();
    }
    public void removeGamePanel(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        if(gamePanel != null){
            //remove(gamePanel) //fixme
        }
    }
    
    
}
