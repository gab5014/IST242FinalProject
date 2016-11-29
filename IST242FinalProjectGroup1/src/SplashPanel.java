
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SplashPanel extends JPanel{
    
    private JLabel title;
    private GridLayout layout;
    private JButton options,instructions,credits,game;
    
    SplashPanel(){
        
        layout = new GridLayout(5,1);
        title = new JLabel("Welcome to team 1's game!");
        game = new JButton("Game");
        options = new JButton("Options");
        instructions = new JButton("Instructions");
        credits = new JButton("Credits");
        
        add(title);
        add(game);
        add(options);
        add(instructions);
        add(credits);
    }
    public void addActionListeners(ActionListener al){
        this.game.addActionListener(al);
        this.options.addActionListener(al);
        this.instructions.addActionListener(al);
        this.credits.addActionListener(al);
    }

}

