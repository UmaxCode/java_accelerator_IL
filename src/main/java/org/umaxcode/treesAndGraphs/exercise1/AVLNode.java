package org.umaxcode.treesAndGraphs.exercise1;

public class AVLNode {

    int key;
    int height;
    AVLNode left;
    AVLNode right;

    AVLNode(int key) {
        this.key = key;
        this.height = 1; // A new node is initially at height 1
    }
}
