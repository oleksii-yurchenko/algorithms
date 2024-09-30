package queue;

public interface CustomQueue {
    void enqueue(int item);
    int dequeue();
    int peek();
    boolean isEmpty();
    boolean isFull();
}
