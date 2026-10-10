import array.ArrayQueue;
import array.ArrayStack;
import array.DynamicArray;

/** Demo runner for the array-based data structures. */
public class Main {

    public static void main(String[] args) {
        demoArray();
        demoStack();
        demoQueue();
    }

    private static void demoArray() {
        System.out.println("=== Dynamic Array ===");
        DynamicArray<Integer> arr = new DynamicArray<>();
        arr.insertAtEnd(20);
        arr.insertAtEnd(30);
        arr.insertAtFront(10);
        arr.insertAt(2, 25);
        System.out.println("After inserts  : " + arr);
        System.out.println("Index of 25    : " + arr.indexOf(25));
        arr.removeAt(2);
        arr.removeFromFront();
        arr.removeFromEnd();
        System.out.println("After removals : " + arr);
        System.out.println();
    }

    private static void demoStack() {
        System.out.println("=== Array Stack ===");
        ArrayStack<String> stack = new ArrayStack<>(5);
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack + " | peek = " + stack.peek());
        System.out.println("Popped: " + stack.pop() + " -> " + stack);
        System.out.println();
    }

    private static void demoQueue() {
        System.out.println("=== Array Queue ===");
        ArrayQueue<String> queue = new ArrayQueue<>(5);
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println(queue + " | peek = " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue() + " -> " + queue);
    }
}
