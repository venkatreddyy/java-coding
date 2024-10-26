package com.venkat.codility.hard.StackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/*
To solve the Nested Bracket Matching problem with complex cases in Java, where we have multiple types of brackets (e.g., (), {}, [], <>), we need to verify that:

Every opening bracket has a corresponding closing bracket.
Brackets are correctly nested, meaning that a closing bracket must match the most recent unmatched opening bracket.
Approach:
Use a stack to keep track of opening brackets.
As we iterate through the string:
Push opening brackets onto the stack.
For each closing bracket, check that it matches the top of the stack. If it matches, pop the stack; otherwise, it’s invalid.
After processing the entire string, the stack should be empty if all brackets are matched correctly.


Explanation:
bracketPairs Map: Maps each closing bracket to its corresponding opening bracket for easy lookup.
Stack Operations:
Push opening brackets onto the stack.
For each closing bracket, check if it matches the top of the stack.
If it doesn’t match or the stack is empty when a closing bracket appears, it indicates an invalid structure.
Final Check: If the stack is empty after processing the string, all brackets are matched correctly.
Example Outputs
Test 1: {[()]}

Output: true
Explanation: Brackets are properly nested and matched.
Test 2: {[(<>)()]}

Output: true
Explanation: All types of brackets are correctly nested.
Test 3: {[(()]>

Output: false
Explanation: The last closing bracket > does not match the expected ).
Test 4: {[(])}

Output: false
Explanation: Incorrect nesting with [ ] and ( ).
Complexity Analysis
Time Complexity:
𝑂(𝑛)
O(n), where n is the length of the input string, as we process each character once.
Space Complexity:
𝑂(𝑛)
O(n) in the worst case if all characters are opening brackets, requiring storage in the stack.
This approach provides an efficient solution for complex nested bracket matching with various bracket types. Let me know if you need additional examples or clarifications!

 */
public class NestedBracketMatching {

    public static boolean isValid(String s) {
        // Map of matching pairs for brackets
        Map<Character, Character> bracketPairs = new HashMap<>();
        bracketPairs.put(')', '(');
        bracketPairs.put('}', '{');
        bracketPairs.put(']', '[');
        bracketPairs.put('>', '<');

        // Stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            if (bracketPairs.containsValue(ch)) {
                // If it's an opening bracket, push onto the stack
                stack.push(ch);
            } else if (bracketPairs.containsKey(ch)) {
                // If it's a closing bracket, check for matching opening bracket
                if (stack.isEmpty() || stack.pop() != bracketPairs.get(ch)) {
                    return false; // Unmatched or incorrect nesting
                }
            }
        }

        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Test cases
        String test1 = "{[()]}";        // Balanced
        String test2 = "{[(<>)()]}";    // Balanced
        String test3 = "{[(()]>";       // Unbalanced
        String test4 = "{[(])}";        // Incorrectly nested

        System.out.println("Test 1: " + isValid(test1)); // Expected: true
        System.out.println("Test 2: " + isValid(test2)); // Expected: true
        System.out.println("Test 3: " + isValid(test3)); // Expected: false
        System.out.println("Test 4: " + isValid(test4)); // Expected: false
    }
}

