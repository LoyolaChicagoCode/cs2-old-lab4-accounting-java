package cs271.lab.deque;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/**
 * A wrapper (adapter) for using any implementation of the 
 * {@link java.util.Deque} interface as a LIFO implementation
 * of the {@link java.util.Queue} interface.
 * This allows algorithms to be designed using Queue as the
 * uniform interface for the ordering strategy of the algorithm,
 * with the flexibility of using different concrete ordering
 * strategies such as a (FIFO) queue, a LIFO queue (i.e., a stack),
 * etc. 
 *
 * @param <E> the item type of the queue
 */
public class LIFOWrapper<E> implements Queue<E> {

	private Deque<E> deque;

	/**
	 * Creates a LIFO wrapper around the given deque implementation.
	 * @param deque
	 */
	public LIFOWrapper(final Deque<E> deque) {
		this.deque = deque;
	}

	@Override
	public boolean add(final E item) {
		//this makes the queue LIFO
		deque.addFirst(item);
		return true;
	}

	@Override
	public E element() {
		return deque.element();
	}

	@Override
	public boolean offer(final E item) {
		// TODO implement this method as a forwarding method
		return false;
	}

	@Override
	public E peek() {
		// TODO implement this method as a forwarding method
		return null;
	}

	@Override
	public E poll() {
		// TODO implement this method as a forwarding method
		return null;
	}

	@Override
	public E remove() {
		// TODO implement this method as a forwarding method
		return null;
	}

	@Override
	public boolean addAll(final Collection<? extends E> c) {
	    //addAll doesn't work because it doesn't necessarily
		//invoke the (overridden) add
		//return deque.addAll(c);
		boolean changed = false;
		for (final E item : c)
			if (this.add(item))
				changed = true;
		return changed;
	}

	@Override
	public void clear() {
		// TODO implement this method as a forwarding method
	}

	@Override
	public boolean contains(final Object item) {
		// TODO implement this method as a forwarding method
		return false;
	}

	@Override
	public boolean containsAll(final Collection<?> c) {
		// TODO implement this method as a forwarding method
		return false;
	}

	@Override
	public boolean isEmpty() {
		return deque.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO implement this method as a forwarding method
		return null;
	}

	@Override
	public boolean remove(final Object item) {
		// TODO implement this method as a forwarding method
		return false;
	}

	@Override
	public boolean removeAll(final Collection<?> c) {
		// TODO implement this method as a forwarding method
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO implement this method as a forwarding method
		return false;
	}

	@Override
	public int size() {
		return deque.size();
	}

	@Override
	public Object[] toArray() {
		return deque.toArray();
	}

	@Override
	public <T> T[] toArray(final T[] a) {
		return deque.toArray(a);
	}

}
