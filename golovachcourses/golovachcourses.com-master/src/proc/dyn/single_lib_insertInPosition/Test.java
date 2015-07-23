package proc.dyn.single_lib_insertInPosition;

/**
 * Реализуйте метод insertInPosition класса SingleLLUtils (итеративно или рекурсивно), который вставляет элемент 'value' в указанную позицию односвязного списка.
 То есть:
 SingleLLUtils.insertInPosition(1, 0, 100) = 100->1

 SingleLLUtils.insertInPosition(1->2, 0, 100) = 100->1->2
 SingleLLUtils.insertInPosition(1->2, 1, 100) = 1->100->2

 SingleLLUtils.insertInPosition(1->2->3, 0, 100) = 100->1->2->3
 SingleLLUtils.insertInPosition(1->2->3, 1, 100) = 1->100->2->3
 SingleLLUtils.insertInPosition(1->2->3, 2, 100) = 1->2->100->3
 */
public class Test {
    public static void main(String[] args) {

        Node tail = _(1);

        //System.out.println(toString(tail));
        System.out.println(toString(SingleUtils.insertInPosition(tail, 0, 100)));

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
