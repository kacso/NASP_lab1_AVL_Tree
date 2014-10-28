package nasp.lab1;

public class AVLNode {
	protected int value;
	protected AVLNode rightChild = null;
	protected AVLNode leftChild = null;

	protected int height = 0;

	public AVLNode(int value) {
		this.value = value;
	}

	public AVLNode appendChild(AVLNode newChild) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasChildNodes() {
		if (rightChild != null || leftChild != null) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * public void printTree() { System.out.println(value); if (leftChild !=
	 * null) leftChild.printTree();
	 * 
	 * if (rightChild != null) rightChild.printTree(); }
	 */
	/*
	 * public void printTree() { printTree(this);
	 * 
	 * }
	 * 
	 * private void printTree(AVLNode node) { if (node == null) return;
	 * 
	 * // left, node itself, right printTree(node.leftChild);
	 * System.out.print(node.value + "  "); printTree(node.rightChild); }
	 */
}
