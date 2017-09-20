import junit.framework.TestCase;

public class LLNodeTest extends TestCase {
    public void testSetPayload() throws Exception {
        LLNode listNode5 = new LLNode();
        listNode5.setPayload("Malachite");
        assertEquals(listNode5.getPayload(), "Malachite");
    }

    public void testGetPayload() throws Exception {
        LLNode listNode2 = new LLNode("Tourmaline");
        assertEquals(listNode2.getPayload(), "Tourmaline");
    }

    public void testSetLast() throws Exception {
        LLNode listNode1 = new LLNode();
        LLNode listNode2 = new LLNode("Tourmaline");
        listNode2.setLast(listNode1);
        assertEquals(listNode2.getLast(), listNode1);
    }

    public void testGetLast() throws Exception {
        LLNode listNode1 = new LLNode();
        LLNode listNode2 = new LLNode("Tourmaline");
        listNode2.setLast(listNode1);
        assertEquals(listNode2.getLast(), listNode1);
    }

    public void testSetNext() throws Exception {
        LLNode listNode6 = new LLNode("Aquamarine");
        LLNode listNode7 = new LLNode("Peridot");
        listNode6.setNext(listNode7);
        assertEquals(listNode6.getNext(), listNode7);
    }

    public void testGetNext() throws Exception {
        LLNode listNode6 = new LLNode("Aquamarine");
        LLNode listNode7 = new LLNode("Peridot");
        listNode6.setNext(listNode7);
        assertEquals(listNode6.getNext(), listNode7);
    }
}