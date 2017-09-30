/**
 * class DoublyLinkedList
 * - contains references to LLNode objects at head and tail of List.
 *
 * @author Jan Dwyer
 * @version 1.1     09/20/2017
 */
public class DoublyLinkedList {
    private LLNode head;
    private LLNode tail;
    private int nodeCounter = 0;

    // no-args constructor.
    public DoublyLinkedList() {
    }   // end constructor.

    /**
     * method printList
     * - prints entire contents of current list, one line per element.
     */
    public void printList() {
        StringBuffer list = createPrintList();
        System.out.println(list);
    }   // end printList.

    /**
     * method createPrintList
     * - creates and returns a StringBuffer object containing the print string:
     *      the entire contents of current list, one line per element.
     * @return printString      StringBuffer
     */
    public StringBuffer createPrintList() {
        StringBuffer printString = new StringBuffer();
        int ct = 1;
        LLNode node;
        printString.append("\n");
        if (!listEmpty()) {
            while (ct <= nodeCounter) {
                node = searchByPosition(ct);
                printString.append("ct: " + ct + " - payload: " + node.getPayload());
                printString.append("\n");
                ct++;
            }   // end while.
        } else {
            printString.append("List is empty");
        }   // end if/else.
        printString.append("\n");
        return printString;
    }   // end printList.

    /**
     * method insertNode
     * - accepts new LLNode, neighbor LLNode, and before/after value.
     * - adds the new node before or after the neighbor as specified.
     * @param node LLNode
     * @param neighbor LLNode
     * @param ba String
     */
    public void insertNode(LLNode node, LLNode neighbor, String ba) {
        LLNode neighborLast;
        LLNode neighborNext;
        if (nodeCounter == 0) {
            // list was empty, new node becomes head and tail.
            head = node;
            tail = node;
        } else {
            if (ba == "before") {
                if (neighbor != head) {
                    node.setNext(neighbor);
                    neighborLast = neighbor.getLast();
                    node.setLast(neighborLast);
                    neighborLast.setNext(node);
                    neighbor.setLast(node);
                } else {
                    // there is no before-partner when neighbor is head.
                    node.setNext(neighbor);
                    neighbor.setLast(node);
                    // node is new head.
                    head = node;
                }   // end if.
            } else {    // after.
                if (neighbor != tail) {
                    node.setLast(neighbor);
                    neighborNext = neighbor.getNext();
                    node.setNext(neighborNext);
                    neighbor.setNext(node);
                    neighborNext.setLast(node);
                } else {
                    // there is no after-partner when neighbor is tail.
                    node.setLast(neighbor);
                    neighbor.setNext(node);
                    // node is new tail.
                    tail = node;
                }   // end if.
            }   // end before or after.
        }   // end if.
        nodeCounter++;
    }   // end insertNode.

    /**
     * method insertNewHead()
     * - accepts a node and adds it to the head (entry-point)
     *      of the List.
     * - ignore this method and code one per WKK description.
     * @param node LLNode
     */
    public void insertNewHead (LLNode node) {
        if (nodeCounter == 0) {
            head = node;
            tail = node;
        } else {
            // set incoming node next-ref to existing head.
            node.setNext(head);
            // set existing head last-ref to incoming node.
            head.setLast(node);
            // set head to incoming node.
            // tail is not affected by insert.
            head = node;
        }   // end if.
        nodeCounter++;
    }   // end insertNewHead.

    /**
     * method deleteNode()
     * - accepts a node, does a search to locate it in list,
     *      and then deletes it by position.
     * @param node
     * @return
     */
    public void deleteNode(LLNode node) {
        LLNode neighbor;
        LLNode beforeNode;
        LLNode afterNode;
        if (!listEmpty()) {
            if (node == head) {
                neighbor = node.getNext();
                // this removes ref to current head.
                neighbor.setLast(null);
                // neighbor becomes the new head.
                head = neighbor;
            } else if (node == tail) {
                neighbor = node.getLast();
                // this removes ref to current tail.
                neighbor.setNext(null);
                // neighbor becomes the new tail.
                tail = neighbor;
            } else {
                beforeNode = node.getLast();
                afterNode = node.getNext();
                // this removes node from the list.
                beforeNode.setNext(afterNode);
                afterNode.setLast(beforeNode);
            }   // end conditions.
            // reduce the node count in the list.
            nodeCounter--;
        }   // end list not empty.
    }   // end deleteNode.

    /**
     * method searchByNode()
     * - accepts LLNode
     * - then does a search to locate that value in the list
     *      and return a int position value.
     * - will return a -1 when the list is empty, or when
     *      the node is not found in the list.
     * @param node          LLNode
     * @return position     int
     */
    public int searchByNode(LLNode node) {
        int position = -1;      // initialize to a non-position value.
        int compareCounter = 1;
        LLNode compareNode = head;
        boolean match = false;

        if (!listEmpty()) {
            while ((compareNode != tail) && (!match)){
                if (compareNode == node) {
                    match = true;
                    position = compareCounter;
                } else {
                    LLNode next = compareNode.getNext();
                    compareNode = next;
                    compareCounter++;
                }   // end if/else.
            }   // end while.
            if (!match) {
                if (tail == node) {
                    position = compareCounter;
                }   // end if.
            }       // end if.
        }   // end if.
        return position;
    }   // end searchByNode.

    /**
     * method searchByPosition
     * - accepts an int value for position
     * - returns the node at that position in the list, as long
     *      as position value is LTE the nodeCounter value
     * @param pos int
     * @return LLNode node
     */
    public LLNode searchByPosition(int pos) {
        LLNode node = null;
        int counter = 1;
        boolean match = false;

        if (pos <= nodeCounter) {       // then I can return a node.
            node = head;
            while ((counter <= nodeCounter) && (!match)) {
                if (pos == counter) {
                    match = true;
                } else {
                    LLNode next = node.getNext();
                    node = next;
                    counter++;
                }   // end if/else.
            }   // end while.
        }   // end if.
        // if pos exceeds nodeCounter then returned node is null.
        return node;
    }   // end searchByPosition.

    /**
     * method getHead()
     * @return LLNode
     */
    public LLNode getHead() {
        return head;
    }   // end getHead.

    /**
     * method getTail()
     * @return LLNode
     */
    public LLNode getTail() {
        return tail;
    }   // end getTail.

    /**
     * method getNodeCounter()
     * @return int
     */
    public int getNodeCounter() {
        return nodeCounter;
    }   // end getNodeCounter.

    public boolean listEmpty() {
        return (nodeCounter == 0);
    }   // end listEmpty.
}   // end DoublyLinkedList class
