package Chapter4;

import java.util.Stack;

public class MinimumOfStack {

	int array[];
	int top;
	int size;
	Stack<Integer> min;

	public MinimumOfStack() {
		array = new int[10];
		top = -1;
		size = 0;
		min = new Stack<Integer>();
	}

	public MinimumOfStack(int length) {
		array = new int[length];
		top = -1;
		size = 0;
		min = new Stack<Integer>();
	}

	public void push(int element) throws Exception {
		if (size >= array.length)
			throw new Exception("Stack is full...!!!");

		array[++top] = element;
		setMinimumOfStack(element);
		size++;
	}

	public int pop() throws Exception {
		if (size <= 0)
			throw new Exception("Stack is Empty...!!!");

		int element = array[top--];
		getMinimumOfStack(element);
		size--;
		return element;
	}

	public void setMinimumOfStack(int element) {
		if (!min.isEmpty()) {
			int temp = (int) min.peek();
			if (element <= temp)
				min.push(element);
		} else {
			min.push(element);
		}

	}

	public void getMinimumOfStack(int element) {
		if (!min.isEmpty()) {
			int temp = (int) min.peek();
			if (element == temp)
				min.pop();
		}
	}

	public int getMin() {
		return (int) min.peek();
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
		public static void main(String[] args) throws Exception {
			MinimumOfStack s = new MinimumOfStack(5);
			s.push(5);
			System.out.println(s.getMin());
			s.push(10);
			s.push(4);
			System.out.println(s.getMin());
			s.pop();
			System.out.println(s.getMin());
			s.push(2);
			System.out.println(s.getMin());
			s.push(1);
			System.out.println(s.getMin());
	}

}
