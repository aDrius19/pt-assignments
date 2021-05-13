package test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import assignment1.polynomialcalculator.Model.Polynom;
import assignment1.polynomialcalculator.Model.Monom;

/**
 *
 * @author Darius
 */
public class Test {
    //String resP, resQ = "";
    Monom m1 = new Monom(7, 5); Monom m2 = new Monom(2, 6); Monom m3 = new Monom(3, 1);
    Monom m4 = new Monom(2, 4); Monom m5 = new Monom(5, 1);
    Polynom p1, p2 = new Polynom();
    p1.addMonom(m1); p1.addMonom(m2); p1.addMonom(m3);
    p2.addMonom(m4); p2.addMonom(m5);
    //resP = p1.toString(); resQ = p2.toString(); //for comparing the strings, but not neccessarly to test this
    
    public Test() {
        
        private static Model operatii;
        private static int nbTests= 0;
        private static int nbGoodTests = 0;
        private static int nbBadTests = 0;
    }
    
    @BeforeClass
    public static void setUpClass() throw Expection{
        operatii = new Model();
    }
    @AfterClass
    public static void tearDownClass() throws Exception{
        System.out.println("Executed " + nbTests + " tests which " + nbGoodTests + " had success and " + nbBadTests + "did not have success!");
    }
    @Before
    public void setUp() throws Exception{
        System.out.print("New Test!");
    }
    @After
    public void tearDown() throws Exception{
        System.out.println("The current test is over!");
        nbTests++; 
    }
    
    @org.junit.Test
    public void testAddT() throws Exception{
        System.out.print(" Add!\n");
        Monom m6 = new Monom(7, 5); Monom m7 = new Monom(2, 6); Monom m8 = new Monom(3, 1); Monom m9 = new Monom(2, 4); Monom m10 = new Monom(5, 1);
        Polynom expectedResult = new Polynom();
        expectedResult.addMonom(m6); expectedResult.addMonom(m7); expectedResult.addMonom(m8); expectedResult.addMonom(m9); expectedResult.addMonom(m10);
        Polynom GottenResult = this.operatii.add(p1, p2);
        
        assertTrue(GottenResult.equals(expectedResult));
        nbGoodTests++;
    }
    @org.junit.Test
    public void testAddF() throws Exception{
        System.out.print(" Add!\n");
        Monom m6 = new Monom(7, 5); Monom m7 = new Monom(2, 6); Monom m8 = new Monom(3, 1); Monom m9 = new Monom(2, 7); Monom m10 = new Monom(5, 1);
        Polynom expectedResult = new Polynom();
        expectedResult.addMonom(m6); expectedResult.addMonom(m7); expectedResult.addMonom(m8); expectedResult.addMonom(m9); expectedResult.addMonom(m10);
        Polynom GottenResult = this.operatii.add(p1, p2);
        
        assertFalse(GottenResult.equals(expectedResult));
        nbBadTests++;
    }
    @org.junit.Test
    public void testSubT() throws Exception{
        System.out.print(" Substraction!\n");
        Monom m6 = new Monom(7, 5); Monom m7 = new Monom(2, 6); Monom m8 = new Monom(3, 1); Monom m9 = new Monom(2, 4); Monom m10 = new Monom(5, 1);
        Polynom expectedResult = new Polynom();
        expectedResult.addMonom(m6); expectedResult.addMonom(m7); expectedResult.addMonom(m8); expectedResult.addMonom(m9); expectedResult.addMonom(m10);
        Polynom GottenResult = this.operatii.sub(poli1, poli2);
        
        assertTrue(nbGoodTests.equals(expectedResult));
        nbGoodTests++;
    }
    @org.junit.Test
    public void testSubF() throws Exception{
        System.out.print(" Substraction!\n");
        Monom m6 = new Monom(7, 5); Monom m7 = new Monom(2, 6); Monom m8 = new Monom(3, 1); Monom m9 = new Monom(2, 7); Monom m10 = new Monom(5, 1);
        Polynom expectedResult = new Polynom();
        expectedResult.addMonom(m6); expectedResult.addMonom(m7); expectedResult.addMonom(m8); expectedResult.addMonom(m9); expectedResult.addMonom(m10);
        Polynom GottenResult = this.calculator.sub(poli1);
        
        assertFalse(nbGoodTests.equals(expectedResult));
        nbBadTests++;
    }
    @org.junit.Test
    public void testMulT() throws Exception{
        System.out.print(" Multiply!\n");
        Monom m6 = new Monom(7, 5); Monom m7 = new Monom(2, 6); Monom m8 = new Monom(3, 1); Monom m9 = new Monom(2, 4); Monom m10 = new Monom(5, 1);
        Polynom expectedResult = new Polynom();
        expectedResult.addMonom(m6); expectedResult.addMonom(m7); expectedResult.addMonom(m8); expectedResult.addMonom(m9); expectedResult.addMonom(m10);
        Polynom GottenResult = this.operatii.mul(p1, p2);
        
        assertTrue(nbGoodTests.equals(expectedResult));
        nbGoodTests++;
    }
    @org.junit.Test
    public void testMulF() throws Exception{
        System.out.print(" Multiply!\n");
        Monom m6 = new Monom(7, 5); Monom m7 = new Monom(2, 6); Monom m8 = new Monom(3, 1); Monom m9 = new Monom(2, 7); Monom m10 = new Monom(5, 1);
        Polynom expectedResult = new Polynom();
        expectedResult.addMonom(m6); expectedResult.addMonom(m7); expectedResult.addMonom(m8); expectedResult.addMonom(m9); expectedResult.addMonom(m10);
        Polynom GottenResult = this.operatii.mul(p1, p2);
        
        assertFalse(nbGoodTests.equals(expectedResult));
        nbBadTests++;
    }
    @org.junit.Test
    public void testDivT() throws Exception{
        System.out.print(" Division!\n");
        Monom m6 = new Monom(7, 5); Monom m7 = new Monom(2, 6); Monom m8 = new Monom(3, 1); Monom m9 = new Monom(2, 7); Monom m10 = new Monom(5, 1);
        Polynom expectedResult = new Polynom();
        expectedResult.addMonom(m6); expectedResult.addMonom(m7); expectedResult.addMonom(m8); expectedResult.addMonom(m9); expectedResult.addMonom(m10);
        Polynom GottenResult = this.operatii.div(p1, p2);
        
        assertTrue(nbGoodTests.equals(expectedResult));
        nbGoodTests++;
    }
    @org.junit.Test
    public void testDivF() throws Exception{
        System.out.print(" Division!\n");
        Monom m6 = new Monom(7, 5); Monom m7 = new Monom(2, 6); Monom m8 = new Monom(3, 1); Monom m9 = new Monom(2, 7); Monom m10 = new Monom(5, 1);
        Polynom expectedResult = new Polynom();
        expectedResult.addMonom(m6); expectedResult.addMonom(m7); expectedResult.addMonom(m8); expectedResult.addMonom(m9); expectedResult.addMonom(m10);
        Polynom GottenResult = this.operatii.div(p1, p2);
        
        assertFalse(nbGoodTests.equals(expectedResult));
        nbBadTests++;
    }
    @org.junit.Test
    public void testDerivT() throws Exception{
        System.out.print(" Derivate!\n");
        Monom m6 = new Monom(8, 3); Monom m7 = new Monom(5, 0); 
        Polynom expectedResult = new Polynom();
        expectedResult.addMonom(m6); expectedResult.addMonom(m7);
        Polynom GottenResult = this.operatii.deriv(p2);
        
        assertTrue(nbGoodTests.equals(expectedResult));
        nbGoodTests++;
    }
    @org.junit.Test
    public void testDerivF() throws Exception{
        System.out.print(" Derivate!\n");
        Monom m6 = new Monom(8, 3); Monom m7 = new Monom(5, 1); 
        Polynom expectedResult = new Polynom();
        expectedResult.addMonom(m6); expectedResult.addMonom(m7);
        Polynom GottenResult = this.operatii.deriv(p2);
        
        assertFalse(nbGoodTests.equals(expectedResult));
        nbBadTests++;
    }
    @org.junit.Test
    public void testInteT() throws Exception{
        System.out.print(" Integrate!\n");
        Monom m6 = new Monom(0.4, 5); Monom m7 = new Monom(2.5, 2); 
        Polynom expectedResult = new Polynom();
        expectedResult.addMonom(m6); expectedResult.addMonom(m7);
        Polynom GottenResult = this.operatii.inte(p2);
        
        assertTrue(nbGoodTests.equals(expectedResult));
        nbGoodTests++;
    }
    @org.junit.Test
    public void testInteF() throws Exception{
        System.out.print(" Integrate!\n");
        Monom m6 = new Monom(0.4, 5); Monom m7 = new Monom(2.5, 3); 
        Polynom expectedResult = new Polynom();
        expectedResult.addMonom(m6); expectedResult.addMonom(m7);
        Polynom GottenResult = this.operatii.inte(p2);
        
        assertFalse(nbGoodTests.equals(expectedResult));
        nbBadTests++;
    }
}