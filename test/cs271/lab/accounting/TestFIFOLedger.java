package cs271.lab.accounting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFIFOLedger {

	private Ledger ledger;

	@Before
	public void setUp() throws Exception {
		ledger = new DefaultLedger(new LinkedList<Item>());
	}

	@After
	public void tearDown() throws Exception {
		ledger = null;
	}

	@Test
	public void testNegative() {
		try {
			ledger.sellItems(-50);
			fail("exception expected");
		} catch (final IllegalArgumentException ex) { }
	}

	@Test
	public void testEmpty() {
		try {
			ledger.sellItems(50);
			fail("exception expected");
		} catch (final Exception ex) { }
	}

	@Test
	public void testSingleItemFewer() {
		ledger.buyItems(100, 2);
		assertEquals(100, ledger.sellItems(50));
		assertEquals(100, ledger.sellItems(50));
	}

	@Test
	public void testSingleItemAll() {
		ledger.buyItems(100, 2);
		assertEquals(200.0, ledger.sellItems(100));
	}

	@Test
	public void testSingleItemTooMany() {
		try {
			ledger.buyItems(100, 2);
			ledger.sellItems(300);
			fail("exception expected");
		} catch (final Exception ex) { }
	}

	@Test
	public void testTwoItemsFewer() {
		ledger.buyItems(100, 2);
		ledger.buyItems(100, 3);
		assertEquals(350.0, ledger.sellItems(150), 0.0001);
	}

	@Test
	public void testTwoItemsEnough() {
		ledger.buyItems(100, 2);
		ledger.buyItems(100, 3);
		assertEquals(500, ledger.sellItems(200));
	}

	@Test
	public void testTwoItemsTooMany() {
		try {
			ledger.buyItems(100, 2);
			ledger.sellItems(200);
			fail("exception expected");
		} catch (final Exception ex) { }
	}

	@Test
	public void testTwoItemsTwoSales() {
		ledger.buyItems(100, 2);
		ledger.buyItems(100, 3);
		assertEquals(350, ledger.sellItems(150));
		assertEquals(150, ledger.sellItems(50));
	}

	@Test
	public void testComplex() {
		ledger.buyItems(300, 2.00);
		ledger.buyItems(600, 2.10);
		ledger.buyItems(400, 2.20);
		ledger.buyItems(500, 2.30);
		assertEquals(2520, ledger.sellItems(1200));
	}
}
