package proc.dyn.tree_add;

/**
 * Реализовать метод add, который добавляет в данное бинарное древо поиска новый элемент и при этом новое дерево остается деревом поиска. То есть таким деревом, что для каждой вершины выполняются условия:
 1. Каждое значение в каждом узле левого поддерева - меньше чем в этой вершине.
 2. Каждое значение в каждом узле правого поддерева - больше чем в этой вершине.

 Пустое дерево (null) - является деревом поиска.

 Деревья поиска

 5
 / \
 3   8

 5
 / \
 3   8
 / \
 6   9
 НЕ деревья поиска
 Деревья поиска

 5
 / \
 3   4

 5
 / \
 3   8
 / \
 4   9
 Примеры работы метода

 5
 / \
 3   8
 add(1) =
 5
 / \
 3   8
 /
 1
 5
 / \
 3   8
 add(4) =
 5
 / \
 3   8
 \
 4
 5
 / \
 3   8
 add(9) =
 5
 / \
 3   8
 \
 9
 5
 / \
 3   8
 add(6) =
 5
 / \
 3   8
 /
 6
 */
public class Test {

    public static void main(String[] args) {
        TreeNode ref = new TreeNode(
                3,
                new TreeNode(
                        2,
                        null,
                        new TreeNode(5, null, null)),
                new TreeNode(
                        0,
                        new TreeNode(0, null, null),
                        new TreeNode(4, null, null)));

        System.out.println(toString(TreeUtils.add(ref, 1)));
    }

    public static TreeNode _(int... values) {
        int index = 0;
        TreeNode tail = new TreeNode(values[index++], null, null);
        TreeNode head = tail;
        while (index < values.length) {
            head.right = new TreeNode(values[index++], head, null);
            head = head.right;
        }
        return tail;
    }

    public static String toString(TreeNode root) {
        return (root == null) ? "()" : "(" + toString(root.left) + root.value + toString(root.right) + ")";
    }
}
