package com.arturo;

import com.arturo.classes.BinarySearchTree;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Random random = new Random();
        int numberOfNodes = 1000;
        int keyForSearch = 0;
        for (int i = 0; i <= numberOfNodes; i++) {
            int randomInt = random.nextInt(numberOfNodes);
            binarySearchTree.recursiveInsert(randomInt);
            if (i == numberOfNodes/2) {
                keyForSearch = randomInt;
            }
        }

        System.out.println("In order tree walk");
        binarySearchTree.inOrderTreeWalk();

        System.out.println("Recursive search result: ");
        BinarySearchTree.Node recursiveResult = binarySearchTree.recursiveTreeSearch(keyForSearch);
        System.out.println(recursiveResult.toString());

        System.out.println("Iterative search result: ");
        BinarySearchTree.Node iterativeResult = binarySearchTree.iterativeTreeSearch(keyForSearch);
        System.out.println(iterativeResult.toString());

        BinarySearchTree.Node minValue = binarySearchTree.getTreeMinimum();
        System.out.println("Minimum value result iterative: ");
        System.out.println(minValue.toString());

        BinarySearchTree.Node maxValue = binarySearchTree.getTreeMaximum();
        System.out.println("Maximum value result iterative: ");
        System.out.println(maxValue.toString());

        BinarySearchTree.Node minValueRecursive = binarySearchTree.getTreeMinimumRecursive();
        System.out.println("Minimum value result recursive: ");
        System.out.println(minValueRecursive.toString());

        BinarySearchTree.Node maxValueRecursive = binarySearchTree.getTreeMaximumRecursive();
        System.out.println("Maximum value result recursive: ");
        System.out.println(maxValueRecursive.toString());
    }
}
