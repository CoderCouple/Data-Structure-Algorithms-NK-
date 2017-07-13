package Chapter2;

public class ArrayTraversal_Recursion {

	public static boolean isRecursion(int array[], int num) {

		if (num == array.length - 1) {
			return true;
		}
		if (array[num] <= array[num + 1]) {
			return isRecursion(array, num + 1);
		} else {

			return false;
		}
	}

	public static void main(String[] args) {

		int array[] = { 4, 5, 6,7, 8, 9 };
		System.out.println(isRecursion(array, 0));

	}

}
