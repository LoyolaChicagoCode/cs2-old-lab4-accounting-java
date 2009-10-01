package cs271.lab.accounting;

/**
 * A very simple accounting ledger.
 */
public interface Ledger {

	/**
	 * Buys the specified quantity of items at the specified price.
	 * @param quantity the quantity
	 * @param price the price
	 */
	void buyItems(int quantity, double price);

	/**
	 * Sells the specified quantity of items and returns
	 * the cost basis of the items 
	 * using the ledger's internal accounting order.
	 * @param quantity the quantity to be sold
	 * @return the cost basis
	 */
	double sellItems(int quantity);

}
