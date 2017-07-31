package Chapter4;

import java.util.Arrays;

public class TwoStackOneArray {

	int array[];
	int stackCount;
	int top1;
	int size1;
	int top2;
	int size2;

	public TwoStackOneArray() {

		array = new int[10];
		top1 = -1;
		size1 = 0;
		top2 = array.length;
		size2 = 0;
		stackCount = 2;
	}

	public TwoStackOneArray(int length) {
		array = new int[length];
		top1 = -1;
		size1 = 0;
		top2 = array.length;
		size2 = 0;
		stackCount = 2;
	}

	public void push(int number, int element) throws Exception {
		if (size1 + size2 == array.length)
			throw new Exception("Stacks are Full...!!!");

		if (number > stackCount || number <= 0)
			throw new Exception("No such stack exists...!!!");

		if (number == 1) {
			array[++top1] = element;
			size1++;
		} else {
			array[--top2] = element;
			size2++;
		}

	}

	public int pop(int number) throws Exception {
		if (number == 1 && size1 == 0)
			throw new Exception("Stack 1 is Empty...!!!");
		else if (number == 2 && size2 == 0) {
			throw new Exception("Stack 2 is Empty...!!!");
		}

		if (number > stackCount || number <= 0)
			throw new Exception("No such stack exists...!!!");

		if (number == 1) {
			int temp = array[top1];
			array[top1--] = 0;
			size1--;
			return temp;
		} else {
			int temp = array[top2];
			array[top2++] = 0;
			size2--;
			return temp;
		}

	}

	public int peek(int number) throws Exception {

		if (number > stackCount || number <= 0)
			throw new Exception("No such stack exists...!!!");

		if (number == 1 && size1 == 0)
			throw new Exception("Stack 1 is Empty...!!!");
		else if (number == 2 && size2 == 0) {
			throw new Exception("Stack 2 is Empty...!!!");
		}

		if (number == 1)
			return array[top1];
		else
			return array[top2];
	}

	public boolean isEmpty(int number) throws Exception {
		if (number > stackCount || number <= 0)
			throw new Exception("No such stack exists...!!!");

		if (number == 1)
			return size1 == 0;
		else
			return size2 == 0;

	}

	public String toString() {
		return Arrays.toString(array);
	}

	public static void main(String[] args) throws Exception {
		TwoStackOneArray s = new TwoStackOneArray(10);
		System.out.println("Is Empty : "+s.isEmpty(1));
		s.push(1, 1);
		s.push(1, 2);
		s.push(1, 3);
		s.push(1, 4);
		s.push(1, 5);
		System.out.println(s.peek(1));
		System.out.println(s.pop(1));
		System.out.println("Is Empty : "+s.isEmpty(1));
		System.out.println(s);
		System.out.println("Is Empty : "+s.isEmpty(2));
		s.push(2, 6);
		s.push(2, 7);
		s.push(2, 8);
		s.push(2, 9);
		s.push(2, 10);
		System.out.println(s.peek(2));
		System.out.println(s.pop(2));
		System.out.println(s.isEmpty(2));
		System.out.println("Is Empty : "+s);

	}

}
