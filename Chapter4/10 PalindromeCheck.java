package Chapter4;

import java.util.Stack;

public class PalindromeCheck {

	public static boolean isPalindrome(char array[]) throws Exception {
		if (array.length <= 0)
			return true;
		Stack<Character> s = new Stack<Character>();
		int i = 0;
		while (array[i] != 'x') {
			s.push(array[i]);
			i++;
		}

		int j = i + 1;
		while (j < array.length) {
			if (!s.isEmpty()) {
				char temp = s.pop();
				if (temp != array[j])
					return false;
			} else {
				throw new Exception("Not a palindrome ...!!!");
			}
			j++;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		char input[] = { 'a', 'b', 'b', 'a', 'x', 'a', 'b', 'b', 'a' };
		System.out.println("Is it Palindrome : " + isPalindrome(input));

	}

}
