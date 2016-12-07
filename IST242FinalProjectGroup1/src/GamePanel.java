import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JButton;

public class GamePanel extends JPanel implements KeyListener,ActionListener{


    private TangibleObject bouncer1, follower1, wanderer1, berserker1, player;
    private TangibleObject item1,item2,item3;
    private Walls walls;
    private Timer time;
    private int count, pause;
    private Color dotColor;
    private JButton back;
    private JLabel name,difficulty;
    private ArrayList<TangibleObject> enemies,items;
    
    GamePanel(){
        
        walls = new Walls();
        enemies = new ArrayList();
        bouncer1 = new Bouncer(55,20,10,10);
        follower1 = new Follower(300,11,10,10);
        wanderer1 = new Wanderer(300,300,10,10);
        berserker1 = new Berserker(350,300,10,10);
        enemies.add(bouncer1);
        enemies.add(follower1);
        enemies.add(wanderer1);
        enemies.add(berserker1);
        
        player = new Player(100,100,10,10);
        player.setDifficulty(10);
        
        items = new ArrayList();
        item1 = new Item(10,10,10,10);
        item2 = new Item(150,250,10,10);
        item3 = new Item(10,250,10,10);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        time = new Timer(30,this);
        time.start();
        back = new JButton("Back");
        add(back);
        name = new JLabel("default");
        add(name);
        difficulty = new JLabel("default");
        add(difficulty);
        addKeyListeners(this);
    }
    public void addActionListeners(ActionListener al){
        this.back.addActionListener(al);
    }
    public void addKeyListeners(KeyListener e){
        this.addKeyListener(e);
    }
    public JButton getBack(){
        return this.back;
    }
    public void setName(String nameText){
        name.setText(nameText);
    }
    public void setDifficulty(int difficultyNumber){
        difficulty.setText("difficulty is " + difficultyNumber);
        player.setDifficulty(difficultyNumber);
    }
    public int getDifficulty(){
        return player.getDifficulty();
    }
    public int getPlayerX(){
        return this.player.getThisX();
    }
    public void setPlayerX(int x){
        player.setX(x);
    }
    public int getPlayerY(){
        return this.player.getThisY();
    }
    public void setPlayerY(int y){
        player.setY(y);
    }
    public ArrayList<TangibleObject> getEnemies(){
        return this.enemies;
    }
    public ArrayList<TangibleObject> getItems(){
        return this.items;
    }
    public void setEnemies(ArrayList<TangibleObject> enemies){
        for(int i = 0; i < wanderer1.getObjectArray().size();i++){
            enemies.add(wanderer1.getObjectArray().get(i));
            System.out.println(enemies.size());
        }
        this.enemies = enemies;
    }
    public void enemyContact(TangibleObject player){
        for(int i = 0; i < enemies.size(); i++){
            pause++;
            if(pause > 60){
                if(player.intersects(enemies.get(i))){
                    player.setDifficulty(player.getDifficulty()-1);
                    pause = 0;
                }
            }
        }
    }
    public void counter(){
        count++;
        
        player.objectMovement(3);
        player.playerCollision();
        setDifficulty(player.getDifficulty());
        player.setFacing(player.getDX(), player.getDY());
        player.itemCollision(items);
        bouncer1.bouncerMovement();
        bouncer1.wallCollision();
        follower1.targetFollower(player);
        wanderer1.randomMotion(count);
        wanderer1.setFacing(wanderer1.getDX(), wanderer1.getDY());
        wanderer1.projectileShooter(wanderer1.getFacing(),count);
        berserker1.aggressiveRandomMotion(count, player);
        //setEnemies(enemies);//projectiles don't work right
            
        if(count == 100){
            count = 0;
        }
    }
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.fillRect(player.x,player.y,player.width,player.height);
        for(int i = 0; i < items.size();i++){
            g.setColor(wanderer1.dotColor(count));
            g.fillRect(items.get(i).x,items.get(i).y,items.get(i).width,items.get(i).height);
        }
        g.setColor(Color.black);
        g.fillRect(bouncer1.x,bouncer1.y,bouncer1.width,bouncer1.height);
        g.fillRect(follower1.x,follower1.y,follower1.width,follower1.height);
        g.fillRect(wanderer1.x,wanderer1.y,wanderer1.width,wanderer1.height);
        g.fillRect(berserker1.x,berserker1.y,berserker1.width,berserker1.height);

        for(int i = 0; i < wanderer1.getObjectArray().size();i++){
            //g.setColor(wanderer1.dotColor(count));
            g.fillRect(wanderer1.getObjectArray().get(i).x,wanderer1.getObjectArray().get(i).y,wanderer1.getObjectArray().get(i).width,wanderer1.getObjectArray().get(i).height);
        }
        for(int i = 0; i < player.getObjectArray().size();i++){
            System.out.println("bang");
            g.setColor(player.dotColor(count));
            g.fillRect(player.getObjectArray().get(i).x,player.getObjectArray().get(i).y,player.getObjectArray().get(i).width,player.getObjectArray().get(i).height);
        }
        g.setColor(Color.black);
        for(int i = 0;i < walls.getWallArray().size();i++){
            g.fillRect(walls.getWallArray().get(i).x, walls.getWallArray().get(i).y, walls.getWallArray().get(i).width, walls.getWallArray().get(i).height);
        }
        repaint();
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(this.isFocusOwner()){
            counter();
        }           
        enemyContact(player);
 
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP){
            player.setDX(0);
            player.setDY(-1);
        }
        if(key == KeyEvent.VK_DOWN){
            player.setDX(0);
            player.setDY(1);
        }
        if(key == KeyEvent.VK_LEFT){
            player.setDX(-1);
            player.setDY(0);
        }
        if(key == KeyEvent.VK_RIGHT){
            player.setDX(1);
            player.setDY(0);
        }
//        if(key == KeyEvent.VK_SPACE){
//            player.playerShooter(player.getFacing(), count);
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP){
            player.setDX(0);
            player.setDY(0);
        }
        if(key == KeyEvent.VK_DOWN){
            player.setDX(0);
            player.setDY(0);
        }
        if(key == KeyEvent.VK_LEFT){
            player.setDX(0);
            player.setDY(0);
        }
        if(key == KeyEvent.VK_RIGHT){
            player.setDX(0);
            player.setDY(0);
        }
    }
    
}
