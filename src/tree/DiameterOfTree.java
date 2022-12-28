package tree;

import util.TreeNode;

public class DiameterOfTree {
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

        DiaPair diameter = getDiameter(root);
        System.out.println(diameter.diameter);
    }

    private static DiaPair getDiameter(TreeNode root) {
        if(root == null){
            return new DiaPair(-1,0);
        }

        DiaPair left = getDiameter(root.left);
        DiaPair right = getDiameter(root.right);

        int ht = Math.max(left.height, right.height) + 1;
        int dia = Math.max(left.height+ right.height+2,Math.max(left.diameter, right.diameter));

        return new DiaPair(ht,dia);
    }
}

class DiaPair{
    int height;
    int diameter;

    public DiaPair(int height, int diameter) {
        this.height = height;
        this.diameter = diameter;
    }
}
