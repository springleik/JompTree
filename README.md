# JompTree

Java Compiler Test Case Generator JompTree.java randomly creates Java test cases, as described at http://www.williamsonic.com/CompTree/index.html. There you'll find other closely related projects using these same random composite tree techniques to study parsers, interpreters, and compilers in a variety of languages. Of course, any language can be used to create input files for any other language. Branch nodes are created according to parameters set inside the program using operations and functions taken from the text file _Jbrnch.txt_, while leaf nodes are created according to the text file _Jleaf.txt_. Everything is adjustable, so the output can be steered and constrained according to your needs. Leaf values are pulled line-by-line from the leaf file, but don't have to be simple types. The leaf file can also contain valid composite structures including math expressions and function calls as long as each structure is on one line. Console output can be redirected to a Java file to be compiled and executed.

The contents of this repo represent a very small example of a technique which can be scaled and applied in many contexts. In particular, the example shown here makes no attempt to predict what the correct output should be for a program it generates. And the example here makes no distinction between valid inputs which should compile without error, marginal inputs which should throw warnings but still produce code, and invalid inputs which should throw an error and not produce executable code. This example is meant to be simple and clear enough that such improvements can be added according to your needs. As an old colleague used to say, regarding object-oriented programming, "Just subclass it and you're done!"

Following are steps you can use to download, build, and run the JompTree example program. First obtain a local copy of this repo:
'''

'''
