package Chapter4;

import java.util.Arrays;

public class MultipleStackOneArray {

	int array[];
	int stackCount;
	int stackCapacity;
	int size[];

	public MultipleStackOneArray(int count, int capacity) {

		stackCount = count;
		stackCapacity = capacity;

		array = new int[stackCount * stackCapacity];
		size = new int[stackCount];

	}

	public int getTop(int stackNo) throws Exception {

		int indexStart = (stackNo - 1) * stackCapacity;
		int ofset = size[stackNo - 1];
		return indexStart + ofset;
	}

	public void push(int stackNo, int element) throws Exception {
		if (size[stackNo - 1] == stackCapacity)
			throw new Exception("Stack " + stackNo + " is full...!!!");

		if (stackNo > stackCount || stackNo <= 0)
			throw new Exception("No such stack exists...!!!");

		array[getTop(stackNo)] = element;
		size[stackNo - 1]++;

	}

	public int pop(int stackNo) throws Exception {
		if (size[stackNo - 1] == 0)
			throw new Exception("Stack " + stackNo + " is Empty...!!!");

		if (stackNo > stackCount || stackNo <= 0)
			throw new Exception("No such stack exists...!!!");

		int temp = array[getTop(stackNo) - 1];
		array[getTop(stackNo) - 1] = 0;
		size[stackNo - 1]--;
		return temp;

	}

	public int peek(int stackNo) throws Exception {

		if (size[stackNo - 1] == 0)
			throw new Exception("Stack " + stackNo + " is Empty...!!!");

		if (stackNo > stackCount || stackNo <= 0)
			throw new Exception("No such stack exists...!!!");

		return array[getTop(stackNo) - 1];

	}

	public boolean isEmpty(int stackNo) throws Exception {
		if (stackNo > stackCount || stackNo <= 0)
			throw new Exception("No such stack exists...!!!");

		return size[stackNo - 1] == 0;
	}

	public String toString() {
		return Arrays.toString(array);
	}

	public static void main(String[] args) throws Exception {
		MultipleStackOneArray s = new MultipleStackOneArray(4, 5);

		System.out.println("Is Empty : " + s.isEmpty(1));
		s.push(1, 1);
		s.push(1, 2);
		s.push(1, 3);
		s.push(1, 4);
		s.push(1, 5);
		System.out.println(s);
		System.out.println(s.peek(1));
		System.out.println(s.pop(1));
		System.out.println("Is Empty : " + s.isEmpty(1));
		System.out.println(s);

		System.out.println("================================");
		System.out.println("Is Empty : " + s.isEmpty(2));
		s.push(2, 6);
		s.push(2, 7);
		s.push(2, 8);
		s.push(2, 9);
		s.push(2, 10);
		System.out.println(s);
		System.out.println(s.peek(2));
		System.out.println(s.pop(2));
		System.out.println(s);

		System.out.println("================================");
		System.out.println("Is Empty : " + s.isEmpty(3));
		s.push(3, 11);
		s.push(3, 12);
		s.push(3, 13);
		s.push(3, 14);
		s.push(3, 15);
		System.out.println(s);
		System.out.println(s.peek(3));
		System.out.println(s.pop(3));
		System.out.println(s);

		System.out.println("================================");
		System.out.println("Is Empty : " + s.isEmpty(4));
		s.push(4, 16);
		s.push(4, 17);
		s.push(4, 18);
		s.push(4, 19);
		s.push(4, 20);
		System.out.println(s);
		System.out.println(s.peek(4));
		System.out.println(s.pop(4));
		System.out.println(s);

	}

}
