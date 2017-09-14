/**
 * class DoublyLinkedList
 * - contains references to LLNode objects at head and tail of List.
 *
 * @author Jan Dwyer
 * @version 1.0     09/11/2017
 */
public class DoublyLinkedList {
    private LLNode head;
    private LLNode tail;
    private int nodeCounter = 0;

    // no-args constructor.
    public DoublyLinkedList() {
        // TODO - remove println comments.
        // System.out.println("in DoublyLinkedList constructor");
        // System.out.println("nodeCounter: " + nodeCounter);
    }   // end constructor.

    /**
     * method printList
     * - prints entire contents of current list, one line
     *      per element.
     */
    public void printList() {
        // TODO - remove println comments.
        System.out.println("");
        System.out.println("in printList");
        int counter = 1;
        LLNode node;
        if (!listEmpty()) {
            while (counter <= nodeCounter) {
                node = searchByPosition(counter);
                // TODO - remove println comments.
                System.out.println("counter: " + counter +
                    " - payload: " + node.getPayload());
                counter++;
            }
        }
        System.out.println("");
    }   // end printList.

    /**
     * method insertNode
     * - accepts new LLNode, neighbor LLNode, and before/after value.
     * - locates the neighbor LLNode by calling searchByNode, then
     *      adds the new node before or after the neighbor as specified.
     * @param node LLNode
     * @param neighbor LLNode
     * @param ba String
     */
    public void insertNode(LLNode node, LLNode neighbor, String ba) {
        // TODO - remove println comments.
        System.out.println("in DoublyLinkedList.insertNode()");
        LLNode partner;
        if (nodeCounter == 0) {
            // list was empty, new node becomes head and tail.
            head = node;
            tail = node;
        } else {
            // search for neighbor node.
            int position = searchByNode(neighbor);
            // TODO - remove println comments.
            // System.out.println("position: " + position);
            if (ba == "before") {
                position--;
                // TODO - remove println comments.
                // System.out.println("position (before): " + position);
                if (neighbor != head) {
                    partner = searchByPosition(position);
                    // now I have neighbor and partner; do insert logic.
                    node.setLast(partner);
                    partner.setNext(node);
                    node.setNext(neighbor);
                    neighbor.setLast(node);
                } else {
                    // there is no before-partner when neighbor is head.
                    node.setNext(neighbor);
                    neighbor.setLast(node);
                    // node is new head.
                    head = node;
                }   // end if.
            } else {    // after.
                position++;
                // TODO - remove println comments.
                // System.out.println("position (after): " + position);
                if (neighbor != tail) {
                    partner = searchByPosition(position);
                    // now I have neighbor and partner; do insert logic.
                    node.setNext(partner);
                    partner.setLast(node);
                    node.setLast(neighbor);
                    neighbor.setNext(node);
                } else {
                    // there is no after-partner when neighbor is tail.
                    node.setLast(neighbor);
                    neighbor.setNext(node);
                    // node is new tail.
                    tail = node;
                }   // end if.
            }   // end before or after.
            nodeCounter++;
        }   // end if.
    }   // end insertNode.

    /**
     * method insertNewHead()
     * - accepts a node and adds it to the head (entry-point)
     *      of the List.
     * - ignore this method and code one per WKK description.
     * @param node LLNode
     */
    public void insertNewHead (LLNode node) {
        // TODO - remove println comments.
        // System.out.println("in DoublyLinkedList.insertNewHead()");
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
        // TODO - remove println comments.
        // System.out.println("nodeCounter: " + nodeCounter);
    }   // end insertNewHead.

    /**
     * method deleteNode()
     * - accepts a node, does a search to locate it in list,
     *      and then deletes it by position.
     * @param node
     * @return
     */
    public void deleteNode(LLNode node) {
        // TODO - remove println comments.
        System.out.println("in DoublyLinkedList.deleteNode()");
        int position = 0;
        LLNode neighbor;
        if (!listEmpty()) {
            if (node == head) {
                // head is position 1, next is position 2.
                neighbor = searchByPosition(2);
                // this removes ref to current head.
                neighbor.setLast(null);
                // neighbor becomes the new head.
                head = neighbor;
            } else if (node == tail) {
                // tail is position nodeCounter.
                position = (nodeCounter - 1);
                neighbor = searchByPosition(position);
                // this removes ref to current tail.
                neighbor.setNext(null);
                // neighbor becomes the new tail.
                tail = neighbor;
            } else {
                position = searchByNode(node);
                int b = position--;
                int a = position++;
                LLNode before = searchByPosition(b);
                LLNode after = searchByPosition(a);
                before.setNext(after);
                after.setLast(before);
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
        // TODO - remove println comments.
        System.out.println("in DoublyLinkedList.searchByNode()");
        int position = -1;      // initialize to a non-position value.
        int compareCounter = 1;
        LLNode compareNode = head;
        boolean match = false;

        if (!listEmpty()) {
            // System.out.println("list is not empty");
            while ((compareNode != tail) && (!match)){
                // TODO - remove println comments.
                System.out.println("(while loop) compareCounter: " +
                        compareCounter + " " + compareNode.getPayload());
                if (compareNode == node) {
                    // TODO - remove println comments.
                    // System.out.println("compareNode == node");
                    match = true;
                    position = compareCounter;
                } else {
                    // TODO - remove println comments.
                    // System.out.println("in else");
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
        // TODO - remove println comments.
        // System.out.println("in searchByPosition - pos: " + pos);
        LLNode node = null;
        int counter = 1;
        boolean match = false;

        if (pos <= nodeCounter) {       // then I can return a node.
            node = head;
            while ((counter <= nodeCounter) && (!match)) {
                if (pos == counter) {
                    // TODO - remove println comments.
                    // System.out.println("pos == counter");
                    match = true;
                } else {
                    // TODO - remove println comments.
                    // System.out.println("else");
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
