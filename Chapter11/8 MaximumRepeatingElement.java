package Chapter11;

import java.util.Arrays;

public class MaximumRepeatingElement {

	public static int getMaximumRepeatingElement(int array[]) {

		if (array.length <= 0)
			return -1;

		// k : Range of element in the array must be from 1 to k-1 (k=6)
		// n : size of the array (n=6)

		int n = array.length;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max)
				max = array[i];
		}

		int k = max + 1;
		for (int i = 0; i < array.length; i++) {
			array[(array[i] % k)] = k + array[(array[i] % k)];
		}

		int maxValue = array[0], result = 0;
		for (int i = 1; i < n; i++) {
			if (array[i] > maxValue) {
				maxValue = array[i];
				result = i;
			}
		}

		for (int i = 0; i < n; i++)
			array[i] = array[i] % k;

		return result;
	}

	public static void main(String[] args) {
		int array[] = { 3, 4, 1, 4, 5, 3 };
		System.out.println(Arrays.toString(array));
		System.out.println("Maximum Repeating Element is : " + getMaximumRepeatingElement(array));
		System.out.println(Arrays.toString(array));
	}

}
