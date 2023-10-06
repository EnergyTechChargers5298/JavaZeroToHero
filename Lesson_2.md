# Variables and Operators

One of the most powerful features of a programming language is the ability to define and manipulate variables. A **variable** is a named location in memory that stores a value. Values may be numbers, text, images, sounds, and other types of data. 

## Declaring Variables

To store a value, you first have to declare a variable:

```java
String message;
```

This statement is called a **declaration**, because it declares that the variable message has the type String. Each variable has a type that determines what kind of values it can store. For example, the `int` type can store integers like `1` and `-5`, and the char type can store characters like `'A'` and `'z'`. Some types begin with a capital letter and some with lowercase. You will learn the significance of this distinction later, but for now you should take care to get it right. There is no such type as `Int` or `string`.

To declare an integer variable named `x`, you simply type this:

```java
int x;
```

Note that `x` is an arbitrary name for the variable. In general, you should use
names that indicate what the variables mean:

```java
String firstName;
String lastName;
int hour, minute;
```

This example declares two variables with type `String` and two with type `int`.
The last line shows how to declare multiple variables with the same type: `hour`
and `minute` are both integers. Note that each declaration statement ends with
a semicolon (;).

Variable names usually begin with a lowercase letter, in contrast to class names
(like `Hello`) that start with a capital letter. When a variable name con-
tains more than one word (like `firstName`), it is conventional to capitalize
the first letter of each subsequent word. Variable names are case-sensitive, so
`firstName` is not the same as `firstname` or `FirstName`.

You can use any name you want for a variable. But there are about 50 reserved words, called **keywords**, that you are not allowed to use as variable names. These words include `public`, `class`, `static`, `void`, and `int`, which are used by the compiler to analyze the structure of the program. The full list of keywords can be found here on the [online](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html).

## Assigning Variables

Now that we have declared some variables, we can use them to store values. We do that with an **assignment** statement:

```java
message = "Hello!"; // give message the value "Hello!"
hour = 11; // assign the value 11 to hour
minute = 59; // set minute to 59
```

This example shows three assignments, and the comments illustrate different
ways people sometimes talk about assignment statements. The vocabulary
can be confusing here, but the idea is straightforward:

- When you declare a variable, you create a named storage location.
- When you make an assignment to a variable, you update its value.

As a general rule, a variable has to have the same type as the value you
assign to it. For example, you cannot store a string in `minute` or an integer 
`message`. We will show some examples that seem to breaink this rule, but we’ll
get to that later.

A common source of confusion is that some strings look like integers, but they
are not. For example, message can contain the string `"123"`, which is made
up of the characters `'1'`, `'2'`, and `'3'`. But that is not the same thing as the
integer `123`:

```java
message = "123";  // legal
message = 123; // not legal
```

Variables must be **initialized** (assigned for the first time) before they can
be used. You can declare a variable and then assign a value later, as in the
previous example. You can also declare and initialize on the same line:

```java 
String message = "Hello!";
int hour = 11;
int minute = 59;
```

## Printing Variables

You can display the current value of a variable by using `print` or `println`.
The following statements declare a variable named `firstLine`, assign it the
value `"Hello, again!"`, and display that value:

```java
String firstline = "Hello, again!";
System.out.println(firstLine);
```

When we talk about displaying a variable, we generally mean the *value* of the
variable. To display the *name* of a variable, you have to put it in quotes:

```java
System.out.print("The value of firstLine is ");
System.out.println(firstLine);
```

For this example, the output is as follows:

```
The value of firstLine is Hello, again!
```

Conveniently, the code for displaying a variable is the same regardless of its
type. For example:

```java
int hour = 11;
int minute = 59;
System.out.print("The current time is ");
System.out.print(hour);
System.out.print(":");
System.out.print(minute);
System.out.println(".");
```

The output of this program is shown here:

```java
The current time is 11:59.
```

## Arithmetic Operators

**Operators** are symbols that represent simple computations. For example, the
addition operator is +, subtraction is -, multiplication is *, and division is /.

The following program converts a time of day to minutes:

```java
int hour = 11;
int minute = 59;
System.out.print("Number of minutes since midnight: ");
System.out.println(hour * 60 + minute);
```

The output is as follows:

```java
Number of minutes since midnight: 719
```

In this program, `hour * 60 + minute` is an **expression**, which represents a
single value to be computed `(719)`. When the program runs, each variable is
replaced by its current value, and then the operators are applied. The values
that operators work with are called **operands**.

Expressions are generally a combination of numbers, variables, and operators.
When compiled and executed, they become a single value. For example, the
expression `1 + 1` has the value `2`. In the expression `hour - 1`, Java replaces
the variable with its value, yielding `11 - 1`, which has the value `10`.

In the expression `hour * 60 + minute`, both variables get replaced, yielding
`11 * 60 + 59`. The multiplication happens first, yielding `660 + 59`. Then
the addition yields `719`.

Addition, subtraction, and multiplication all do what you expect, but you
might be surprised by division. For example, the following fragment tries to
compute the fraction of an hour that has elapsed:

```java
System.out.print("Fraction of the hour that has passed: ");
System.out.println(minute / 60);
```

The output is as follows:

```
Fraction of the hour that has passed: 0
```

This result often confuses people. The value of minute is `59`, and `59` divided
by `60` should be `0.98333`, not `0`. The problem is that Java performs integer
division when the operands are integers. By design, *integer division* always
rounds toward zero, even in cases like this one where the next integer is close.

## Decimal Numbers

A more general solution is to use floating-point numbers, which represent
values with decimal places. In Java, the default floating-point type is called
double, which is short for “double-precision”. You can create double variables
and assign values to them the same way we did for the other types:

```java
double pi;
pi = 3.14159;
```

Java performs *floating-point division* when one or more operands are `double`
values. So we can solve the problem from the previous section:

```java
double minute = 59.0;
System.out.print("Fraction of the hour that has passed: ");
System.out.println(minute / 60.0);
```

The output is shown here:

```java
Fraction of the hour that has passed: 0.9833333333333333
```

It is important to note that Java treats `1` and `1.0` very differently even though they seem to be the same number because they belong to different data types.

## Operators for Strings

In general, you cannot perform mathematical operations on strings, even if
the strings look like numbers. The following expressions are illegal:

```java
"Hello" - 1     "World" / 123    "Hello" * "World"
```

The + operator works with strings, but it might not do what you expect. For
strings, the + operator performs concatenation, which means joining end-to-
end. So `"Hello, " + "World!"` yields the string `"Hello, World!"`.

Likewise if you have a variable called name that has type `String`, the expression
`"Hello, " + name appends the value of `name` to the hello string, which creates
a personalized greeting.

Since addition is defined for both numbers and strings, Java performs automatic conversions you may not expect:

```java
System.out.println(1 + 2 + "Hello");
// the output is 3Hello
System.out.println("Hello" + 1 + 2);
// the output is Hello12
```

Java executes these operations from left to right. In the first line, `1 + 2` is
`3`, and `3 + "Hello"` is `"3Hello"`. But in the second line, `"Hello" + 1` is
`"Hello1"`, and `"Hello1" + 2` is `"Hello12"`.

When more than one operator appears in an expression, they are evaluated
according to the order of operations. Generally speaking, Java evaluates
operators from left to right (as you saw in the previous section). But for
numeric operators, Java follows mathematical conventions:

- Multiplication and division take “precedence” over addition and subtraction, which means they happen first. So `1 + 2 * 3` yields `7`, not `9`, and
`2 + 4 / 2` yields `4`, not `3`.

- If the operators have the same precedence, they are evaluated from left
to right. So in the expression `minute * 100 / 60`, the multiplication
happens first; if the value of `minute is 59`, we get `5900 / 60`, which
yields `98`. If these same operations had gone from right to left, the result
would have been `59 * 1`, which is incorrect.
- Anytime you want to override the order of operations (or you are not
sure what it is) you can use parentheses. Expressions in parentheses are
evaluated first, so `(1 + 2) * 3` is `9`. You can also use parentheses to
make an expression easier to read, as in `(minute * 100) / 60`, even
though it doesn’t change the result.

## Taking Input

Many programs are built to be interative with the user. Now that we can store data, we should be able to store the input of a user and then utilize that variable to build more complex programs.

To take input, we need to use to use a prebuilt class. `Scanner` is a class that provides methods for inputting words,cnumbers, and other data. Scanner is provided by `java.util`, which is a
package that contains various “utility classes”. Before you can use `Scanner`,
you have to import it like this (goes at the top of your file outside the class definition):

```java
import java.util.Scanner;
```

This `import statement` tells the compiler that when you refer to `Scanner`,
you mean the one defined in `java.util`. Using an import statement is necessary because there might be another class named Scanner in another package.

Next you have to initialize the `Scanner`. This line declares a `Scanner` variable
named `in` and creates a `Scanner` that reads input from `System.in` which refers to the terminal:

```java
Scanner in = new Scanner(System.in);
```

The `Scanner` class provides a method called `nextLine` that reads a line of
input from the keyboard and returns a `String`. Here’s a complete example
that reads two lines and repeats them back to the user:

```java
import java.util.Scanner;

public class Echo {
    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);

        System.out.print("Type something: ");
        line = in.nextLine();
        System.out.println("You said: " + line);

        System.out.print("Type something else: ");
        line = in.nextLine();
        System.out.println("You also said: " + line);
    }
}
```

The statement `in.nextLine()` allows us to take the next line as input from the user. This is a string input however we can take various other inputs depending on what our program needs.

- `in.next()` will only take the next word as input.
- `in.nextInt()` will take the next integer as input.
- `in.nextDouble()` will take the next double as input.

It is important to note that we use `in` because that is what we named out `Scanner` object.

If we write: 

```java
Scanner obj = new Scanner(System.in);
```

then we would use `obj.nextLine()` to get the line as input and so on.

Finally, import statements can’t be inside a class definition. By convention, they are usually at the beginning of the file. If you omit the import statement, you get a compiler error like “cannot find symbol”. That means the compiler doesn’t know where to find the definition for Scanner.

## Glossary

**variable:** A named storage location for values. All variables have a type,
which is declared when the variable is created.

**value:** A number, string, or other data that can be stored in a variable. Every
value belongs to a type (e.g., `int` or `String`).

**type:** Mathematically speaking, a set of values. The type of a variable deter-
mines which values it can have.

**declaration:** A statement that creates a new variable and specifies its type.

**keyword:** A reserved word used by the compiler to analyze programs. You
cannot use keywords (like `public`, `class`, and `void`) as variable names.

**assignment:** A statement that gives a value to a variable.

**initialize:** To assign a variable for the first time.

**operator:** A symbol that represents a computation like addition, multiplication, or string concatenation.

**operand:** One of the values on which an operator operates. Most operators
in Java require two operands.

**expression:** A combination of variables, operators, and values that represents a single value. Expressions also have types, as determined by their
operators and operands.

**floating-point:** A data type that represents numbers with an integer part
and a fractional part. In Java, the default floating-point type is `double`.

**concatenate:** To join two values, often strings, end to end.

**order of operations:** The rules that determine in what order expressions are
evaluated. Also known as “operator precedence”.

**library:** A collection of packages and classes that are available for use in other
programs.

**import statement:** A statement that allows programs to use classes defined
in other packages.

**prompt:** A brief message displayed in a print statement that asks the user
for input.

### Credits

Full credit goes to the book [Think Java: How to Think Like a Computer Scientist 2nd Edition](https://greenteapress.com/thinkjava7/thinkjava2.pdf), Version 7.1.0 by Allen B. Downey and Chris Mayfield. Most of the lessons content are excerpts from this book.