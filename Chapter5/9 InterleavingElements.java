package Chapter5;

import java.util.LinkedList;
import java.util.Queue;

public class InterleavingElements {

	public static void getInterleavingElements(Queue<Integer> q) throws Exception {

		if (q.isEmpty())
			return;

		if (q.size() % 2 != 0)
			throw new Exception("Not a valid aregument...!!!");

		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();

		int size = q.size();

		for (int i = 0; i < size; i++)
			if (i < size / 2)
				q1.add(q.remove());
			else
				q2.add(q.remove());

		// System.out.println(q1);
		// System.out.println(q2);
		while (!q1.isEmpty() && !q2.isEmpty()) {
			q.add(q1.remove());
			q.add(q2.remove());
		}

	}

	public static void main(String[] args) throws Exception {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);
		q.add(7);
		q.add(8);
		q.add(9);
		q.add(10);

		getInterleavingElements(q);

		System.out.println(q);

	}

}
