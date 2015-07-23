package proc.dyn.single_lib_removeInPosition;

public class SingleUtils {

    public static Node removeInPosition(Node tail, int index) {

        Node head = tail; // сохраним ссылку на "голову" списка

        // позиция элемента списка
        int k = 0;

        // если хотим удалить из начала
        if (index == 0) {
            if (tail.next == null) {
                return null;
            }
            head = tail.next;
        }

        //SingleLLUtils.removeInPosition(1->2->3, 0) = 2->3
        while (tail != null) {

            if (k == index - 1 ) {
                tail.next = tail.next.next;

            }

            tail = tail.next;
            k++;

        }

        return head;


    }

}

class Node {
    public int value;
    public Node next;
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
