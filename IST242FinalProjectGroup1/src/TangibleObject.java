
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Master
 */
abstract public class TangibleObject extends Rectangle{

    private Color objectColor;
    private int facing,objectDX,objectDY,random;
    private Rectangle top,bottom,left,right;
    private int xDisplacement,yDisplacement,topDisplacement,bottomDisplacement,leftDisplacement,rightDisplacement;
    private Walls walls;
    private ArrayList<TangibleObject> objectArray;
    private boolean wait;
    
    TangibleObject(){
        
    }
    TangibleObject(int x,int y,int width, int height){
        
        this.walls = new Walls();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.objectDX = 0;
        this.objectDY = 0;
        this.xDisplacement = (this.x + this.width)-1;
        this.yDisplacement = (this.y + this.height)-1;
        this.topDisplacement = (((this.x + this.width) / 2) -1);
        this.bottomDisplacement = (this.x + (this.width / 2) -1);
        this.leftDisplacement = (this.y + (this.height / 2) -1);
        this.rightDisplacement = (this.y + (this.height / 2) -1);
        this.objectArray = new ArrayList();
        this.wait = false;
        
        this.top = new Rectangle(this.topDisplacement, y, 2, 1);//math so Rectangles don't overlap
        this.bottom = new Rectangle(this.bottomDisplacement, this.yDisplacement, 2, 1);//math so Rectangles don't overlap and are properly displaced
        this.left = new Rectangle(x, this.leftDisplacement, 1, 2);//math so Rectangles don't overlap
        this.right = new Rectangle(this.xDisplacement, this.rightDisplacement, 1, 2);//math so Rectangles don't overlap and are properly displaced
        
    }
    public ArrayList<TangibleObject> getObjectArray(){
        return this.objectArray;
    }
    public int getThisX(){
        return this.x;
    }
    public int getThisY(){
        return this.y;
    }
    public void setX(int dotDX){
        this.x = dotDX;
    }
    public void setY(int dotDY){
        this.y = dotDY;
    }
    public int getDX(){
        return this.objectDX;
    }
    public int getDY(){
        return this.objectDY;
    }
    public void setDX(int dotDX){
        this.objectDX = dotDX;
    }
    public void setDY(int dotDY){
        this.objectDY = dotDY;
    }
    public int getFacing(){
        return facing;
    }
    public void setFacing(int DX,int DY){//uses clock directions
        if(DX == 0 && DY == -1){
            this.facing = 12;
        }
        if(DX == 1 && DY == 0){
            this.facing = 3;
        }
        if(DX == 0 && DY == 1){
            this.facing = 6;
        }
        if(DX == -1 && DY == 0){
            this.facing = 9;
        }
    }
    public Rectangle getTop(){
        return this.top;
    }
    public Rectangle getBottom(){
        return this.bottom;
    }
    public Rectangle getLeft(){
        return this.left;
    }
    public Rectangle getRight(){
        return this.right;
    }
    public Color dotColor(int count){

        if(count % 2 == 0){
            this.objectColor = Color.RED;
        }else{
            this.objectColor = Color.BLUE;
        }
        return this.objectColor;
    }
    public void setXDisplacement(int xDisplacement){
        this.xDisplacement = xDisplacement;
    }
    public void setYDisplacement(int yDisplacement){
        this.yDisplacement = yDisplacement;
    }
    public int getTopDisplacement(){
        this.topDisplacement = (this.x + (this.width / 2) -1);
        return this.topDisplacement;
    }
    public int getBottomDisplacement(){
        this.bottomDisplacement = (this.x + (this.width / 2) -1);
        return this.bottomDisplacement;
    }
    public int getLeftDisplacement(){
        this.leftDisplacement = (this.y + (this.height / 2) -1);
        return this.leftDisplacement;
    }
    public int getRightDisplacement(){
        this.rightDisplacement = (this.y + (this.height / 2) -1);
        return this.rightDisplacement;
    }
    public void objectMovement(int speed){
        
        for(int i = 0; i < speed;i++){
            this.x = this.x + this.getDX();
            this.xDisplacement = (this.x + this.width)-1;
            getTop().x = getTopDisplacement();
            getBottom().x = getBottomDisplacement();
            getLeft().x = x;
            getRight().x = this.xDisplacement;

            this.y = this.y + this.getDY();
            this.yDisplacement = (this.y + this.height)-1;
            getTop().y = this.y;
            getBottom().y = this.yDisplacement;
            getLeft().y = getLeftDisplacement();
            getRight().y = getRightDisplacement();
        }
    }
    public void bouncerMovement(){

        this.objectMovement(3);
        this.wallCollision();
    }
    public void targetFollower(TangibleObject target){//fix bouncing on stationary target
        if(this.getBottom().x < target.getBottom().x - target.height){//move down
            setDX(1);
        }
        if(this.getTop().x > target.getTop().x + target.height){//move up
            setDX(-1);
        }
        if(this.getRight().y < target.getRight().y - target.width){//move right
            setDY(1);
        }
        if(this.getLeft().y > target.getLeft().y + target.width){//move left
            setDY(-1);
        }
        this.wallCollision();
        
        this.objectMovement(1);
    }
    public void randomMotion(int counter){
        if(counter == 1){
            this.random = (int) (Math.random() * 4);
        
            switch(this.random){
                case 0://up
                    this.setDX(0);
                    this.setDY(-1);
                    break;
                case 1://down
                    this.setDX(0);
                    this.setDY(1);
                    break;
                case 2://right
                    this.setDX(1);
                    this.setDY(0);
                    break;
                case 3://left
                    this.setDX(-1);
                    this.setDY(0);
                    break;
            }
        }
        this.wallCollision();
        this.objectMovement(3);
    }
    public void aggressiveRandomMotion(int counter,TangibleObject target){//moves toward target 1 in 5 times
        
        if(this.wait == false){
            if(counter == 1){
                this.random = (int) (Math.random() * 5);

                switch(this.random){
                    case 0://up
                        this.setDX(0);
                        this.setDY(-1);
                        break;
                    case 1://down
                        this.setDX(0);
                        this.setDY(1);
                        break;
                    case 2://right
                        this.setDX(1);
                        this.setDY(0);
                        break;
                    case 3://left
                        this.setDX(-1);
                        this.setDY(0);
                        break;
                    case 4://attack
                        this.targetFollower(target);//switch to target catcher when written //make these stop if wallCollision is called
                        this.wait = true;
                        break;
                }
            }
        }else if(counter == 1){
            this.setDX(0);
            this.setDY(0);
            this.wait = false;
        }
        this.wallCollision();
        this.objectMovement(3);
    }
    public void projectileShooter(int facing,int count){
        
        TangibleObject projectile = new Projectile();//any way to fix this?
        int projectileSize = 4;
        if(count == 50){
            if(facing == 12){
                projectile = new Projectile(this.x + (this.width/2) - (projectileSize/2),this.y - projectileSize,projectileSize,projectileSize);
                projectile.setDX(0);
                projectile.setDY(-1);
                this.objectArray.add(projectile);
            }
            if(facing == 3){
                projectile = new Projectile(this.x + this.width,this.y + (this.height/2) - (projectileSize/2),projectileSize,projectileSize);
                projectile.setDX(1);
                projectile.setDY(0);
                this.objectArray.add(projectile);
            }
            if(facing == 6){
                projectile = new Projectile(this.x + (this.width/2) - (projectileSize/2),this.y + this.height,projectileSize,projectileSize);
                projectile.setDX(0);
                projectile.setDY(1);
                this.objectArray.add(projectile);
            }
            if(facing == 9){
                projectile = new Projectile(this.x - projectileSize,this.y + (this.height/2) - (projectileSize/2),projectileSize,projectileSize);
                projectile.setDX(-1);
                projectile.setDY(0);
                this.objectArray.add(projectile);
            }
            if(objectArray.size() == 3){
                objectArray.remove(0);
            } 
        }
        for(int i = 0; i < this.getObjectArray().size();i++){
            TangibleObject tempProjectile = new Projectile(this.getObjectArray().get(i).x,this.getObjectArray().get(i).y,this.getObjectArray().get(i).width,this.getObjectArray().get(i).height);
            tempProjectile.setDX(this.getObjectArray().get(i).getDX());
            tempProjectile.setDY(this.getObjectArray().get(i).getDY());
            tempProjectile.wallCollision();
            tempProjectile.objectMovement(4);
            this.objectArray.set(i, tempProjectile);
        }
    }
    public void wallCollision(){
        for(int i = 0;i < walls.getWallArray().size();i++){
            if(walls.getWallArray().get(i).intersects(this.getTop())){
                this.setDY(1);
                //System.out.println("hit top");
            }
            if(walls.getWallArray().get(i).intersects(this.getBottom())){
                this.setDY(-1);
                //System.out.println("hit bottom");
            }
            if(walls.getWallArray().get(i).intersects(this.getLeft())){
                this.setDX(1);
                //System.out.println("hit left");
            }
            if(walls.getWallArray().get(i).intersects(this.getRight())){
                this.setDX(-1);
                //System.out.println("hit right");
            }
        }
    }
    
    
}
