package nasp.lab1;

public class AVLNode {
	private int value;
	private AVLNode rightChild = null;
	private AVLNode leftChild = null;

	int balanceFactor = 0;

	public AVLNode(int value) {
		this.value = value;
	}

	public int getNodeValue() {
		return value;
	}

	public void setNodeValue(int nodeValue) {
		// TODO Auto-generated method stub

	}

	public AVLNode getParentNode() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * public AVLNode getFirstChild() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * public AVLNode getLastChild() { // TODO Auto-generated method stub return
	 * null; }
	 * 
	 * public AVLNode getPreviousSibling() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * public AVLNode getNextSibling() { // TODO Auto-generated method stub
	 * return null; }
	 */

	public AVLNode insertBefore(AVLNode newChild, AVLNode refChild) {
		// TODO Auto-generated method stub
		return null;
	}

	public AVLNode replaceChild(AVLNode newChild, AVLNode oldChild) {
		// TODO Auto-generated method stub
		return null;
	}

	public AVLNode removeChild(AVLNode oldChild) {
		// TODO Auto-generated method stub
		return null;
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

/*	public AVLNode cloneNode(boolean deep) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSameNode(AVLNode other) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEqualNode(AVLNode arg) {
		// TODO Auto-generated method stub
		return false;
	}*/
}
