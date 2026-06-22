/***********************************************
* Java Compiler Test Case Generator
* File JompTree.java
* M. Williamsen
* https://github.com/springleik/JompTree/
* http://www.williamsonic.com/CompTree/index.html
* 21 June 2026
************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

// Populate a Java class with random code
public class JompTree {
    // main entry point
    public static void main(String[] args) {
        // check command line arguments
        if (args.length < 2) {
            System.err.println ("Usage: java JompTree Jbrnch.txt Jleaf.txt");
            System.exit (-1);
        }
        System.err.println (String.format ("Opening branch input file: %s, "
            + "leaf input file: %s", args[0], args[1]));

        // open branch and leaf files for reading as text
        brnch.theFile = new File (args[0]);
        leaf.theFile = new File (args[1]);
        try {
            brnch.theScan = new Scanner (brnch.theFile);}
        catch (FileNotFoundException e) {
            System.err.println (String.format ("Branch file not found: %s", args[0]));
            System.exit (-2);
        }
        try {
            leaf.theScan = new Scanner (leaf.theFile);}
        catch (FileNotFoundException e) {
            System.err.println (String.format ("Leaf file not found: %s", args[1]));
            System.exit (-3);
        }

        // start generating source code as compiler input
        System.out.println ("class what {");
        System.out.println ("    public static void main(String[] args) {");
        System.out.println ("        double first = 1, second = 2, third = 3;");

        // generate 25 random outputs on console
        for (int i = 0; i < 25; i++)
        {
            node.nodeCount = 0;
            node.theDepth = 0;
            node.maxDepth = 0;

            // construct & randomly populate a composite tree
            node listHead = new brnch ();
            listHead.populate ();

            // express tree by recursive descent as console text
            System.out.print ("        System.out.println (");
            listHead.express ();

            // add comment text describing the line generated
            System.out.println ("); /* " + node.nodeCount + ", " + node.maxDepth + " */");
        }

        System.out.println ("    }");
        System.out.println ("}");

        // close input files
        brnch.theScan.close ();
        leaf.theScan.close ();
    }
}

// abstract base class of objects to compose into a tree structure
abstract class node
{
// class members
static int theDepth;
static int nodeCount;
static int maxDepth;

// instance members
abstract void populate ();
abstract void express ();
}

// composite class, may have child nodes
class brnch extends node {
    // class members
    static File theFile;
    static Scanner theScan;

    // instance members
    String pre;
    String inter;
    String post;
    List <node> theList;

    // compose a random tree of branch and leaf nodes
    void populate () {
        theDepth += 1;
        // rewind branch input file as needed
        if (!theScan.hasNext ()) {
            try {
                theScan = new Scanner (theFile);}
            catch (FileNotFoundException e) {
                System.err.println ("Branch file not open.");
                System.exit (-4);
            }
        }

        // read and tokenize a line from branch input file
        String theLine = theScan.nextLine ();
        String [] theWords = theLine.split (" ", 4);

        // handle unary operations
        if (theWords.length == 2) {
            pre = theWords [0];
            inter = null;
            post = theWords[1];
        }
        // handle binary operations
        else if (theWords.length == 3) {
            pre = theWords [0];
            inter = theWords [1];
            post = theWords [2];
        }
        // handle ternary operations
        else if (theWords.length == 4) {
            pre = theWords [0];
            inter = theWords [1];
            post = theWords [3];
        }
        else {
            System.err.println (String.format ("Bad word count: %d", theWords.length));
            System.exit (-5);
        }

        // append the right number of operands
        node theNode = null;
        theList = new ArrayList <> ();
        int numOpnds = theWords.length - 1;
        while (0 < numOpnds--) {
            // tunable parameters help steer the code generator
            if ((0.5 < Math.random ()) && (nodeCount < 15) && (theDepth < 11)) {
                theNode = new brnch ();
            }
            else {
                theNode = new leaf ();
            }

            // append and populate recursively
            theList.add (theNode);
            theNode.populate ();
        }
        theDepth -= 1;
    }

    // serialize this branch node recursively
    void express () {
        // render preamble always
        System.out.print (pre);
        boolean first = true;
        for (node aNode: theList) {
            if (first) {
                first = false;
            }
            else {
                // render interamble if two or more arguments
                System.out.print (inter);
            }
            aNode.express ();
        }
        // render postamble always
        System.out.print (post);
    }
}

// component class, no child nodes
class leaf extends node {
    // class members
    static File theFile;
    static Scanner theScan;

    // instance members
    String theStr;
    int myDepth;

    // obtain argument value from leaf input file
    void populate () {
        nodeCount += 1;
        myDepth = theDepth;
        if (theDepth > maxDepth) {
            maxDepth = theDepth;
        }
        // rewind leaf input file as needed
        if (!theScan.hasNext ()) {
            try {
                theScan = new Scanner (theFile); }
                catch (FileNotFoundException e) {
                    System.err.println ("Leaf file not open.");
                    System.exit (-6);
            }
        }
        theStr = theScan.next ();
    }

    // serialize this leaf node
    void express () {
        System.out.print (theStr);
    }
}
