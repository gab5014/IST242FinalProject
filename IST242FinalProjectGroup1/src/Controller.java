
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import javax.swing.JButton;

public class Controller{
    
    private Timer time;
    private Model model;
    private View view;
    private GamePanel gamePanel;
    private SplashPanel splashPanel;
    private OptionsPanel optionsPanel;
    private InstructionsPanel instructionsPanel;
    
    Controller(Model model,View view){
        this.model = model;
        this.view = view;
        this.gamePanel = new GamePanel();
        this.splashPanel = new SplashPanel();
        this.optionsPanel = new OptionsPanel();
        this.instructionsPanel = new InstructionsPanel();
        
        class ButtonListener implements ActionListener{
            
            @Override
            public void actionPerformed(ActionEvent e){//not firing
                JButton buttonPressed = (JButton) e.getSource();
 
                if(buttonPressed == view.getSplashGame()){
                    view.addGamePanel();
                }
                if(buttonPressed == view.getSplashOptions()){
                    view.addOptionsPanel();
                }
                if(buttonPressed == view.getSplashInstructions()){
                    view.addInstuctionsPanel();
                }
                if(buttonPressed == view.getSplashCredits()){
                    view.addCreditsPanel();
                }
                if(buttonPressed == view.getGameBack()||
                        buttonPressed == view.getOptionsBack()||
                        buttonPressed == view.getInstructionsBack()||
                        buttonPressed == view.getCreditsBack()){
                    view.addSplashPanel();
                }
                if(buttonPressed == view.getOptionsInfo()){
                    model.setDifficulty(view.getDifficulty());
                    model.setName(view.getPlayerName());
                    view.setNameLabel(model.getName());
                    view.setDifficulty(model.getDifficulty());//fix to use view
                    view.setPlayerName(model.getName());
                    System.out.println(model.getName());
                    System.out.println(model.getDifficulty());
                }
            }
        }
        view.addActionListeners(new ButtonListener());
    }
    public void setPanel(int panelNumber){
        if(panelNumber == 1){
            view.addSplashPanel();
        }
        if(panelNumber == 2){
            view.addGamePanel();
        }
        if(panelNumber == 3){
            view.addOptionsPanel();
        }
        if(panelNumber == 4){
            view.addInstuctionsPanel();
        }
    }

    
}
