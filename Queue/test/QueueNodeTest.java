import junit.framework.TestCase;

public class QueueNodeTest extends TestCase {
    public void testSetPayload() throws Exception {
        QueueNode node01 = new QueueNode();
        node01.setPayload(168);
        assertEquals(node01.getPayload(), 168);
    }

    public void testGetPayload() throws Exception {
        QueueNode node02 = new QueueNode(5);
        int payload = node02.getPayload();
        assertEquals(payload, 5);
    }

    public void testSetLast() throws Exception {
        QueueNode node06 = new QueueNode(63);
        QueueNode node07 = new QueueNode(751);
        node06.setLast(node07);
        assertEquals(node06.getLast(), node07);
    }

    public void testGetLast() throws Exception {
        QueueFifo firstQueue = new QueueFifo();
        QueueNode node03 = new QueueNode(70);
        QueueNode node04 = new QueueNode(54);
        firstQueue.enqueue(node03);
        firstQueue.enqueue(node04);
        QueueNode node05 = node04.getLast();
        assertEquals(node04, node05);
    }

}