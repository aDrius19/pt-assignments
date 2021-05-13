package presentationLayer;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class for the Chef GUI using an Observer Patter to notify the chef
 * that the is ready for preparation
 * @author Loga Darius
 */
public class ChefGUI implements Observer {
    private JFrame frame;
    
    public ChefGUI(){
        this.frame = new JFrame();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        JOptionPane.showMessageDialog(frame, "The chef saw the oder and it's working on it!", "Chef", JOptionPane.INFORMATION_MESSAGE, null);
    }
}