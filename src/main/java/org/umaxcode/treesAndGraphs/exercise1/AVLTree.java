package org.umaxcode.treesAndGraphs.exercise1;

public class AVLTree {

    private AVLNode root;

    // Helper method to get the height of a node
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    // Helper method to calculate balance factor
    private int getBalance(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // Right rotate subtree rooted with y
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotate subtree rooted with x
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Insert a key into the AVL tree
    public void insert(int key) {
        root = insert(root, key);
    }

    private AVLNode insert(AVLNode node, int key) {
        if (node == null) {
            return new AVLNode(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            // Duplicates are not allowed
            return node;
        }

        // Update height of the ancestor node
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Balance the node
        return balance(node, key);
    }

    // Balance the node after insertion or deletion
    private AVLNode balance(AVLNode node, int key) {
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Delete a key from the AVL tree
    public void delete(int key) {
        root = delete(root, key);
    }

    private AVLNode delete(AVLNode node, int key) {
        if (node == null) {
            return node;
        }

        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            // Node with one child or no child
            if ((node.left == null) || (node.right == null)) {
                AVLNode temp = (node.left != null) ? node.left : node.right;
                if (temp == null) {
                    // No child case
                    node = null;
                } else {
                    // One child case
                    node = temp;
                }
            } else {
                // Node with two children: Get the in-order successor
                AVLNode temp = getMinValueNode(node.right);
                node.key = temp.key;
                node.right = delete(node.right, temp.key);
            }
        }

        // If the tree had only one node, return
        if (node == null) {
            return node;
        }

        // Update height
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Balance the node
        return balance(node, key);
    }

    // Get the node with the smallest key (used for deletion)
    private AVLNode getMinValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Search a key in the AVL tree
    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(AVLNode node, int key) {
        if (node == null) {
            return false;
        }

        if (key == node.key) {
            return true;
        } else if (key < node.key) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    // Print the AVL tree in in-order traversal
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(AVLNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }
}
