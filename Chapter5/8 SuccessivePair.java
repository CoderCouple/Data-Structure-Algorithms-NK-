package Chapter5;

import java.util.Stack;

public class SuccessivePair {

	public static boolean isSuccessivePair(Stack<Integer> s) {
		if (s.isEmpty())
			return true;

		while (!s.isEmpty() && s.size() > 1) {
			int pair1 = s.pop();
			int pair2 = s.pop();

			if (pair1 + 1 != pair2 && pair1 - 1 != pair2) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();

		s.add(5);
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(-1);
		s.add(0);

		System.out.println("Is Successive pair : " + isSuccessivePair(s));

	}

}
