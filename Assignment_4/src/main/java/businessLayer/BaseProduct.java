package businessLayer;

/**
 * Class for extending the MenuItem with a base product containing the name and price
 * @author Loga Darius
 *
 */
@SuppressWarnings("serial")
public class BaseProduct extends MenuItem {
    
    public BaseProduct(String name, double price) {
        super(name, price);
    }
}