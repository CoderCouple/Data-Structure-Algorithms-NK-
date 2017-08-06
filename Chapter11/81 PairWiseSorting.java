package Chapter11;

public class PairWiseSorting {

	public static boolean isPairWiseSorted(int array[]) {
		if (array.length < 2)
			return true;

		for (int i = 1; i < array.length; i = i + 2) {
			if (array[i - 1] > array[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int array[] = { 0, 1, 2, 3, 4, 5 };
		System.out.println(isPairWiseSorted(array));

	}

}
