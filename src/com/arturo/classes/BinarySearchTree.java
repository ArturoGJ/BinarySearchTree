package com.arturo.classes;

/**
 * Creating an implementation of a binary search tree based on the book:
 * Introduction to Algorithms (Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein)
 */
public class BinarySearchTree {
    Node root;

    public static class Node {
        private int key;
        private Node left;
        private Node right;
        private Node top; // also known as p.

        public Node(int data) {
            key = data;
            left = null;
            right = null;
            top = null;
        }

        public int getKey() {
            return key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getTop() { return top; }

        public void setTop(Node top) { this.top = top; }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", left=" + left +
                    ", right=" + right +
                    ", top=" + top +
                    '}';
        }
    }

    // Empty binary tree
    public BinarySearchTree() {
        this.root = null;
    }

    public void recursiveInsert(int key) {
        root = recursiveInsert(root, key);
    }

    private Node recursiveInsert(Node root, int key) {
        // Base case, Node is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }
        // We insert in the tree depending on the key value
        if (key < root.key) {
            // If the key is smaller than the root key, we insert recursively in the left.
            root.left = recursiveInsert(root.left, key);
        } else {
            // If the key is larger than the root key, we insert recursively in the right.
            root.right = recursiveInsert(root.right, key);
        }

        return root;
    }

    public void iterativeInsert(int key) {
        root = iterativeInsert(root, key);
    }

    private Node iterativeInsert(Node root, int key) {
        Node tempNode = null;
        while (root != null) {
            tempNode = root;
            if (key < root.key) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

    public void inOrderTreeWalk() {
        inOrderTreeWalk(root);
    }

    private void inOrderTreeWalk(Node root) {
        if (root != null) {
            // This way we are printing everything in the left first.
            inOrderTreeWalk(root.left);
            // After printing everything on the left we print the root.
            System.out.println(root.key);
            // Then we print everything on the right.
            inOrderTreeWalk(root.right);
        }
    }

    // Note: On most computers, the iterative version is more efficient.
    public Node recursiveTreeSearch(int key) {
        Node rootCopy = new Node(root.key);
        rootCopy.setLeft(root.left);
        rootCopy.setRight(root.right);
        long beginningTime = System.nanoTime();
        Node result = recursiveTreeSearch(rootCopy, key);
        long endTime = System.nanoTime();
        System.out.printf("Total time for recursive tree search: %d ns \n", (endTime - beginningTime));
        return result;
    }

    private Node recursiveTreeSearch(Node root, int key) {
        // Base case, when we've found the node, otherwise we return null.
        if (root == null || key == root.key) {
            return root;
        }

        if (key < root.key) {
            // If the key is smaller than the root.key we search in the left.
            return recursiveTreeSearch(root.left, key);
        } else {
            // If the key is larger than the root.key we search in the right.
            return recursiveTreeSearch(root.right, key);
        }
    }

    // Note: On most computers, the iterative version is more efficient.
    public Node iterativeTreeSearch(int key) {
        Node rootCopy = new Node(root.key);
        rootCopy.setLeft(root.left);
        rootCopy.setRight(root.right);
        long beginningTime = System.nanoTime();
        Node result = iterativeTreeSearch(rootCopy, key);
        long endTime = System.nanoTime();
        System.out.printf("Total time for iterative tree search: %d ns \n", (endTime - beginningTime));
        return result;
    }

    private Node iterativeTreeSearch(Node root, int key) {
        while (root != null && root.key != key) {
            if (key < root.key) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return root;
    }

    public Node getTreeMinimum() {
        Node rootCopy = new Node(root.key);
        rootCopy.setLeft(root.left);
        rootCopy.setRight(root.right);
        // We can always find an element in a binary search tree whose key is a minimum by following left child pointers
        // from the root until we encounter a null O(h) where h is the height of the tree.
        while (rootCopy.left != null) {
            rootCopy = rootCopy.left;
        }

        return rootCopy;
    }

    public Node getTreeMinimumRecursive() {
        Node rootCopy = new Node(root.key);
        rootCopy.setLeft(root.left);
        rootCopy.setRight(root.right);
        rootCopy = getTreeMinimumRecursive(rootCopy);
        return rootCopy;
    }

    private Node getTreeMinimumRecursive(Node root) {
        if (root.left == null) {
            return root;
        } else {
            root = getTreeMinimumRecursive(root.left);
        }

        return root;
    }

    public Node getTreeMaximum() {
        Node rootCopy = new Node(root.key);
        rootCopy.setLeft(root.left);
        rootCopy.setRight(root.right);
        // We can always find an element in a binary search tree whose key is a maximum by following right child pointers
        // from the root until we encounter a null O(h) where h is the height of the tree.
        while (rootCopy.right != null) {
            rootCopy = rootCopy.right;
        }

        return rootCopy;
    }

    public Node getTreeMaximumRecursive() {
        Node rootCopy = new Node(root.key);
        rootCopy.setLeft(root.left);
        rootCopy.setRight(root.right);
        rootCopy = getTreeMaximumRecursive(rootCopy);
        return rootCopy;
    }

    private Node getTreeMaximumRecursive(Node root) {
        if (root.right == null) {
            return root;
        } else {
            root = getTreeMaximumRecursive(root.right);
        }
        return root;
    }
}
