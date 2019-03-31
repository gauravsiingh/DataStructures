package com.gaurav.datastructures.impl;

import com.gaurav.datastructures.stack.LinkedStack;
import com.gaurav.datastructures.stack.Stack;

public class ExpressionMacther {

	public static void main(String[] args) {

		String input1 = "()(()){([()])}";
		String input2 = "((()(()){([()])}))";
		String input3 = ")(()){([()])}";
		String input4 = "({[])}";
		String input5 = "(()";

		/*System.out.println("For -> " + input1 + " " + isMatched(input1));

		
		System.out.println("\n\n********************");

		System.out.println("For -> " + input2 + " " + isMatched(input2));

		System.out.println("\n\n********************");

		System.out.println("For -> " + input3 + " " + isMatched(input3));

		System.out.println("\n\n********************");

		System.out.println("For -> " + input4 + " " + isMatched(input4));

		System.out.println("\n\n********************");*/

		System.out.println("For -> " + input5 + " " + isExpressionMatched(input5));
		 

	}

	/** Tests if delimiters in the given expression are properly matched. */
	public static boolean isExpressionMatched(String expression) {
		final String opening = "({["; // opening delimisiters
		final String closing = ")}]"; // respective closing delimiters
		Stack<Character> buffer = new LinkedStack<>();
		int itr = 0;
		for (char c : expression.toCharArray()) {
			System.out.println("itr: " + itr++);
			if (opening.indexOf(c) != -1) // this is a left delimiter
			{
				System.out.println("In first if: " + opening.indexOf(c));
				buffer.push(c);
				System.out.println("Stack contains: " + buffer.top());
			} else if (closing.indexOf(c) != -1) { // this is a right delimiter
				System.out.println("In else if");
				if (buffer.isEmpty()) // nothing to match with
				{
					System.out.println("In else if-if");
					return false;
				}
				int cind = closing.indexOf(c);
				int oindpop = opening.indexOf(buffer.pop());
				if (cind != oindpop) {
					System.out.println("In last if");
					System.out.println(closing.indexOf(c));
					System.out.println(buffer.top());
					return false; // mismatched delimiter
				}
			}
		}
		return buffer.isEmpty(); // were all opening delimiters matched?
	}

	/** Tests if every opening tag has a matching closing tag in HTML string. */
	public static boolean isHTMLMatched(String html) {
		Stack<String> buffer = new LinkedStack<>();
		int j = html.indexOf('<'); // find first ’<’ character (if any)
		while (j != -1) {
			int k = html.indexOf('>', j + 1); // find next ’>’ character
			if (k == -1)
				return false; // invalid tag
			String tag = html.substring(j + 1, k); // strip away < >
			if (!tag.startsWith("/")) // this is an opening tag
				buffer.push(tag);
			else { // this is a closing tag
				if (buffer.isEmpty())
					return false; // no tag to match
				if (!tag.substring(1).equals(buffer.pop()))
					return false; // mismatched tag
			}
			j = html.indexOf('<', k + 1); // find next ’<’ character (if any)
		}
		return buffer.isEmpty(); // were all opening tags matched?
	}

}
