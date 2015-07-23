package proc.dyn.single_lib_removeLast;

/**
 * Реализуйте метод removeLast класса SingleLLUtils (итеративно или рекурсивно), который удаляет последний элемент односвязного списка.
 То есть:
 SingleLLUtils.removeLast(1) = null
 SingleLLUtils.removeLast(1->2) = 1
 SingleLLUtils.removeLast(1->2->3) = 1->2
 SingleLLUtils.removeLast(1->2->3->4) = 1->2->3

 */
public class Test {
    public static void main(String[] args) {

        Node tail = _(1, 2);

        //System.out.println(toString(tail));
        System.out.println(toString(SingleUtils.removeLast(tail)));

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
