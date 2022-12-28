package tree;

import util.TreeNode;
/*
* Node does not have any sibling i.e. parent has only single child
* */

public class PrintSingleChildNodes {
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

        printSingleChildNodes(null,root);
    }

    private static void printSingleChildNodes(TreeNode parent,TreeNode root) {
        if (root == null)
            return;
        if(parent != null) {
            if (parent.left == root && parent.right == null)
                System.out.println(root.data);
            if (parent.left == null && parent.right == root)
                System.out.println(root.data);
        }

        printSingleChildNodes(root,root.left);
        printSingleChildNodes(root,root.right);
    }
}
