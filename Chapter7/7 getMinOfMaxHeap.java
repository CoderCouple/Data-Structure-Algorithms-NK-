package UtilPackageImplementation;

public class HeapMax {

	int array[];
	int size;
	int capacity;
	int heaptype;

	public HeapMax() {
		array = new int[10];
		size = 0;
		capacity = 10;
		int heaptype = 1;
	}

	public HeapMax(int length, int type) {
		array = new int[length];
		size = 0;
		capacity = length;
		int heaptype = type;
	}

	public int getParent(int childIndex) throws Exception {
		if (0 >= childIndex || childIndex > size) {
			return -1;
		}
		return (childIndex - 1) / 2;
	}

	public int getLeftChild(int parentIndex) throws Exception {

		if (0 > parentIndex || parentIndex > size) {
			throw new Exception("No Such parent Exists...!!!");
		}

		int leftChildIndex = (2 * parentIndex) + 1;

		if (leftChildIndex >= array.length)
			return -1;
		return leftChildIndex;
	}

	public int getRightChild(int parentIndex) throws Exception {

		if (0 > parentIndex || parentIndex > size) {
			throw new Exception("No Such parent Exists...!!!");
		}

		int rightChildIndex = (2 * parentIndex) + 2;

		if (rightChildIndex >= size)
			return -1;

		return rightChildIndex;
	}

	public int getNodeByIndex(int index) throws Exception {
		if (0 < index && index > size) {
			throw new Exception("No Such node Exists...!!!");
		}

		return array[index];
	}

	public int getMaximum() {
		if (size == 0)
			return -1;
		return array[0];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void insert(int element) throws Exception {
		if (array.length == size) {
			resizeHeap();
		}
		array[size++] = element;

		int childI = size - 1;
		int parentI;
		int parent;
		int child = element;

		while (childI > 0) {
			parentI = getParent(childI);
			parent = getNodeByIndex(parentI);
			if (parent > element)
				break;

			array[parentI] = child;
			array[childI] = parent;

			childI = parentI;
		}

	}

	public int delete() throws Exception {

		if (size <= 0)
			return -1;

		int element = array[0];
		array[0] = array[size - 1];
		size--;

		percolateDown(0);
		return element;

	}
	

	public void percolateDown(int index) throws Exception {

		int left = getLeftChild(index);
		int right = getRightChild(index);
		if (left == -1 && right == -1)
			return;

		int maxChildI = index;

		if (left != -1) {
			if (array[left] > array[maxChildI])
				maxChildI = left;
		}
		if (right != -1) {
			if (array[right] > array[maxChildI])
				maxChildI = right;
		}

		if (maxChildI == index)
			return;

		int temp = array[index];
		array[index] = array[maxChildI];
		array[maxChildI] = temp;

		percolateDown(maxChildI);
	}

	public void destroyHeap() {
		size = 0;
		array = null;
	}

	public void resizeHeap() {
		int newArray[] = new int[capacity * 2];
		System.arraycopy(array, 0, newArray, 0, array.length);
		array = newArray;
		capacity = array.length;
	}

	public void printHeap() {

		for (int i = 0; i < capacity; i++) {
			for (int j = 0; j < Math.pow(2, i) && j + Math.pow(2, i) < capacity; j++) {

				if (j + (int) Math.pow(2, i) - 1 < size)
					System.out.print(array[j + (int) Math.pow(2, i) - 1] + " ");
				else
					return;

			}
			System.out.println();
		}

	}

	public int getMinOfMaxHeap() {
		int min = array[array.length / 2];
		for (int i = array.length / 2; i < array.length; i++)
			if (array[i] < min)
				min = array[i];

		return min;
	}

	public static void main(String[] args) throws Exception {

		HeapMax hm = new HeapMax(10, 1);
		hm.insert(5);
		hm.insert(4);
		hm.insert(3);
		hm.insert(2);
		hm.insert(1);
		hm.insert(0);
		hm.insert(100);
		hm.insert(10);
		hm.insert(1);
		hm.delete();
		hm.delete();

		System.out.println();
		hm.printHeap();
		System.out.println(hm.getMinOfMaxHeap());

	}

}
