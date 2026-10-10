package datastructures;

import java.util.NoSuchElementException;

/**
 * A resizable array-backed list supporting insertion, deletion and search
 * at the front, end, or any index.
 *
 * @param <T> element type
 */
public class DynamicArray<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] data;
    private int size;

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive: " + capacity);
        }
        this.data = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // ---------- Insert operations ----------

    /** Inserts at the front. O(n) because elements are shifted right. */
    public void insertAtFront(T element) {
        insertAt(0, element);
    }

    /** Inserts at the end. Amortized O(1). */
    public void insertAtEnd(T element) {
        insertAt(size, element);
    }

    /** Inserts at the given index (0..size). O(n). */
    public void insertAt(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    // ---------- Delete operations ----------

    /** Removes and returns the first element. */
    public T removeFromFront() {
        requireNonEmpty();
        return removeAt(0);
    }

    /** Removes and returns the last element. O(1). */
    public T removeFromEnd() {
        requireNonEmpty();
        return removeAt(size - 1);
    }

    /** Removes and returns the element at the given index. O(n). */
    @SuppressWarnings("unchecked")
    public T removeAt(int index) {
        checkIndex(index);
        T removed = (T) data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null; // avoid memory leak
        return removed;
    }

    /** Removes the first occurrence of the value. Returns true if found. */
    public boolean removeByValue(T element) {
        int index = indexOf(element);
        if (index == -1) {
            return false;
        }
        removeAt(index);
        return true;
    }

    // ---------- Search / access ----------

    /** Linear search. Returns index of first match or -1. */
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (element == null ? data[i] == null : element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    public void set(int index, T element) {
        checkIndex(index);
        data[index] = element;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    // ---------- Helpers ----------

    private void ensureCapacity() {
        if (size == data.length) {
            Object[] bigger = new Object[data.length * 2];
            System.arraycopy(data, 0, bigger, 0, size);
            data = bigger;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void requireNonEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Array is empty");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }
}
