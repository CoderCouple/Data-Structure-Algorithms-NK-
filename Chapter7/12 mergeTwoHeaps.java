package UtilPackageImplementation;

public class MaxHeap {

	int array[];
	int size;
	int capacity;
	int heaptype;

	public MaxHeap() {
		array = new int[10];
		size = 0;
		capacity = 10;
		int heaptype = 1;
	}

	public MaxHeap(int length, int type) {
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
		percolateUp(size - 1);

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

	public void percolateUp(int index) throws Exception {
		int childI = index;
		int child = array[index];
		int parentI;
		int parent;

		while (childI > 0) {
			parentI = getParent(childI);
			parent = getNodeByIndex(parentI);
			if (parent > child)
				break;

			array[parentI] = child;
			array[childI] = parent;

			childI = parentI;
		}
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

	public int deleteAtIndex(MaxHeap h, int index) throws Exception {

		if (index < 0 || size <= index)
			throw new Exception("Invalid Index");

		int element = array[index];
		array[index] = array[size - 1];
		percolateDown(index);
		size--;
		return element;

	}

	public void mergeTwoHeaps( MaxHeap hm2) throws Exception {
		int startPoint = this.size;
		if (this.array.length < this.size + hm2.size) {
			resizeHeap();
		}
		
		System.arraycopy(hm2.array, 0, this.array, this.size, hm2.size);
		this.size=this.size + hm2.size;
		for(int i=startPoint;i<this.size;i++){
			percolateUp(i);
		}
		
	}

	public static void main(String[] args) throws Exception {

		MaxHeap hm1 = new MaxHeap(10, 1);
		hm1.insert(5);
		hm1.insert(4);
		hm1.insert(3);
		hm1.insert(2);
		hm1.insert(1);
		hm1.insert(0);
		hm1.insert(9);

		
		
		MaxHeap hm2 = new MaxHeap(10, 1);
		hm2.insert(50);
		hm2.insert(40);
		hm2.insert(30);
		hm2.insert(20);
		hm2.insert(10);
		hm2.insert(0);
	
		hm1.printHeap();
		System.out.println("============================");
		hm2.printHeap();
		System.out.println();
		System.out.println("============================");
		
		hm1.mergeTwoHeaps(hm2);
		hm1.printHeap();
		
	}

}
