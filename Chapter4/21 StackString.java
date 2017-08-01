package Chapter4;

public class StackString {

	public static boolean isValidStackString(String s) {
		int count = 0;
		char charArray[] = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == 'S') {
				count++;
			} else {
				if (count > 0)
					count--;
				else
					return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String s = "SSXXSXX";
		System.out.println("Is valid String : " + isValidStackString(s));
	}

}
