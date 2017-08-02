package Chapter5;

import java.util.Stack;

public class QueueOfStacks {

	Stack<Integer> s1;
	Stack<Integer> s2;

	public QueueOfStacks() {
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}

	public void enQueue(int x) {
		s1.add(x);
	}

	public void shuffleStacks(Stack<Integer> stk1, Stack<Integer> stk2) {
		while (!stk1.isEmpty()) {
			stk2.push(stk1.pop());
		}
	}

	public int deQueue() throws Exception {
		if (s1.isEmpty())
			throw new Exception("Queue is Empty...!!!");
		shuffleStacks(s1, s2);
		int x = s2.pop();
		shuffleStacks(s2, s1);

		return x;
	}

	public int peek() throws Exception {
		if (s1.isEmpty())
			throw new Exception("Queue is Empty...!!!");

		shuffleStacks(s1, s2);
		int x = s2.peek();
		shuffleStacks(s2, s1);

		return x;
	}

	public int size() {
		return s1.size();
	}

	public boolean isEmpty() {
		return s1.isEmpty();
	}

	public void printit() {
		if (s1.isEmpty())
			return;
		int x = s1.pop();
		System.out.print(x);
		System.out.print(" ");
		printit();
		s1.push(x);
	}

	public static void main(String[] args) throws Exception {
		QueueOfStacks qos = new QueueOfStacks();
		qos.enQueue(1);
		qos.enQueue(2);
		qos.enQueue(3);
		qos.printit();
		System.out.println();
		System.out.println("===========================");
		System.out.println(qos.deQueue());
		qos.printit();
		System.out.println();
		System.out.println("===========================");
		qos.enQueue(4);
		qos.printit();
		System.out.println();
		System.out.println("===========================");
		System.out.println(qos.peek());
		System.out.println(qos.size());
		System.out.println(qos.isEmpty());

	}

}
