/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Master
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model,view);
        
    }
    
}
