package proc.dyn.double_lib_removeInPosition;


public class DoubleLLUtils {
    public static DoubleNode removeInPosition(DoubleNode tail, int index) {

        DoubleNode head = tail; // сохраним ссылку на "голову" списка

        // позиция элемента списка
        int k = 0;

        // если хотим удалить из начала
        if (index == 0) {
            if (tail.next == null) {
                return null;
            }
            head = tail.next;
            head.prev = null;
        }

        while (tail != null) {

            if (k == index - 1 ) {

                if (tail.next.next == null) {
                    // for the last element
                    tail.next.prev = null;
                    tail.next = null;
                } else {
                    // other case
                    tail.next.next.prev = tail;
                    tail.next = tail.next.next;
                }

            }

            tail = tail.next;
            k++;

        }

        return head;
    }
}

class DoubleNode {
    public int value;
    public DoubleNode prev;
    public DoubleNode next;
    public DoubleNode(int value, DoubleNode prev, DoubleNode next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}