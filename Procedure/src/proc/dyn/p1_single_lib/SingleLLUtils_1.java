package proc.dyn.p1_single_lib;

import proc.dyn.Node;

import static java.lang.Math.*;

public class SingleLLUtils_1 {
    public static int length(Node tail) {
        if(tail == null)return 0;
        return 1 + length(tail.next);
    }

    public static int max(Node tail) {
        /*
            Вопрос — можно ли считать рекурсивно, например:

            if(tail == null) return Integer.MIN_VALUE; // Данное значение при единственном нуллевом аргументе даст ответ Integer.MIN_VALUE, что некорректно
            int max = Math.max(tail.value, max(tail.next));
            if(max == Integer.MIN_VALUE){// Если там реально такое значение, то эксепшн некорректен
                throw new IllegalArgumentException();
            }
            return max;
        */
        if(tail == null)
        {
            throw new IllegalArgumentException("Node is null, no max value can be found in zero node list.");
        }
        int max = tail.value;
        while(tail.next != null)
        {
            tail = tail.next;
            if(max < tail.value){
                max = tail.value;
            }
        }
        return max;
    }

    public static int sum(Node tail) {
        if(tail == null)return 0;
        return tail.value + sum(tail.next);
    }
}
