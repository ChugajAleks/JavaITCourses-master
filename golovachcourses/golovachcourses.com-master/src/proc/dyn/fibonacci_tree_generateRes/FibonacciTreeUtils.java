package proc.dyn.fibonacci_tree_generateRes;

public class FibonacciTreeUtils {
    public static TreeNode generateRes(int k) {

        int fib = 0; // fibb value
        // calc fibb number without recursion
        int i = 2;
        int a = 1, b = 1;

        if (k <=0) {
            fib = 0;
        } else if (k == 1) {
            fib = 1;
        } else if (k == 2) {
            fib = 1;
        } else {
            while (i<k) {
                fib = a + b;
                a = b;
                b = fib;
                i++;
            }
        }

        TreeNode node = null;
        if (k-2 >= 0) {
            node = new TreeNode(fib, generateRes(k-2), generateRes(k-1));
        } else {
            node = new TreeNode(fib, null, null);
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