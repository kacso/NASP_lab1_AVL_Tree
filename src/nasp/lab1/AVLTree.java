package nasp.lab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class AVLTree {
	private String fileName;
	protected AVLNode root = null;

	public AVLTree(String fileName) {
		this.fileName = fileName;
	}

	public void initialize() throws Exception {

		ArrayList<Integer> values = readValues();

		/** Create tree */
		for (int value : values) {
			if (addElement(value) == false) {
				System.out.println("Inserting duplicate value!");
			}
		}
	}

	public boolean addElement(int value) {
		AVLNode newElement = new AVLNode(value);
		try {
			root = addElement(newElement, root);
			return true;
		} catch (Exception e) {
			// e.printStackTrace();
			return false;
		}
	}

	/**
	 * Returns new root element
	 * 
	 * @throws Exception
	 */
	private AVLNode addElement(AVLNode newElement, AVLNode parent)
			throws Exception {
		if (parent == null) {
			return newElement;
		} else if (newElement.value < parent.value) {
			parent.leftChild = addElement(newElement, parent.leftChild);

			if (height(parent.rightChild) - height(parent.leftChild) <= -2) {
				if (newElement.value < parent.leftChild.value) {
					parent = rotateWithLeftChild(parent);
				} else {
					parent = doubleRotateWithLeftChild(parent);
				}
			}
		} else if (newElement.value > parent.value) {
			parent.rightChild = addElement(newElement, parent.rightChild);

			if (height(parent.rightChild) - height(parent.leftChild) >= 2)
				if (newElement.value > parent.rightChild.value) {
					parent = rotateWithRightChild(parent);
				} else {
					parent = doubleRotateWithRightChild(parent);
				}
		} else {
			throw new Exception("Adding duplicate value");
		}

		parent.height = max(height(parent.leftChild), height(parent.rightChild)) + 1;
		
		return parent;

	}
	
	/** Return max value */
	private int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}

	/** Get height of node */
	public int height(AVLNode node) {
		return node == null ? -1 : node.height;
	}

	private AVLNode rotateWithLeftChild(AVLNode parent) {
		if (parent.leftChild == null) {
			return parent;
		}
		AVLNode child = parent.leftChild;

		parent.leftChild = child.rightChild;
		child.rightChild = parent;

		parent.height = max(height(parent.leftChild), height(parent.rightChild)) + 1;
		child.height = max(height(child.leftChild), height(child.rightChild)) + 1;

		return child;
	}

	private AVLNode doubleRotateWithLeftChild(AVLNode parent) {
		parent.leftChild = rotateWithRightChild(parent.leftChild);
		return rotateWithLeftChild(parent);
	}

	private AVLNode rotateWithRightChild(AVLNode parent) {
		if (parent.rightChild == null) {
			return parent;
		}
		AVLNode child = parent.rightChild;

		parent.rightChild = child.leftChild;
		child.leftChild = parent;

		parent.height = max(height(parent.leftChild), height(parent.rightChild)) + 1;
		child.height = max(height(child.leftChild), height(child.rightChild)) + 1;

		return (child);
	}

	private AVLNode doubleRotateWithRightChild(AVLNode parent) {
		parent.rightChild = rotateWithLeftChild(parent.rightChild);
		return rotateWithRightChild(parent);
	}

	private ArrayList<Integer> readValues() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName)));
		String fileText;
		/** read all input values */
		try {
			fileText = br.readLine();
		} finally {
			br.close();
		}
		return splitAndConvertText(fileText);
	}

	private ArrayList<Integer> splitAndConvertText(String fileText) {
		ArrayList<Integer> values = new ArrayList<Integer>();

		/** Get values as integer */
		String[] splitedText = fileText.split(" ");
		for (String text : splitedText) {
			values.add(Integer.parseInt(text));
		}
		return values;
	}

	/** Returns new root element */
	public void deleteElement(int value) {
		root = deleteElement(value, root);
	}

	private AVLNode deleteElement(int value, AVLNode node) {
		if (node == null) {
			System.out.println(value + " doesn't exist in this tree");
			return null;
		}

		if (value < node.value) {
			node.leftChild = deleteElement(value, node.leftChild);
			int left = node.leftChild != null ? height(node.leftChild) : -1;

			if ((node.rightChild != null)
					&& (node.rightChild.height - left >= 2)) {
				int rightHeight = node.rightChild.rightChild != null ? height(node.rightChild.rightChild)
						: 0;
				int leftHeight = node.rightChild.leftChild != null ? height(node.rightChild.leftChild)
						: 0;

				if (rightHeight >= leftHeight)
					node = rotateWithRightChild(node);
				else
					node = doubleRotateWithRightChild(node);
			}

		} else if (value > node.value) {
			node.rightChild = deleteElement(value, node.rightChild);
			int right = node.rightChild != null ? height(node.rightChild) : -1;
			if ((node.leftChild != null)
					&& (right - height(node.leftChild) <= -2)) {
				int leftHeight = node.leftChild.leftChild != null ? height(node.leftChild.leftChild)
						: 0;
				int rightHeight = node.leftChild.rightChild != null ? height(node.leftChild.rightChild)
						: 0;
				if (leftHeight >= rightHeight)
					node = rotateWithLeftChild(node);
				else
					node = doubleRotateWithLeftChild(node);
			}
		}
		/**
		 * Now delete element
		 */
		else if (node.leftChild != null) {
			node.value = findMax(node.leftChild).value;
			node.leftChild = deleteElement(node.value, node.leftChild);

			if ((node.rightChild != null)
					&& (height(node.rightChild) - height(node.leftChild) >= 2)) {
				int rightHeight = node.rightChild.rightChild != null ? height(node.rightChild.rightChild)
						: 0;
				int leftHeight = node.rightChild.leftChild != null ? height(node.rightChild.leftChild)
						: 0;

				if (rightHeight >= leftHeight)
					node = rotateWithLeftChild(node);
				else
					node = doubleRotateWithRightChild(node);
			}
		}

		else {
			node = (node.leftChild != null) ? node.leftChild : node.rightChild;
		}

		if (node != null) {
			int leftHeight = node.leftChild != null ? height(node.leftChild)
					: -1;
			int rightHeight = node.rightChild != null ? height(node.rightChild)
					: -1;
			node.height = max(leftHeight, rightHeight) + 1;
		}
		return node;
	}

	/**
	 * Internal method to find the largest item in a subtree.
	 */
	private AVLNode findMax(AVLNode node) {
		if (node == null)
			return node;

		while (node.rightChild != null)
			node = node.rightChild;
		return node;
	}

	/** Display AVL tree in console */
	public void printTree() {
		Stack<AVLNode> globalStack = new Stack<AVLNode>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out
				.println("......................................................");
		while (isRowEmpty == false) {
			Stack<AVLNode> localStack = new Stack<AVLNode>();
			isRowEmpty = true;

			for (int j = 0; j < nBlanks; j++)
				System.out.print(' ');

			while (globalStack.isEmpty() == false) {
				AVLNode temp = (AVLNode) globalStack.pop();
				if (temp != null) {
					System.out.print(temp.value);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);

					if (temp.leftChild != null || temp.rightChild != null)
						isRowEmpty = false;
				} else {
					System.out.print("**");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++)
					System.out.print(' ');
			}
			System.out.println();
			nBlanks /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		}
		System.out
				.println("......................................................");
	}
}
