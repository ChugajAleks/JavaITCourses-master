package proc.dyn.p3_tree_lib;

import proc.dyn.Node;
import proc.dyn.TreeNode;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 27.01.13
 * Time: 20:57
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreeUtils {
    public static int size(TreeNode root) {
        int result;
        if(root == null)
        {
            result = 0;
        } else {
            result = 1;

            result += size(root.left);
            result += size(root.right);
        }

        return result;
    }

    public static int height(TreeNode root){
        if(root == null){
            return 0;
        } else {
            int rightHeight = height(root.right);
            int leftHeight = height(root.left);
            int result = 1;
            int max = Math.max(rightHeight, leftHeight);

            result += max;
            return result;
        }
    }

    public static int sum(TreeNode root) {
       if(root == null){
           throw new IllegalArgumentException("Node is null");
       } else {
           int leftValue = 0;
           int rightValue = 0;
           if(root.right != null)
           {
                rightValue = sum(root.right);
           }

           if(root.left != null)
           {
               leftValue = sum(root.left);
           }

           return (root.value + leftValue + rightValue);
       }
    }

    public static int max(TreeNode root) {
        if(root == null){
            throw new IllegalArgumentException("Node is null");
        } else {
            int leftMax = Integer.MIN_VALUE;
            int rightMax = Integer.MIN_VALUE;
            if(root.right != null)
            {
                rightMax = max(root.right);
            }

            if(root.left != null)
            {
                leftMax = max(root.left);
            }

            int maxInChildren = Math.max(leftMax, rightMax);

            return Math.max(root.value, maxInChildren);
        }
    }

    public static TreeNode generateTree(int depth){
        TreeNode rootNode = null;

        if(depth != 0){
            rootNode = getRandomLeafNode();
            if(depth > 1)
            {
                rootNode.left = generateTree(depth-1);
                rootNode.right = generateTree(depth-1);
            }
        }
        return rootNode;
    }

    private static TreeNode getRandomLeafNode(){
        return new TreeNode(getRandomInRange(1,11), null,null);
    }

    private static int getRandomInRange(int min, int max)
    {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }
}
