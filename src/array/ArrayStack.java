package datastructures;

import java.util.EmptyStackException;

/**
 * Fixed-capacity stack (LIFO) backed by an array.
 *
 * @param <T> element type
 */
public class ArrayStack<T> {

    private final Object[] data;
    private int top = -1;

    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive: " + capacity);
        }
        this.data = new Object[capacity];
    }

    /** Pushes an element on top. O(1). */
    public void push(T element) {
        if (isFull()) {
            throw new IllegalStateException("Stack overflow: capacity " + data.length);
        }
        data[++top] = element;
    }

    /** Removes and returns the top element. O(1). */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = (T) data[top];
        data[top--] = null;
        return value;
    }

    /** Returns the top element without removing it. O(1). */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public int size() {
        return top + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(data[i]);
            if (i < top) {
                sb.append(", ");
            }
        }
        return sb.append("] <- top").toString();
    }
}
