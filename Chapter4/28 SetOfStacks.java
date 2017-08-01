package Chapter4;

import java.util.Arrays;
import java.util.Stack;

public class SetOfStacks {

	Stack<Stack<Integer>> records;
	int capacity;

	public SetOfStacks() {
		records = new Stack<Stack<Integer>>();
		capacity = 5;
	}

	public SetOfStacks(int c) {
		records = new Stack<Stack<Integer>>();
		capacity = c;
	}

	public void push(int element) throws Exception {
		if (records.isEmpty()) {
			Stack<Integer> s = new Stack<Integer>();
			records.push(s);
			s.push(element);
		} else {
			Stack<Integer> temp = records.peek();
			if (temp.size() >= capacity) {
				Stack<Integer> s = new Stack<Integer>();
				records.push(s);
				s.push(element);
			} else {
				temp.push(element);
			}

		}

	}

	public int pop() throws Exception {
		if (records.size() == 0)
			throw new Exception("Stacks are empty...!!!");
		int x = 0;
		Stack<Integer> temp = records.peek();
		if (!temp.isEmpty()) {
			x = temp.pop();
			if (temp.isEmpty())
				records.pop();
		}
		return x;
	}

	public int peek() throws Exception {
		if (records.size() == 0)
			throw new Exception("Stacks are empty...!!!");
		int x = 0;
		Stack<Integer> temp = records.peek();
		if (!temp.isEmpty()) {
			x = temp.peek();
		}
		return x;

	}

	public boolean isEmpty() {
		return records.size() == 0;
	}

	public static void main(String[] args) throws Exception{
		SetOfStacks s = new SetOfStacks(5);
		System.out.println(s.records);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(9);
		s.push(10);
		s.push(11);
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.push(12);
		s.push(13);
		s.push(14);
		s.push(15);
		s.push(16);
		System.out.println(s.peek());
		System.out.println(s.records);
		
	}

}
