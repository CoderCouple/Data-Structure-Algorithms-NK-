package Chapter4;

public class HistogramRectangle {

	public static int getMinimum(int array[], int startIndex, int endIndex) {

		if (startIndex == endIndex)
			return array[startIndex];

		int minValue = Integer.MAX_VALUE;
		for (int i = startIndex; i <= endIndex; i++) {
			if (array[i] < minValue)
				minValue = array[i];
		}

		return minValue;
	}

	public static int getMaximumHistogramRectangle(int array[]) {

		int maxArea = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++)
			for (int j = i; j < array.length; j++) {
				int min = getMinimum(array, i, j);
				int area = min * (j - i + 1);
				if (area > maxArea)
					maxArea = area;
			}

		return maxArea;
	}

	public static void main(String[] args) {
		int histogram[] = { 3, 2, 5, 6, 1, 4, 4 };
		System.out.println("Max Rectangle Area : " + getMaximumHistogramRectangle(histogram));

	}

}
