package Chapter4;

import java.util.Stack;

public class SortStack {

	public static Stack<Integer> getSortedStack(Stack<Integer> input) {
		if (input.isEmpty())
			return input;

		Stack<Integer> temp = new Stack<Integer>();

		while (!input.isEmpty()) {
			int x = input.pop();

			while (!temp.isEmpty() && temp.peek() > x) {
				input.push(temp.pop());
			}

			temp.push(x);
		}

		return temp;
	}

	public static void main(String[] args) {

		Stack<Integer> input = new Stack<Integer>();
		input.add(5);
		input.add(1);
		input.add(4);
		input.add(3);
		input.add(2);

		System.out.println("Original Stack : " + input);
		Stack<Integer> output = getSortedStack(input);
		System.out.println("Sorted Stack : " + output);
	}

}
