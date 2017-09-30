import java.util.*;

/**
 * Class MakeList for LinkedList assignment.
 *
 * @author Jan Dwyer
 * @version 1.1	09/20/2017
 *
 */
public class MakeListApp {
    /**
     * Main method.
     * Instantiate nodes, lists and stacks.
     * Primarily for testing.
     */
    public static void main(String[] args){
        // System.out.println("in MakeListApp.main");

        String after = "after";
        String before = "before";
        int position = 0;
        LLNode listNode0;

        LLNode listNode1 = new LLNode();
        LLNode listNode2 = new LLNode("Tourmaline");
        LLNode listNode3 = new LLNode(args[0]);
        LLNode listNode5 = new LLNode();
        listNode5.setPayload("Malachite");

        System.out.println("Type in the value 'Olivine' on the next line:");
        Scanner sc = new Scanner(System.in);
        String gem = sc.next();
        LLNode listNode4;
        listNode4 = new LLNode(gem);
        // Need to type an input (Olivine) for listNode4 in output pane;
        //  then the program will complete and show an exit code.

        DoublyLinkedList dlList = new DoublyLinkedList();
        dlList.insertNewHead(listNode1);
        dlList.insertNewHead(listNode2);
        dlList.insertNewHead(listNode3);
        dlList.insertNewHead(listNode4);
        dlList.insertNewHead(listNode5);
        dlList.printList();

        LLNode listNode6;
        listNode6 = new LLNode("Aquamarine");
        System.out.println("insert L6 Aquamarine before L2 Tourmaline");
        dlList.insertNode(listNode6, listNode2, before);
        dlList.printList();

        LLNode listNode7;
        listNode7 = new LLNode("Peridot");
        System.out.println("insert L7 Peridot after L2 Tourmaline");
        dlList.insertNode(listNode7, listNode2, after);
        dlList.printList();

        LLNode listNode8;
        listNode8 = new LLNode("Gaspeite");
        System.out.println("insert L8 Gaspeite before L5 Malachite (head)");
        dlList.insertNode(listNode8, listNode5, before);
        dlList.printList();

        LLNode listNode9;
        listNode9 = new LLNode("Amazonite");

        System.out.println("insert L9 Amazonite after L1 Emerald (tail)");
        dlList.insertNode(listNode9, listNode1, after);
        dlList.printList();

        System.out.println("delete L9 Amazonite (tail)");
        dlList.deleteNode(listNode9);
        dlList.printList();

        System.out.println("delete L8 Gaspeite (head)");
        dlList.deleteNode(listNode8);
        dlList.printList();

        System.out.println("delete L7 Peridot (between L2 Tourmaline and L1 Emerald)");
        dlList.deleteNode(listNode7);
        dlList.printList();
        System.out.println("nodeCounter: " + dlList.getNodeCounter());

        DoublyLinkedList dlList2 = new DoublyLinkedList();
        try {
            // No exception generated, code silently skips request.
            dlList2.deleteNode(listNode1);
        } catch (Exception e) {
            System.out.println("deleting node from empty list");
            e.printStackTrace();
        }   // end try.

        // test empty list section of insertNode().
        dlList2.insertNode(listNode9, listNode1, after);
        // modified to createPrintList() to state "List is empty" and it is.
        int count = dlList2.getNodeCounter();
        System.out.println("count: " + count);
        dlList2.printList();

        // sc.close();
    }	// end method main.
}       // end class MakeListApp.
