import java.util.ArrayList;

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

    public String stackPop() {
        System.out.println("in StackLifo.stackPop");
        String item = stackArray.get(head);
        stackArray.remove(head);
        return item;
    }   // end pop.

    public boolean stackEmpty() {
        return (stackArray.isEmpty());
    }   // end stackEmpty.

    public Integer getHead() {
        if (stackArray.size() > 0) {
            return head;
        } else {
            return null;
        }   // end if.
    }       // end getHead.
}       // end class.