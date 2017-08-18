import java.util.*;
import java.text.*;
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
     *
     *
     */
    public static void main(String[] args){
        System.out.println("in MakeListApp.main");
        // So, using IJ, how do I provide cmd line args?
        // Edit Configs screen for args.  How about System.in?
        // System.out.println("args[0]: " + args[0]);

        LLNode listNode1;
        listNode1 = new LLNode();
        LLNode listNode2;
        listNode2 = new LLNode("Tourmaline");
        LLNode listNode3;
        listNode3 = new LLNode(args[0]);

        Scanner sc = new Scanner(System.in);
        String gem = sc.next();
        LLNode listNode4;
        listNode4 = new LLNode(gem);
        sc.close();

    }	// end method main.
}       // end class MakeListApp.
