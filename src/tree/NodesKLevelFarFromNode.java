package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NodesKLevelFarFromNode {
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

        int k = 2;
        findNodesKLevelFarFrom(root,n8,k);
    }

    private static void findNodesKLevelFarFrom(TreeNode root, TreeNode n8, int k) {
        /*
        * print Node to root path
        * traverse every node for K-i levels far with blocker as earlier node
        * */
        printNodeToRootPath(root, n8.data);
        List<TreeNode> result = new ArrayList<>();
        for (int i=0;i<nodeToRoot.size();i++){
            findNodesFrom(nodeToRoot.get(i),k-i,i != 0 ? nodeToRoot.get(i-1) : null, result);
        }

        result.stream().forEach(n->System.out.println(n.data));

    }

    private static void findNodesFrom(TreeNode root, int k, TreeNode blocker, List<TreeNode> result) {
        if(root == null || root == blocker){
            return;
        }
        if(k<0){
            return;
        }
        if(k==0){
            result.add(root);
        }
        findNodesFrom(root.left, k-1,blocker, result);
        findNodesFrom(root.right, k-1,blocker, result);
    }

    static List<TreeNode> nodeToRoot = new ArrayList<>();
    public static boolean printNodeToRootPath(TreeNode root, int data){
        if(root == null)
            return false;

        if(root.data == data) {
            nodeToRoot.add(root);
            return true;
        }

        if(printNodeToRootPath(root.left, data)){
            nodeToRoot.add(root);
            return true;
        }
        if(printNodeToRootPath(root.right, data)){
            nodeToRoot.add(root);
            return true;
        }
        return false;
    }
}
