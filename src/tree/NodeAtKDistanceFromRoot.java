package tree;

import util.TreeNode;

public class NodeAtKDistanceFromRoot {
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

        int k = 1;
        printNodesAtKDistance(root,k);
    }

    private static void printNodesAtKDistance(TreeNode root, int k) {
        if(root == null || k<0)
            return;
        if(k == 0)
            System.out.println(root.data);
        printNodesAtKDistance(root.left,k-1);
        printNodesAtKDistance(root.right, k-1);
    }

}
