package Chapter11;

import java.util.HashMap;

public class TwoElementSumUsingHashMap {

	private static Integer put;

	public static void getTwoElementSumUsingHashMap(int array[], int k) {
		if (array.length <= 0)
			return;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++) {
			int temp = k - array[i];
			if (map.containsKey(temp)) {
				System.out.println("Element 1 : " + array[i]);
				System.out.println("Element 2 : " + temp);
				// return;
			}

			map.put(array[i], i);
		}

	}

	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 5;
		getTwoElementSumUsingHashMap(array, k);

	}

}
