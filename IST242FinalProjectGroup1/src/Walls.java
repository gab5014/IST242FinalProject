import java.awt.Rectangle;
import java.util.ArrayList;

public class Walls {
    
    private ArrayList<Rectangle> wallsList;
    private Rectangle wallEast,wallWest,wallNorth,wallSouth;
    private Rectangle wall1,wall2;
    
    Walls(){
        
        wallsList = new ArrayList();
        
        wall1 = new Rectangle(195,100,10,200);
        wallsList.add(wall1);
        wall2 = new Rectangle(100,195,200,10);
        wallsList.add(wall2);
        
        //border walls
        wallEast = new Rectangle(400,0,10,410);
        wallsList.add(wallEast);
        wallWest = new Rectangle(0,0,10,400);
        wallsList.add(wallWest);
        wallNorth = new Rectangle(0,0,400,10);
        wallsList.add(wallNorth);
        wallSouth = new Rectangle(0,400,410,10);
        wallsList.add(wallSouth);
    }
    
    public ArrayList<Rectangle> getWallArray(){
        return this.wallsList;
    }
    
}
