package nasp.lab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AVLTree {
	private String fileName;
	private AVLNode root = null;

	public AVLTree(String fileName) {
		this.fileName = fileName;
	}

	public void initialize() throws Exception {
		// TODO
		ArrayList<Integer> values = readValues();

		/** Create tree */
		for (int value : values) {
			if(addElement(value) == false){
				System.out.println("Inserting duplicate value!");
			}
		}
	}
	
	public boolean addElement(int value){
		AVLNode newElement = new AVLNode(value);
		try{
			addElement(newElement, root);
			return true;
		} catch(Exception e){
			return false;
		}
	}

	/** Returns new root element 
	 * @throws Exception */
	private AVLNode addElement(AVLNode newElement, AVLNode parent) throws Exception {
		if (root == null)
			root = newElement;
		else if (newElement.getNodeValue() < root.getNodeValue()) {
			root.leftChild = addElement(newElement, root.leftChild);

			/*if (height(t.left) - height(t.right) == 2) {
				if (x.compareTo(t.left.element) < 0) {
					t = rotateWithLeftChild(t);
					countSingleRotations++;
				} else {
					t = doubleWithLeftChild(t);
					countDoubleRotations++;
				}
			}*/
		} else if (newElement.getNodeValue() > root.getNodeValue()) {
			root.rightChild = addElement(newElement, root.rightChild);

			/*if (height(t.right) - height(t.left) == 2)
				if (x.compareTo(t.right.element) > 0) {
					t = rotateWithRightChild(t);
					countSingleRotations++;
				} else {
					t = doubleWithRightChild(t);
					countDoubleRotations++;
				}*/
		} else {
			throw new Exception("Adding duplicate value");
		}

		//t.height = max(height(t.left), height(t.right)) + 1;
		return root;

	}

	/** Returns new root element */
	public AVLNode deleteElement() {
		// TODO
		return null;
	}

	private void rotateElement() {
		// TODO
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

	private AVLNode findElementByValue(int value) {
		// TODO
		return null;
	}

	private AVLNode reorganizeTree(AVLNode insertedElement) {
		// TODO
		return null;
	}
}
