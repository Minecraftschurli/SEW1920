package gburkl;

/**
 * @author Georg Burkl
 * @version 2019-12-10
 */
public interface IStack<T> {
    /**
     * Returns the topmost value from the stack and removes it
     * @return the removed value
     */
    T pop();

    /**
     * Returns the topmost value without removing it
     * @return the topmost value
     */
    T peek();

    /**
     * Adds a new value to the top of the stack
     * @param value the new value
     */
    void push(T value);

    /**
     * Clears the stack
     */
    void clear();
}
