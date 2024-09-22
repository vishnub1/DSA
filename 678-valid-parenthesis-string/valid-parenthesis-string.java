import java.util.Stack;

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openStack = new Stack<>(); // Stack to store indices of '('
        Stack<Integer> starStack = new Stack<>(); // Stack to store indices of '*'

        // Traverse through the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openStack.push(i); // Push index of '(' to openStack
            } else if (c == '*') {
                starStack.push(i); // Push index of '*' to starStack
            } else if (c == ')') {
                if (!openStack.isEmpty()) {
                    openStack.pop(); // Match ')' with '('
                } else if (!starStack.isEmpty()) {
                    starStack.pop(); // Match ')' with '*' (treat * as '(')
                } else {
                    return false; // No matching '(' or '*' for ')', so invalid
                }
            }
        }

        // Now try to match remaining '(' in openStack with '*' from starStack
        while (!openStack.isEmpty()) {
            if (starStack.isEmpty()) {
                return false; // No '*' left to match with '('
            } else if (openStack.peek() < starStack.peek()) {
                openStack.pop(); // Match '(' with '*' occurring after it
                starStack.pop();
            } else {
                return false; // '(' occurs after '*' which can't match, so invalid
            }
        }

        return true; // All parentheses are balanced
    }
}
