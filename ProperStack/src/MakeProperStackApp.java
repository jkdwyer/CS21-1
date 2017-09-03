public class MakeProperStackApp {
    public static void main(String args[]) {
        System.out.println("in MakeProperStackApp.main");

        // test StackNode constructor and setPayload methods.
        StackNode node01 = new StackNode();
        node01.setPayload(120);
        StackNode node02 = new StackNode();
        node02.setPayload(44);
        StackNode node03 = new StackNode();
        node03.setPayload(53);
        StackNode node04 = new StackNode();
        node04.setPayload(6);

        // test ProperStackLifo constructor.
        ProperStackLifo firstStack = new ProperStackLifo();
        //  test stackEmpty method when stack is empty.
        if (firstStack.stackEmpty()) {
            System.out.println("stack is empty");
        } else {
            System.out.println("stack is NOT empty");
        }   // end if.
        // test stackPush, stackPop methods.
        firstStack.stackPush(node01);
        firstStack.stackPush(node02);
        firstStack.stackPush(node03);
        firstStack.stackPush(node04);
        firstStack.stackPop();
        //  test stackEmpty method when stack is NOT empty.
        if (firstStack.stackEmpty()) {
            System.out.println("stack is empty");
        } else {
            System.out.println("stack is NOT empty");
        }   // end if.
    }   // end main.
}   // end class
