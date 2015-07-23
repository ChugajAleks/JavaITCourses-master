package proc.dyn.p3_tree_lib;

import proc.dyn.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 27.01.13
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreeUtilsTest {
    public static void main(String[] args) {
        TreeNode node = BinaryTreeUtils.generateTree(3);
      //  System.out.println(node);
        System.out.println("Size = " + BinaryTreeUtils.size(node));
        System.out.println("Height = " + BinaryTreeUtils.height(node));
        System.out.println("Sum = " + BinaryTreeUtils.sum(node));
        System.out.println("Max = " + BinaryTreeUtils.max(node));
        System.out.println(node);
    }




}
