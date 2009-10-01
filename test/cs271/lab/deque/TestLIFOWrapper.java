package cs271.lab.deque;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLIFOWrapper {

	private LIFOWrapper<Integer> stack;
	private LinkedList<Integer> list;

	@Before
	public void setUp() throws Exception {
		list = new LinkedList<Integer>();
		stack = new LIFOWrapper<Integer>(list);
	}

	@After
	public void tearDown() throws Exception {
		stack = null;
		list = null;
	}

	@Test
	public void testConstructor() {
		assertTrue(stack.isEmpty());
	}

	@Test
	public void testAdd() {
		stack.add(3);
		stack.add(5);
		final boolean result = stack.add(7);
		assertTrue(result);
		assertFalse(stack.isEmpty());
		assertEquals(3, stack.size());
		assertEquals(7, stack.element());
	}

	@Test
	public void testElementEmpty() {
		try {
			stack.element();
			fail("Expected empty stack exception");
		} catch (final Exception ex) { }
	}

	@Test
	public void testOffer() {
		assertTrue(stack.offer(3));
		assertFalse(stack.isEmpty());
		assertEquals(3, stack.peek());
	}

	@Test
	public void testPeek() {
		stack.add(3);
		stack.add(5);
		stack.add(7);
		assertFalse(stack.isEmpty());
		assertEquals(7, stack.peek());
	}

	@Test
	public void testPollEmpty() {
		assertTrue(stack.isEmpty());
		assertNull(stack.poll());
	}

	@Test
	public void testPollNonempty() {
		stack.add(3);
		stack.add(5);
		stack.add(7);
		assertFalse(stack.isEmpty());
		assertEquals(7, stack.poll());
	}

	@Test
	public void testRemoveEmpty() {
		try {
			stack.remove();
			fail("Expected empty stack exception");
		} catch (final Exception ex) { }
	}

	@Test
	public void testRemoveNonempty() {
		stack.add(3);
		stack.add(5);
		stack.add(7);
		assertFalse(stack.isEmpty());
		assertEquals(3, stack.size());
		assertEquals(7, stack.remove());
		assertFalse(stack.isEmpty());
		assertEquals(2, stack.size());
	}

	@Test
	public void testAddAll() {
		final boolean result = stack.addAll(Arrays.asList(3, 5, 7));
		assertTrue(result);
		assertFalse(stack.isEmpty());
		assertEquals(3, stack.size());
		assertEquals(7, stack.element());
	}

	@Test
	public void testClear() {
		stack.add(3);
		stack.add(5);
		stack.add(7);
		assertFalse(stack.isEmpty());
		stack.clear();
		assertTrue(stack.isEmpty());
	}

	@Test
	public void testContains() {
		stack.add(3);
		stack.add(5);
		stack.add(7);
		assertTrue(stack.contains(5));
		assertFalse(stack.contains(666));
	}

	@Test
	public void testContainsAll() {
		stack.add(3);
		stack.add(5);
		stack.add(7);
		assertTrue(stack.containsAll(Arrays.asList(5, 7)));
		assertFalse(stack.containsAll(Arrays.asList(5, 666)));
		assertFalse(stack.containsAll(Arrays.asList(444, 666)));
	}

	@Test
	public void testIsEmpty() {
		assertTrue(stack.isEmpty());
		stack.add(7);
		assertFalse(stack.isEmpty());
	}

	@Test
	public void testIterator() {
		assertFalse(stack.iterator().hasNext());
		stack.add(7);
		assertTrue(stack.iterator().hasNext());
		assertEquals(7, stack.iterator().next());
	}

	@Test
	public void testRemoveObject() {
		stack.add(3);
		stack.add(5);
		stack.add(7);
		assertEquals(3, stack.size());
		assertFalse(stack.remove(666));
		assertEquals(3, stack.size());
		assertTrue(stack.remove(5));
		assertEquals(2, stack.size());
	}

	@Test
	public void testRemoveAll() {
		stack.add(3);
		stack.add(5);
		stack.add(7);
		assertTrue(stack.removeAll(Arrays.asList(3, 7)));
		assertEquals(1, stack.size());
		assertEquals(5, stack.element());
	}

	@Test
	public void testRetainAll() {
		stack.add(3);
		stack.add(5);
		stack.add(7);
		assertTrue(stack.retainAll(Arrays.asList(3, 7)));
		assertEquals(2, stack.size());
		assertEquals(7, stack.element());
	}

	@Test
	public void testSize() {
		assertEquals(0, stack.size());
		stack.add(3);
		stack.add(5);
		stack.add(7);
		assertEquals(3, stack.size());
	}

	@Test
	public void testToArray() {
		stack.add(3);
		stack.add(5);
		stack.add(7);
		assertEquals(new Object[] { 7, 5, 3 }, stack.toArray());
	}

	@Test
	public void testToArrayTArray() {
		stack.add(3);
		stack.add(5);
		stack.add(7);
		assertEquals(new Integer[] { 7, 5, 3 }, stack.toArray(new Integer[0]));
	}

}
