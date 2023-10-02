# Java Basics

Computers are able to do fantastic and complex things like stream videos worldwide, run video games, render complex models, and more. However, what many don't know is that computers are dumb and only can execute simple instructions like add two numbers together. Programmers are able to utilize simple instructions and put them together to built complex ***programs*** which are a set of instructions that can do virtually anything!

![Programming Languages](/img/languages.jpg)

There are many programming languages out there each with their own strengths and weaknesses and there are always new programming languages being created. For this course, we will focus on ***Java*** which is a popular programming language which can be used to code FIRST Robotics Robots. One important thing to note is that every programming language is written differently however the concepts stay mostly the same which means once you learn one programming language, the next one gets much easier to learn!

## Structure

Every Java file ends with a `.java` to denote it was written in Java. An example of a java file is `Playground.java` which is in this folder. Let's take a deeper look at this file.

```java
public class Playground {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

Every Java file we will create starts with `public class <FileName>`. For this case, the file starts with... 

```java 
public class Playground
```

because our file name is `Playground.java`. If our file name was `Robots.java`, then our file would start with...

```java
public class Robots
```

After the class statement, there are `{}` which we call curly braces. Every code we write are inside the curly brace which states to the computer that it is part of the file. If you write code outside the curly brace, it will give you an error (The computer will basically be mad at you).

### Main Method

After the class, we see the statement...

```java
public static void main(String[] args) {

}
```

For Java, treat this like an incantation because the only code that the computer actually runs is the code inside these curly braces. This part of the file is always written the same way.

### Statements

Now that we have done the grunt work to setup our Java file, we can write code! There is already a line inside the curly braces of the main method...

```java
System.out.println("Hello World");
```

This line will print `Hello World` to the ***terminal*** which is a place where our code can output information.

We call lines of code like this a ***statement***, which are similar to sentences. Each statement is one instruction we ask our computer to do. One important thing to note is that in English we end each sentence with a period ( **.** ). In Java, we end every statement with a ( **;** ).

### Printing

Printing displays statements in the terminal. In the examples in this section, it is the `Hello World` sent to the **terminal** from the `System.out.println("Hello World")`.

A **terminal** (this may also be referred to as a **console**) serves as a place for the user to enter and recieve data. Note that it only starts working after "run" is clicked. This would also be the place error codes would appear (this includes but is not limited to: missing `;`, misspelt statements, and stray `{}` or `()`).

There are two ways of writing print statements, and each one will change the way they are displayed in the **terminal**...

```java
System.out.println("Hello World");
System.out.print("Hello World");
```

This code will produce a terminal output that looks like...

```
Hello World
Hello World
```  

While they might appear the same, the difference becomes clearer when you write the `print` before the `println` statement:

```java
System.out.print("Hello World");
System.out.println("Hello World");

```

```
Hello worldHello world
```

This is because `println` creates a **line break** (think when you hit 'enter' on a keyboard) while `print` does not.

### Escape Sequences

Say we wanted to write `"Hello World"` in our terminal. With what we've seen, `System.out.println("Hello World")` only prints `Hello World` without the quotation marks. However, just writing `System.out.println(""Hello World"")` will produce an error, since the statement no longer has the correct **syntax** (any messages within a `System.out.println` have to follow a certain format). There are other **special characters** that will produce the same effect: `'` and `/`.

In order to fix this, we must use **escape sequences** in order to tell the computer to treat the special character like part of the print message...

```java
System.out.println("\"Hello World\"");
```
Notice how it gets written as `\"`. The backslash gets placed before the special character you want to appear.

It's the same way if you want to use a `\` or `'`in your terminal output as well. 

```java
System.out.println("\\Hello World\\");
System.out.println("/'Hello World/'");
```
These statements may look like they will print `\\Hello World\\` and `/'Hello World/'` respectively, but they actually produce `\Hello World\` and `'Hello World'`, since the first `\` is telling the computer to treat the special character immediately following as normal text.

Now that we've covered ways of getting special characters into a normal statement, there are also ways of modifying the statements to easily format them. Say we wanted to achieve the following with one line of code:

```
Hello World
Hello World
```

To achieve this, we *could* write...

```java
System.out.println("Hello World");
System.out.println("Hello World");
```

Or, we could introduce `\n` to be able to write the two `Hello World`s in one statement...

```java
System.out.println("Hello World\nHello World");
```

Notice how it's a regular text character, but with the `\`, it becomes a special formatting character. Everything around the `\n` is still used in the terminal output. Look closely at the following formatting of the `println` statement, and how its respective console output behaves because of the extra spaces.

```java
System.out.println("Hello World \n Hello World");
```

```
Hello World 
 Hello World
```

Say we wanted to now write the two `Hello World`s in same line, but to have a gap in between them. We could achieve this by using spaces, but this makes it hard to be consistent. (*Did I use 5 or 6 spaces?*)

Instead, we insert a tab with `\t`. This behaves similarly to `\n`, where it is affected by spaces. For reference, tabs are equivalent to 4 spaces.

```java
System.out.println("Hello World\tHello World");
```

```
Hello World    Hello World
```


### Methods (with no parameters)

//intro?

Setting up a **method** is similar to setting up your **Main Method** (where we've been writing our "Hello World" print statements.
These new methods will be **nested** inside of our main class but outside of our main method (this can and will change in later lessons).

The syntax for creating a new method with no parameters is as follows:

```java
public static void newMethod() {

}
```

There are a couple of things to note with this setup:

`public` allows for the method to be run anywhere in our code. This isn't entirely relevant at the moment but make sure that you remember that it *can and will* change in future lessons.

`static` simply denotes the method is a part of the class (in this example, it's our main class). This will be important later when we start implementing **objects**.

`void` indicates our **return** type. Void is the only type that does not return a value after running the method.

`newMethod()` is the name of the method: this can change if you want to better describe what your method does. Notice how there is an empty set of parenthasis: this is telling the computer *"because there are no parameters in our method, it does not need any extra information to run"*. Pay attention to the capitalization in the method names: they should always be in camelCase!

Let's use this in another example. Say we want to print `Hello world` three times, have a blank row, then print another three lines of `Hello world`. Writing it all out would give us a very hefty block of code:

```java
System.out.println("Hello World");
System.out.println("Hello World");
System.out.println("Hello World");
System.out.println();
System.out.println("Hello World");
System.out.println("Hello World");
System.out.println("Hello World");
```

We can approach this by writing a `helloWorld()` method that prints it three times *for* us:

```java
public static void helloWorld() {
    System.out.println("Hello World");
    System.out.println("Hello World");
    System.out.println("Hello World");
}
```
Note here how the `helloWorld()` replaced our `newMethod()` from the first example. This is just to show that it's interchangeable.

After writing our `helloWorld()` method, we can *call* it into our main method. This will run the method once, printing `Hello World` three times (as **defined** in our method):

```java
public static void main(String[] args) {
    helloWorld();
}
```
*Notice how there is a `;` after our statement, just like our regular `System.out.println()`.*

Putting this all together in the main class, we get:

```java
class Main {
  public static void main(String[] args) {
    helloWorld();
    System.out.println();
    helloWorld();
  }

  public static void helloWorld(){
    System.out.println("Hello World");
    System.out.println("Hello World");
    System.out.println("Hello World");
  }

}
```


<ins> Quick Reference </ins>

Adding special characters to a statement: 
```java
System.out.println("\"Hello World\"");
System.out.println("\'Hello World\'");
System.out.println("\\Hello World\\");
```

```
"Hello World"
'Hello World'
\Hello World\
```
Adding formatting to a statement:

```java
System.out.println("Hello World\nHello World");
System.out.println("\tHello World\tHello World");
```

```
Hello World
Hello World
    Hello World    Hello World
```

Creating a method with no parameters or return:

```java
public static void newMethod() {
//code goes here;
}
```