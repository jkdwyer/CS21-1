import java.util.ArrayList;

/**
 * Class StackLifo
 * - contains Integer variable head to track location of last-in
 * - contains ArrayList variable to hold elements of the stack.
 *
 * - contains two constructors:
 * - StackLifo() and StackLifo(String element)
 *
 * - contains four methods 07/26/2017:
 * - public void stackPush(String element) to accept a new element
 *      and add it to the end of the stack.
 * - public String stackPop() to remove and return an element from the stack.
 * - public boolean stackEmpty() to return true if stack is empty.
 * - public Integer getHead() to return the position of the head of the stack.
 *
 * - Additions to code should provide error handling.
 *
 * @author Jan Dwyer
 * @version 1.2	09/02/2017
 *
 */

public class StackLifo {
    // head is position of last element appended.
    private Integer head;
    private ArrayList<String> stackArray = new ArrayList<String>();

    public StackLifo() {
        System.out.println("in StackLifo.constructor - no args");
        System.out.println();
    }   // end no-args constructor.

    public StackLifo(String element){
        System.out.println("in StackLifo.constructor - element");
        System.out.println("element: " + element);
        // get current size, add element, increment head.
        stackPush(element);
    }   // end element constructor.

    /**
     * method stackPush(String element) accepts a new String element
     *      and adds it to the head (end) of the stack.
     * @param element
     */
    public void stackPush(String element) {
        System.out.println("in StackLifo.stackPush");
        System.out.println("element: " + element);
        System.out.println("head: " + head);
        // append to head of ArrayList.
        stackArray.add(element);
        // increment head only when append is done.
        head = (stackArray.size() - 1);
        System.out.println("getHead(): " + getHead());
        System.out.println("stackArray.get(head): " +
                stackArray.get(head));
        System.out.println();
    }   // end push.

    /**
     * method stackPop() removes and returns a String element from
     *      the head (end) of the stack.
     * @return
     */
    public String stackPop() {
        System.out.println("in StackLifo.stackPop");
        String item = stackArray.get(head);
        stackArray.remove(head);
        // @TODO decrement the head?
        return item;
    }   // end pop.

    /**
     * method stackEmpty() returns boolean true if stack is empty.
     * @return
     */
    public boolean stackEmpty() {
        return (stackArray.isEmpty());
    }   // end stackEmpty.

    /**
     * method getHead() returns Integer position of head element
     *      in the ArrayList stackArray.
     * @return
     */
    public Integer getHead() {
        if (stackArray.size() > 0) {
            return head;
        } else {
            return null;
        }   // end if.
    }       // end getHead.
}       // end class.