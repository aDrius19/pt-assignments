package assignment1.polynomialcalculator;

import assignment1.polynomialcalculator.Model.Polynom;
import assignment1.polynomialcalculator.Model.Monom;
/**
 *
 * @author Darius
 */
public class Control {
//Method used for the sum between P and Q
    public Polynom add(Polynom P, Polynom Q) {
        int i = 0, j = 0;
        Monom m;
        Polynom resPQ = new Polynom(); 	  
        int nbP = P.retMonoms();
        int nbQ = Q.retMonoms();

        while(i < nbP) { //if polyQ doesn't exist or is 0
                    double coefP = P.getMonom(i).getCoef();	
                    int powerP = P.getMonom(i).getPower();
                    m = new Monom(coefP, powerP);
                    i++;
                    resPQ.addMonom(m);
            }
        while(j < nbQ) { //if polyP doesn't exist or is 0
                    double coefQ = Q.getMonom(j).getCoef();
                    int powerQ = Q.getMonom(j).getPower();
                    m = new Monom(coefQ, powerQ);
                    j++;
                    resPQ.addMonom(m);
            }
        while(i < nbP && j < nbQ){//Coefficients and powers of P and Q
                    double coefP = P.getMonom(i).getCoef();
                    int powerP = P.getMonom(i).getPower();
                    double coefQ = Q.getMonom(j).getCoef();
                    int powerQ = Q.getMonom(j).getPower();

                    if(powerP == powerQ){ //equal powers
                            m = new Monom(coefP + coefQ, powerP);
                            i++; j++;}
                            else if(powerP > powerQ){ //different powers
                            m = new Monom(coefP, powerP); i++;}
                            else {  m = new Monom(coefQ, powerQ); j++;}
                    resPQ.addMonom(m);	
            }
        return resPQ;    
    } 

//The method used for the substraction between P and Q
    public Polynom sub(Polynom P,Polynom Q) {
        int i = 0, j = 0;
        Monom m;
        Polynom resPQ = new Polynom();
        int nrP = P.retMonoms();
        int nrQ = Q.retMonoms(); 	 

        while(i < nrP) {//if polyP doesn't exist or is 0
            double coefP = P.getMonom(i).getCoef();	
            int powerP = P.getMonom(i).getPower();
            m = new Monom(coefP, powerP);
            i++;
            resPQ.addMonom(m);
        }
        while(j < nrQ) {//if polyP doesn't exist or is 0
            double coefQ = Q.getMonom(j).getCoef();
            int powerQ = Q.getMonom(j).getPower();
            m = new Monom(-coefQ, powerQ);
            j++;
            resPQ.addMonom(m);
        }
        while(i < nrP && j < nrQ){//Coefficients and powers of P and Q
            double coefP = P.getMonom(i).getCoef();
            int powerP = P.getMonom(i).getPower();
            double coefQ = Q.getMonom(j).getCoef();
            int powerQ = Q.getMonom(j).getPower();

            if(powerP == powerQ){	
                    m = new Monom(coefP - coefQ,powerP);
                    i++;j++;}
                else if(powerP > powerQ){
                        m = new Monom(coefP, powerP);
                        i++;}
                        else {
                            m = new Monom(-coefQ, powerQ);
                            j++;}
            resPQ.addMonom(m);
        }
        return resPQ; 
    }
//The method used for the multiplicity between P and Q
    public Polynom mul(Polynom P,Polynom Q) {
        int i = 0, j = 0;
        Monom m;
        Polynom resPQ = new Polynom(); 	 
        int nrP = P.retMonoms();
        int nrQ = Q.retMonoms();

        while(i < nrP){
            double coefP = P.getMonom(i).getCoef();
            int powerP = P.getMonom(i).getPower();
            i++;
            j = 0;
            while(j < nrQ){
                double coefQ = Q.getMonom(j).getCoef();
                int powerQ = Q.getMonom(j).getPower();
                m = new Monom(coefP * coefQ, powerP + powerQ);
                resPQ.addMonom(m);
                j++;}
        }
        return resPQ; 
    }  
//The method used for the derivative of one polynom
    public Polynom deriv(Polynom P) {
        int i = 0;
        Monom m;
        Polynom res = new Polynom();
        int nrP = P.retMonoms();

        while(i < nrP) {
            double coefP = P.getMonom(i).getCoef();
            int powerP = P.getMonom(i).getPower();
            i++;
            if(powerP != 0){
                m = new Monom(coefP * powerP, powerP - 1);
                res.addMonom(m);}
        }
        return res;
    }

//The method used for the integration of one polynom
    public Polynom inte(Polynom P) {
        int i = 0;
        Monom m;
        Polynom res = new Polynom();
        int nrP = P.retMonoms();

        while(i < nrP) {
            double coefP = P.getMonom(i).getCoef();
            int powerP = P.getMonom(i).getPower();
            i++;
            m = new Monom(coefP/(powerP + 1), powerP + 1);
            res.addMonom(m);}
        return res;
    }
//The mehtod used for the division of P and Q with rest
    public String div(Polynom P, Polynom Q) {
        int i = 0;
        Monom aux2, aux3, m;
        Polynom resPQ = new Polynom();
        Polynom p1 = new Polynom();
        Polynom aux = new Polynom();
        String div = "";
        Control oper = new Control();
        String rest = "";

        while(P.getMonom(0).getPower() >= Q.getMonom(0).getPower()){	
                double coefQ = Q.getMonom(0).getCoef();
                int powerQ = Q.getMonom(0).getPower();
                aux2 = new Monom(coefQ, powerQ); //save the polynom Q in aux one
                aux3 = P.getMonom(i);

                double coefM = aux3.divM(aux2).getCoef();
                int powerM = aux3.divM(aux2).getPower();
                m = new Monom(coefM, powerM);
                aux.addMonom(m);
                resPQ.addMonom(m);
                p1 = oper.mul(Q, aux);
                P = oper.sub(P, p1);
                P.elimMonom(0);
        }
        rest = P.toStringDouble();
        div = resPQ.toStringDouble() + " r = " + rest;
        return div;
    }
}