package com.greatlearning.labsession;

import java.util.Stack;

public class BSTPairFinder {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void findPairWithSum(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        TreeNode left = root;
        TreeNode right = root;

        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();

        while (true) {
            while (left != null) {
                leftStack.push(left);
                left = left.left;
            }

            while (right != null) {
                rightStack.push(right);
                right = right.right;
            }

            if (leftStack.isEmpty() || rightStack.isEmpty()) {
                break;
            }

            TreeNode leftNode = leftStack.peek();
            TreeNode rightNode = rightStack.peek();

            if (leftNode == rightNode) {
                break;
            }

            int currentSum = leftNode.value + rightNode.value;

            if (currentSum == targetSum) {
                System.out.println("Pair is (" + leftNode.value + ", " + rightNode.value + ")");
                return;
            } else if (currentSum < targetSum) {
                leftStack.pop();
                left = leftNode.right;
            } else {
                rightStack.pop();
                right = rightNode.left;
            }
        }

        System.out.println("No pair found with the given sum.");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(20);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(50);
        root.right.right = new TreeNode(70);

        int targetSum = 130;
        findPairWithSum(root, targetSum);
    }
}
