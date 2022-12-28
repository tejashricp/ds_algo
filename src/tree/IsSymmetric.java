package tree;

import util.TreeNode;

public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(20);
        TreeNode n2 = new TreeNode(20);
        root.left = n1;
        root.right = n2;

        TreeNode n3 = new TreeNode(40);
        TreeNode n4 = new TreeNode(50);
        n1.left = n3;
        n1.right = n4;

        TreeNode n5 = new TreeNode(50);
        TreeNode n6 = new TreeNode(40);
        n2.left = n5;
        n2.right = n6;

        System.out.println(isSymmetric(root.left, root.right));
    }

    private static boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode == null && rightNode == null){
            return true;
        }
        if(leftNode == null && rightNode != null){
            return false;
        }
        if(leftNode != null && rightNode == null){
            return false;
        }

        return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left)
                && leftNode.data == rightNode.data;
    }
}
