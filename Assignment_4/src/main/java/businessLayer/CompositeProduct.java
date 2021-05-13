package businessLayer;

import java.util.ArrayList;

/**
 * Class for the Composite product that extends MenuItem and saves in an array
 * the base and the comp product with their prices using the Composite Pattern
 * @author Loga Darius
 */
@SuppressWarnings("serial")
public class CompositeProduct extends MenuItem 
{
    private ArrayList<MenuItem> list;

    public CompositeProduct(){
        list = new ArrayList<MenuItem>();
    }

    public CompositeProduct(String name, ArrayList<MenuItem> list){
        super(name, -1);
        this.list = list;
        super.setPrice(this.computePrice());
    }

    @Override
    public double computePrice(){
        double res = 0;
        for(MenuItem m : list) {
            res += m.computePrice();
        }
        return res;
    }

    public void addCompItem(MenuItem item){
        this.list.add(item);
    }

    public ArrayList<MenuItem> getList(){
        return this.list;
    }
}