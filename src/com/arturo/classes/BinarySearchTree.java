package com.arturo.classes;

/**
 * Creating an implementation of a binary search tree based on the book:
 * Introduction to Algorithms (Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein)
 */
public class BinarySearchTree {
    Node root;

    public class Node {
        private int key;
        private Node left;
        private Node right;

        public Node(int data) {
            key = data;
            left = null;
            right = null;
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

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    // Empty binary tree
    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int key) {
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
}
