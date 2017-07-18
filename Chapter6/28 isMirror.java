package Chapter6;

import java.util.Queue;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class BinaryTree {

	TNode root;

	public BinaryTree() {
		root = null;
	}

	public void add(int element) {
		TNode n = new TNode(element);
		if (root == null) {
			root = n;
			return;
		}

		TNode ptr = root;
		TNode parent = null;
		boolean isLeft = true;

		while (ptr != null) {
			parent = ptr;
			if (element <= ptr.data) {
				ptr = ptr.leftChild;
				isLeft = true;
			} else {
				ptr = ptr.rightChild;
				isLeft = false;
			}
		}

		if (isLeft) {
			parent.leftChild = n;
			n.parent = parent;
		} else {
			parent.rightChild = n;
			n.parent = parent;
		}
	}

	public boolean search(int element) {
		if (root == null) {
			return false;
		}

		TNode ptr = root;
		TNode parent = null;
		boolean isLeft = true;

		while (ptr != null) {
			parent = ptr;

			if (element == ptr.data) {
				return true;
			} else if (element < ptr.data) {
				ptr = ptr.leftChild;
				isLeft = true;
			} else {
				ptr = ptr.rightChild;
				isLeft = false;
			}
		}

		return false;

	}

	public boolean remove(int element) {
		// if the binary tree is empty
		if (root == null) {
			return false;
		}

		// case 1 : root is element to be deleted
		if (root.data == element) {
			if (root.rightChild == null) {
				root = root.leftChild;
				root.parent = null;
				return true;
			}

			if (root.leftChild == null) {
				root = root.rightChild;
				root.parent = null;
				return true;
			}

			if (root.leftChild != null && root.rightChild != null) {
				TNode min = minNode(root.rightChild);
				TNode minParent = minNodeParent(root.rightChild);
				root.data = min.data;
				minParent.leftChild = null;
				return true;
			}

		}

		TNode current = root;
		TNode parent = null;
		while (current != null) {
			if (element == current.data) {
				break;
			}
			parent = current;
			if (element > current.data) {
				current = current.rightChild;

			} else if (element < current.data) {
				current = current.leftChild;
			}

		}

		// Reached the end of the tree but did not find the element
		if (current == null) {
			return false;
		}

		// case2: deleting the leaf node

		if (current.leftChild == null && current.rightChild == null) {
			if (parent.leftChild == current) {
				parent.leftChild = null;
				return true;
			}

			else if (parent.rightChild == current) {
				parent.rightChild = null;
				return true;
			}
		}

		// case3: deleting a node with one child

		if (current.leftChild != null && current.rightChild == null) {
			if (parent.leftChild == current) {
				parent.leftChild = current.leftChild;
				current.leftChild.parent = parent;
				current.leftChild = null;
				return true;
			}
			if (parent.rightChild == current) {
				parent.rightChild = current.leftChild;
				current.leftChild.parent = parent;
				current.leftChild = null;
				return true;
			}
		}

		if (current.leftChild == null && current.rightChild != null) {
			if (parent.leftChild == current) {
				parent.leftChild = current.rightChild;
				current.rightChild.parent = parent;
				current.rightChild = null;
				return true;
			}
			if (parent.rightChild == current) {
				parent.rightChild = current.rightChild;
				current.rightChild.parent = parent;
				current.rightChild = null;
				return true;
			}
		}

		// case4: deleting a node with two child
		if (current.leftChild != null && current.rightChild != null) {
			TNode min = minNode(current.rightChild);
			TNode minParent = minNodeParent(current.rightChild);
			current.data = min.data;
			minParent.leftChild = null;
			return true;
		}

		return false;

	}

	public TNode minNode(TNode node) {
		TNode minNode = root;
		while (minNode.leftChild != null) {
			minNode = minNode.leftChild;
		}
		return minNode;
	}

	public TNode minNodeParent(TNode node) {
		TNode minNode = root;
		TNode minNodeParent = root;
		while (minNode.leftChild != null) {
			minNodeParent = minNode;
			minNode = minNode.leftChild;
		}
		return minNodeParent;
	}

	public void inOrderTraversal(TNode node) {
		if (node == null)
			return;

		Stack<TNode> nodeStorage = new Stack<TNode>();
		TNode currentNode = node;

		while (currentNode != null) {
			nodeStorage.push(currentNode);
			currentNode = currentNode.leftChild;
		}

		while (nodeStorage.size() > 0) {

			currentNode = nodeStorage.pop();
			System.out.println(currentNode.data + " ");
			if (currentNode.rightChild != null) {
				currentNode = currentNode.rightChild;

				while (currentNode != null) {
					nodeStorage.push(currentNode);
					currentNode = currentNode.leftChild;
				}
			}

		}
	}

	public void preOrderTraversal(TNode node) {
		if (node == null)
			return;

		Stack<TNode> nodeStorage = new Stack<TNode>();
		TNode currentNode = node;
		nodeStorage.push(currentNode);

		while (nodeStorage.size() > 0) {

			TNode mynode = nodeStorage.peek();
			System.out.print(mynode.data + " ");
			nodeStorage.pop();

			// printing the data first abd then
			// pushing the right child first and left child later in the stack
			// because I want to print it in the reverse order i.e.(root -> left
			// -> right)

			if (mynode.rightChild != null) {
				nodeStorage.push(mynode.rightChild);
			}
			if (mynode.leftChild != null) {
				nodeStorage.push(mynode.leftChild);
			}
		}
	}

	public void inOrderTraversalReversed(TNode node) {
		if (node == null)
			return;

	}

	public void levelOrderTraversal(TNode node) {

		if (node == null)
			return;

		Queue<TNode> nodeQueue = new LinkedList<TNode>();
		TNode marker = new TNode(-1);

		nodeQueue.add(node);
		nodeQueue.add(marker);
		while (!nodeQueue.isEmpty()) {

			TNode temp = nodeQueue.peek();
			nodeQueue.remove();
			if (temp.data == -1) {
				System.out.println("\n");
				if (nodeQueue.size() != 0)
					nodeQueue.add(marker);

			} else {
				System.out.print(temp.data + " ");
				if (temp.leftChild != null)
					nodeQueue.add(temp.leftChild);
				if (temp.rightChild != null)
					nodeQueue.add(temp.rightChild);
			}

		}

	}

	public void myOwnPostOrderTraversal() {
		Stack<TNode> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		TNode n = root;
		if (n != null) {
			s1.push(n);
			s2.push(1);
		}

		while (!s1.isEmpty()) {
			TNode newN = s1.pop();
			Integer i = s2.pop();

			if (i.equals(1)) {
				s1.push(newN);
				s2.push(2);
				if (newN.leftChild != null) {
					s1.push(newN.leftChild);
					s2.push(1);
				}
			} else if (i.equals(2)) {
				s1.push(newN);
				s2.push(3);
				if (newN.rightChild != null) {
					s1.push(newN.rightChild);
					s2.push(1);
				}
			} else if (i.equals(3)) {
				System.out.print(newN.data + " ");
			}
		}
	}

	public void postOrderTraversal(TNode node) {
		Stack<TNode> s1 = new Stack<>();
		Stack<TNode> s2 = new Stack<>();

		if (node == null)
			return;

		s1.push(node);

		// Run while first stack is not empty
		while (!s1.isEmpty()) {
			TNode temp = s1.pop();
			s2.push(temp);

			if (temp.leftChild != null)
				s1.push(temp.leftChild);
			if (temp.rightChild != null)
				s1.push(temp.rightChild);
		}

		// Print all elements of second stack
		while (!s2.isEmpty()) {
			TNode temp = s2.pop();
			System.out.print(temp.data + " ");
		}
	}

	public void printStrategy(int strategy) {
		if (strategy == 1)
			inOrderTraversal(root);
		else if (strategy == 2)
			preOrderTraversal(root);
		else if (strategy == 3)
			postOrderTraversal(root);
		else if (strategy == 4)
			inOrderTraversalReversed(root);
		else if (strategy == 5)
			myOwnPostOrderTraversal();
		else if (strategy == 6)
			levelOrderTraversal(root);
	}

	public static boolean isLeaf(TNode n) {
		return n.leftChild == null && n.rightChild == null;
	}

	public static int getMaximumElementFromTreeWithRecursion(TNode node) {
		int max = Integer.MIN_VALUE;
		int rightMax = -1, leftMax = -1;
		if (node != null) {

			if (node.leftChild != null) {
				leftMax = getMaximumElementFromTreeWithRecursion(node.leftChild);
			}

			if (node.rightChild != null) {
				rightMax = getMaximumElementFromTreeWithRecursion(node.rightChild);
			}

			if (rightMax >= leftMax) {
				max = rightMax;
			} else {
				max = leftMax;
			}

			if (node.data >= max)
				max = node.data;
		}

		return max;
	}

	public static int getMaximumElementFromTreeWithOutRecursion(TNode node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		Queue<TNode> q = new LinkedList<TNode>();

		int max = node.data;
		TNode dummy = new TNode(-1);
		q.add(dummy);
		q.add(node);

		while (!q.isEmpty()) {
			System.out.print(q.peek().data);
			System.out.print(" ");
			TNode n = q.remove();

			if (n.data == -1 && q.size() != 0) {
				q.add(n);
				System.out.println(" ");
			} else {
				if (n.leftChild != null)
					q.add(n.leftChild);
				if (n.rightChild != null)
					q.add(n.rightChild);
				if (n.data >= max)
					max = n.data;
			}

		}

		return max;
	}

	public static boolean searchAnElementInTreeWithRecursion(TNode node, int element) {

		if (node == null)
			return false;

		if (node.data == element)
			return true;

		return searchAnElementInTreeWithRecursion(node.leftChild, element)
				|| searchAnElementInTreeWithRecursion(node.rightChild, element);

	}

	public static boolean searchAnElementInTreeWithOutRecursion(TNode node, int element) {

		if (node == null)
			return false;

		Queue<TNode> q = new LinkedList<TNode>();
		q.add(node);

		while (!q.isEmpty()) {
			TNode n = q.remove();
			System.out.println(n.data);
			if (n.data == element) {
				return true;
			}
			if (n.leftChild != null)
				q.add(n.leftChild);
			if (n.rightChild != null)
				q.add(n.rightChild);

		}
		return false;
	}

	public static int getSizeOfBinaryTreeWithRecursion(TNode node) {

		if (node == null)
			return 0;

		int sizeOfLeftSubTree = getSizeOfBinaryTreeWithRecursion(node.leftChild);
		int sizeOfRightSubTree = getSizeOfBinaryTreeWithRecursion(node.rightChild);
		return sizeOfLeftSubTree + sizeOfRightSubTree + 1;
	}

	public static int getSizeOfBinaryTreeWithOutRecursion(TNode node) {

		if (node == null)
			return 0;

		Queue<TNode> q = new LinkedList<TNode>();
		q.add(node);
		int count = 1;
		while (!q.isEmpty()) {
			TNode n = q.remove();
			if (n.leftChild != null) {
				count++;
				q.add(n.leftChild);
			}
			if (n.rightChild != null) {
				count++;
				q.add(n.rightChild);
			}

		}

		return count;
	}

	public static int getHeightOfTheTreeWithRecursion(TNode node) {

		if (node == null)
			return 0;

		int left = getHeightOfTheTreeWithRecursion(node.leftChild);
		int right = getHeightOfTheTreeWithRecursion(node.rightChild);

		if (left <= right)
			return right + 1;
		else
			return left + 1;

	}

	public static int getHeightOfTheTreeWithOutRecursion(TNode node) {

		if (node == null) {
			return 0;
		}
		int count = 1;
		TNode dummy = new TNode(-1);
		Queue<TNode> q = new LinkedList<TNode>();
		q.add(node);
		q.add(dummy);

		while (!q.isEmpty()) {
			TNode temp = q.remove();

			if (temp.data == -1 && q.size() > 0) {
				count++;
				q.add(dummy);
			} else {
				if (temp.leftChild != null) {
					q.add(temp.leftChild);
				}

				if (temp.rightChild != null) {
					q.add(temp.rightChild);
				}
			}

		}

		return count;

	}

	public static int getLeafNodesWithRecursion(TNode node) {
		if (node == null)
			return 0;

		if (node.leftChild == null & node.rightChild == null) {
			return 1;
		}

		int left = getLeafNodesWithRecursion(node.leftChild);
		int right = getLeafNodesWithRecursion(node.rightChild);

		return left + right;

	}

	public static int getLeafNodesWithOutRecursion(TNode node) {
		if (node == null)
			return 0;

		int count = 0;
		Queue<TNode> q = new LinkedList<TNode>();
		q.add(node);

		while (!q.isEmpty()) {
			TNode n = q.remove();

			if (n.leftChild == null && n.rightChild == null) {
				count++;
			}

			if (n.leftChild != null) {
				q.add(n.leftChild);
			}

			if (n.rightChild != null) {
				q.add(n.rightChild);
			}

		}
		return count;

	}

	public static int getFullNodesWithRecursion(TNode node) {
		if (node == null)
			return 0;
		int left = 0;
		int right = 0;
		left = getLeafNodesWithRecursion(node.leftChild);
		right = getLeafNodesWithRecursion(node.rightChild);
		if (node.leftChild != null & node.rightChild != null) {
			return 1;

		}

		return left + right;
	}

	public static int getFullNodesWithOutRecursion(TNode node) {
		if (node == null)
			return 0;

		int count = 0;
		Queue<TNode> q = new LinkedList<TNode>();
		q.add(node);

		while (!q.isEmpty()) {
			TNode n = q.remove();

			if (n.leftChild != null && n.rightChild != null) {
				count++;
			}

			if (n.leftChild != null) {
				q.add(n.leftChild);
			}

			if (n.rightChild != null) {
				q.add(n.rightChild);
			}

		}
		return count;

	}

	public static int getHalfNodesWithOutRecursion(TNode node) {
		if (node == null)
			return 0;

		int count = 0;
		Queue<TNode> q = new LinkedList<TNode>();
		q.add(node);

		while (!q.isEmpty()) {
			TNode n = q.remove();

			if (n.leftChild != null && n.rightChild == null) {
				count++;
			}

			if (n.leftChild == null && n.rightChild != null) {
				count++;
			}

			if (n.leftChild != null) {
				q.add(n.leftChild);
			}

			if (n.rightChild != null) {
				q.add(n.rightChild);
			}

		}
		return count;

	}

	public static boolean isIdentialTo(TNode node1, TNode node2) {

		if (node1 == null && node2 == null)
			return true;
		else if (node1 != null && node2 != null) {
			if (node1.data == node2.data) {
				boolean left = isIdentialTo(node1.leftChild, node2.leftChild);
				boolean right = isIdentialTo(node1.rightChild, node2.rightChild);

				return left && right;
			} else
				return false;
		} else
			return false;
	}

	public static int getLevelSum(TNode node) {
		int sum = 0;
		int currentSum = 0;
		if (node == null) {
			return 0;
		}

		Queue<TNode> q = new LinkedList<TNode>();
		TNode dummy = new TNode(-1);
		q.add(node);
		sum = q.peek().data;
		q.add(dummy);

		while (!q.isEmpty()) {
			TNode n = q.remove();

			if (n.data == -1 && q.size() > 0) {
				q.add(dummy);
				if (currentSum > sum) {
					sum = currentSum;
				}
				currentSum = 0;
			} else {
				currentSum = currentSum + n.data;
				System.out.println(currentSum);
				System.out.println(sum);

				if (n.leftChild != null) {
					q.add(n.leftChild);
				}

				if (n.rightChild != null) {
					q.add(n.rightChild);
				}
			}

		}

		if (currentSum > sum) {
			sum = currentSum + 1;
		}
		return sum;

	}

	public static void getAllPaths(TNode node) {
		int array[] = new int[256];
		getPaths(node, array, 0, 1050);
	}

	public static void getPaths(TNode node, int array[], int length, int sum) {
		if (node == null)
			return;

		// if(node.leftChild==null && node.rightChild==null && node.data-sum==0)
		// System.out.println(node.data);

		array[length] = node.data;
		sum = sum - node.data;

		if (node.leftChild == null && node.rightChild == null && sum == 0) {
			System.out.println("Path : ");
			for (int i = 0; i <= length; i++) {
				System.out.print(array[i]);
				System.out.print(" ");

			}
			System.out.println(" ");
		} else {
			getPaths(node.leftChild, array, length + 1, sum);
			getPaths(node.rightChild, array, length + 1, sum);
		}

	}

	public static int getTreeSum(TNode node) {
		if (node == null)
			return 0;

		return node.data + getTreeSum(node.leftChild) + getTreeSum(node.rightChild);

	}

	public static void getMirror(TNode node) {

		if (node != null) {
			TNode temp = node.leftChild;
			node.leftChild = node.rightChild;
			node.rightChild = temp;
			getMirror(node.leftChild);
			getMirror(node.rightChild);

		}
	}

	public static boolean isMirror(TNode node1, TNode node2) {

		if (node1 == null && node2 == null)
			return true;
		if (node1 == null || node2 == null)
			return false;
		if (node1.data != node2.data)
			return false;
		else {
			return isMirror(node1.leftChild, node2.leftChild) && isMirror(node1.rightChild, node2.rightChild);
		}
	}

	public static void main(String[] args) {

		BinaryTree bt1 = new BinaryTree();

		bt1.add(100);
		bt1.add(200);
		bt1.add(50);
		bt1.add(80);
		bt1.add(40);
		bt1.add(250);
		bt1.add(150);
		bt1.add(225);
		bt1.add(500);
		bt1.add(3);
		bt1.add(45);

		BinaryTree bt2 = new BinaryTree();

		bt2.add(100);
		bt2.add(200);
		bt2.add(50);
		bt2.add(80);
		bt2.add(40);
		bt2.add(250);
		bt2.add(150);
		bt2.add(225);
		bt2.add(500);
		bt2.add(3);
		bt2.add(45);

		/*
		 * bt.add(30); bt.add(45); bt.add(70); bt.add(90); bt.add(140);
		 * bt.add(160); bt.add(225); bt.add(275);
		 */
		// getMirror(bt1.root);
		// bt1.levelOrderTraversal(bt1.root);

		System.out.println("Are the two binary trees mirror of each other : " + isMirror(bt1.root, bt2.root));

	}

}
