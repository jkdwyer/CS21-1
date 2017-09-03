/**
 * Class StackNode
 * - contains int payload value and StackNode reference to last node.
 * - contains constructor, and get/set methods for payload and last.
 *
 * @author Jan Dwyer
 * @version 1.0     09/03/2017
 */
public class StackNode {
    private int payload;
    private StackNode last;

    // no-args constructor.
    public StackNode() {
        System.out.println("in StackNode constructor");
    }   // end constructor.

    /**
     * method setPayload()
     * @param data - takes int value for payload
     */
    public void setPayload(int data) {
        System.out.println("in StackNode.setPayload()");
        payload = data;
    }   // end setPayload.

    /**
     * method getPayload()
     * @return payload - int value of payload.
     */
    public int getPayload() {
        System.out.println("in StackNode.getPayload()");
        return payload;
    }   // end getPayload.

    /**
     * method setLast()
     * @param node - takes StackNode as value for last.
     */
    public void setLast(StackNode node) {
        System.out.println("in StackNode.setLast()");
        last = node;
    }   // end setLast.

    /**
     * method getLast()
     * @return last - StackNode reference stored in last.
     */
    public StackNode getLast() {
        System.out.println("in StackNode.getLast()");
        return last;
    }   // end getLast.
}   // end class
