/**
 * Class LLDoubleNode for LinkedList assignment.
 *
 * Creates nodes for the LinkedList that hold a Double instead of a String.
 * Each node needs a payload.
 * Each node needs a reference to the next and prior nodes.
 *
 * @author Jan Dwyer
 * @version 1.0		09/25/2017
 *
 */
public class LLDoubleNode {
	private double payload;
	private LLDoubleNode next;
	private LLDoubleNode last;

	/**
	  * default constructor, no arguments.
	  */
	public LLDoubleNode() {
		payload = 0.0;
	}	// end no-args constructor.

	/**
	 * constructor, takes Double argument for payload.
	 * @param data double
	 */
	public LLDoubleNode(double data) {
        payload = data;
    }	// end one-arg constructor.

	/**
	 * method setPayload
	 * @param data	double
	 */
	public void setPayload(double data) {
		payload = data;
	}

	/**
	 * method getPayload
	 * @return String
	 */
	public double getPayload() {
		return payload;
	}

    /**
     * method setLast
     * @param node LLNode
     */
    public void setLast(LLDoubleNode node) {
		last = node;
	}

    /**
     * method getLast
     * @return LLNode
     */
    public LLDoubleNode getLast() {
		return last;
	}

    /**
     * method setNext
     * @param node LLNode
     */
    public void setNext(LLDoubleNode node) {
		next = node;
	}

    /**
     * method getNext
     * @return LLNode
     */
    public LLDoubleNode getNext() {
		return next;
	}
}	// end class LLNode.
