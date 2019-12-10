package gburkl;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Georg Burkl
 * @version 2019-12-10
 */
@SuppressWarnings("unchecked")
public class ArrayStack<T> implements IStack<T>, Iterable<T> {
    private int maxsize;
    private Object[] storage;

    /**
     * Creates a new {@link ArrayStack} with the given maximum size
     * @param maxsize the maximum size of this stack (infinite if 0)
     */
    public ArrayStack(int maxsize) {
        if (maxsize < 0) throw new IllegalArgumentException("No negative values allowed as max size of stack!");
        this.maxsize = maxsize;
        this.clear();
    }

    /**
     * Returns the topmost value from the stack and removes it
     *
     * @return the removed value
     */
    @Override
    public synchronized T pop() {
        T out = (T)storage[storage.length-1];
        this.storage = Arrays.copyOfRange(storage, 0, storage.length-1);
        return out;
    }

    /**
     * Returns the topmost value without removing it
     *
     * @return the topmost value
     */
    @Override
    public T peek() {
        return (T)storage[storage.length-1];
    }

    /**
     * Adds a new value to the top of the stack
     *
     * @param value the new value
     */
    @Override
    public synchronized void push(T value) {
        if (maxsize > 0 && storage.length + 1 > maxsize)
            throw new StackOverflowException("Maximum size of stack reached!");
        storage = Arrays.copyOf(storage, storage.length+1);
        storage[storage.length-1] = value;
    }

    /**
     * Clears the stack
     */
    @Override
    public synchronized void clear() {
        storage = new Object[0];
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return Arrays.asList((T[])storage).iterator();
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        List<T> tmp = Arrays.asList(Arrays.copyOf((T[])storage, storage.length));
        Collections.reverse(tmp);
        return "["+tmp.stream().map(Objects::toString).collect(Collectors.joining(", "))+"]";
    }
}
