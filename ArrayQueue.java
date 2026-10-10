package datastructures;

import java.util.NoSuchElementException;

/**
 * Fixed-capacity circular queue (FIFO) backed by an array.
 *
 * @param <T> element type
 */
public class ArrayQueue<T> {

    private final Object[] data;
    private int front;
    private int size;

    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive: " + capacity);
        }
        this.data = new Object[capacity];
    }

    /** Adds an element at the rear. O(1). */
    public void enqueue(T element) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full: capacity " + data.length);
        }
        int rear = (front + size) % data.length;
        data[rear] = element;
        size++;
    }

    /** Removes and returns the front element. O(1). */
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T value = (T) data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return value;
    }

    /** Returns the front element without removing it. O(1). */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return (T) data[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("front -> [");
        for (int i = 0; i < size; i++) {
            sb.append(data[(front + i) % data.length]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        return sb.append("] <- rear").toString();
    }
}
