package tree;

import util.TreeNode;

import java.util.Stack;

public class IterativeTraversal {
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

        traversePreorderIteratively(root);
        System.out.println("+++");
        printPreorder(root);
    }

    private static void traversePreorderIteratively(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        while(!stack.isEmpty()){
            Pair pair = stack.peek();
            if(pair.state == 1){
                System.out.println(pair.node.data);
                pair.state++;
                if(pair.node.left != null)
                    stack.push(new Pair(pair.node.left, 1));
            }
            else if(pair.state == 2){
                pair.state++;
                if(pair.node.right != null)
                    stack.push(new Pair(pair.node.right, 1));
            }
            else if(pair.state == 3){
                stack.pop();
            }
        }


    }

    public static void printPreorder(TreeNode root){
        if(root == null)
            return;

        System.out.println(root.data);
        printPreorder(root.left);
        printPreorder(root.right);
    }


}

class Pair{
    TreeNode node;
    int state;

    public Pair(TreeNode node, int state) {
        this.node = node;
        this.state = state;
    }
}