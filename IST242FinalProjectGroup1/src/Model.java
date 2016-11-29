
import java.awt.Color;
import java.util.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Master
 */
public class Model {
    
    int panelNumber;
    
    Model(){
        
       panelNumber = 1;

    }
    public int getPanelNumber(){
        return this.panelNumber;
    }
    public void setPanelNumber(int panelNumber){
        this.panelNumber = panelNumber;
    }
}
