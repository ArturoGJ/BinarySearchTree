package com.arturo;

import com.arturo.classes.BinarySearchTree;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Random random = new Random();
        int numberOfNodes = 18;
        int keyForSearch = 0;
        for (int i = 0; i <= numberOfNodes; i++) {
            int randomInt = random.nextInt(numberOfNodes);
            binarySearchTree.insert(randomInt);
            if (i == numberOfNodes/2) {
                keyForSearch = randomInt;
            }
        }

        System.out.println("In order tree walk");
        binarySearchTree.inOrderTreeWalk();
        BinarySearchTree.Node recursiveResult = binarySearchTree.recursiveTreeSearch(keyForSearch);
        System.out.println(recursiveResult.toString());
        BinarySearchTree.Node iterativeResult = binarySearchTree.iterativeTreeSearch(keyForSearch);
        System.out.println(iterativeResult.toString());
    }
}
