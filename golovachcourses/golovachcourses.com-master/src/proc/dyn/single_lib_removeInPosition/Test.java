package proc.dyn.single_lib_removeInPosition;

/**
 * Реализуйте метод removeInPosition класса SingleLLUtils (итеративно или рекурсивно), который удаляет элемент в указанной позиции односвязного списка.
 То есть:
 SingleLLUtils.removeInPosition(1, 0) = null

 SingleLLUtils.removeInPosition(1->2, 0) = 2
 SingleLLUtils.removeInPosition(1->2, 1) = 1

 SingleLLUtils.removeInPosition(1->2->3, 0) = 2->3
 SingleLLUtils.removeInPosition(1->2->3, 1) = 1->3
 SingleLLUtils.removeInPosition(1->2->3, 2) = 1->2

 SingleLLUtils.removeInPosition(1->2->3->4, 0) = 2->3->4
 SingleLLUtils.removeInPosition(1->2->3->4, 1) = 1->3->4
 SingleLLUtils.removeInPosition(1->2->3->4, 2) = 1->2->4
 SingleLLUtils.removeInPosition(1->2->3->4, 3) = 1->2->3
 */
public class Test {
    public static void main(String[] args) {
        Node tail = _(1);

        //System.out.println(toString(tail));
        System.out.println(toString(SingleUtils.removeInPosition(tail, 0)));

    }

    public static Node _(int... values) {
        Node tail = null;

        if (values != null) {
            for (int k = values.length - 1; k >= 0; k--) {
                tail = new Node(values[k], tail);
            }
        }
        return tail;
    }

    public static String toString(Node tail) {
        String result = "";
        for (; tail != null; tail = tail.next){
            result += tail.value + "->";
        }
        return result + "*";
    }
}
