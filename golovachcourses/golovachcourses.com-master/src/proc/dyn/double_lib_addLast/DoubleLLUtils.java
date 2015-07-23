package proc.dyn.double_lib_addLast;


public class DoubleLLUtils {

    public static DoubleNode addLast(DoubleNode tail, int elem) {

        // проверяем если список содержит null
        if (tail == null) {
            return new DoubleNode(elem, null, null);
        }

        DoubleNode head = tail; // сохраним ссылку на "голову" списка
        int k = 0;

        // считаем сколько всего элементов в списке
        while (tail != null) {
            tail = tail.next;
            k++;
        }
        // System.out.println("k = " + k);

        // идем до последнего элемента
        DoubleNode tmp = head;
        for (int i = 0; i < k - 1; i++) {
            tmp = tmp.next;
        }

        //DoubleNode dd = tmp.next;

        DoubleNode newNode = new DoubleNode(elem, tmp.next, null);
        tmp.next = newNode;
        newNode.prev = tmp;


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