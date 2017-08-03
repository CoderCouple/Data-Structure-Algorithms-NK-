package Chapter11;

public class DuplicatesByNegation {

	public static boolean hasDuplicates(int array[]) {
		if (array.length <= 0)
			return false;

		for (int i = 0; i < array.length; i++) {
			if (array[Math.abs(array[i])] < 0)
				return true;
			else
				array[Math.abs(array[i])] = -array[Math.abs(array[i])];
		}

		return false;
	}

	public static void main(String[] args) {
		int array[] = { 3, 4, 1, 4, 5, 3 };
		System.out.println("Has Duplicates : " + hasDuplicates(array));

	}

}
