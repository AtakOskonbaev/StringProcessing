package org.example;
import java.util.Stack;

public class StringProcessor {
    public boolean isStrongPassword(String password)
    {
        int n = password.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false, specialChar = false;
        char[] special = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+', ' '};
        for (char i : password.toCharArray())
        {
            if (Character.isLowerCase(i))
                hasLower = true;
            if (Character.isUpperCase(i))
                hasUpper = true;
            if (Character.isDigit(i))
                hasDigit = true;
            if (isCharInArray(i, special))
                specialChar = true;

            if (hasLower && hasUpper && hasDigit && specialChar)
                return true;
        }
        return hasLower && hasUpper && hasDigit && specialChar;
    }
    //helper
    private boolean isCharInArray(char target, char[] array) {
        for (char c : array) {
            if (c == target) {
                return true;
            }
        }
        return false;
    }

    public int calculateDigits(String sentence)
    {
        int counter = 0;
        for (char c : sentence.toCharArray())
        {
            if(Character.isDigit(c))
            {
                counter++;
            }
        }
        return counter;
    }

    public int calculateWords(String sentence)
    {
        sentence = sentence.trim();
        if (sentence.isEmpty()) {
            return 0;
        }
        String[] words = sentence.split("\\s+");

        return words.length;
    }

    public double calculateExpression(String expression) {
        char[] tokens = expression.toCharArray();

        // Stacks to store operands and operators
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        // Iterate through each character in the expression
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue; // Skip spaces

            // If the character is a digit or a decimal point, parse the number
            if ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.') {
                StringBuilder sb = new StringBuilder();
                // Collect digits and the decimal point
                while (i < tokens.length && (Character.isDigit(tokens[i]) || tokens[i] == '.')) {
                    sb.append(tokens[i]);
                    i++;
                }
                // Push the parsed number onto the values stack
                values.push(Double.parseDouble(sb.toString()));
                i--; // Adjust for the extra increment
            } else if (tokens[i] == '(') {
                // Push '(' onto the operators stack
                operators.push(tokens[i]);
            } else if (tokens[i] == ')') {
                // Pop and apply operators until '(' is encountered
                while (operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop(); // Pop the '('
            } else if (tokens[i] == '+' || tokens[i] == '-'
                    || tokens[i] == '*' || tokens[i] == '/') {
                // Pop and apply operators with higher precedence
                while (!operators.isEmpty() && hasPrecedence(tokens[i], operators.peek())) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                // Push the current operator onto the operators stack
                operators.push(tokens[i]);
            }
        }

        // Process any remaining operators in the stack
        while (!operators.isEmpty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }

        // The result is the only remaining element in the values stack
        return values.pop();
    }

    // Function to check if operator1 has higher precedence than operator2
    private static boolean hasPrecedence(char operator1, char operator2) {
        // '(' has the lowest precedence
        if (operator2 == '(' || operator2 == ')')
            return false;
        // Higher precedence for '*' and '/' than '+' and '-'
        return (operator1 != '*' && operator1 != '/') || (operator2 != '+' && operator2 != '-');
    }

    // Function to apply the operator to two operands
    private static double applyOperator(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new ArithmeticException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

}
