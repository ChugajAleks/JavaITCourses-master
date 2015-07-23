package proc.dyn.single_lib_removeLast;



public class SingleUtils {

    public static Node removeLast(Node tail) {

        Node head = tail; // сохраним ссылку на "голову" списка
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
        Node tmp = head;
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

class Node {
    public int value;
    public Node next;
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
