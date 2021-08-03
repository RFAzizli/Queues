package Queues;

public interface Queue {
    /*
        insert(Object item) - inserts an item in the queue, if possible, returns true, otherwise false
     */
    boolean insert(Object item);
    /*
        remove() - removes the first object from the queue
     */
    Object remove();
    /*
        peek() - returns the first object from the queue
     */
    Object peek();
    /*
        isEmpty() - checks if the queue is empty
     */
    boolean isEmpty();
    /*
        isFull() - checks if the queue is full
     */
    boolean isFull();
}
