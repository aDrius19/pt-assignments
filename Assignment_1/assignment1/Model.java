package assignment1.polynomialcalculator;
import java.util.ArrayList;
/**
 *
 * @author Darius
 */
public class Model {
    
    public static class Monom{
    private double coef;
    private int power;
    
    Monom(double coef ,int power) {
        setPower(power);        //constructor for the monom
		setCoef(coef);
    }
    
    public void setPower(int power1) {

        this.power = power1;  //setter for the power
    }

    public int getPower() {
            
        return this.power;  //getter for the power
    }
    
    public void setCoef(double coef){
            
        this.coef = coef; //setter for the coefficient
    }

    public double getCoef(){
            
        return this.coef; //getter for the coefficient
    }
    
    public Monom divM(Monom aux) {
            
        Monom m1 = new Monom(this.coef / aux.getCoef(), this.power - aux.getPower()); //used to divide one monom with other
        return m1;
    }
}
    public static class Polynom{
  
      private ArrayList<Monom> monoms = new ArrayList<Monom>();
      private int nbMonoms = 0;
      
      public void addMonom(Monom m){
          monoms.add(m);            //add monoms and count them
          nbMonoms++;
      }
      public void elimMonom(int i) {
		
          monoms.remove(i);  //remove one monom at index i
        }
      
       public int retMonoms() {
            
           return nbMonoms;	//method for returning a monom
	}
      public Monom getMonom(int i){
		
            return monoms.get(i); //get the monom at the index i
		
	}
      @Override //represent the polynomials as a string
      public String toString(){

            String finalPolinom = "";
            String auxP = "";
            String auxC = "";
            boolean lastCoeff1 = false;  //used to check if the polynomial has the last coefficient 1

            for (Monom m1 : monoms){

                    int coef = (int) m1.getCoef(); //modify the coeff to be integer
                    if(m1.getCoef() == 0) continue;
                    if((coef != 1) && (coef != -1)) auxC = coef + "";
                    else if(coef == 1) {auxC = ""; lastCoeff1 = true;}
                            else {auxC = "-";}
                    if((m1.getPower() != 0) && (m1.getPower() != 1)) auxP = "x^" + m1.getPower();
                    else if(m1.getPower() == 1) auxP = "x";
                            else auxP = ""; 
                    if(coef == 1 && m1.getPower() == 0) auxC = "1";
                    if(coef == -1 && m1.getPower() == 0) auxC = "-1";

                    finalPolinom = finalPolinom + auxC + auxP + "+";
                    finalPolinom = finalPolinom.replace("+-", "-");
            }
            if(finalPolinom.compareTo("") == 0) 
                {if(lastCoeff1) finalPolinom = "1";
                    else finalPolinom = "0"; 		
                }
              else if(finalPolinom.length() > 0)
                    finalPolinom = finalPolinom.substring(0, finalPolinom.length() - 1);
                    finalPolinom = finalPolinom.replace("+-", "-");
            if(finalPolinom.compareTo("-") == 0) finalPolinom = "-1";
            return finalPolinom;
    }  
      //represent the polynomials as a string with double coeff
       public String toStringDouble(){

            String finalPolinom = "";
            String auxP = "";
            String auxC = "";
            boolean lastCoeff1 = false;  //used to check if the polynomial has the last coefficient 1

            for (Monom m1 : monoms){

                    double coef = m1.getCoef();
                    if(coef == 0) continue;
                    if((coef != 1) && (coef != -1)) auxC = coef + "";
                    else if(coef == 1) {auxC = ""; lastCoeff1 = true;}
                            else {auxC = "-";}
                    if((m1.getPower() != 0) && (m1.getPower() != 1)) auxP = "x^" + m1.getPower();
                    else if(m1.getPower() == 1) auxP = "x";
                            else auxP = ""; 
                    if(coef == 1 && m1.getPower() == 0) auxC = "1";
                    if(coef == -1 && m1.getPower() == 0) auxC = "-1";

                    finalPolinom = finalPolinom + auxC + auxP + "+";
                    finalPolinom = finalPolinom.replace("+-", "-");
            }
            if(finalPolinom.compareTo("") == 0) 
                {if(lastCoeff1) finalPolinom = "1";
                    else finalPolinom = "0"; 		
                }
              else if(finalPolinom.length() > 0)
                    finalPolinom = finalPolinom.substring(0, finalPolinom.length() - 1);
                    finalPolinom = finalPolinom.replace("+-", "-");
            if(finalPolinom.compareTo("-") == 0) finalPolinom = "-1";
            return finalPolinom;
    }  
     
  }   
}