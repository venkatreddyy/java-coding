package com.venkat.codility.medium.StringManipulation;

import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String part : components) {
            if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop(); // Go up a directory
            } else if (!part.equals("") && !part.equals(".")) {
                stack.push(part); // Add directory to the path
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir); // Build the canonical path
        }
        return result.length() > 0 ? result.toString() : "/";
    }

    public static void main(String[] args) {
        String path = "/home//foo/";
        String result = simplifyPath(path);
        System.out.println("Simplified Path: " + result); // Output: "/home/foo"
    }
}

