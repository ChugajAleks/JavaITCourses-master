package proc.dyn.fibonacci_tree_generateRes;

/**
 * Разработать метод-генератор бинарного дерева, соответствующего по форме истории рекурсивного вычисления числа Фибоначчи.
 generateRes() возвращает дерево, в котором в качестве value стоит ЗНАЧЕНИЕ числа Фибоначчи:

 generateRes(3) =
           2
         /   \
        1     1
            /   \
           0     1
   То есть

         generateRes(3) =

          fib(3)
         /     \
       fib(1)   fib(2)
                /     \
             fib(0)   fib(1)
 */

public class Test {
    public static void main(String[] args) {



        TreeNode node = FibonacciTreeUtils.generateRes(3);
        System.out.println(toString(node));

    }

    public static String toString(TreeNode root) {
        return (root == null) ? "()" : "(" + toString(root.left) + root.value + toString(root.right) + ")";
    }

    public static void Test() {
        // CALL
        TreeNode root = FibonacciTreeUtils.generateRes(0);
        // CHECK
        String expectedStr = "(()1())";
        String actualStr = toString(root);
        if (!expectedStr.equals(actualStr)) {
            throw new AssertionError("expected = " + expectedStr + " but actual = " + actualStr);
        }

        System.out.print("OK");
    }

}

