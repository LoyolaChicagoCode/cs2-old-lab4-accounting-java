package cs271.lab.accounting;

/**
 * An accounting item. Each item has a quantity available and a price. 
 */
public interface Item {

	/**
	 * The current nonnegative quantity of the item available. 
	 * @return the quantity
	 */
	int getQuantity();

	/**
	 * The price of the item.
	 * @return the price
	 */
	double getPrice();

	/**
	 * Reduces the available quantity of the item by the given number.
	 * @param howMany the number by which to reduce the available quantity
	 */
	void reduceQuantityBy(int howMany);
}
