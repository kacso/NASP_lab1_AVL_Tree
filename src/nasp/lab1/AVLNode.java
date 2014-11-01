package nasp.lab1;

public class AVLNode {
	protected int value;
	protected AVLNode rightChild = null;
	protected AVLNode leftChild = null;

	protected int height = 0;

	public AVLNode(int value) {
		this.value = value;
	}
}
