package dataLayer;

import businessLayer.MenuItem;
import businessLayer.Order;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class with a method used for generating the bills in a text format
 * @author Loga Darius
 */
public class FilesWriter 
{
    public void generateBill(Order order, HashMap<Order, ArrayList<MenuItem>> hash){
        try {
            String file = "generatedBill_" + order.getOrderID() + ".txt";
            PrintWriter fw = new PrintWriter(file);
            fw.println("Order_" + order.getOrderID());
            fw.println("Table = " + order.getTable());
            fw.println("Date = " + order.getDate());
            fw.println("Orders: ");
            int i = 1;
            for(MenuItem item : hash.get(order)){
                fw.println("Item" + i + ": " + item.getName() + " " + item.computePrice() + " ");
                i++;
            }
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(FilesWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}