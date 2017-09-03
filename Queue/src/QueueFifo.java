import java.util.ArrayList;

/**
 * Class QueueFifo
 * - queue is first-in, first-out.
 * - contains QueueNode references to head and tail of queue.
 * - contains two constructors.
 * - contains enqueue and dequeue methods.
 *
 * @author Jan Dwyer
 * @version 1.0     09/02/2017
 */
public class QueueFifo {
    private QueueNode head;
    private QueueNode tail;
    // queue should always start empty.
    private int nodeCounter = 0;

    // no-args constructor 1.
    public QueueFifo() {
        System.out.println("in QueueFifo constructor - 1");
    }   // end no-args constructor.

    // constructor 2 takes a QueueNode object.
    public QueueFifo(QueueNode node){
        System.out.println("in QueueFifo constructor - 2");
        System.out.println("node.getPayload(): " + node.getPayload());
        enqueue(node);
    }   // end constructor 2.

    /**
     * method enqueue
     * - takes a QueueNode, adds a new node to existing queue.
     *
     * @param node - the node being added to the queue
     */
    public void enqueue(QueueNode node) {
        System.out.println("in QueueFifo.enqueue");
        System.out.println("node.getPayload(): " + node.getPayload());

        if (nodeCounter == 0) {
            head = node;
            tail = node;
        } else {
            // set newTail to ref for incoming node.
            // also change existing tail ref to incoming node.
            QueueNode newTail = new QueueNode();
            newTail = node;
            tail.setLast(node);
            // replace old value of tail with incoming node.
            tail = newTail;
        }   // end if.
        nodeCounter++;

        // debug.
        System.out.println("after enqueue changes:");
        System.out.println("head.getPayload(): " + head.getPayload());
        System.out.println("tail.getPayload(): " + tail.getPayload());
        System.out.println("nodeCounter: " + nodeCounter);
    }   // end enqueue.

    /**
     * method dequeue()
     * - removes and returns the head object from the queue.
     * - if the current head object is the last in the queue, then
     *      dequeue also sets the boolean queueEmpty value to true.
     *
     * @return QueueNode
     */
    public QueueNode dequeue(){
        System.out.println("in QueueFifo.dequeue");
        System.out.println("head.getPayload(): " + head.getPayload());
        System.out.println("tail.getPayload(): " + tail.getPayload());
        System.out.println("removing head.getPayload(): " + head.getPayload());

        // need placeholder for value of head.last object reference.
        QueueNode currentHeadLast = new QueueNode();
        currentHeadLast = head.getLast();

        // re-set new head to the object referenced by the current head.
        // the instance that is the current head is still out there, but the
        //      reference to it in the queue will be gone.
        // the tail of the queue (where new ones are inserted) is untouched
        //      by the dequeue process.
        head = currentHeadLast;
        nodeCounter--;

        // debug.
        System.out.println("after dequeue changes:");
        System.out.println("head.getPayload(): " + head.getPayload());
        System.out.println("tail.getPayload(): " + tail.getPayload());
        System.out.println("nodeCounter: " + nodeCounter);

        return head;
    }   // end dequeue.

    /**
     * method queueEmpty returns true when nodeCounter is zero.
     * @return boolean
     */
    public boolean queueEmpty() {
        return (nodeCounter == 0);
    }   // end queueEmpty.
}       // end class
