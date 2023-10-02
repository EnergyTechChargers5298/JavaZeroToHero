# Introduction to Java

As programmers our goal is to solve complex problems through code. We build a **program** which is a sequence of instructions that specifies how to perform a
computation on computer hardware. The computation might be something
mathematical, like solving a system of equations or finding the roots of a poly-
nomial. It could also be a symbolic computation, like searching and replacing
text in a document or (strangely enough) compiling a program.

The details look different in different languages, but a few basic instructions
appear in just about every language:

1. **input:** Get data from the keyboard, a file, a sensor, or some other device.
2. **output:** Display data on the screen, or send data to a file or other device.
3. **math:** Perform basic mathematical operations like addition and division.
4. **decision:** Check for certain conditions and execute the appropriate code.
5. **repetition:** Perform an action repeatedly, usually with some variation.

Believe it or not, that’s pretty much all there is to it. Every program you’ve
ever used, no matter how complicated, is made up of small instructions that
look much like these. So you can think of programming as the process of
breaking down a large, complex task into smaller and smaller subtasks. The
process continues until the subtasks are simple enough to be performed with
the electronic circuits provided by the hardware.

## Our First Program

Traditionally, the first program you write when learning a new programming
language is called the “Hello World” program. All it does is output the words
`Hello, World!` to the screen. In Java, it looks like this:

```java
public class Hello {
    public static void main(String[] args) {
        // generate some simple output
        System.out.println("Hello, World!");
    }
}
```

When this program runs, it displays the following:

```
Hello, World!
```

Java programs are made up of *class* and *method* definitions, and methods are
made up of *statements*. A *statement* is a line of code that performs a basic action. In the Hello World program, this line is a *print* statement that displays a message to the user:

```java
System.out.println("Hello, World!");
```

`System.out.println` displays results on the screen; the name `println` stands
for “print line”. Confusingly, *print* can mean both “display on the screen” and
“send to the printer”. In Java, we’ll try to say “display” when we mean
output to the screen. Like most statements, the print statement ends with a
semicolon (;).

Java is “case-sensitive”, which means that uppercase and lowercase are not the
same. In the Hello World program, `System` has to begin with an uppercase
letter; `system` and `SYSTEM` won’t work.

A **method** is a named sequence of statements. This program defines one
method named `main`:

```java
public static void main(String[] args)
```

The name and format of `main` is special: when the program runs, it starts at
the first statement in `main` and ends when it finishes the last statement. Later,
you will see programs that define more than one method.

This program defines a class named `Hello`. For now, a **class** is a collection
of methods; we’ll have more to say about this later. You can give a class any
name you like, but it is conventional to start with a capital letter. The name
of the class has to match the name of the file it is in, so this class has to be in
a file named *Hello.java*.

Java uses curly braces (`{` and `}`) to group things together. In *Hello.java*, the
outermost braces contain the class definition, and the inner braces contain the
method definition.

The line that begins with two slashes (`//`) is a **comment**, which is a bit of
English text that explains the code. When Java sees `//`, it ignores everything
from there until the end of the line. Comments have no effect on the execution
of the program, but they make it easier for other programmers (and your future
self) to understand what you meant to do.

## Displaying Multiple Messages

You can put as many statements as you like in the `main` method. For example,
to display more than one line of output:

```java
public class Hello2 {
    public static void main(String[] args) {
        // generate some simple output
        System.out.println("Hello, World!"); // first line
        System.out.println("How are you?"); // another line
    }
}
```

As this example also shows, you can put comments at the end of a line as well
as on lines all by themselves.

Phrases that appear in quotation marks are called **strings**, because they con-
tain a sequence of characters strung together in memory. Characters can be
letters, numbers, punctuation marks, symbols, spaces, tabs, etc.

`System.out.println` appends a special character, called a **newline**, that
moves to the beginning of the next line. If you don’t want a newline at the
end, you can use `print` instead of `println`:

```java
public class Goodbye {
    public static void main(String[] args) {
        System.out.print("Goodbye, ");
        System.out.println("cruel world");
    }
}
```

In this example, the first statement does not add a newline, so the output appears on a single line:

```
Goodbye, cruel world
```

Notice that there is a space at the end of the first string, which appears in the
output just before the word `cruel`.

## Using Escape Sequences

It’s possible to display multiple lines of output with only one line of code. You
just have to tell Java where to put the line breaks:

```java
public class Hello3 {
    public static void main(String[] args) {
        System.out.print("Hello!\nHow are you doing?\n");
    }
}
```

The output is two lines, each ending with a newline character:

```
Hello!
How are you doing?
```

Each `\n` is an **escape sequence**, or two characters of source code that represent a single character. (The backslash allows you to *escape* the string to
write special characters.) Notice there is no space between `\n` and `How`. If you
add a space there, there will be a space at the beginning of the second line.

| Symbol | Escape Sequence |
| - | - |
| `\n` | newline |
| `\t` | tab |
| `\"` | double quote |
| `\\` | backslash |

Java has a total of eight escape sequences, and the four most commonly used ones are listed in the table above. For example, to write quotation marks inside of
strings, you need to escape them with a backslash:

```java
System.out.println("She said \"Hello!\" to me.");
```

The result is as follows:

```
She said "Hello!" to me.
```

## Debugging

Whenever you are experimenting with a new feature, you should also try to
make mistakes. For example, in the Hello World program, what happens if
you leave out one of the quotation marks? What if you leave out both? What
if you spell `println` wrong? These kinds of experiments help you remember
what you read. They also help with debugging, because you learn what the
error messages mean. It is better to make mistakes now and on purpose than
later on and accidentally.

Debugging is like an experimental science: once you have an idea about what
is going wrong, you modify your program and try again. If your hypothesis
was correct, then you can predict the result of the modification, and you take
a step closer to a working program. If your hypothesis was wrong, you have
to come up with a new one.

Programming and debugging should go hand in hand. Don’t just write a bunch
of code and then perform trial-and-error debugging until it all works. Instead,
start with a program that does *something* and make small modifications, de-
bugging them as you go, until the program does what you want. That way,
you will always have a working program, and isolating errors will be easier.

Finally, programming sometimes brings out strong emotions. If you are strug-
gling with a difficult bug, you might feel angry, despondent, or embarrassed.
Remember that you are not alone, and virtually every programmer has had
similar experiences. Don’t hesitate to reach out to a friend and ask questions!


## Glossary

**problem solving:** The process of formulating a problem, finding a solution,
and expressing the solution.

**program:** A sequence of instructions that specifies how to perform tasks on
a computer. Also known as “software”.

**programming:** The application of problem solving to creating executable
computer programs.

**statement:** Part of a program that specifies one step of an algorithm.

**print statement:** A statement that causes output to be displayed on the
screen.

**method:** A named sequence of statements.

**class:** For now, a collection of related methods. (You will see later that there
is a lot more to it.)

**comment:** A part of a program that contains information about the program
but has no effect when the program runs.

**string:** A sequence of characters; the primary data type for text.

**newline:** A special character signifying the end of a line of text. Also known
as “line ending”, “end of line” (EOL), or “line break”.

**escape sequence:** A sequence of code that represents a special character
when used inside a string.

**algorithm:** A procedure or formula for solving a problem, with or without a
computer.

**computer science:** The scientific and practical approach to computation
and its applications.

**bug:** An error in a program.

**debugging:** The process of finding and removing errors.


### Credits

Full credit goes to the book [Think Java: How to Think Like a Computer Scientist 2nd Edition](https://greenteapress.com/thinkjava7/thinkjava2.pdf), Version 7.1.0 by Allen B. Downey and Chris Mayfield. Most of the lessons content are excerpts from this book.