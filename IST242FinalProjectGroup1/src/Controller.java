
import java.awt.event.ActionEvent;
import java.util.Timer;

public class Controller {
    
    private Timer time;
    Model model;
    View view;
    
    Controller(Model model,View view){
        this.model = model;
        this.view = view;
        
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
