package Chapter4;

import java.util.Stack;

public class BalancedSymbol {

	public static boolean isValidSymbol(char ch) {
		if (ch == '(' || ch == ')' || ch == '[' || ch == ']' || ch == '{' || ch == '}')
			return true;
		return false;
	}

	public static boolean isOpeningType(char ch) {
		if (ch == '(' || ch == '[' || ch == '{')
			return true;
		return false;
	}

	public static char getClosingType(char opt) {
		if (isOpeningType(opt)) {
			if (opt == '(')
				return ')';

			if (opt == '[')
				return ']';

			if (opt == '{')
				return '}';
		}

		return '?';

	}

	public static boolean hasBalancedSymbols(String str) {
		if (str.length() == 0)
			return true;

		Stack<Character> s = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			if (isValidSymbol(str.charAt(i))) {
				if (isOpeningType(str.charAt(i))) {
					s.push(str.charAt(i));
				} else {
					if (!s.isEmpty()) {
						char temp = s.pop();
						char cst = getClosingType(temp);
						if (str.charAt(i) != cst)
							return false;
					} else
						return false;

				}

			}
		}

		if (!s.isEmpty())
			return false;

		return true;
	}

	public static void main(String[] args) {
		String s = new String("(A+B)*(C+D)+{[()]}");
		System.out.println("Is the expression Balanced ? : " + hasBalancedSymbols(s));

	}

}
