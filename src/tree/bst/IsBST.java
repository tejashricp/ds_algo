package tree.bst;

import util.TreeNode;

public class IsBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(13);
        root.left = n1;
        root.right = n2;

        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(12);
        n1.left = n3;
        n1.right = n4;

        TreeNode n5 = new TreeNode(9);
        TreeNode n6 = new TreeNode(14);
        n2.left = n5;
        n2.right = n6;



        BSTPair bst = isBst(root);
        System.out.println(bst.isBST);
    }

    private static BSTPair isBst(TreeNode root) {
        if (root == null)
            return new BSTPair(true,Integer.MIN_VALUE, Integer.MAX_VALUE);


        BSTPair leftBst = isBst(root.left);
        BSTPair rightBst = isBst(root.right);

        int max = Math.max(rightBst.max,Math.max(root.data, leftBst.max));
        int min = Math.min(rightBst.min,Math.max(root.data, leftBst.min));

        boolean isBST = root.data >= leftBst.max && root.data <= rightBst.min && leftBst.isBST && rightBst.isBST;
        return new BSTPair(isBST, max,min);
    }
}

class BSTPair{
    boolean isBST;
    int max;
    int min;

    public BSTPair(boolean isBST, int max, int min) {
        this.isBST = isBST;
        this.max = max;
        this.min = min;
    }
}