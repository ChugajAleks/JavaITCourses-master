package proc.dyn.tree_isSearchTree;

/**
 *
 * Реализовать метод isSearchTree, который проверяет, является ли данное бинарное дерево - бинарным деревом ПОИСКА. То есть таким деревом, что для каждой вершины выполняются условия:
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

  5
 / \
3   4

   5
  / \
 3   8
    / \
   4   9

 *
 *
 */
public class Test {

    public static void main(String[] args) {

        /*


ref-------------------------+
                            v
                      +------------+
                      |3|left|right|
                      +---|----|---+
             +------------+    +------------+
             v                              v
      +------------+                  +------------+
      |2|left|right|                  |1|left|right|
      +---|-----|--+                  +---|-----|--+
          v     +----+               +----+     +----+
        null         v               v               v
              +------------+   +------------+  +------------+
              |2|left|right|   |0|left|right|  |4|left|right|
              +---|-----|--+   +---|-----|--+  +---|-----|--+
                  v     v          v     v         v     v
                null  null       null  null      null  null


         */
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

        System.out.println(TreeUtils.isSearchTree(ref));

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
