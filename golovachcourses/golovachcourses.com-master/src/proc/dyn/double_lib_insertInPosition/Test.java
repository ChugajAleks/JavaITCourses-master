package proc.dyn.double_lib_insertInPosition;

/**
 * Реализовать метод, который вставляет элемент в указанную позицию дважды связанного списка и возвращает ссылку на "удлиненный" список.

 Можно добавлять элемент в пустой список (то есть в null).

 insertInPosition({1}, 0, 42) = {42, 1}
 insertInPosition({1, 2, 3}, 0, 42) = {42, 1, 2, 3}
 insertInPosition({1, 2, 3}, 1, 42) = {1, 42, 2, 3}
 insertInPosition({1, 2, 3}, 2, 42) = {1, 2, 42, 3}
 */
public class Test {
    public static void main(String[] args) {
        DoubleNode ref = _(1, 2);
        //System.out.println(toString(ref));

        System.out.println(toString(DoubleLLUtils.insertInPosition(ref, 0, 1)));

        //test();

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
        DoubleNode expected = _(1, 0, 2);
        String expectedAsStr = toString(expected);
        int insertionPosition = 1;
        int newValue = 0;
        DoubleNode beforeInsertion = _(1, 2);
        // CALL
        DoubleNode actual = DoubleLLUtils.insertInPosition(beforeInsertion, insertionPosition, newValue);
        // CHECK
        String actualAsStr = toString(actual);
        if (!actualAsStr.equals(expectedAsStr)) {
            throw new AssertionError("actual = '" + actualAsStr + "' but expected = '" + expectedAsStr + "'");
        }

        System.out.print("OK");
    }

}
