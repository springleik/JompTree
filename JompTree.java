/* Java Compiler Test Case Generator
* File JompTree.java
* M. Williamsen
* 21 June 2026
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;

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
        File brnchFile = new File (args[0]);
        File leafFile = new File (args[1]);
        try {
        leaf.theScan = new Scanner (leafFile);
        brnch.theScan = new Scanner (brnchFile); }
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
            listHead.express ();

            // express tree recursively as text on console
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
    static Scanner theScan;

    // instance members
    String pre;
    String inter;
    String post;
    List <node> the_list;
    void populate () {
        if (theScan.hasNext ()) {
            pre = theScan.next ();
        }

    }
    void express () {
        System.out.println (pre);
    }
}

// component class, no child nodes
class leaf extends node {
    // class members
    static Scanner theScan;

    // instance members
    String the_str;
    int my_depth;
    void populate () {
        ;
    }
    void express () {
        ;
    }
}
