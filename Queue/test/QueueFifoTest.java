import junit.framework.TestCase;

public class QueueFifoTest extends TestCase {
    public void testQueueFifo(QueueNode node) {
        QueueNode node04 = new QueueNode(54);
        assertEquals(node04.getPayload(), 54);
    }

    public void testEnqueue() {
        QueueNode node01 = new QueueNode(168);
        QueueNode node02 = new QueueNode(5);
        QueueNode node03 = new QueueNode(70);
        QueueNode node04 = new QueueNode(54);
        QueueFifo firstQueue = new QueueFifo();

        firstQueue.enqueue(node01);
        assertEquals(firstQueue.getHead(), node01);
        assertEquals(firstQueue.getTail(), node01);

        firstQueue.enqueue(node02);
        assertEquals(firstQueue.getHead(), node01);
        assertEquals(firstQueue.getTail(), node02);

        firstQueue.enqueue(node03);
        assertEquals(firstQueue.getHead(), node01);
        assertEquals(firstQueue.getTail(), node03);

        firstQueue.enqueue(node04);
        assertEquals(firstQueue.getHead(), node01);
        assertEquals(firstQueue.getTail(), node04);
    }

    public void testDequeue() {
        QueueNode node01 = new QueueNode(168);
        QueueNode node02 = new QueueNode(5);
        QueueFifo firstQueue = new QueueFifo();

        firstQueue.enqueue(node01);
        assertEquals(firstQueue.getHead(), node01);
        assertEquals(firstQueue.getTail(), node01);

        firstQueue.enqueue(node02);
        assertEquals(firstQueue.getHead(), node01);
        assertEquals(firstQueue.getTail(), node02);

        QueueNode node05 = firstQueue.dequeue();
        assertEquals(node05, node02);
        assertEquals(firstQueue.getHead(), node02);
        assertEquals(firstQueue.getTail(), node02);
    }

    public void testQueueEmptyTrue() {
        // test no-args QueueNode constructor.
        QueueNode node01 = new QueueNode();
        node01.setPayload(168);
        QueueNode node02 = new QueueNode(5);
        QueueNode node03 = new QueueNode(70);
        QueueNode node04 = new QueueNode(54);
        QueueFifo firstQueue = new QueueFifo();
        assertEquals(firstQueue.queueEmpty(),true);
    }

    public void testQueueEmptyFalse() {
        QueueNode node02 = new QueueNode(5);
        QueueFifo firstQueue = new QueueFifo();
        firstQueue.enqueue(node02);
        assertEquals(firstQueue.queueEmpty(),false);
    }

    public void testGetHead() {
        QueueNode node01 = new QueueNode(168);
        QueueNode node02 = new QueueNode(5);
        QueueFifo firstQueue = new QueueFifo();
        firstQueue.enqueue(node01);
        firstQueue.enqueue(node02);
        // first-in, first-out.
        assertEquals(firstQueue.getHead(), node01);
    }

    public void testGetTail() {
        QueueNode node01 = new QueueNode(168);
        QueueNode node02 = new QueueNode(5);
        QueueFifo firstQueue = new QueueFifo();
        firstQueue.enqueue(node01);
        firstQueue.enqueue(node02);
        // first-in, first-out.
        assertEquals(firstQueue.getTail(), node02);
    }

    public void testGetNodeCounter() {
        QueueFifo firstQueue = new QueueFifo();
        assertEquals(firstQueue.getNodeCounter(), 0);

        QueueNode node01 = new QueueNode(168);
        firstQueue.enqueue(node01);
        assertEquals(firstQueue.getNodeCounter(), 1);

        QueueNode node02 = new QueueNode(5);
        firstQueue.enqueue(node02);
        assertEquals(firstQueue.getNodeCounter(), 2);
    }

}