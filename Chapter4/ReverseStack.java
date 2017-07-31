package Chapter4;

import java.util.Stack;

public class ReverseStack {

	public static void insertAtBottom(Stack<Integer> s, int x) {
		if (s.isEmpty()) {
			s.add(x);
			return;
		}

		int temp = s.pop();
		insertAtBottom(s, x);
		s.push(temp);
	}

	public static void reverseStack(Stack<Integer> s) {
		if (s.isEmpty())
			return;

		int temp = s.pop();
		reverseStack(s);
		insertAtBottom(s, temp);

	}

	public static void printStack(Stack<Integer> s) {
		if (s.isEmpty())
			return;

		int x = s.pop();
		System.out.println(x);
		printStack(s);
		s.push(x);
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);

		printStack(s);
		reverseStack(s);
		System.out.println("=======================");
		printStack(s);

	}

}
