package proc.dyn.fibonacci_tree_generateArg;

/**
 * Разработать метод-генератор бинарного дерева, соответствующего по форме истории рекурсивного вычисления числа Фибоначчи.
 generateArg() возвращает дерево, в котором в качестве value стоит АРГУМЕНТ, по которому вычисляют число Фибоначчи:

 generateArg(3) =
    3
  /   \
 1     2
     /   \
    0     1

*/
public class Test {
    public static void main(String[] args) {

        TreeNode node = FibonacciTreeUtils.generateArg(3);
        System.out.println(toString(node));

    }

    public static String toString(TreeNode root) {
        return (root == null) ? "()" : "(" + toString(root.left) + root.value + toString(root.right) + ")";
    }
}
