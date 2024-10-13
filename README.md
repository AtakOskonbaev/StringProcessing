# String Processor

This Java project implements a `StringProcessor` class that provides various utility methods for processing strings, including checking password strength, counting digits and words, and evaluating mathematical expressions.

## Features

- **Check Password Strength**: Determine if a password is strong based on specific criteria (length, presence of upper/lowercase letters, digits, and special characters).
- **Count Digits**: Count the total number of digits in a given string.
- **Count Words**: Count the total number of words in a given sentence.
- **Evaluate Expressions**: Calculate the result of arithmetic expressions involving addition, subtraction, multiplication, and division, including support for parentheses.

### Example of Strong Password Method

```java
StringProcessor.isStrongPassword("examplePassword123!"); // Strong
```

### Example of Count Digits Method

```java
int digitCount = StringProcessor.calculateDigits("The price is 20 dollars."); // Returns 2
```

### Example of Count Words Method

```java
int wordCount = StringProcessor.calculateWords("Hello World!"); // Returns 2
```

### Example of Evaluate Expression Method

```java
double result = StringProcessor.calculateExpression("10 + 2 * 3"); // Returns 16
```