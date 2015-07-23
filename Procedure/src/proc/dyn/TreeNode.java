package proc.dyn;


public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return "value = " + value + ";\n\tright: " + right + "\n\tleft: " + left;
    }


}
