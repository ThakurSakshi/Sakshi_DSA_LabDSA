package com.greatlearning.labsession;

import java.util.Stack;

public class BalancingBrackets {
    
    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : input.toCharArray()) {
            if (isOpenBracket(c)) {
                stack.push(c);
            } else if (isCloseBracket(c)) {
                if (stack.isEmpty() || !isMatchingBracket(stack.pop(), c)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    private static boolean isOpenBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }
    
    private static boolean isCloseBracket(char c) {
        return c == ')' || c == ']' || c == '}';
    }
    
    private static boolean isMatchingBracket(char open, char close) {
        return (open == '(' && close == ')') || 
               (open == '[' && close == ']') || 
               (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        String input1 = "([{}])";
        String input2 = "([{})])";

        System.out.println("Sample Input 1: " + input1);
        if (isBalanced(input1)) {
            System.out.println("The entered String has Balanced Brackets");
        } else {
            System.out.println("The entered Strings do not contain Balanced Brackets");
        }

        System.out.println("\nSample Input 2: " + input2);
        if (isBalanced(input2)) {
            System.out.println("The entered String has Balanced Brackets");
        } else {
            System.out.println("The entered Strings do not contain Balanced Brackets");
        }
    }
}
