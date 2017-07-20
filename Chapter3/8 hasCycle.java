package Chapter3;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.Stack;

public class MyLinkedList {

	Node head;
	Node tail;
	int size;
	Node headptr;

	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void addAtHead(int data) {
		Node newNode = new Node(data);

		if (head == null && tail == null) {
			head = newNode;
			tail = newNode;
			size++;
		}

		newNode.next = head;
		head = newNode;
		size++;
	}

	public void addAtTail(int data) {
		Node newNode = new Node(data);

		if (head == null && tail == null) {
			head = newNode;
			tail = newNode;
			size++;
		}

		tail.next = newNode;
		tail = newNode;
		size++;
	}

	public void add(int data) {
		Node newNode = new Node(data);

		if (head == null && tail == null) {
			head = newNode;
			tail = newNode;
			size++;
			return;
		}

		tail.next = newNode;
		tail = newNode;
		size++;
	}

	public void add(int index, int data) throws Exception {
		if (index < 0 || index > size)
			throw new Exception("Invalid Index");

		if (index == 0) {
			addAtHead(data);
			return;
		}
		if (index == size) {
			addAtTail(data);
			return;
		}

		Node curr_ptr = head;
		Node next_ptr = head.next;
		int count = 0;
		Node newNode = new Node(data);

		while (count != index) {
			curr_ptr = next_ptr;
			next_ptr = next_ptr.next;
			count++;
		}

		curr_ptr.next = newNode;
		newNode.next = next_ptr;
		size++;
	}

	public void removeFromHead() throws Exception {

		if (head == null && tail == null) {
			throw new Exception("No node to remove");
		}

		if (size == 1) {
			tail = null;
			head = null;
			return;
		}

		Node ptr = head;
		head = head.next;
		ptr.next = null;
		size--;

	}

	public void removeFromTail() throws Exception {

		if (head == null && tail == null) {
			throw new Exception("No node to remove");
		}

		Node curr_ptr = head;
		Node prev_ptr = null;

		while (curr_ptr.next != null) {
			prev_ptr = curr_ptr;
			curr_ptr = curr_ptr.next;

		}

		if (size == 1) {
			head = null;
			tail = null;
			return;
		}

		tail = prev_ptr;
		prev_ptr.next = null;
		size--;

	}

	public void remove(int index) throws Exception {
		if (index < 0 || index >= size)
			throw new Exception("Invalid index");
		if (head == null && tail == null) {
			throw new Exception("There is no element to remove...!!!");
		}
		size--;

		Node curr_ptr = head;
		Node prev_ptr = null;

		if (index == 0) {
			removeFromHead();
			return;
		}

		for (int i = 0; i <= index; i++) {
			prev_ptr = curr_ptr;
			curr_ptr = curr_ptr.next;
		}

		if (index == size) {
			removeFromTail();
			return;
		}

		prev_ptr.next = curr_ptr.next;

	}

	public void removeElement(int data) throws Exception {

		Node curr_ptr = head;
		Node prev_ptr = null;
		int count = 0;

		while (curr_ptr != null) {
			prev_ptr = curr_ptr;
			curr_ptr = curr_ptr.next;
			if (curr_ptr.data == data) {
				prev_ptr.next = curr_ptr.next;
				size--;
				return;
			}
		}

		throw new Exception("No such element to remove...!!!");

	}

	public int size() {
		int count = 0;
		Node ptr = head;

		while (ptr.next != null) {
			ptr = ptr.next;
			count++;
		}

		return count;
	}

	public boolean isEmpty() {
		return size == 0;

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node ptr = head;

		while (ptr != null) {
			sb.append(ptr.data);
			sb.append(" ");
			ptr = ptr.next;
		}

		return sb.toString();
	}

	// change
	public void removeDuplicates() {

		Node ptr1 = head;

		while (ptr1.next != null) {
			Node ptr2 = ptr1.next;
			// System.out.println(ptr1.data);
			// System.out.println(ptr2.data);

			while (ptr2 != null) {
				if (ptr1.data == ptr2.data) {
					// System.out.println(true);
					ptr1.next = ptr2.next;
					// ptr2.next=null;
					size--;
				}
				// System.out.println(false);
				ptr2 = ptr2.next;
			}
			if (ptr1.next == null)
				return;
			ptr1 = ptr1.next;
		}

	}

	public void removeDuplicatesByHashTable() {
		Node prev = null;
		Node curr = head;
		Set<Integer> table = new HashSet<Integer>(size);
		while (curr != null) {
			if (table.contains(curr.data)) {
				System.out.println("Removing: " + curr.data);
				prev.next = curr.next;
				size--;
			} else {
				table.add(curr.data);
				System.out.println("Adding: " + curr.data);
				prev = curr;
			}

			curr = curr.next;
		}

	}

	public Node getNthNode(int n) throws Exception {
		if (n > size)
			throw new Exception("Nuber is greater than the size of the linked list");

		Node ptr = head;
		int count = 0;
		while (ptr != null) {
			count++;
			if (count == n)
				return ptr;

			ptr = ptr.next;

		}

		return ptr;
	}

	public void deleteNthNode(Node ptr) throws Exception {

		if (head == null && tail == null) {
			throw new Exception("There is no element to remove...!!!");
		}

		Node curr_ptr = head;
		Node prev_ptr = null;

		if (head == ptr || tail == ptr) {
			throw new Exception("Can Not Remove the first and last element...!!!");
		}

		while (curr_ptr != null) {

			if (ptr.data == curr_ptr.data && ptr.next == curr_ptr.next) {
				prev_ptr.next = curr_ptr.next;
				curr_ptr.next = null;
			}

			prev_ptr = curr_ptr;
			curr_ptr = curr_ptr.next;
		}

	}

	public void deleteNthNodeWithoutAccessToHead(Node ptr) throws Exception {

		if (head == null && tail == null) {
			throw new Exception("There is no element to remove...!!!");
		}

		if (head == ptr || tail == ptr) {
			throw new Exception("Can Not Remove the first and last element...!!!");
		}

		Node prev_ptr = ptr;
		Node curr_ptr = prev_ptr.next;

		prev_ptr.data = curr_ptr.data;
		prev_ptr.next = curr_ptr.next;
		curr_ptr.next = null;
	}

	public void getPartitionAroundElement(int element) throws Exception {
		Node curr_ptr = head;
		Node prev_ptr = null;

		Node newHead = null;
		Node newTail = null;

		while (curr_ptr != null) {

			if (element > curr_ptr.data) {

				Node newNode = new Node(curr_ptr.data);
				if (prev_ptr == null) {
					System.out.println(curr_ptr.data);
					removeFromHead();
				} else {
					System.out.println(curr_ptr.data);
					removeElement(curr_ptr.data);
				}

				if (newHead == null && newTail == null) {
					newHead = newNode;
					newTail = newNode;
				} else {
					newHead.next = newHead;
					newHead = newNode;
				}
			}

			prev_ptr = curr_ptr;
			curr_ptr.next = curr_ptr;

		}

	}

	public int getKthElement(int k) throws Exception {

		if (size < k)
			throw new Exception("Insufficient elements!");
		int m = k;
		Node fastPtr = head;
		Node slowPtr = null;

		while (fastPtr != null) {
			fastPtr = fastPtr.next;

			if (m > 0) {
				m--;
			}

			if (m == 0) {
				slowPtr = head;
				m--;
			} else if (m == -1) {
				slowPtr = slowPtr.next;
			}

		}

		return slowPtr.data;
	}

	public boolean isPalindrome() {

		Node ptr = head;

		Node newhead = null;
		Node newTail = null;

		while (ptr != null) {
			Node newNode = new Node(ptr.data);
			if (newhead == null && newTail == null) {
				newhead = newNode;
				newTail = newNode;
			} else {
				newNode.next = newhead;
				newhead = newNode;
			}

			ptr = ptr.next;
		}

		Node ptr1 = head;
		Node ptr2 = newhead;

		// while(ptr2!=null)
		// {
		// System.out.println(ptr2.data);
		// ptr2=ptr2.next;
		// }

		while (ptr2 != null) {
			if (ptr1.data != ptr2.data) {
				System.out.println(ptr1.data + " " + ptr2.data);
				return false;
			}
			ptr2 = ptr2.next;
			ptr1 = ptr1.next;
		}

		return true;

	}

	public boolean isPalindromeCheck() {

		Node fastPtr = head;
		Node slowPtr = head;

		Stack<Integer> myStack = new Stack<Integer>();

		while (fastPtr != null && fastPtr.next != null) {
			myStack.push(slowPtr.data);

			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}

		if (fastPtr != null)
			slowPtr = slowPtr.next;

		while (slowPtr != null) {
			int value = myStack.pop().intValue();
			if (value != slowPtr.data)
				return false;

			slowPtr = slowPtr.next;
		}
		return true;

	}

	public void createIntersection() {
		Node n1 = new Node(5);
		Node n2 = new Node(7);
		Node n3 = new Node(1);
		headptr = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = head.next.next;
	}

	public boolean isIntersecting() {

		Node ptr1 = head;
		Node ptr2 = headptr;

		int counter1 = 1;
		while (ptr1.next != null) {
			// System.out.println("List 1:"+ptr1.data);
			counter1++;
			ptr1 = ptr1.next;
		}

		int counter2 = 1;
		while (ptr2.next != null) {
			// System.out.println("List 2:"+ptr2.data);
			counter2++;
			ptr2 = ptr2.next;
		}

		if (ptr1 == ptr2) {
			// System.out.println(counter1+" "+counter2);
			if (counter1 > counter2) {
				Node temp1 = getIntersectingNodeWithlength(head, counter1, headptr, counter2);
				System.out.println("Node data:" + temp1.data);
			} else {
				Node temp2 = getIntersectingNodeWithlength(headptr, counter2, head, counter1);
				System.out.println("Node data:" + temp2.data);
			}

			Node temp3 = getIntersectingNodeWithOutLength(head, headptr);
			System.out.println("Node data:" + temp3.data);
			return true;
		}

		return false;
	}

	public Node getIntersectingNodeWithlength(Node head1, int length1, Node head2, int length2) {

		int move = length1 - length2;
		// System.out.println(move);

		Node ptr1 = head1;
		Node ptr2 = head2;

		while (move != 0) {
			ptr1 = ptr1.next;
			move--;
		}

		while (ptr2 != null && ptr1 != null) {
			if (ptr1 == ptr2)
				return ptr1;

			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}

		return ptr1;
	}

	public Node getIntersectingNodeWithOutLength(Node head1, Node head2) {

		Node ptr1 = head1;
		Node ptr2 = head2;

		HashSet<Node> table = new HashSet<Node>();

		while (ptr1 != null) {
			table.add(ptr1.next);
			ptr1 = ptr1.next;
		}

		while (ptr2 != null) {

			if (table.contains(ptr2.next)) {
				return ptr2.next;
			}
			ptr2 = ptr2.next;
		}

		return ptr2.next;
	}

	public static Node getNthNodeFromTheEndOfTheLinkedList(Node node, int k) {

		if (node == null)
			return null;

		Node slowPtr = node;
		Node fastPtr = node;
		int counter = 0;
		while (fastPtr != null) {
			if (counter >= k) {
				slowPtr = slowPtr.next;
			}
			fastPtr = fastPtr.next;
			counter++;
		}

		return slowPtr;
	}

	public static boolean hasCycle(Node node) {

		if (node == null)
			return false;

		HashSet<Node> hs = new HashSet<Node>();
		Node ptr = node;
		while (ptr != null) {
			if (hs.contains(ptr.next))
				return true;

			hs.add(ptr.next);
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyLinkedList l1 = new MyLinkedList();
		// l1.add(1);
		// l1.add(1);
		// l1.add(2);
		// l1.add(3);
		// l1.add(4);
		// l1.add(4);
		// System.out.println(l1);

		l1.add(5);
		l1.add(10);
		l1.add(7);
		l1.add(15);
		l1.add(5);
		l1.add(9);
		l1.add(25);

		System.out.println(l1);
		System.out.println(getNthNodeFromTheEndOfTheLinkedList(l1.head, 4).data);

		// l1.removeDuplicatesByHashTable();
		// System.out.println(l1);
		// l1.removeDuplicatesByHashTable();

		/*
		 * try { System.out.println(l1.getKthElement(6)); } catch (Exception e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		/*
		 * try { l1.deleteNthNodeWithoutAccessToHead(l1.getNthNode(4));
		 * System.out.println(l1); } catch (Exception e) { e.printStackTrace();
		 * }
		 */

		/*
		 * try { l1.getPartitionAroundElement(9); System.out.println(l1); }
		 * catch (Exception e) { e.printStackTrace(); }
		 */

		// System.out.println("Palindrome Check :" + l1.isPalindromeCheck());
		// l1.createIntersection();
		// System.out.println("Are the linked Lists Intersecting ? :" +
		// l1.isIntersecting());
		// System.out.println("Are the linked Lists Intersecting ? :" +
		// l1.isIntersecting());

	}

}
