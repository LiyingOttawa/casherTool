/**
 * File name: YourPurchasesTest.java
 * Author: Liying Guo, 040858257
 * Course: CST8284 OOP
 * Assignment: Lab 4
 * Date: 2023-10-15
 * Professor: Sandra Iroakazi
 * Purpose: The program class to test on YourPurchases.java;
 * To have 100% coverage, I create a test per method
 */

package lab4;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the JUnit testing class to test on YourPurchases.java;
 * To have 100% coverage, it test every method including following list:
 * 1. calculateChange()
 * 2. getPurchase()
 * 3. getPayment()
 * 4. recordPurchase()
 * 5. receivePayment()
 * 6. giveChange()
 * @author Liying Guo
 * @version 1.0
 * @since 2023-10-07
 */
public class YourPurchasesTest {

    /**the maximum delta between expected and actual for which both numbers are still considered equal*/
	private static final double EPSILON = 1E-12;
	 
	/**
	 * test on method calculateChange()
	 * purchase:1.5
	 * payment:5 dollar, 0 quarters, 0 dimes, 0 nickels, 0 pennies
	 * expected result: 3.5 = 5.0-1.5
	 * */
	@Test
	public void testCalculateChange() {
		YourPurchases aPurchase = new YourPurchases();
		aPurchase.recordPurchase(1.5);
		aPurchase.receivePayment(5, 0, 0, 0, 0); //Five dollars of payment.
		double changeResult = aPurchase.CalculateChange();
		double expected = 3.50; //Expecting 3.5 dollars of change.
	    Assert.assertEquals(expected, changeResult, EPSILON);
	}
	
	/**
	 * test on method getPurchase()
	 * purchase:1.5
	 * expected result: 1.5
	 * */
	@Test
	public void testGetPurchase() {
		YourPurchases aPurchase = new YourPurchases();
		aPurchase.recordPurchase(1.5);
		Assert.assertEquals(1.5,aPurchase.getPurchase(),EPSILON);		
	}
	
	/**
	 * test on method getPayment()
	 * payment:1 dollar, 2 quarters, 3 dimes, 4 nickels, 5 pennies
	 * expected result: 2.05 = 1 + 2 * 0.25 + 3 * 0.1 + 4 * 0.05
				+ 5 * 0.01;
	 * */
	@Test
	public void testGetPayment() {
		YourPurchases aPurchase = new YourPurchases();
		aPurchase.receivePayment(1, 2, 3, 4, 5);
		Assert.assertEquals(2.05,aPurchase.getPayment(),EPSILON);
	}
	
	/**
	 * test on method recordPurchase()
	 * first purchase:1
	 * second purchase:1.5
	 * expected result: 2.5 = 1+1.5
	 * */
	@Test
	public void testRecordPurchase() {
		YourPurchases aPurchase = new YourPurchases();
		aPurchase.recordPurchase(1);
		aPurchase.recordPurchase(1.5);
		Assert.assertEquals(2.5,aPurchase.getPurchase(),EPSILON);
	}
	
	/**
	 * test on method receivePayment()
	 * payment:5 dollar, 4 quarters, 3 dimes, 2 nickels, 1 pennies
	 * expected result: 6.41 = 5 + 4 * 0.25 + 3 * 0.1 + 2 * 0.05
				+ 1 * 0.01;
	 * */
	@Test
	public void testReceivePayment() {
		YourPurchases aPurchase = new YourPurchases();
		aPurchase.receivePayment(5, 4, 3, 2, 1);
		Assert.assertEquals(6.41,aPurchase.getPayment(),EPSILON);
	}
	
	
	/**
	 * test on method giveChange()
	 * purchase:2.5
	 * payment:5 dollar, 4 quarters, 3 dimes, 2 nickels, 1 pennies->6.41
	 * change:3.91 = 6.41 - 2.5
	 * purchase after given changes: 0 it is reset
	 * payment after given changes: 0 it is reset
	 * */
	@Test
	public void testGiveChange() {
		YourPurchases aPurchase = new YourPurchases();
		aPurchase.recordPurchase(2.5);
		aPurchase.receivePayment(5, 4, 3, 2, 1);
		double changeResult = aPurchase.giveChange();
		double expected = 3.91; //Expecting 3.5 dollars of change.
	    Assert.assertEquals(expected, changeResult, EPSILON);
		Assert.assertEquals(0,aPurchase.getPurchase(),EPSILON);
		Assert.assertEquals(0
				,aPurchase.getPayment(),EPSILON);

	}
}