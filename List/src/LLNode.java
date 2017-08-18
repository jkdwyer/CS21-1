import java.util.*;
import java.text.*;
/**
 * Class LLNode for LinkedList assignment.
 *
 * Creates nodes for the LinkedList.
 * Each node needs a dataElement.
 * Each node needs a reference to the next and prior nodes.
 *
 * @author Jan Dwyer
 * @version 1.1	07/26/2017
 *
 */
public class LLNode {
	private String dataElement;
	private LLNode nextNode;
	private LLNode priorNode;

	/**
	  * Needs a constructor, methods and member vars.
	  */
	public LLNode () {
		dataElement = "Emerald";
		System.out.println("in LLNode no-args constructor");
		System.out.println("dataElement: " + dataElement);
	}	// end no-args constructor.

    public LLNode (String data) {
        dataElement = data;
        System.out.println("in LLNode one-arg constructor");
        System.out.println("dataElement: " + dataElement);
    }	// end one-arg constructor.
}		// end class LLNode.
