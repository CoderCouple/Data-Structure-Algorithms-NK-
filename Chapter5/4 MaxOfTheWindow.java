package Chapter5;

public class MaxOfTheWindow {

	public static int getMaxOfTheWindow(int array[], int windowNumber, int windowLength) {

		if (array.length <= 0)
			return -1;
		int max = Integer.MIN_VALUE;
		for (int i = windowNumber; i < windowNumber + windowLength; i++) {
			if (array[i] > max)
				max = array[i];
		}

		return max;

	}

	public static void getMaxWindow(int array[], int windowLength) {
		if (array.length <= 0 || array.length - windowLength < 0)
			return;

		int max = 0;
		int wn = 0;
		for (int i = 0; i <= array.length - windowLength; i++) {
			int temp = getMaxOfTheWindow(array, i, windowLength);
			if (temp > max) {
				max = temp;
				wn = i;
			}
		}

		System.out.println("Window Number : " + wn);
		System.out.println("Maximum element : " + max);

	}

	public static void main(String[] args) {
		int array[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		getMaxWindow(array, 3);
	}

}
