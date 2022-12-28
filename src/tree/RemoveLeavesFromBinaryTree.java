package tree;

import util.TreeNode;

public class RemoveLeavesFromBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(20);
        TreeNode n2 = new TreeNode(30);
        root.left = n1;
        root.right = n2;

        TreeNode n3 = new TreeNode(40);
        TreeNode n4 = new TreeNode(50);
        n1.left = n3;
        n1.right = n4;

        TreeNode n5 = new TreeNode(60);
        TreeNode n6 = new TreeNode(70);
        n2.left = n5;
        n2.right = n6;

        TreeNode n7 = new TreeNode(80);
        TreeNode n8 = new TreeNode(90);
        TreeNode n9 = new TreeNode(100);
        TreeNode n10 = new TreeNode(110);
        TreeNode n11 = new TreeNode(120);
        TreeNode n12 = new TreeNode(130);

        n4.left = n7;
        n4.right = n8;
        n7.left = n10;
        n8.left = n11;
        n8.right = n9;
        n11.right = n12;

        TreeNode treeNode = removeLeaves(root);
        printInorder(treeNode);
    }

    private static void printInorder(TreeNode treeNode) {
        if(treeNode == null)
            return;
        printInorder(treeNode.left);
        System.out.println(treeNode.data);
        printInorder(treeNode.right);
    }

    private static TreeNode removeLeaves(TreeNode root) {
        if(root == null)
            return null;
        if(root.left == null && root.right == null) {
            return null;
        }
        TreeNode leftChild = removeLeaves(root.left);
        TreeNode rightChild = removeLeaves(root.right);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}
