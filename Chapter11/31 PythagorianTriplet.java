package Chapter11;

import java.util.HashMap;

public class PythagorianTriplet {

	public static boolean hasPythagorianTriplet(int array[]) {
		if (array.length <= 0)
			return false;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++) {
			map.put(array[i] * array[i], array[i]);
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				int temp = (array[i] * array[i]) + (array[j] * array[j]);
				if (map.containsKey((temp))) {
					System.out.println(array[i]);
					System.out.println(array[j]);
					System.out.println(map.get(temp));
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int array[] = { 3, 66, 7, 10, 11, 4, 25, 9, 5 };
		System.out.println("Has Pythagorian Triplet : " + hasPythagorianTriplet(array));
	}

}
