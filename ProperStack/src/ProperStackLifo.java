/**
 * Class ProperStackLifo
 * - This is the second version, using correct node-based model.
 *
 * - contains StackNode variable for head of stack.
 * - contains constructor, stackEmpty, stackPush and stackPop methods.
 *
 * @author Jan Dwyer
 * @version 1.0     09/03/2017
 */
public class ProperStackLifo {
    private StackNode head;
    // Stack should always start empty.
    private int nodeCounter = 0;

    // no-args constructor.
    public ProperStackLifo() {
        System.out.println("in ProperStackLifo constructor");
    }   // end constructor.

    /**
     * method stackEmpty
     * @return boolean - true if nodeCounter is zero.
     */
    public boolean stackEmpty() {
        System.out.println("in ProperStackLifo.stackEmpty()");
        return (nodeCounter == 0);
    }   // end stackEmpty.

    /**
     * method stackPush
     * @param node - takes StackNode to add to stack.
     */
    public void stackPush(StackNode node) {
        System.out.println("in ProperStackLifo.stackPush()");
        System.out.println("node.getPayload(): " + node.getPayload());
        if (nodeCounter == 0) {
            // then this is the first node added to the stack.
            head = node;
        } else {
            // current head must become last ref in new head,
            //      then incoming node must become new head.
            node.setLast(head);
            head = node;
        }   // end if.
        nodeCounter++;
        System.out.println("nodeCounter: " + nodeCounter);
    }   // end stackAppend.

    /**
     * method stackPop
     * @return StackNode - head of stack is removed & returned.
     */
    public StackNode stackPop() {
        System.out.println("in ProperStackLifo.stackPop()");
        System.out.println("head.getPayload(): " + head.getPayload());
        StackNode currentHead = new StackNode();
        currentHead = head;
        // new head needs to be last ref from current head; this loses
        //      the connection between the current head and the stack.
        head = currentHead.getLast();
        // return value is the node that was the previous head.
        System.out.println("payload from node removed and returned: " +
                currentHead.getPayload());
        System.out.println("payload from new head: " + head.getPayload());

        nodeCounter--;
        System.out.println("nodeCounter: " + nodeCounter);
        return currentHead;
    }   // end stackPop.
}   // end class.
