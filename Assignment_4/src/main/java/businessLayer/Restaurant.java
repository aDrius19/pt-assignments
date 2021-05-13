package businessLayer;

import java.io.*;
import java.util.*;
import java.util.Observable;
import presentationLayer.ChefGUI;
import dataLayer.FilesWriter;

/**
 * Class used for computing the operations for the Waiter and Admin roles
 * @author Loga Darius
 * @inv isWellFormed()
 */
@SuppressWarnings("serial")
public class Restaurant extends Observable implements IRestraurantProcessing, Serializable {

	private HashMap<Order, ArrayList<MenuItem>> hash;
        private ArrayList<MenuItem> items;

	/**
	 * @pre hash == null
	 * @post isWellFormed()
	 */
	public Restaurant() {
            assert (hash == null);
            this.hash = new HashMap<Order, ArrayList<MenuItem>>();
            this.items = new ArrayList<MenuItem>();
            addObserver(new ChefGUI());
            assert (isWellFormed());
	}
        
        public ArrayList<MenuItem> getItems(){
            return this.items;
        }
        
        public HashMap<Order, ArrayList<MenuItem>> getHash(){
            return this.hash;
        }
        
        @Override
        public void addMenuItem(MenuItem item) {
            assert (item != null);
            assert !(item.getName().isEmpty());
            assert (item.computePrice() > 0);
            items.add(item);
            assert (items != null);
        }
        
        public boolean isInMenu(String itemName){
            for(MenuItem menuItem : items) {
                if(menuItem.getName().equals(itemName))
                    return true;
            }
            return false;
        }
        
        public MenuItem findMenuItem(String itemName){
            for(MenuItem menuItem : items) {
                if(menuItem.getName().equals(itemName))
                    return menuItem;
            }
            return null;
        }

        @Override
        public void removeMenuItem(String itemName) {
            assert (itemName != null);
            assert (items != null);
            assert (isInMenu(itemName) != false);
            MenuItem item = findMenuItem(itemName);
            if(item != null) {
                items.remove(item);
            }
            assert (item != null);
        }

        @Override
        public void editMenuItem(MenuItem item, double price) {
            assert (items != null);
            assert (item != null);
            assert (price > 0);
            assert (isInMenu(item.getName()));
            item = findMenuItem(item.getName());
            assert (item != null);
            item.setPrice(price);
        }


        @Override
        public void addOrder(Order order, ArrayList<MenuItem> items) {
            assert (order != null);
            assert (items != null);
            hash.put(order, items);
            setChanged();
            notifyObservers();
            assert (isWellFormed());
        }


        @Override
        public double computePriceOrder(Order order) {
            assert (order != null);
            assert (isWellFormed());
            double price = 0;
            for(MenuItem items : hash.get(order))
            {
                assert (items != null);
                price += items.computePrice();
            }
            assert (price > 0);
            return price;
        }

        public boolean isInOrders(int orderID) {
            assert (orderID > 0);
            for(Order order : hash.keySet()){
                if(order.getOrderID() == orderID)
                    return true;
            }
            return false;
        }
        
        public Order getOrder(int orderID) {
            assert (orderID > 0);
            for(Order order : hash.keySet()){
                if(order.getOrderID() == orderID)
                    return order;
            }
            return null;
        }
        
        @Override
        public void generateBills(int orderID) {
            assert (isInOrders(orderID));
            Order order = getOrder(orderID);
            assert (order != null);
            FilesWriter f = new FilesWriter();
            f.generateBill(order, hash);
        }
	
	private boolean isWellFormed() 
        {
		if(hash != null) return true;
		else return false;
	}
}