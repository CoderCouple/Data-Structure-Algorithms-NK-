package Chapter11;

import java.util.Arrays;

public class TwoElementSum {

	public static void getTwoElementSum(int array[], int k) {

		if (array.length <= 0)
			return;

		Arrays.sort(array);
		int lowIndex = 0;
		int highIndex = array.length - 1;

		while (highIndex >= lowIndex) {
			if ((array[lowIndex] + array[highIndex]) == k) {
				System.out.println("Elements are : " + array[lowIndex] + "  " + array[highIndex]);
				return;
			} else if ((array[lowIndex] + array[highIndex]) < k) {
				lowIndex++;
			} else {
				highIndex--;
			}
		}
	}

	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 5;
		getTwoElementSum(array, k);

	}

}
