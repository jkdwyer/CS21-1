import java.util.*;
import java.io.*;
import java.text.*;

/**
 * MakeDoubleListApp class
 * - main method tests functionality
 * - static read and write methods
 *
 * @author Jan Dwyer    09/25/2017.
 * @version 1.0
 */
public class MakeDoubleListApp {
    public static void main(String[] args) {
        System.out.println("in MakeDoubleListApp");

        Double dbl = 0.0;
        int wct = 0;
        int nct = 0;
        String after = "after";
        String before = "before";
        LLDoubleNode dNode;
        Double dPayload = 0.0;

        Scanner fileIn;
        File dblFile;
        FileReader frInput;
        BufferedReader bufInput;

        File outputFile;
        FileWriter fwOutput;
        BufferedWriter bufOutput;
        PrintWriter dblOut;

        // Block 1 - test output of call:
        LinkedDoublesList doubleList = new LinkedDoublesList();
        doubleList = readDoublesFromConsole();
        doubleList.printList();

        // Second block OK:  make a list from doubles in text file.
        /*
        try {
            // dblFile = new File("/Users/jandwyer/Documents/work/CS21-1/LDList/src/dblFile.txt");
            dblFile = new File("fileOfDoubles.txt");
            if (dblFile.exists()) {
                System.out.println("Name: " + dblFile.getName());
                System.out.println("Readable: " + dblFile.canRead());
            }   // end if file exists.

            frInput = new FileReader(dblFile);
            bufInput = new BufferedReader(frInput);
            fileIn = new Scanner(bufInput);

            // read double values from input text file into list.
            while (fileIn.hasNextDouble()) {
                LLDoubleNode nextNode = new LLDoubleNode();
                LLDoubleNode otherNode = new LLDoubleNode();
                dbl = fileIn.nextDouble();
                nextNode.setPayload(dbl);
                if (wct == 0) {
                    dblList.insertNode(nextNode, otherNode, after);
                } else {
                    otherNode = dblList.getHead();
                    dblList.insertNode(nextNode, otherNode, before);
                }
                wct++;
            }
            dblList.printList();

        } catch (Exception e){
            System.out.println("Error encountered in read");
            e.printStackTrace();
        }   // end try
        */

        // Block 2 - test output of call:
        LinkedDoublesList dblList = new LinkedDoublesList();
        dblList = readDoublesFromFile("fileOfDoubles.txt");
        dblList.printList();

        // Third block:  format to 3 dec places, then write to text file.
        /*
        try {
            outputFile = new File("DblsToThreeDec.txt");
            fwOutput = new FileWriter(outputFile, true);
            bufOutput = new BufferedWriter(fwOutput);
            dblOut = new PrintWriter(bufOutput);
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(3);
            nf.setMinimumFractionDigits(3);
            String strPayload;

            // loop over dblList and add each payload to output file.
            nct = dblList.getNodeCounter();
            dNode = dblList.getHead();
            for (int j = 0; j < nct; j++) {
                dPayload = dNode.getPayload();
                strPayload = nf.format(dPayload);
                // System.out.println(strPayload);
                dblOut.println(strPayload);
                dNode = dNode.getNext();
            }   // end for loop
            dblOut.close();

        } catch (Exception e){
            System.out.println("\nError encountered in write");
            e.printStackTrace();
        }   // end try
        */

        // Block 3 - test output of call:
        String filename = "listOfDoubles.txt";
        writeDoublesToFile(dblList, filename);
        // need to check the contents of the created file to verify.

    }   // end main.

    /**
     * readDoublesFromConsole() static method
     * - make a list object from doubles entered at console.
     * @return doubleList       LinkedDoublesList
     */
    public static LinkedDoublesList readDoublesFromConsole() {
        System.out.println("in readDoublesFromConsole()");

        System.out.println("\nPlease type in a list of double values, " +
        "one per line,\n and then finish by typing Command-D: ");
        LinkedDoublesList doubleList = new LinkedDoublesList();
        Scanner processDoubles = new Scanner(System.in);
        int wct = 0;

        while (processDoubles.hasNextDouble()) {
            // these have to be new, each loop.
            LLDoubleNode newNode = new LLDoubleNode();
            LLDoubleNode otherNode = new LLDoubleNode();
            double ndbl = processDoubles.nextDouble();
            if (wct == 0) {
                newNode.setPayload(ndbl);
                doubleList.insertNode(newNode, otherNode, "after");
            } else {
                newNode.setPayload(ndbl);
                // each next hNode becomes new head
                otherNode = doubleList.getHead();
                doubleList.insertNode(newNode, otherNode, "before");
            }
            wct++;
        }   // end while.
        processDoubles.close();

        return doubleList;
    }   // end readDoublesFromConsole

    /**
     * readDoublesFromFile() static method
     * - make a list of doubles from an input file
     * @param filename      - a String containing the file name
     *                          and the path to that file if needed.
     * @return newLDList    LinkedDoublesList
     */
    public static LinkedDoublesList readDoublesFromFile(String filename) {
        System.out.println("in readDoublesFromFile() - filename: " + filename);

        LinkedDoublesList dblList = new LinkedDoublesList();
        Double dbl = 0.0;
        int wct = 0;
        String after = "after";
        String before = "before";

        Scanner fileIn;
        File dblFile;
        FileReader frInput;
        BufferedReader bufInput;

        try {
            dblFile = new File(filename);
            if (dblFile.exists()) {
                // TODO:  remove this output.
                System.out.println("Name: " + dblFile.getName());
                System.out.println("Readable: " + dblFile.canRead());
            }   // end if file exists.

            frInput = new FileReader(dblFile);
            bufInput = new BufferedReader(frInput);
            fileIn = new Scanner(bufInput);

            // read double values from input text file into list.
            while (fileIn.hasNextDouble()) {
                LLDoubleNode nextNode = new LLDoubleNode();
                LLDoubleNode otherNode = new LLDoubleNode();
                dbl = fileIn.nextDouble();
                nextNode.setPayload(dbl);
                if (wct == 0) {
                    dblList.insertNode(nextNode, otherNode, after);
                } else {
                    otherNode = dblList.getHead();
                    dblList.insertNode(nextNode, otherNode, before);
                }
                wct++;
            }
        } catch (Exception e){
            System.out.println("Error encountered in read");
            e.printStackTrace();
        }   // end try

        return dblList;
    }   // end readDoublesFromFile

    /**
     * writeDoublesToFile() static method
     * - Format doubles to 3 dec places, then write to text file,
     *      one per line.
     * @param ldl           - LinkedDoublesList
     * @return dblOut       - reference to a PrintWriter object.
     */
    public static void writeDoublesToFile(LinkedDoublesList ldl, String fileName) {
        System.out.println("in writeDoublesToFile() - fileName: " + fileName);

        int nct = 0;
        LLDoubleNode dNode;
        Double dPayload = 0.0;

        File outputFile;
        FileWriter fwOutput;
        BufferedWriter bufOutput;
        PrintWriter dblOut;

        try {
            outputFile = new File(fileName);
            fwOutput = new FileWriter(outputFile, true);
            bufOutput = new BufferedWriter(fwOutput);
            dblOut = new PrintWriter(bufOutput);
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(3);
            nf.setMinimumFractionDigits(3);
            String strPayload;

            // loop over dblList and add each payload to output file.
            nct = ldl.getNodeCounter();
            dNode = ldl.getHead();
            for (int j = 0; j < nct; j++) {
                dPayload = dNode.getPayload();
                strPayload = nf.format(dPayload);
                // TODO - remove this output.
                // System.out.println(strPayload);
                dblOut.println(strPayload);
                dNode = dNode.getNext();
            }   // end for loop
            dblOut.close();

        } catch (Exception e){
            System.out.println("\nError encountered in write");
            e.printStackTrace();
        }   // end try
        // Can't return the PrintWriter object, it's closed.
    }   // end writeDoublesToFile
}       // end MakeDoubleListApp class
