/**
 * Class MakeQueueApp
 * - instantiates QueueNode objects and adds them to a QueueFifo object
 *      using QueueFifo methods.
 * - test calls QueueFifo methods as unit testing.
 *
 * @author Jan Dwyer
 * @version 1.0     09/02/2017
 */
public class MakeQueueApp {
    public static void main(String args[]){
        System.out.println("in MakeQueueApp.main");

        // test no-args QueueNode constructor.
        QueueNode node01 = new QueueNode();
        node01.setPayload(168);
        // test data QueueNode constructor and setData methods.
        QueueNode node02 = new QueueNode(5);
        QueueNode node03 = new QueueNode(70);
        QueueNode node04 = new QueueNode(54);

        // test no-args QueueFifo constructor, enqueue and dequeue methods.
        QueueFifo firstQueue = new QueueFifo();
        // test queueEmpty method when empty.
        if (firstQueue.queueEmpty()) {
            System.out.println("queue is empty");
        } else {
            System.out.println("queue is NOT empty");
        }   // end if.
        firstQueue.enqueue(node01);
        firstQueue.enqueue(node02);
        firstQueue.enqueue(node03);
        firstQueue.enqueue(node04);
        firstQueue.dequeue();

        // test node QueueFifo constructor.
        QueueFifo nextQueue = new QueueFifo(node01);
        // test queueEmpty method when NOT empty.
        if (nextQueue.queueEmpty()) {
            System.out.println("queue is empty");
        } else {
            System.out.println("queue is NOT empty");
        }   // end if.

    }   // end main
}       // end class
