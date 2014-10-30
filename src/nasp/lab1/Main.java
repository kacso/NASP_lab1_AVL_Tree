package nasp.lab1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		/** Read input argument */
		String fileName = args[0];
		AVLTree avlTree = new AVLTree(fileName);
		try {
			avlTree.initialize();
		} catch (Exception e) {
			System.out.println("Error occurs" + e);
			return;
		}

		avlTree.printTree();

		Scanner input = new Scanner(System.in); // opens a scanner, keyboard
		System.out.println("Press:\n1 -> Add number to AVL tree\n"
				+ "2 -> Delete number from AVL tree\n0 -> Exit");
		int action;
		while ((action = input.nextInt()) != 0) {
			if (action == 1) {
				System.out.print("Enter a number to add in AVL tree: ");
				int number = input.nextInt();
				if (avlTree.addElement(number) == false) {
					System.out.println("Inserting duplicate value!");
				}
			} else if (action == 2) {
				System.out.print("Enter a number to delete from AVL tree: ");
				int number = input.nextInt();
				avlTree.deleteElement(number);
			}

			avlTree.printTree();
			System.out.println("Press:\n1 -> Add number to AVL tree\n"
					+ "2 -> Delete number from AVL tree\n0 -> Exit");

		}
		input.close();
	}
}
