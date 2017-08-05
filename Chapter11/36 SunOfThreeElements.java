package Chapter11;

public class SunOfThreeElements {

	public static boolean hasSumOfElements(int array[], int index, int sum, int digit) {
		if (array.length <= 0)
			return false;

		if (sum == 0 && digit == 3)
			return true;
		else if (sum < 0 || digit > 3)
			return false;
		else if(index>=array.length)
			return false;

		return hasSumOfElements(array, index + 1, sum - array[index], digit + 1)
				|| hasSumOfElements(array, index + 1, sum, digit);
	}

	public static void main(String[] args) {
		int array[] = { 1, 3, 1,5,4 };
		System.out.println(hasSumOfElements(array, 0, 6, 0));
	}

}
