package proc.dyn.fibonacci_tree_generateArg;

public class FibonacciTreeUtils {
    public static TreeNode generateArg(int k) {

        TreeNode node = null;
        if (k-2 >= 0) {
            node = new TreeNode(k, generateArg(k-2), generateArg(k-1));
        } else {
            node = new TreeNode(k, null, null);
        }

        return node;


    }
}

class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}