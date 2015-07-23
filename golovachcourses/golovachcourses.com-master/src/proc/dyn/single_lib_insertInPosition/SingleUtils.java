package proc.dyn.single_lib_insertInPosition;

public class SingleUtils {

    public static Node insertInPosition(Node tail, int index, int value) {

        Node head = tail; // сохраним ссылку на "голову" списка.

        // позиция элемента списка
        int k = 0;

        // если хотим вставить в начало
        if (index == 0) {
            Node tmp = tail;
            tail = new Node(value, null);
            tail.next = tmp;
            return tail;
        }

        while (tail != null) {

            if (k == index - 1 ) {
                Node tmp = tail.next;
                tail.next = new Node(value, null);
                tail.next.next = tmp;
                break;
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