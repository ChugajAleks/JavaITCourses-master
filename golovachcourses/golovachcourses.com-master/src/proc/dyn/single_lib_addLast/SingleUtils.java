package proc.dyn.single_lib_addLast;


public class SingleUtils {

    public static Node addLast(Node tail, int value) {

        // проверяем если список содержит null
        if (tail == null) {
            return new Node(value, null);
        }

        Node head = tail; // сохраним ссылку на "голову" списка
        int k = 0;

        // считаем сколько всего элементов в списке
        while (tail != null) {
            tail = tail.next;
            k++;
        }
        // System.out.println("k = " + k);

        // идем до последнего элемента
        Node tmp = head;
        for (int i = 0; i < k - 1; i++) {
            tmp = tmp.next;
        }
        //System.out.println("tail.value = " + tmp.value);

        // добавляем к нему новый узел
        tmp.next = new Node(value, null);

        // вернем измененный список
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
