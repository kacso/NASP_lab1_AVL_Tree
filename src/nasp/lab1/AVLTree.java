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
			root = addElement(value);
		}
	}

	/** Returns new root element */
	public AVLNode addElement(int value) {
		// TODO
		AVLNode parent = findElementByValue(value);
		AVLNode newElement = new AVLNode(value);
		
		parent.appendChild(newElement);
		
		return reorganizeTree(newElement);
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
	
	private AVLNode findElementByValue(int value){
		//TODO
		return null;
	}
	
	private AVLNode reorganizeTree(AVLNode insertedElement){
		//TODO
		return null;
	}
}
