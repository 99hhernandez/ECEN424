# INTRODUCTION
Please read all sections of this document before you begin coding. The purpose of this machine problem is to familiarize you with the basics of Java programming. You will code, compile and demo a simple calculatoron your laptop.


# PROBLEM STATEMENT
In this assignment, implement a calculator that performs the operations of addition, subtraction and multiplication.

### CLASSES
You must create a class called Calculator.

#### Fields

> private String name

#### Methods

> public Float addition (Float A, Float B)\
> public Float subtraction (Float A, Float B)\
> public Float multiplication (Float A, Float B)\
> public void setname (String N)\
> public String getname( )\

### OPERATION
Under the main method, a new Calculator object called mycalc must be created. In your code, call the setname method to set your group number (eg. Group 5) as the name of mycalc. The system must print out the following line (using the getname method):

```
Welcome to the Calculator designed by ”mycalc.name”.
Enter A to Add, S to Subtract, M to Multiply ,and Q to quit.
```

Parse the input as a String and then output:

```
Enter argument 1
Enter argument 2
```

In each case above, wait for an input, parse each input as a String, and then convert to Float. Call the appropriate method on mycalc. 

Print out the answer using the format:

```
The [sum/difference/product] of [argument 1] and [argument 2] is [the answer]
```

Put the whole code in a while loop, and terminate when Q is entered. Any other inputs should returnthe user to the Welcome message.

# EVALUATION GUIDELINES

1. Check the operation using test values.
2. Check the code to verify class definitions.
3. Enter arbitrary strings to test for error handling.
