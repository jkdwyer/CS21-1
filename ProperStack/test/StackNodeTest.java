import junit.framework.TestCase;

public class StackNodeTest extends TestCase {
    public void testSetPayload() throws Exception {
        StackNode n = new StackNode();
        n.setPayload(42);
        assertEquals(n.getPayload(), 42);
    }

    public void testGetPayload() throws Exception {
        StackNode n = new StackNode();
        n.setPayload(42);
        assertEquals(n.getPayload(), 42);
    }

    public void testSetLast() throws Exception {
        StackNode n = new StackNode();
        StackNode n2 = new StackNode();
        n.setLast(n2);
        assertEquals(n.getLast(), n2);
    }

    public void testGetLast() throws Exception {
        StackNode n = new StackNode();
        StackNode n2 = new StackNode();
        n.setLast(n2);
        assertEquals(n.getLast(), n2);
    }

}