package proc.dyn.single_lib_addLast;

/**
 * Реализуйте метод addLast класса SingleLLUtils (итеративно или рекурсивно), который добавляет элемент 'value' в 'хвост' односвязного списка.
 То есть:
 SingleLLUtils.addLast(null, 10) = 10
 SingleLLUtils.addLast(1, 10) = 1->10
 SingleLLUtils.addLast(1->2, 10) = 1->2->10
 SingleLLUtils.addLast(1->2->3, 10) = 1->2->3->10
 */

public class Test {
    public static void main(String[] args) {

        Node tail = _(null);

        //System.out.println(toString(tail));
        System.out.println(toString(SingleUtils.addLast(tail, 10)));

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
