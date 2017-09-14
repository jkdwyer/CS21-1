import java.util.*;

/**
 * Class MakeList for LinkedList assignment.
 *
 * @author Jan Dwyer
 * @version 1.0	07/26/2017
 *
 */
public class MakeListApp {
    /**
     * Main method.
     * Instantiate nodes, lists and stacks.
     * Primarily for testing.
     */
    public static void main(String[] args){
        // TODO - remove println comments.
        System.out.println("in MakeListApp.main");
        // So, using IJ, how do I provide cmd line args?
        // Edit Configs screen for args.  How about System.in?
        // System.out.println("args[0]: " + args[0]);

        int position = 0;
        LLNode listNode0;
        String before = "before";
        String after = "after";

        LLNode listNode1;
        listNode1 = new LLNode();
        LLNode listNode2;
        listNode2 = new LLNode("Tourmaline");
        LLNode listNode3;
        listNode3 = new LLNode(args[0]);
        LLNode listNode5;
        listNode5 = new LLNode("Malachite");

        System.out.println("Type in the value 'Olivine' on the next line:");
        Scanner sc = new Scanner(System.in);
        String gem = sc.next();
        LLNode listNode4;
        listNode4 = new LLNode(gem);
        // Need to type an input (Olivine) for listNode4 in output pane;
        //  then the program will complete and show an exit code.

        DoublyLinkedList dlList = new DoublyLinkedList();
        dlList.insertNewHead(listNode1);
        // TODO - remove test calls to get head and tail.
        /*LLNode head = dlList.getHead();
        LLNode tail = dlList.getTail();
        // TODO - remove println comments.
        System.out.println("head.getPayload(): " + head.getPayload());
        System.out.println("tail.getPayload(): " + tail.getPayload());
        System.out.println();
        */

        dlList.insertNewHead(listNode2);
        // TODO - remove test calls to get head and tail.
        /*head = dlList.getHead();
        tail = dlList.getTail();
        // TODO - remove println comments.
        System.out.println("head.getPayload(): " + head.getPayload());
        System.out.println("tail.getPayload(): " + tail.getPayload());
        System.out.println();
        */

        dlList.insertNewHead(listNode3);
        // TODO - remove test calls to get head and tail.
        /*head = dlList.getHead();
        tail = dlList.getTail();
        // TODO - remove println comments.
        System.out.println("head.getPayload(): " + head.getPayload());
        System.out.println("tail.getPayload(): " + tail.getPayload());
        System.out.println();
        */

        dlList.insertNewHead(listNode4);
        // TODO - remove test calls to get head and tail.
        /*head = dlList.getHead();
        tail = dlList.getTail();
        // TODO - remove println comments.
        System.out.println("head.getPayload(): " + head.getPayload());
        System.out.println("tail.getPayload(): " + tail.getPayload());
        System.out.println();
        */

        dlList.insertNewHead(listNode5);
        // TODO - remove test calls to get head and tail.
        /*head = dlList.getHead();
        System.out.println("head.getPayload(): " + head.getPayload());
        tail = dlList.getTail();
        System.out.println("tail.getPayload(): " + tail.getPayload());
        System.out.println();
        */

        // TODO - replace this call with a unit test.
        // position = dlList.searchByNode(listNode4);
        // TODO - remove println comments.
        /*System.out.println("listNode4.getPayload(): " +
                listNode4.getPayload());
        System.out.println("listNode4 position: " + position);
        System.out.println();
        */

        // TODO - replace this call with a unit test.
        // position = dlList.searchByNode(listNode1);
        // TODO - remove println comments.
        /*System.out.println("listNode1.getPayload(): " +
                listNode1.getPayload());
        System.out.println("listNode1 position: " + position);
        System.out.println();
        */

        // TODO - replace this call with a unit test.
        // listNode0 = dlList.searchByPosition(4);
        // TODO - remove println comments.
        /*System.out.println("listNode0.getPayload(): " +
                listNode0.getPayload());
        */
        dlList.printList();

        LLNode listNode6;
        listNode6 = new LLNode("Aquamarine");
        // TODO - remove println comments.
        System.out.println("listNode6: Aquamarine before listNode2: Tourmaline");
        dlList.insertNode(listNode6, listNode2, before);
        dlList.printList();
        // TODO - remove println comments.
        System.out.println("head payload: " +
                dlList.getHead().getPayload());
        System.out.println("tail payload: " +
                dlList.getTail().getPayload());

        LLNode listNode7;
        listNode7 = new LLNode("Peridot");
        // TODO - remove println comments.
        System.out.println("listNode7: Peridot after listNode2: Tourmaline");
        dlList.insertNode(listNode7, listNode2, after);
        // TODO - when neighbor is head or tail, I have a problem.
        dlList.printList();

        LLNode listNode8;
        listNode8 = new LLNode("Gaspeite");
        // TODO - remove println comments.
        System.out.println("listNode8: Gaspeite, listNode5: Malachite");
        System.out.println("insert before head");
        dlList.insertNode(listNode8, listNode5, before);
        dlList.printList();

        LLNode listNode9;
        listNode9 = new LLNode("Amazonite");
        // TODO - remove println comments.
        System.out.println("listNode9: Amazonite, listNode1: Emerald");
        System.out.println("insert after tail");
        dlList.insertNode(listNode9, listNode1, after);
        dlList.printList();

        System.out.println("testing deleteNode");
        System.out.println("delete listNode9: Amazonite (tail)");
        dlList.deleteNode(listNode9);
        dlList.printList();

        System.out.println("delete listNode8: Gaspeite (head)");
        dlList.deleteNode(listNode8);
        dlList.printList();

        System.out.println("delete listNode7: Peridot " +
                "(from between Tourmaline and Emerald)");
        dlList.deleteNode(listNode7);
        dlList.printList();

        sc.close();
    }	// end method main.
}       // end class MakeListApp.
