
import java.awt.Color;
import java.util.Timer;

public class Model {
    
    private int panelNumber,difficulty;
    private String name;
    private int playerX,playerY;
    
    Model(){
        
       panelNumber = 1;

    }
    public int getPanelNumber(){
        return this.panelNumber;
    }
    public void setPanelNumber(int panelNumber){
        this.panelNumber = panelNumber;
    }
    public void setDifficulty(int difficulty){
        this.difficulty = difficulty;
    }
    public int getDifficulty(){
        return difficulty;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getPlayerX(){
        return this.playerX;
    }
    public void setPlayerX(int x){
        this.playerX = x;
    }
    public int getPlayerY(){
        return this.playerY;
    }
    public void setPlayerY(int y){
        this.playerY = y;
    }
}
