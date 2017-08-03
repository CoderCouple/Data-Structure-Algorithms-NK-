package Chapter5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElements {

	public static void getFirstKElementsReversed(Queue<Integer> q, int k) {
		if (q.isEmpty())
			return;

		if (k > q.size())
			return;

		Stack<Integer> s = new Stack<Integer>();
		int size = q.size();
		int i = 0;
		while (i < k) {
			s.push(q.remove());
			i++;
		}

		for (int j = 0; j < size; j++) {
			if (j < k)
				q.add(s.pop());
			else
				q.add(q.remove());
		}

	}

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<Integer>();
		int k = 4;
		q.add(10);
		q.add(20);
		q.add(30);
		q.add(40);
		q.add(50);
		q.add(60);
		q.add(70);
		q.add(80);
		q.add(90);
		q.add(100);

		getFirstKElementsReversed(q, k);
		System.out.println(q);

	}

}
