/**
 * Class LLNode for LinkedList assignment.
 *
 * Creates nodes for the LinkedList.
 * Each node needs a payload.
 * Each node needs a reference to the next and prior nodes.
 *
 * @author Jan Dwyer
 * @version 1.2	09/11/2017
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
		// TODO - remove println comments.
		// System.out.println("in LLNode no-args constructor");
		// System.out.println("payload: " + payload);
	}	// end no-args constructor.

	/**
	 * constructor, takes String argument for payload.
	 * @param data String
	 */
	public LLNode (String data) {
        payload = data;
        // TODO - remove println comments.
        // System.out.println("in LLNode one-arg constructor");
        // System.out.println("payload: " + payload);
    }	// end one-arg constructor.

	public void setPayload(String data) {
		payload = data;
	}

	public String getPayload() {
		return payload;
	}

	public void setLast(LLNode node) {
		last = node;
	}

	public LLNode getLast() {
		return last;
	}

	public void setNext(LLNode node) {
		next = node;
	}

	public LLNode getNext() {
		return next;
	}
}		// end class LLNode.
