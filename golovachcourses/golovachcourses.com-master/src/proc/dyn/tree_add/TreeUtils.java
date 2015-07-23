package proc.dyn.tree_add;

public class TreeUtils {
    public static TreeNode add(TreeNode root, int value) {

        if (root == null)
            root = new TreeNode(value, null, null);

        if (value < root.value)
        {
            if (root.left != null)
            {
                add(root.left, value);
            }
            else
            {
                root.left = new TreeNode(value, null, null);
            }
        }
        else if (value > root.value)
        {
            if (root.right != null)
            {
                add(root.right, value);
            }
            else
            {
                root.right = new TreeNode(value, null, null);
            }
        }

        return root;

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
