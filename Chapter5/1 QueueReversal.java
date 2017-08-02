package Chapter5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {

	public static void getReversedQueue(Queue<Integer> q) {
		if (q.isEmpty())
			return;

		Stack<Integer> s = new Stack<Integer>();

		while (!q.isEmpty()) {
			s.push(q.remove());
		}

		while (!s.isEmpty()) {
			q.add(s.pop());
		}

	}

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);

		System.out.println(q);
		getReversedQueue(q);
		System.out.println(q);

	}

}
