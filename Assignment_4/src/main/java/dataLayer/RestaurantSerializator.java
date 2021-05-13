package dataLayer;

import java.io.*;
import businessLayer.*;

/**
 * Class and methods used for serializing the data
 * loading and saving data for Restaurant to a file
 * @author Loga Darius
 */

public class RestaurantSerializator {
    public static void serialize(Restaurant object) {
        try {
            FileOutputStream file = new FileOutputStream("restaurant.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(object);
            out.close();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Restaurant deserialize(String filename) {
        try {
            Restaurant object = new Restaurant(); 
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            object = (Restaurant)in.readObject(); 
            in.close();
            file.close();
            return object;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}