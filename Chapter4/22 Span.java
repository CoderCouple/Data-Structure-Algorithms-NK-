package Chapter4;

import java.util.Arrays;

public class Span {

	public static int[] getSpan(int array[]) {

		if (array.length <= 0)
			return array;

		int span[] = new int[array.length];
		span[0] = 1;
		int j = 0, count = 1;
		for (int i = 0; i < array.length - 1; i++) {
			j = i + 1;
			if (array[j] >= array[i]) {
				count++;
				span[j] = count;
			} else {
				count = 1;
				span[j] = count;
			}

		}

		return span;
	}

	public static void main(String[] args) {
		int input[] = { 6, 3, 4, 5, 2 };
		int output[] = getSpan(input);

		System.out.println("Input is : " + Arrays.toString(input));
		System.out.println("Span is : " + Arrays.toString(output));
	}

}
