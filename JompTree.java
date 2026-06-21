/* Java Compiler Test Case Generator
* File JompTree.java
* M. Williamsen
* 21 June 2026
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

// Populate a Java class with random code
public class JompTree {
    public static void main(String[] args) {
        // check command line arguments
        if (args.length < 2) {
            System.out.println ("Usage: java JompTree Jbrnch.txt Jleaf.txt");
            System.exit (-1);
        }
        System.out.println (String.format ("Opening branch input file: %s, leaf input file: %s", args[0], args[1]));

        // open branch and leaf files for reading as text
        brnch.theFile = new File (args[0]);
        leaf.theFile = new File (args[1]);
        try {
            brnch.theScan = new Scanner (brnch.theFile);
            leaf.theScan = new Scanner (leaf.theFile);
        }
        catch (FileNotFoundException e) {
            System.out.println ("File not found.");
            System.exit (-2);
        }

        // generate 25 random outputs on console
        System.out.println ("text to open a class and a method");
        for (int i = 0; i < 25; i++)
        {
            node.nodeCount = 0;
            node.theDepth = 0;
            node.maxDepth = 0;

            // construct & randomly populate tree
            node listHead = new brnch ();
            listHead.populate ();

            // express tree recursively as text on console
            listHead.express ();

            System.out.println ("/* " + node.nodeCount + ", " + node.maxDepth + " */");
        }

        System.out.println ("test to close a class and a method");
        brnch.theScan.close ();
        leaf.theScan.close ();
    }
}

// abstract base class to compose objects into a tree structure
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
    int numOpnds;
    List <node> theList;

    void populate () {
        if (null == theScan || !theScan.hasNext ()) {
            try {
                theScan = new Scanner (theFile); }
                catch (FileNotFoundException e) {
                    System.out.println ("Branch file not found.");
                    System.exit (-2);
            }
        }
        String theLine = theScan.nextLine ();
        String [] theWords = theLine.split (" ", 4);
        // handle unary operations
        if (theWords.length == 2) {
            numOpnds = 1;
            pre = theWords [0];
            inter = null;
            post = theWords[1];
        }
        // handle binary operations
        else if (theWords.length == 3) {
            numOpnds = 2;
            pre = theWords [0];
            inter = theWords [1];
            post = theWords [2];
        }
        // handle ternary operations
        else if (theWords.length == 4) {
            numOpnds = 3;
            pre = theWords [0];
            inter = theWords [1];
            post = theWords [3];
        }
        else {
            System.out.println ("Wrong word count on a line.");
            System.exit (-3);
        }

        // append the right number of operands
        node theNode = null;
        theList = new ArrayList <> ();
        for (int i = 0; i < numOpnds; i++) {
            if (0.5 < Math.random ()) {
                theNode = new brnch ();
            }
            else {
                theNode = new leaf ();
            }
            theList.add (theNode);
            theNode.populate ();
        }
    }

    void express () {
        System.out.print (pre);
        boolean first = true;
        for (int i = 0; i < numOpnds; i++) {
            theList.get (i).express ();
            if (first) {
                first = false;
            }
            else {
                System.out.print (inter);
            }
        }
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
    int my_depth;

    void populate () {
        if (null == theScan || !theScan.hasNext ()) {
            try {
                theScan = new Scanner (theFile); }
                catch (FileNotFoundException e) {
                    System.out.println ("Leaf file not found.");
                    System.exit (-2);
            }
        }
        theStr = theScan.next ();
    }

    void express () {
        System.out.print (theStr);
    }
}
