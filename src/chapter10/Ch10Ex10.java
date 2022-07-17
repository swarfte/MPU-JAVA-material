package chapter10;

/**
 * @author swarfte
 * @title The Queue class
 */
public class Ch10Ex10 {
    public static void main(String[] args) {
        Queue queue = new Queue();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);

        }

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
    }
}

/**
 * UML diagram
 * <p>
 * Queue
 * <p>
 * - element: int[]
 * <p>
 * - size: int
 * <p>
 * + Queue()
 * <p>
 * + enqueue(v: int): void
 * <p>
 * + dequeue(): int
 * <p>
 * + empty(): boolean
 * <p>
 * + getSize(): int
 */

class Queue {
    private int[] element;
    private int size;

    public Queue() {
        element = new int[8];
        size = 0;
    }

    public void enqueue(int v) {
        if (size >= element.length) {
            int[] newElement = new int[element.length * 2];
            System.arraycopy(element, 0, newElement, 0, element.length);
            element = newElement;
        }
        element[size] = v;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        int v = element[0];
        if (size - 1 >= 0) {
            // copy the old array from index 1 to end to the new array
            System.arraycopy(element, 1, element, 0, size - 1);
        }
        size--;
        return v;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}
