package nasp.lab1;

public class Main {
	public static void main(String[] args) {
		/** Read input argument */
		String fileName = args[0];
		AVLTree avlTree = new AVLTree(fileName);
		try {
			avlTree.initialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
