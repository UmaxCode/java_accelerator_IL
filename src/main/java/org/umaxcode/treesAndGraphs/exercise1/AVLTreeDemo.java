package org.umaxcode.treesAndGraphs.exercise1;

public class AVLTreeDemo {

    public static void main(String[] args) {

        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.println("In-order traversal of the AVL tree:");
        tree.inOrder();

        System.out.println("Deleting 30");
        tree.delete(30);
        System.out.println("In-order traversal after deletion:");
        tree.inOrder();

        System.out.println("Search for 30: " + tree.search(30));
        System.out.println("Search for 50: " + tree.search(50));
    }
}
