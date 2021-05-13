package businessLayer;

import java.util.ArrayList;

/**
 * Interface that contains the methods to be implemented by the Restaurant class
 * @author Loga Darius
 */
public interface IRestraurantProcessing 
{
	/**
         * @param item the item to be added
	 * @pre item != null && !(item.getName().isEmpty()) && (item.computePrice() > 0)
	 * @post item != null
	 */
	public void addMenuItem(MenuItem item);
	
	/**
	 * @param itemName the name of the item as a string
         * @pre itemName != null && items != null && isInMenu(itemName) != false
	 * @post item != null
	 */
	public void removeMenuItem(String itemName);
	
	/**
	 * @param item the item in the menu
         * @param price the price of that item
         * @pre items != null && item != null && (price > 0) && isInMenu(item.getName())
	 * @post item != null
	 */
	public void editMenuItem(MenuItem item, double price);
	
	/**
	 * @param order the order to be added
         * @param items the list of all items
         * @pre order != null && items != null;
	 * @post isWellFormed()
	 */
	public void addOrder(Order order, ArrayList<MenuItem> items);
	
	/**
	 * @param order the order
         * @pre order != null && isWellFormed()
	 * @post (price > 0)
         * @return returns the price of the entire order
	 */
	public double computePriceOrder(Order order);
	
	/**
	 * @param orderID the number of the order
         * @pre isInOrders(orderID)
	 * @post order != null
	 */
	public void generateBills(int orderID);
}