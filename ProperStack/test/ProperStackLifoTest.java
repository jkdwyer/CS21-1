import junit.framework.TestCase;

public class ProperStackLifoTest extends TestCase {
    public void testStackEmptyTrue() throws Exception {
        ProperStackLifo p = new ProperStackLifo();
        assertEquals(p.stackEmpty(), true);
    }

    public void testStackEmptyFalse() throws Exception {
        ProperStackLifo p = new ProperStackLifo();
        StackNode n = new StackNode();
        p.stackPush(n);
        assertEquals(p.stackEmpty(), false);
    }

    public void testStackPush() throws Exception {
        ProperStackLifo p = new ProperStackLifo();
        StackNode n = new StackNode();
        p.stackPush(n);
        assertEquals(p.getNodeCounter(), 1);
    }

    public void testStackPop() throws Exception {
        ProperStackLifo p = new ProperStackLifo();
        StackNode n1 = new StackNode();
        p.stackPush(n1);
        assertEquals(p.getNodeCounter(), 1);
        StackNode n2 = p.stackPop();
        assertEquals(p.getNodeCounter(), 0);
        assertEquals(n1, n2);
        // validates that n1 and n2 are equivalent.
        // validates that n2 was assigned a value.
        assertNotNull(n2);
        // validates that n2 is not null after pop.
        // below tests last un-covered line.
        StackNode n3 = new StackNode();
        StackNode n4 = new StackNode();
        p.stackPush(n3);
        p.stackPush(n4);
        StackNode n5 = p.stackPop();
        assertEquals(p.getNodeCounter(), 1);
        assertEquals(n4, n5);
    }

    public void testGetHead() throws Exception {
        ProperStackLifo p = new ProperStackLifo();
        StackNode n1 = new StackNode();
        StackNode n2 = new StackNode();
        p.stackPush(n1);
        p.stackPush(n2);
        StackNode n3 = p.getHead();
        assertEquals(n2, n3);
        assertNotNull(n3);
    }

}