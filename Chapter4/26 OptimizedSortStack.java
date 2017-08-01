package Chapter4;

import java.util.Stack;

public class OptimizedSortStack {

	public static void insertInorder(Stack<Integer> input, int element) {
		if (input.isEmpty()) {
			input.push(element);
			return;
		}

		int temp = input.peek();
		if (temp > element) {
			temp = input.pop();
			insertInorder(input, element);
			input.push(temp);

		} else {
			input.push(element);
		}

	}

	public static void getOptimizedSortedStack(Stack<Integer> input) {
		if (input.isEmpty())
			return;

		int x = input.pop();
		getOptimizedSortedStack(input);
		insertInorder(input,x);
	}


	public static void main(String[] args) {

		Stack<Integer> input = new Stack<Integer>();
		input.add(5);
		input.add(1);
		input.add(4);
		input.add(3);
		input.add(2);

		System.out.println("Original Stack : " + input);
		getOptimizedSortedStack(input);
		System.out.println("Sorted Stack : " + input);
	}
}
