package proc.dyn.double_lib_insertInPosition;

public class DoubleLLUtils {

    public static DoubleNode insertInPosition(DoubleNode tail, int index, int elem) {

        DoubleNode head = tail; // сохраним ссылку на "голову" списка

        // позиция элемента списка
        int k = 0;

        // если хотим вставить в начало
        if (index == 0) {
            DoubleNode tmp = tail;
            tail = new DoubleNode(elem, null, tmp);
            tail.next = tmp;
            tail.prev = null;
            tail.next.prev = tail;
            return tail;
        }

        while (tail != null) {

            if (k == index - 1 ) {
                tail.next = new DoubleNode(elem, tail, tail.next);
                tail.next.next.prev = tail.next;
                break;
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