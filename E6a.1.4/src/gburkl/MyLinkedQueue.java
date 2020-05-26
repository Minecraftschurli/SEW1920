package gburkl;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Georg Burkl
 * @version 2020-02-23
 */
public class MyLinkedQueue<E> implements MyQueue<E>, Iterable<E> {
    private Cell front, rear;
    private int count;

    /**
     * append an element at the end of the queue
     *
     * @param element the element to append
     * @return the queue
     */
    @Override
    public synchronized MyQueue<E> append(E element) {
        Cell newCell = new Cell(element);
        if (isEmpty()){
            front = newCell;
            rear = newCell;
            front.next = rear;
            count = 1;
            return this;
        }
        if (rear != null)
            rear.next = newCell;
        rear = newCell;
        count++;
        return this;
    }

    /**
     * remove the first element
     *
     * @return the value
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public synchronized E delete() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();
        E val = front.value;
        front = front.next;
        count--;
        return val;
    }

    /**
     * count the elements of the queue
     *
     * @return size
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * is the queue empty?
     *
     * @return true or false
     */
    @Override
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * show the value of the first element
     *
     * @return the value of the first element
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public E peek() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();
        return front.value;
    }

    /**
     * show the value of the last element
     *
     * @return the value of the last element
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public E peekLast() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException();
        return rear.value;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class Cell {
        private final E value;
        private Cell next;

        Cell(E value){
            this.value = value;
        }
    }

    private class MyIterator implements Iterator<E> {
        private Cell pointer, prev;
        private boolean begin = true, removable = false;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return pointer == null || pointer.next != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            prev = pointer;
            if (begin) {
                begin = false;
                pointer = front;
            } else {
                pointer = pointer.next;
            }
            removable = true;
            return pointer.value;
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.
         * <p>
         * The behavior of an iterator is unspecified if the underlying collection
         * is modified while the iteration is in progress in any way other than by
         * calling this method, unless an overriding class has specified a
         * concurrent modification policy.
         * <p>
         * The behavior of an iterator is unspecified if this method is called
         * after a call to the {@link #forEachRemaining forEachRemaining} method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         */
        @Override
        public void remove() {
            if (removable) {
                removable = false;
                if (prev == null)
                    front = pointer.next;
                else
                    prev.next = pointer.next;
                count--;
            } else {
                throw new IllegalStateException();
            }
        }
    }
}
