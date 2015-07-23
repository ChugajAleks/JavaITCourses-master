package proc.dyn.tree_isSearchTree;

public class TreeUtils {

    /* Returns true if a binary tree is a binary search tree */
    // based on http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
    public static boolean isSearchTree(TreeNode root) {

        if (root == null)
            return true;


        /* false if the max of the left is > than us */
        if (root.left != null && maxValue(root.left) > root.value)
            return false;


        /* false if the min of the right is <= than us */
        if (root.right != null && minValue(root.right) < root.value)
            return false;


        /* false if, recursively, the left or right is not a BST */
        if (!isSearchTree(root.left) || !isSearchTree(root.right))
            return false;

        /* passing all that, it's a BST */
        return true;


    }

    private static int minValue(TreeNode root) {

        int minValue = 0;

        if(root.right == null) {
            return root.value;
        } else {
            minValue = root.value;
            minValue = Math.min(minValue, minValue(root.right));
        }

        return minValue;

    }

    private static int maxValue(TreeNode root) {
        int maxValue = 0;

        if(root.left == null) {
            return root.value;
        } else {
            maxValue = root.value;
            maxValue = Math.max(maxValue, maxValue(root.left));
        }

        return maxValue;
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