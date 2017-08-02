package Chapter5;

import java.util.LinkedList;
import java.util.Queue;

public class StackOfQueues {

	Queue<Integer> q1;
	Queue<Integer> q2;

	public StackOfQueues() {
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
	}

	public void push(int x) {
		q1.add(x);
	}

	public void shuffleQueues(Queue<Integer> qu1, Queue<Integer> qu2) {
		while (!qu1.isEmpty()) {
			qu2.add(qu1.remove());
		}
	}

	public int pop() throws Exception {
		if (q1.isEmpty())
			throw new Exception("Queue is Empty...!!!");
		shuffleQueues(q1, q2);
		int x = q2.remove();
		shuffleQueues(q2, q1);

		return x;
	}

	public int peek() throws Exception {
		if (q1.isEmpty())
			throw new Exception("Queue is Empty...!!!");

		shuffleQueues(q1, q2);
		int x = q2.peek();
		shuffleQueues(q2, q1);

		return x;
	}

	public int size() {
		return q1.size();
	}

	public boolean isEmpty() {
		return q1.isEmpty();
	}

	public void printit() {
		if (q1.isEmpty())
			return;
		int x = q1.remove();
		System.out.print(x);
		System.out.print(" ");
		printit();
		q1.add(x);
	}
	public static void main(String[] args) throws Exception {
		StackOfQueues soq = new StackOfQueues();
		soq.push(1);
		soq.push(2);
		soq.push(3);
		soq.printit();
		System.out.println();
		System.out.println("===========================");
		System.out.println(soq.pop());
		soq.printit();
		System.out.println();
		System.out.println("===========================");
		soq.push(4);
		soq.printit();
		System.out.println();
		System.out.println("===========================");
		System.out.println(soq.peek());
		System.out.println(soq.size());
		System.out.println(soq.isEmpty());

	}

}
