# Java Array Data Structures

Generic, well-documented array-based data structures in Java.

## Structure
```
src/
├── Main.java               # demo runner
└── array/
    ├── DynamicArray.java   # resizable array
    ├── ArrayStack.java     # stack (LIFO)
    └── ArrayQueue.java     # circular queue (FIFO)
```

## Operations

**DynamicArray**: insert at front / end / index, remove from front / end / index, remove by value, search (`indexOf`, `contains`), `get`, `set`, `clear`

**ArrayStack**: `push`, `pop`, `peek`, `isEmpty`, `isFull`, `size`

**ArrayQueue**: `enqueue`, `dequeue`, `peek`, `isEmpty`, `isFull`, `size`

## Run
```bash
javac -d out $(find src -name "*.java")
java -cp out Main
```

## Time Complexity
| Operation | DynamicArray | ArrayStack | ArrayQueue |
|-----------|--------------|------------|------------|
| Insert at end | O(1) amortized | push O(1) | enqueue O(1) |
| Insert at front / index | O(n) | - | - |
| Remove at end | O(1) | pop O(1) | - |
| Remove at front | O(n) | - | dequeue O(1) |
| Remove at index | O(n) | - | - |
| Search | O(n) | - | - |
