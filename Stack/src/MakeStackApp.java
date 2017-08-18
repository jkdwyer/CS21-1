public class MakeStackApp {
    public static void main(String[] args){
        System.out.println("in MakeStackApp.main");

        // test no-args constructor and getHead().
        StackLifo stackInstance = new StackLifo();
        System.out.println("stackInstance.getHead(): " +
                stackInstance.getHead());

        // test isEmpty() - 1.
        if (stackInstance.stackEmpty()) {
            System.out.println("stackInstance ArrayList is empty");
        } else {
            System.out.println("stackInstance ArrayList is NOT empty");
        }   // end if.
        System.out.println();

        // test push.
        stackInstance.stackPush("Liberty");
        Integer position = stackInstance.getHead();
        System.out.println("position: " + position);

        // test isEmpty() - 2.
        if (stackInstance.stackEmpty()) {
            System.out.println("stackInstance ArrayList is empty");
        }else {
            System.out.println("stackInstance ArrayList is NOT empty");
        }   // end if.
        System.out.println();

        // test pop.
        String poppedElement = stackInstance.stackPop();
        System.out.println("poppedElement: " + poppedElement);
        System.out.println();

        // test element constructor and getHead().
        StackLifo stackElement = new StackLifo("Justice");
        System.out.println("stackElement.getHead(): " +
                stackElement.getHead());

        stackElement.stackPush("Life");
        System.out.println("stackElement.getHead(): " +
                stackElement.getHead());

        stackElement.stackPush("Liberty");
        System.out.println("stackElement.getHead(): " +
                stackElement.getHead());

        stackElement.stackPush("Pursuit of Happiness");
        System.out.println("stackElement.getHead(): " +
                stackElement.getHead());

    }   // end main.
}       // end class.