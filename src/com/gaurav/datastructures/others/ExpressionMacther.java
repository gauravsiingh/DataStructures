package com.gaurav.datastructures.others;

import com.gaurav.datastructures.stack.LinkedStack;
import com.gaurav.datastructures.stack.Stack;

public class ExpressionMacther {

	public static void main(String[] args) {

		System.out.println(isMatched("()(()){([()])}"));

		System.out.println(isMatched("({[])}"));

	}

	/** Tests if delimiters in the given expression are properly matched. */
	public static boolean isMatched(String expression) {
		final String opening = "({["; // opening delimiters
		final String closing = ")}]"; // respective closing delimiters
		Stack<Character> buffer = new LinkedStack<>();
		for (char c : expression.toCharArray()) {
			if (opening.indexOf(c) != -1) // this is a left delimiter
				buffer.push(c);
			else if (closing.indexOf(c) != -1) { // this is a right delimiter
				if (buffer.isEmpty()) // nothing to match with
					return false;
				if (closing.indexOf(c) != opening.indexOf(buffer.pop()))
					return false; // mismatched delimiter
			}
		}
		return buffer.isEmpty(); // were all opening delimiters matched?
	}

}
