package cs271.lab.accounting;

/**
 * The default implementation of an accounting item.
 */
public class DefaultItem implements Item {

	private double price;

	private int quantity;

	/**
	 * Creates an accounting item with the given quantity and price. 
	 * @param quantity the quantity
	 * @param price the price
	 */
	public DefaultItem(final int quantity, final double price) {
		if (quantity < 0)
			throw new IllegalArgumentException("quantity < 0");
		if (price < 0)
			throw new IllegalArgumentException("price < 0");
		this.quantity = quantity;
		this.price = price;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	@Override
	public void reduceQuantityBy(final int howMany) {
		if (this.quantity < howMany)
			throw new IllegalArgumentException("quantity not available: " + howMany);
		this.quantity -= howMany;
	}
}
