package proc.dyn.double_lib_removeLast;

public class DoubleLLUtils {
    public static DoubleNode removeLast(DoubleNode tail) {

        DoubleNode head = tail; // сохраним ссылку на "голову" списка.
        int k = 0;

        // считаем сколько всего элементов в списке
        while (tail != null) {
            tail = tail.next;
            k++;
        }
        // System.out.println("k = " + k);

        // если имеет только 1 элемент
        if (k==1) {
            return null;
        }

        // идем до последнего элемента
        DoubleNode tmp = head;
        for (int i = 0; i < k - 2; i++) {
            tmp = tmp.next;
        }
        //System.out.println("tail.value = " + tmp.value);

        // добавляем к нему новый узел
        tmp.next = null;

        // вернем измененный список
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