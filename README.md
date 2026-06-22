# JompTree

Java compiler test case generator _JompTree_ randomly creates Java test cases, as described at http://www.williamsonic.com/CompTree/index.html. There you'll find other closely related projects using these same random composite tree techniques to study parsers, interpreters, and compilers in a variety of languages. Of course, any language can be used to create input files for any other language. Branch nodes are created according to parameters set inside the program using operations and functions taken from the text file _Jbrnch.txt_, while leaf nodes are created according to the text file _Jleaf.txt_. Everything is adjustable, so the output can be steered and constrained according to your needs. Leaf values are pulled line-by-line from the leaf file, but don't have to be simple types. The leaf file can also contain valid composite structures including math expressions and function calls as long as each structure is on one line. Console output can be redirected to a Java file to be compiled and executed.

The contents of this repo represent a very small example of a technique which can be scaled and applied in many contexts. In particular, the example shown here makes no attempt to predict what the correct output should be for a program it generates. And the example here makes no distinction between valid inputs which should compile without error, marginal inputs which should throw warnings but still produce code, and invalid inputs which should throw an error and not produce executable code. This example is meant to be simple and clear enough that such improvements can be added according to your needs. As an old colleague used to say, regarding object-oriented programming, "Just subclass it and you're done!"

Following are steps you can use to download, build, and run the JompTree example program. First obtain a local copy of this repo. The following code blocks include the terminal window console prompt, commands you type, and the resulting output:
```
MarksiMac:Projects williamm$ git clone https://github.com/springleik/JompTree.git
Cloning into 'JompTree'...
remote: Enumerating objects: 49, done.
remote: Counting objects: 100% (49/49), done.
remote: Compressing objects: 100% (28/28), done.
remote: Total 49 (delta 19), reused 44 (delta 18), pack-reused 0 (from 0)
Receiving objects: 100% (49/49), 11.14 KiB | 814.00 KiB/s, done.
Resolving deltas: 100% (19/19), done.
```
Navigate into the project folder:
```
MarksiMac:Projects williamm$ cd JompTree
MarksiMac:JompTree williamm$ ls -la
total 64
drwxr-xr-x  10 williamm  staff   340 Jun 22 19:37 .
drwxr-xr-x  18 williamm  staff   612 Jun 22 19:37 ..
drwxr-xr-x  12 williamm  staff   408 Jun 22 19:37 .git
-rw-r--r--   1 williamm  staff   290 Jun 22 19:37 .gitignore
-rw-r--r--   1 williamm  staff    92 Jun 22 19:37 Jbrnch.txt
-rw-r--r--   1 williamm  staff    81 Jun 22 19:37 Jleaf.txt
-rw-r--r--   1 williamm  staff  6540 Jun 22 19:37 JompTree.java
-rw-r--r--   1 williamm  staff  1072 Jun 22 19:37 LICENSE
-rw-r--r--   1 williamm  staff  1893 Jun 22 19:37 README.md
-rw-r--r--   1 williamm  staff  2156 Jun 22 19:37 what.java
```
You'll need to have a Java compiler and interpreter installed:
```
MarksiMac:JompTree williamm$ javac -version
javjavac 1.8.0_51
MarksiMac:JompTree williamm$ java -version
java version "1.8.0_51"
Java(TM) SE Runtime Environment (build 1.8.0_51-b16)
Java HotSpot(TM) 64-Bit Server VM (build 25.51-b03, mixed mode)
```
Build the _JompTree_ program:
```
MarksiMac:JompTree williamm$ javac JompTree.java
```
Run the program without arguments to see the usage text:
```
MarksiMac:JompTree williamm$ java JompTree
Usage: java JompTree Jbrnch.txt Jleaf.txt
```
Run the program with arguments to see generated Java code on the console:
```
Opening branch input file: Jbrnch.txt, leaf input file: Jleaf.txt
class what {
    public static void main(String[] args) {
        double first = 1, second = 2, third = 3;
        System.out.println ((first+second)); /* 2, 1 */
...
```
Redirect the console output to a file, to be compiled:
```
MarksiMac:JompTree williamm$ java JompTree Jbrnch.txt Jleaf.txt > what.java
Opening branch input file: Jbrnch.txt, leaf input file: Jleaf.txt
```
Compile the generated output:
```
MarksiMac:JompTree williamm$ javac what.java
```
Run the random tree test code:
```
MarksiMac:JompTree williamm$ java what
3.0
2.7395043791155023
2.345
-0.6666666666666667
2.0
-123400.0
1.233997655
-1.1109999999999998
NaN
4.0
1.578678038379531E11
1.1108555261599053
3.456
-6
-4.0
3
-0.8786796564403576
-2.345E-6
2.0
-3.0
NaN
-1.90032414910859E-6
1.4142135623730951
20.154700538379252
1.0
```
Assuming you got the same answer I did, you now have a workflow that will let you start experimenting.
