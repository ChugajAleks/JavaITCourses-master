package proc.dyn.double_lib_removeLast;

/**
 * Реализовать метод, который удаляет элемент из конца дважды связанного списка (считая, что мы даем ссылку на начало) и возвращает ссылку на "укороченный" список.

 Можно удалять элемент из списка единичной длины (возвращаем null).

 removeLast({0}) = null
 removeLast({0, 1}) = {0}
 removeLast({0, 1, 2}) = {0, 1}
 removeLast({0, 1, 2, 3}) = {0, 1, 2}
 removeLast({0, 1, 2, 3, 4}) = {0, 1, 2, 3}
 */
public class Test {

    public static void main(String[] args) {

        DoubleNode ref = _(0, 1, 2, 3);
        ////System.out.println(toString(ref));

        System.out.println(toString(DoubleLLUtils.removeLast(ref)));
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
