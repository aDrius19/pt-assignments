package businessLayer;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class representing the order of a customer that can be hashed
 * and override the equals method to make it custom for this Class
 * @author Loga Darius
 */
@SuppressWarnings("serial")
public class Order implements Serializable {
	
        private int orderID;
        private String date;
        private int table;
	
	public Order(int orderID, String date, int table) {
            this.orderID = orderID;
            this.date = date;
            this.table = table;
	}

        public void setOrderID(int newID){
            this.orderID = newID;
        }
        
        public int getOrderID(){
            return this.orderID;
        }
        
        public void setDate(String newDate){
            this.date = newDate;
        }
        
        public String getDate(){
            return this.date;
        }
        
        public int getTable(){
            return this.table;
        }
        
        public void setTable(int newTable){
            this.table = newTable;
        }
        
	@Override
	public int hashCode() {
            return Objects.hash(orderID, date, table);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
                    return true;
		if (obj == null)
                    return false;
		if (this.getClass() != obj.getClass())
                    return false;
		Order other = (Order) obj;
		if(other.getOrderID() != this.orderID)
                    return false;
                if(!other.getDate().equals(this.date))
                    return false;
                if(other.getTable() != this.table)
                    return false;
		return true;
	}
}