# Methods

So far, we’ve written programs that have only one method, named `main`. However, we can organize programs into multiple methods which allows us to create more complex programs in an organized fashion.

## Defining New Methods

Some methods perform a computation and return a result. For example,
nextDouble reads input from the keyboard and returns it as a `double`. Other methods, like println, carry out a sequence of actions without returning a result. Java uses the keyword `void` to define such methods:

```java
public static void newLine() {
    System.out.println();
}

public static void main(String[] args) {
    System.out.println("First line.");
    newLine();
    System.out.println("Second line.");
}
```

In this example, the newLine and main methods are both `public`, which means
they can be **invoked** (or “called”) from other classes. And they are both `void`,
which means that they don’t return a result (in contrast to `nextDouble`). The
output of the program is shown here:

```
First line.

Second line.
```

Notice the extra space between the lines. If we wanted more space between
them, we could invoke the same method repeatedly. Or we could write yet
another method (named `threeLine`) that displays three blank lines:

```java
public class NewLine {

    public static void newLine() {
        System.out.println();
    }

    public static void threeLine() {
        newLine();
        newLine();
        newLine();
    }

    public static void main(String[] args) {
        System.out.println("First line.");
        threeLine();
        System.out.println("Second line.");
    }
}
```

The output of the program is shown here:

```
First line.



Second line.
```

In this example, the name of the class is `NewLine`. By convention, class
names begin with a capital letter. `NewLine` contains three methods, `newLine`,
`threeLine`, and `main`. Remember that Java is case-sensitive, so `NewLine` and `newLine` are not the same.

## Flow of Execution

When you look at a class definition that contains several methods, it is tempt-
ing to read it from top to bottom. But that is *not* the **flow of execution**, or
the order the program actually runs. The `NewLine` program runs methods in
the opposite order than they are listed.

Programs always begin at the first statement of `main`, regardless of where it is
in the source file. Statements are executed one at a time, in order, until you
reach a method invocation, which you can think of as a detour. Instead of
going to the next statement, you jump to the first line of the invoked method,
execute all the statements there, and then come back and pick up exactly
where you left off.

That sounds simple enough, but remember that one method can invoke another
one. In the middle of `main`, the previous example goes off to execute the
statements in `threeLine`. While in `threeLine`, it goes off to execute `newLine`.
Then `newLine` invokes `println`, which causes yet another detour.

Fortunately, Java is good at keeping track of which methods are running.
So when `println` completes, it picks up where it left off in `newLine`; when
`newLine` completes, it goes back to `threeLine`; and when `threeLine` completes, it gets back to `main`.

Beginners often wonder why it’s worth the trouble to write other methods,
when they could just do everything in `main`. The `NewLine` example demonstrates a few reasons:

- Creating a new method allows you to *name a block of statements*, which
makes the code easier to read and understand.
- Introducing new methods can *make the program shorter* by eliminating
repetitive code. For example, to display nine consecutive newlines, you
could invoke `threeLine` three times.
- A common problem-solving technique is to *break problems down* into subproblems. Methods allow you to focus on each subproblem in isolation,
and then compose them into a complete solution.

Perhaps most importantly, organizing your code into multiple methods allows
you to test individual parts of your program separately. It’s easier to get a
complex program working if you know that each method works correctly.

## Parameters and Arguments

Some of the methods we have used require `arguments`, which are the values
you provide in parentheses when you invoke the method.

For example, the `println` method takes a `String` argument. To display a
message, you have to provide the message: S`ystem.out.println("Hello")`. Similarly, the printf method can take multiple arguments. The statement `System.out.printf("%d in = %f cm\n", inch, cm)` has three arguments:
the format string, the `inch` value, and the `cm` value.

```java
public class PrintTwice {
    public static void printTwice(String s) {
        System.out.println(s);
        System.out.println(s);
    }
    public static void main(String[] args) {
        printTwice("Don't make me say this twice!");
    }
}
```

The `printTwice` method has a parameter named `s` with type `String`. When
you invoke `printTwice`, you have to provide an argument with type `String`.

Before the method executes, the argument gets assigned to the parameter. In
the `printTwice` example, the argument `"Don't make me say this twice!"` gets assigned to the parameter `s`.

This process is called **parameter passing**, because the value gets passed from
outside the method to the inside. An argument can be any kind of expression,
so if you have a `String` variable, you can use its value as an argument:

```java
String message = "Never say never.";
printTwice(message);
```

The value you provide as an argument must have the same (or compatible)
type as the parameter. For example, if you try this:

```java
printTwice(17); // syntax error
```

You will get an error message like this:

```
File: Test.java [line: 10]
Error: method printTwice in class Test cannot be applied
to given types;
    required: java.lang.String
    found: int
    reason: actual argument int cannot be converted to
    java.lang.String by method invocation conversion
```

This error message says that it found an `int` argument, but the required
parameter should be a `String`. In the case of `printTwice`, Java won’t convert
the integer `17` to the string `"17"` automatically.

Sometimes Java can convert an argument from one type to another automatically. For example, `Math.sqrt` requires a `double`, but if you invoke
`Math.sqrt(25)`, the integer value `25` is automatically converted to the floating-
point value `25.0`.

Parameters and other variables exist only inside their own methods. In the
`printTwice` example, there is no such thing as `s` in the `main` method. If you
try to use it there, you’ll get a compiler error.

Similarly, inside `printTwice` there is no such thing as `message`. That variable
belongs to `main`. Because variables exist only inside the methods where they
are defined, they are often called **local variables**.

## Multiple Parameters

Here is an example of a method that takes two parameters:

```java
public static void printTime(int hour, int minute) {
    System.out.print(hour);
    System.out.print(":");
    System.out.println(minute);
}
```

To invoke this method, we have to provide two integers as arguments:
```java
int hour = 11;
int minute = 59;
printTime(hour, minute);
```

Beginners sometimes make the mistake of declaring the arguments:
```java
int hour = 11;
int minute = 59;
printTime(int hour, int minute); // syntax error
```

That’s a syntax error, because the compiler sees int hour and int minute
as variable declarations, not expressions that represent values. You wouldn’t
declare the types of the arguments if they were simply integers:

```java
printTime(int 11, int 59); // syntax error
```

Pulling together the code fragments, here is the complete program:

```java
public class PrintTime {
    public static void printTime(int hour, int minute) {
        System.out.print(hour);
        System.out.print(":");
        System.out.println(minute);
    }
    public static void main(String[] args) {
        int hour = 11;
        int minute = 59;
        printTime(hour, minute);
    }
}
```

`printTime` has two parameters, named `hour` and `minute`. And `main` has two
variables, also named `hour` and `minute`. Although they have the same names,
these variables are *not* the same. The `hour` in `printTime` and the `hour` in
main refer to different memory locations, and they can have different values.

For example, you could invoke `printTime` like this:

```java
int hour = 11;
int minute = 59;
printTime(hour + 1, 0);
```

Before the method is invoked, Java evaluates the arguments; in this example,
the results are `12` and `0`. Then it assigns those values to the parameters. Inside
`printTime`, the value of `hour` is `12`, not `11`, and the value of `minute` is `0`, not
`59`. Furthermore, if `printTime` modifies one of its parameters, that change
has no effect on the variables in `main`.

## Math Methods

You don’t always have to write new methods to get work done. As a reminder,
the Java library contains thousands of classes you can use. For example, the
`Math` class provides common mathematical operations:

```java
double root = Math.sqrt(17.0);
double angle = 1.5;
double height = Math.sin(angle);
```

The first line sets root to the square root of `17`. The third line finds the sine
of 1.5 (the value of `angle`). `Math` is in the `java.lang` package, so you don’t
have to import it.

Values for the trigonometric functions (`sin`, `cos`, and `tan`) must be in *radians*. To convert from degrees to radians, you divide by 180 and multiply by *π*. Conveniently, the `Math` class provides a constant named `PI` that contains an approximation of *π*:

```java
double degrees = 90;
double angle = degrees / 180.0 * Math.PI;
```

Notice that `PI` is in capital letters. Java does not recognize `Pi`, `pi`, or `pie`. Also,
`PI` is the name of a constant, not a method, so it doesn’t have parentheses.
The same is true for the constant `Math.E`, which approximates Euler’s number.

Converting to and from radians is a common operation, so the Math class
provides methods that do that for you:

```java
double radians = Math.toRadians(180.0);
double degrees = Math.toDegrees(Math.PI);
```

Another useful method is `round`, which rounds a floating-point value to the
nearest integer and returns a `long`. The following result is `63` (rounded up
from `62.8319`):

```java
long x = Math.round(Math.PI * 20.0);
```

A `long` is like an `int`, but bigger. More specifically, an `int` uses 32 bits of
memory; the largest value it can hold is $2^{31}$ − 1, which is about 2 billion. A
`long` uses 64 bits, so the largest value is $2^{63}$ − 1, which is about 9 quintillion.

Take a minute to read the documentation for these and other methods in the
Math class. The easiest way to find documentation for Java classes is to do a
web search for “Java” and the name of the class.

## Composition

You have probably learned how to evaluate simple expressions like `sin(π/2)`
and `log(1/x)`. First, you evaluate the expression in parentheses, which is the
argument of the function. Then you can evaluate the function itself, either by
hand or by punching it into a calculator.

This process can be applied repeatedly to evaluate more-complex expressions
like `log(1/ sin(π/2))`. First we evaluate the argument of the innermost function
`(π/2 = 1.57)`, then evaluate the function itself `(sin(1.57) = 1.0)`, and so on.

Just as with mathematical functions, Java methods can be **composed** to solve
complex problems. That means you can use one method as part of another.
In fact, you can use any expression as an argument to a method, as long as
the resulting value has the correct type:

```java
double x = Math.cos(angle + Math.PI / 2.0);
```

This statement divides `Math.PI` by `2.0`, adds the result to `angle`, and com-
putes the cosine of the sum. You can also take the result of one method and
pass it as an argument to another:

```java
double x = Math.exp(Math.log(10.0));
```

In Java, the `log` method always uses base `e`. So this statement finds the log
base `e` of `10`, and then raises `e` to that power. The result gets assigned to `x`.

Some math methods take more than one argument. For example, Math.pow
takes two arguments and raises the first to the power of the second. This line
computes $2^{10}$ and assigns the value `1024.0` to the variable `x`:

```java
double x = Math.pow(2.0, 10.0);
```

When using `Math` methods, beginners often forget the word `Math`. For example,
if you just write `x = pow(2.0, 10.0)`, you will get a compiler error:

```
File: Test.java [line: 5]
Error: cannot find symbol
    symbol: method pow(double,double)
    location: class Test
```

The message “cannot find symbol” is confusing, but the last two lines provide
a useful hint. The compiler is looking for a method named `pow` in the file
`Test.java` (the file for this example). If you don’t specify a class name when
referring to a method, the compiler looks in the current class by default.

## Return Values
When you invoke a `void` method, the invocation is usually on a line all by
itself. For example:

```java
printTime(hour + 1, 0);
```

On the other hand, when you invoke a value-returning method, you have to
do something with the return value. We usually assign it to a variable or use
it as part of an expression, like this:

```java
double error = Math.abs(expect - actual);
double height = radius * Math.sin(angle);
```

Compared to `void` methods, value-returning methods differ in two ways:

- They declare the type of the return value (the **return type**).
- They use at least one `return` statement to provide a **return value**.

Here’s an example from a program named *Circle.java*. The `calculateArea`
method takes a `double` as a parameter and returns the area of a circle with
that radius (i.e., $πr^2$):

```java
public static double calculateArea(double radius) {
    double result = Math.PI * radius * radius;
    return result;
}
```

As usual, this method is `public` and `static`. But in the place where we are
used to seeing `void`, we see `double`, which means that the return value from
this method is a `double`.

The last line is a new form of the `return` statement that means, “Return
immediately from this method, and use the following expression as the return
value.” The expression you provide can be arbitrarily complex, so we could
have written this method more concisely:

```java
public static double calculateArea(double radius) {
    return Math.PI * radius * radius;
}
```

The type of the expression in the `return` statement must match the return
type of the method itself. When you declare that the return type is `double`,
you are making a promise that this method will eventually produce a `double`
value. If you try to `return` with no expression, or `return` an expression with
the wrong type, the compiler will give an error.

## Glossary

**void:** A special return type indicating the method does not return a value.

**invoke:** To cause a method to execute. Also known as “calling” a method.

**flow of execution:** The order in which Java executes methods and statements. It may not necessarily be from top to bottom in the source file.

**argument:** A value that you provide when you call a method. This value
must have the type that the method expects.

**parameter:** A piece of information that a method requires before it can run.
Parameters are variables: they contain values and have types.

**parameter passing:** The process of assigning an argument value to a parameter variable.

**local variable:** A variable declared inside a method. Local variables cannot
be accessed from outside their method.

**composition:** The ability to combine simple expressions and statements into
compound expressions and statements.

**return type:** The type of value a method returns.

**return value:** The value provided as the result of a method invocation.

### Credits

Full credit goes to the book [Think Java: How to Think Like a Computer Scientist 2nd Edition](https://greenteapress.com/thinkjava7/thinkjava2.pdf), Version 7.1.0 by Allen B. Downey and Chris Mayfield. Most of the lessons content are excerpts from this book.