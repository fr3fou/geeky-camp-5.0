# OOP

[PDF Presentation](https://github.com/GeekyCamp/geeky-camp-5/blob/master/03-java-oop/java-oop.pdf)

## Paradigm for design and implementation

- Contain state (properties)

- Contain methods

- Communicate through messages

## Class

- Defines an object
	- wraps state
	- wraps behaivour - methods
	
- Constructors

- Method - function for manipulating / changing properties

## This

- Refers to the current / ("this") object

- Used as:
	- Accesing properties for "hidden" properties
	- Calling from an overloaded ctor from the same class
	- Caling some method from a class

## Objects

- Is an instance of a class

The following code will output `Ivan` and `Gosho`

```java
Human ivan = new Human("Ivan");
Human gosho = new Human("Gosho");

ivan.whoAmI();
gosho.whoAmI();
```

## Packages

- Named groups for semantically connected classses

- Used for hierarchary organization of the code

- Named after inverted domain addresses
	- Uses only lowercase letters, `.` for a seperator
	- **mail.google.com** -> **com.google.mail**

- Accesing to another class from a different package
 	- Every class has default access to:
		- Classes from its own package
		- Classes from `java.lang`

### Access modifiers

- For Classes
	- public
		- Can be accessed by every class in every package 
	- without a modifier (package-private)
		- Can be accessed by the classes in the same package

- For Properties
	- public
	- protected
	- without a modifier
	- private

## Encapsulation

- Only the inner behaivour (methods) of a given object have access to its state, makes it impossible for unexpected changes to occur.
	- Can be done in Java through the usage of access modifiers

Wrong usage:

```java
public class Human {
	public String name;

	public Human(string name) {
		this.name = name;
	}
}
```

```java
Human human = new Human("Pesho");
human.name = "Gosho"; // bad code!
```

This should be:

```java
public class Human {
	private String name;

	public Human(string name) {
		this.name = name;
	}
}
```

```java
Human human = new Human("Pesho");
human.name = "Gosho"; // wont work!
```

## Inheritance

- Allows the reuseability and extension of behaivour and state from already existing classes

- Is realized in Java using the keyword `extends`

- The child class gets acces to both public and protected properties and methods from the parent

- The child class can override already existing methods (the access modifier in both classes **must** match in both the child parent class)

- Java doesn't allow multiple class inheritance

### The `super` keyword

- Refers to the parent of the object

- Used for:
	- Accessing properties from the parent class
	- Calling the ctor from the parent class
	- Calling methods from the parent class

```java
public class Student extends Human {
	private int facultyNumber;

	public Student(String name, int facultyNumber) {
		super(name);
		this.facultyNumber = facultyNumber;
	}
}
```

```java
Student ivan = new Student("Ivan", 2345);
ivan.whoAmI(); // calls the parent method
```

### Hierachy of classes in Java

- All classes in java are children of the `java.lang.Object` class

### The `instanceof` operator

- Used for type checking: see whether a given object is an instance of a given class

```java
Student ivan = new Student("Ivan", 234343);
Human petar = new Human("Petar");

System.out.println(ivan instanceof Student); // true
System.out.println(ivan instanceof Human); // true
System.out.println(peter instanceof Student); // false
System.out.println(peter instanceof Human); // false
```

### The `final` keyword

- In variable declaration -> makes it constant

- In method declaration -> method can't be overriden

- In class delcaratoin -> class can't be inherited from

## Polymorphism

- From greek "poly" (a lot) + "morphe" (shape / form)

- Used for modifying methods from parent class (runtime overriding) or from the same class (compile-time overloading)

### Abstract classes

- Uses the keyword `abstract`

- Can have methods withtout an implementation

### Interfaces

- Multiple method declarations / signatures without an implementation

## Abstraction

- Means modelling an object from the "real life / virtual world" by "abstacting" yourself from the irrelevant / unneeded parts.

- Example: modelling student, we only give him a Name and Faculty Number, and abstracting yourself from the irrelevant (for instance - eye color)

## The java.lang.Object

- .equals()

- .hashCode()

- .toString()

- .clone()

- Objects are compared for equality with `.equals()`, and **not** with `==`

```java
if("".equals(s)) {
	System.out.println("Empty string");
}
```

### equals()

- Should always be defined in a class

- Should be used when comparing "value equality", rather than their references (addresses in memory)

### hashCode()

- Should be defined when `equals()` has been defined

- When defining it and `equals()` returns true, the hashCode of their objects **must** be equal. If the hashCode of 2 objects are equal, it is not necessarily true that `equals()` returns true.

## The `static` keyword

- Part of the class and not an instance

- Can be accessed without a created object using the name of the class + `.` a (a dot) and the name of the static property / method

```java
Math.PI
Math.pow(double, double)
```

- The static properties / methods have a single copy, which is shared among the instances of classes. 
	- This saves memory

# Exceptions

- Event that happens during runtime and disturbs the usual flow of instructions

- Examples:
	- Wrong input
	- Trying to open a file that doesn't exist
	- Network error
	- VM has ran out of memory

```java
public Object pop() {
	if (size == 0) {
		throw new ZeroStackSizeException();
	} 
}
```	

```java
try {
	// dangerous code
} catch (Exception e) {
	// handling exception
} finally {
	// optional code which gets executed always
}
```

## Exception types

- Checked (Compile-Time)
	- Compiler checks if they have been handled
		- Examples:
			- FileNotFoundException
			- IOException

- Unchecked (Runtime)
	- Occur during the execution of the program
		- Examples:
			- ArithmeticException
			- ArrayIndexOutOfBoundsException
			- NullPointerException
			- NumberFormatException


- Errors
	- Occur "outside" of the program can't be recovered from
		- Examples:
			- OutOfMemoryError
			- StackOverflowError

## Declaring throwable exceptions

- If a given method doesn't handle a **checked** exception, which may be thrown in the body, the method must declare it in the prototype (warns those who call the method)

```java
public void writeList() throws IOException, IndexOutOfBoundsException {
	...
}
```

## Why should exceptions be used?

- Seperates code for handling them -> becomes cleaner

- "Passing" / Throwing them up the call stack

- Grouping and differentiating different types

# Clean Code

## OOP Principles

- Encapsulation
	- Public parts must be kept to a minimum

- Inheritance
	- Don't write duplicate code

- Polymorphism
	- Use polymorphism **always** when possible
	- Use interface for decleration, implementation for initialization

- Abstraction
	- Abstract the irrelevant code	

- A class should do a **single** thing
	- If you have the word `and` in the name, it's most likely wrong
	- If you have the word `Util`, `Manager`, `Utility`, it *may* have better design

- A method should do a single thing
	- Be Short: <= 20 lines
	- If you have the word `and` in the name -> split it
	- If it has a lot of parameters, its class might not be the most appropriate place

- Don't abuse `static`

## Formatting your code

- Format using your IDE's shortcut

- Rather than using "magic numbers", use an appropriately named constant

### Naming conventions

- Match the appropriate naming convention for the language write in

### Comment your code

- Quality code is self-explanatory

## Seperate logic

- I/O (frontend) from buissnes (backend)

- Normal (mainstream) from exception (non-mainstream) 

## Handle Exceptions

- Use exceptions rather than error codes

- Don't supress / swallow exceptions

	- Never leave an empty `catch`

# Collections

- Java provides a handful of collections, all inherited from the `Collection` interface

