package businessLayer;

import java.io.Serializable;

/**
 * Class representing the MenuItem implementing the Serialization mechanism
 * @author Loga Darius
 */
@SuppressWarnings("serial")
public class MenuItem implements Serializable {
    private String name;
    private double price;
    
    public MenuItem() {
        
    }
    
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }
    
    public double computePrice(){
        return this.price;
    }
}