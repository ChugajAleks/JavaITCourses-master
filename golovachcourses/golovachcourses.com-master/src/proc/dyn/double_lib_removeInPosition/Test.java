package proc.dyn.double_lib_removeInPosition;

/**
 * Реализовать метод, который удаляет элемент в указанной позиции дважды связанного списка и возвращает ссылку на "укороченный" список.

 Можно удалять элемент из списка единичной длины (возвращаем null).

 removeInPosition({0}, 0) = null
 removeInPosition({1, 2, 3}, 0) = {2, 3}
 removeInPosition({1, 2, 3}, 1) = {1, 3}
 removeInPosition({1, 2, 3}, 2) = {1, 2}
 */
public class Test {
    public static void main(String[] args) {
        DoubleNode ref = _(1, 2);
        //System.out.println(toString(ref));

        System.out.println(toString(DoubleLLUtils.removeInPosition(ref, 1)));


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
}
