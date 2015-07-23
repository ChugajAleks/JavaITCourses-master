package proc.dyn.double_lib_addLast;

/*
Реализовать метод, который добавляет элемент в конец дважды связанного списка (считая, что мы даем ссылку на начало) и возвращает ссылку на "удлиненный" список.

Можно добавлять элемент в пустой список (то есть в null).

addLast(null, 0) = {0}
addLast({0}, 1) = {0, 1}
addLast({0, 1}, 2) = {0, 1, 2}
addLast({0, 1, 2}, 3) = {0, 1, 2, 3}
addLast({0, 1, 2, 3}, 5) = {0, 1, 2, 3, 4}

 */
public class Test {

    public static void main(String[] args) {

        /*
                    +-----------+    +-----------+    +-----------+
              null  |           |    |           |    |           |
               ^    v           |    v           |    v           |
          +----|------+    +----|------+    +----|------+    +----|------+
  ref --->|0|prev|next---->|1|prev|next---->|2|prev|next---->|3|prev|next---->null
          +-----------+    +-----------+    +-----------+    +-----------+


        */

        /*DoubleNode node3 = new DoubleNode(3, null, null);
        DoubleNode node2 = new DoubleNode(2, null, node3);
        DoubleNode node1 = new DoubleNode(1, null, node2);
        DoubleNode node0 = new DoubleNode(0, null, node1);

        node3.prev = node2;
        node2.prev = node1;
        node1.prev = node0;

        DoubleNode ref = node0;*/

        DoubleNode ref = _(0, 1, 2, 3);
        ////System.out.println(toString(ref));

        System.out.println(toString(DoubleLLUtils.addLast(ref, 5)));


    }

    public static DoubleNode _(int... values) {
        int index = 0;
        DoubleNode tail = new DoubleNode(values[index++], null, null);
        DoubleNode head = tail;
        while (index < values.length) {
            head.next = new DoubleNode(values[index++], head, null);
            head = head.next;
        }
        return tail;
    }

    public static String toString(DoubleNode tail) {
        if (tail == null) {
            return "null";
        } else {
            String result = "null";
            while (tail != null) {
                result += "<-" + (tail.prev == null ? "" : tail.prev.value + "-");
                result += "(" + tail.value + ")";
                result += (tail.next == null ? "" : "-" + tail.next.value) + "->";
                tail = tail.next;
            }
            result += "null";
            return result;
        }
    }

    public static void test() {
        // PREPARE
        DoubleNode expected = _(1, 0);
        String expectedAsStr = toString(expected);
        // CALL
        DoubleNode actual = DoubleLLUtils.addLast(_(1), 0);
        // CHECK
        String actualAsStr = toString(actual);
        if (!actualAsStr.equals(expectedAsStr)) {
            throw new AssertionError("actual = '" + actualAsStr + "' but expected = '" + expectedAsStr + "'");
        }

        System.out.print("OK");
    }
}
