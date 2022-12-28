package tree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NodeToRootPath {
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

        findTreeNodeToRootPath(root, 60);

        list.forEach(e -> System.out.println(e));

    }

    static List<Integer> list = new ArrayList<>();
    private static boolean findTreeNodeToRootPath(TreeNode node, int value) {
        if(node  == null)
            return false;
        if(node.data == value){
            list.add(node.data);
            return true;
        }

        if(findTreeNodeToRootPath(node.left, value)){
            list.add(node.data);
            return true;
        }
        if(findTreeNodeToRootPath(node.right, value)){
            list.add(node.data);
            return true;
        }
        return false;
    }

}

