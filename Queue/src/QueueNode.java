/**
 * Class QueueNode
 * - contains an int as the payload (which could be any data type.)
 * - contains a QueueNode object that only references its predecessor.
 * - contains get/set methods for the two variables.
 *
 * @author Jan Dwyer
 * @version 1.0     09/02/2017
 */
public class QueueNode {
    private int payload;
    private QueueNode last;

    // constructor1 - no args.
    public QueueNode() {
        System.out.println("in QueueNode no-args constructor");
    };

    // constructor2 - single int arg.
    public QueueNode(int data) {
        System.out.println("in QueueNode int arg constructor");
        payload = data;
    }   // end constructor2.

    /**
     * method setPayload sets private int value for node.
     * @param data - the integer value
     */
    public void setPayload(int data){
        System.out.println("in QueueNode.setPayload");
        payload = data;
    }   // end setPayload.

    /**
     * method getPayload returns private int value for node.
     * @return int
     */
    public int getPayload() {
        return payload;
    }   // end get Payload.

    /**
     * method setLast sets private int value for node.
     * @param node - the node being acted upon.
     */
    public void setLast(QueueNode node){
        System.out.println("in QueueNode.setLast");
        last = node;
    }   // end set last.

    /**
     * method getLast returns private int value for node.
     * @return QueueNode
     */
    public QueueNode getLast() {
        return last;
    }   // end get last.
}   // end class.
