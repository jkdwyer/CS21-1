/**
 * Class LLNode for LinkedList assignment.
 *
 * Creates nodes for the LinkedList.
 * Each node needs a payload.
 * Each node needs a reference to the next and prior nodes.
 *
 * @author Jan Dwyer
 * @version 1.3	09/20/2017
 *
 */
public class LLNode {
	private String payload;
	private LLNode next;
	private LLNode last;

	/**
	  * default constructor, no arguments.
	  */
	public LLNode () {
		payload = "Emerald";
	}	// end no-args constructor.

	/**
	 * constructor, takes String argument for payload.
	 * @param data String
	 */
	public LLNode (String data) {
        payload = data;
    }	// end one-arg constructor.

	/**
	 * method setPayload
	 * @param data	String
	 */
	public void setPayload(String data) {
		payload = data;
	}

	/**
	 * method getPayload
	 * @return String
	 */
	public String getPayload() {
		return payload;
	}

    /**
     * method setLast
     * @param node LLNode
     */
    public void setLast(LLNode node) {
		last = node;
	}

    /**
     * method getLast
     * @return LLNode
     */
    public LLNode getLast() {
		return last;
	}

    /**
     * method setNext
     * @param node LLNode
     */
    public void setNext(LLNode node) {
		next = node;
	}

    /**
     * method getNext
     * @return LLNode
     */
    public LLNode getNext() {
		return next;
	}
}	// end class LLNode.
