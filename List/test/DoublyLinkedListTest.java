import junit.framework.TestCase;

public class DoublyLinkedListTest extends TestCase {
    private String after;
    private String before;
    private int position = 0;
    private LLNode listNode0;
    private LLNode listNode1;
    private LLNode listNode2;
    private LLNode listNode3;
    private LLNode listNode4;
    private LLNode listNode5;
    private LLNode listNode6;
    private LLNode listNode7;
    private LLNode listNode8;
    private LLNode listNode9;
    private DoublyLinkedList dlList;

    public void setUp() {
        after = "after";
        before = "before";
        listNode1 = new LLNode();
        listNode2 = new LLNode("Tourmaline");
        listNode3 = new LLNode("Jade");
        listNode4 = new LLNode("Olivine");
        listNode5 = new LLNode("Malachite");
        listNode6 = new LLNode("Aquamarine");
        listNode7 = new LLNode("Peridot");
        listNode8 = new LLNode("Gaspeite");
        listNode9 = new LLNode("Amazonite");
        dlList = new DoublyLinkedList();    // for searches and gets only.
        dlList.insertNewHead(listNode1);    // tail.
        dlList.insertNewHead(listNode2);
        dlList.insertNewHead(listNode3);
        dlList.insertNewHead(listNode4);
        dlList.insertNewHead(listNode5);    // last inserted is head.
    }

    public void testPrintList() throws Exception {
        // Can verify that the call produces the expected string
        //  but I've done that below in testCreatePrintList.
    }

    public void testCreatePrintList() throws Exception {
        // start fresh list per test.
        DoublyLinkedList dlList = new DoublyLinkedList();
        dlList.insertNewHead(listNode1);    // tail.
        dlList.insertNewHead(listNode2);
        dlList.insertNewHead(listNode3);
        dlList.insertNewHead(listNode4);
        dlList.insertNewHead(listNode5);    // last inserted is head.
        StringBuffer actualList = new StringBuffer();
        actualList.append("\n");
        actualList.append("ct: 1 - payload: Malachite");
        actualList.append("\n");
        actualList.append("ct: 2 - payload: Olivine");
        actualList.append("\n");
        actualList.append("ct: 3 - payload: Jade");
        actualList.append("\n");
        actualList.append("ct: 4 - payload: Tourmaline");
        actualList.append("\n");
        actualList.append("ct: 5 - payload: Emerald");
        actualList.append("\n");
        actualList.append("\n");
        StringBuffer returnedList = dlList.createPrintList();
        assertTrue(returnedList.toString().equals(actualList.toString()));
    }

    public void testInsertNodeListEmpty() throws Exception {
        // needs to begin with an empty list.
        DoublyLinkedList dlList2 = new DoublyLinkedList();
        dlList2.insertNode(listNode9, listNode1, after);
        assertEquals(dlList2.getHead(), listNode9);
        assertEquals(dlList2.getTail(), listNode9);
        assertEquals(dlList2.getNodeCounter(), 1);
    }

    public void testInsertNodeBeforeHead() throws Exception {
        // start fresh list per test.
        DoublyLinkedList dlList = new DoublyLinkedList();
        dlList.insertNewHead(listNode1);    // tail.
        dlList.insertNewHead(listNode2);
        dlList.insertNewHead(listNode3);
        dlList.insertNewHead(listNode4);
        dlList.insertNewHead(listNode5);    // last inserted is head.
        // insert L8 Gaspeite before L5 Malachite (head)
        assertEquals(dlList.getHead(), listNode5);
        dlList.insertNode(listNode8, listNode5, before);
        // new head; next and last changes for L8, L5.
        assertEquals(dlList.getHead(), listNode8);
        assertNull(listNode8.getLast());
        assertEquals(listNode8.getNext(), listNode5);
        assertEquals(listNode5.getLast(), listNode8);
    }

    public void testInsertNodeBeforeNotHead() throws Exception {
        // start fresh list per test.
        DoublyLinkedList dlList = new DoublyLinkedList();
        dlList.insertNewHead(listNode1);    // tail.
        dlList.insertNewHead(listNode2);
        dlList.insertNewHead(listNode3);
        dlList.insertNewHead(listNode4);
        dlList.insertNewHead(listNode5);    // last inserted is head.
        // insert L6 Aquamarine before L2 Tourmaline
        dlList.insertNode(listNode6, listNode2, before);
        // next and last changes for L2, L6, L3.
        assertEquals(listNode2.getLast(), listNode6);
        assertEquals(listNode6.getNext(), listNode2);
        assertEquals(listNode6.getLast(), listNode3);
        assertEquals(listNode3.getNext(), listNode6);
    }

    public void testInsertNodeAfterTail() throws Exception {
        // start fresh list per test.
        DoublyLinkedList dlList = new DoublyLinkedList();
        dlList.insertNewHead(listNode1);    // tail.
        dlList.insertNewHead(listNode2);
        dlList.insertNewHead(listNode3);
        dlList.insertNewHead(listNode4);
        dlList.insertNewHead(listNode5);    // last inserted is head.
        // insert L9 Amazonite after L1 Emerald (tail)
        assertEquals(dlList.getTail(), listNode1);
        dlList.insertNode(listNode9, listNode1, after);
        assertEquals(dlList.getTail(), listNode9);
        assertNull(listNode9.getNext());
        assertEquals(listNode9.getLast(), listNode1);
        assertEquals(listNode1.getNext(), listNode9);
    }

    public void testInsertNodeAfterNotTail() throws Exception {
        // start fresh list per test.
        DoublyLinkedList dlList = new DoublyLinkedList();
        dlList.insertNewHead(listNode1);    // tail.
        dlList.insertNewHead(listNode2);
        dlList.insertNewHead(listNode3);
        dlList.insertNewHead(listNode4);
        dlList.insertNewHead(listNode5);    // last inserted is head.
        // insert L7 Peridot after L2 Tourmaline
        dlList.insertNode(listNode7, listNode2, after);
        // next and last changes for L2, L7, L1.
        assertEquals(listNode2.getNext(), listNode7);
        assertEquals(listNode7.getLast(), listNode2);
        assertEquals(listNode7.getNext(), listNode1);
        assertEquals(listNode1.getLast(), listNode7);
    }

    public void testInsertNewHead() throws Exception {
        // start fresh list.
        DoublyLinkedList dlList3 = new DoublyLinkedList();
        dlList3.insertNewHead(listNode1);    // tail.
        assertEquals(dlList3.getHead(), listNode1);
        assertEquals(dlList3.getTail(), listNode1);
        dlList3.insertNewHead(listNode2);
        assertEquals(dlList3.getHead(), listNode2);
        assertEquals(dlList3.getTail(), listNode1);
        dlList3.insertNewHead(listNode3);
        dlList3.insertNewHead(listNode4);
        dlList3.insertNewHead(listNode5);    // last inserted is head.
        assertEquals(dlList3.getHead(), listNode5);
        assertEquals(dlList3.getTail(), listNode1);
    }

    public void testDeleteNodeListEmpty() throws Exception {
        // needs to begin with an empty list.
        DoublyLinkedList dlList2 = new DoublyLinkedList();
        dlList2.deleteNode(listNode1);
    }

    public void testDeleteNodeHead() throws Exception {
        // start fresh list per test.
        DoublyLinkedList dlList = new DoublyLinkedList();
        dlList.insertNewHead(listNode1);    // tail.
        dlList.insertNewHead(listNode2);
        dlList.insertNewHead(listNode3);
        dlList.insertNewHead(listNode4);
        dlList.insertNewHead(listNode5);
        dlList.insertNewHead(listNode8);    // last inserted is head.
        // delete L8 Gaspeite (head)
        assertEquals(dlList.getHead(), listNode8);
        dlList.deleteNode(listNode8);
        assertEquals(dlList.getHead(), listNode5);
        assertNull(listNode5.getLast());
    }

    public void testDeleteNodeTail() throws Exception {
        // start fresh list per test.
        DoublyLinkedList dlList = new DoublyLinkedList();
        dlList.insertNewHead(listNode9);    // tail.
        dlList.insertNewHead(listNode1);
        dlList.insertNewHead(listNode2);
        dlList.insertNewHead(listNode3);
        dlList.insertNewHead(listNode4);
        dlList.insertNewHead(listNode5);    // last inserted is head.
        // delete L9 Amazonite (tail)
        assertEquals(dlList.getTail(), listNode9);
        dlList.deleteNode(listNode9);
        assertEquals(dlList.getTail(), listNode1);
        assertNull(listNode1.getNext());
    }

    public void testDeleteNode() throws Exception {
        // start fresh list per test.
        DoublyLinkedList dlList = new DoublyLinkedList();
        dlList.insertNewHead(listNode1);    // tail.
        dlList.insertNewHead(listNode2);
        dlList.insertNewHead(listNode3);
        dlList.insertNewHead(listNode4);
        dlList.insertNewHead(listNode5);    // last inserted is head.
        // delete L3 Jade (between L4 Olivine and L2 Tourmaline)
        assertEquals(listNode4.getNext(), listNode3);
        assertEquals(listNode2.getLast(), listNode3);
        dlList.deleteNode(listNode3);
        assertEquals(listNode4.getNext(), listNode2);
        assertEquals(listNode2.getLast(), listNode4);
    }

    public void testSearchByNode() throws Exception {
        // uses private dlList initialized with 5 values.
        position = dlList.searchByNode(listNode5);
        assertEquals(position, 1);
        position = dlList.searchByNode(listNode4);
        assertEquals(position, 2);
        position = dlList.searchByNode(listNode3);
        assertEquals(position, 3);
        position = dlList.searchByNode(listNode2);
        assertEquals(position, 4);
        position = dlList.searchByNode(listNode1);
        assertEquals(position, 5);
    }

    public void testSearchByPosition() throws Exception {
        // uses private dlList initialized with 5 values.
        listNode0 = dlList.searchByPosition(1);
        assertEquals(listNode0, listNode5);
        listNode0 = dlList.searchByPosition(2);
        assertEquals(listNode0, listNode4);
        listNode0 = dlList.searchByPosition(3);
        assertEquals(listNode0, listNode3);
        listNode0 = dlList.searchByPosition(4);
        assertEquals(listNode0, listNode2);
        listNode0 = dlList.searchByPosition(5);
        assertEquals(listNode0, listNode1);
        listNode0 = dlList.searchByPosition(6);
        assertNull(listNode0);
    }

    public void testGetHead() throws Exception {
        // uses private dlList initialized with 5 values.
        assertEquals(dlList.getHead(), listNode5);
    }

    public void testGetTail() throws Exception {
        // uses private dlList initialized with 5 values.
        assertEquals(dlList.getTail(), listNode1);
    }

    public void testGetNodeCounter() throws Exception {
        // uses private dlList initialized with 5 values.
        assertEquals(dlList.getNodeCounter(), 5);
    }

    public void testListEmptyTrue() throws Exception {
        // needs to begin with an empty list.
        DoublyLinkedList dlList2 = new DoublyLinkedList();
        assertEquals(dlList2.listEmpty(), true);
    }

    public void testListEmptyFalse() throws Exception {
        // uses private dlList initialized with 5 values.
        assertEquals(dlList.listEmpty(), false);
    }

}