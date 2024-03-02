/**
 * File name: YourPurchases.java
 * Author: Liying Guo, 040858257
 * Course: CST8284 OOP
 * Assignment: Lab 4
 * Date: 2023-10-11
 * Professor: Sandra Iroakazi
 * Purpose: The class serves as casher calculator
 * to sums up the sales and then computes the change
 * on given dollar,quarters, dimes, nickels, and pennies
 */
package lab4;


/**
 * This class is named YourPurchases Class. 
 * It serves as casher calculator
 * to sums up the sales and then computes the change
 * on given dollar,quarters, dimes, nickels, and pennies
 * 
 * @author Liying Guo
 * @version 1.0
 * @since 2023-10-07
 */
public class YourPurchases
{

	// Canadian money is expressed as "dollars".
	// A dollar has 100 "cents".
	// All values are expressed as dollars in this code.
	// There is a one-dollar coin nicknamed the "loonie".

	/** The 25-cent coin is a quarter */
	public static final double QUARTER_VALUE = 0.25;

	/** A 10-cent coin is called a dime. */
	public static final double DIME_VALUE = 0.1;
	
	/** A 5-cent coin is called a dime. */
	public static final double NICKEL_VALUE = 0.05;
	
	/** A 1-cent coin is called a penny.*/
	public static final double PENNY_VALUE = 0.01;

	/** the amount of purchases*/
	private double purchase;
	/** amount of payments*/
	private double payment;

	/**
	 * Constructs a cash register - your purchases- with no money in it.
	 */
	public YourPurchases()
	{
		//initial purchase to 0
		purchase = 0;
		//initial payment to 0
		payment = 0;
	}

	/**
	 * Returns the amount of purchases.
	 * 
	 * @return amount of purchases
	 */
	public double getPurchase()
	{
		return purchase;

	}

	/**
	 * Returns the amount of payment.
	 * 
	 * @return amount of payments
	 */
	public double getPayment()
	{
		return payment;

	}

	/**
	 * Records the purchase price of an item.
	 * 
	 * @param amount the price of the purchased item
	 */
	public void recordPurchase(double amount)
	{
		//calculate new purchase total by adding up given amount
		purchase = purchase + amount;

	}

	/**
	 * Enters the payment received from the customer.
	 * This calculates payment based on the following formula:
	 * dollars + quarters * QUARTER_VALUE + dimes * DIME_VALUE + nickels * NICKEL_VALUE
	 *			+ pennies * PENNY_VALUE;
	 * @param dollars  the number of dollars in the payment
	 * @param quarters the number of quarters in the payment
	 * @param dimes    the number of dimes in the payment
	 * @param nickels  the number of nickels in the payment
	 * @param pennies  the number of pennies in the payment
	 */
	public void receivePayment(int dollars, int quarters, int dimes, int nickels, int pennies)
	{
		//calculate payment with equation
		payment = dollars + quarters * QUARTER_VALUE + dimes * DIME_VALUE + nickels * NICKEL_VALUE
				+ pennies * PENNY_VALUE;
	}

	/**
	 * Computes and returns the change due. This calculates the change as payment
	 * minus the purchases
	 * 
	 * @return the change due to the customer
	 */
	public double CalculateChange()
	{
		//calculates the change as payment minus the purchases
		double change = payment - purchase;

		return change;
	}

	/**
	 * Computes the change due and resets the machine for the next customer.
	 * 
	 * @return the change due to the customer
	 */
	public double giveChange()
	{
		//calculate the change
		double change = payment - purchase;
		//reset purchase
		purchase = 0;
		//reset payment
		payment = 0;
		return change;
	}
}
