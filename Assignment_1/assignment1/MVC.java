package assignment1.polynomialcalculator;

/**
 *
 * @author Darius
 */
public class MVC {
     
    public static void main(String[] args) {
     
     PolyCalcUI view = new PolyCalcUI();
     Model model = new Model();
     Control control = new Control();
     view.setVisible(true);
     }
}
