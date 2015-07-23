package proc.recursion.hanoi_tower;

import java.util.Stack;

/**
 * Created by pafnat on 22/04/14.
 */
public class Hanoi {

    public static void main(String[] args) {

        Stack<Integer> from = new Stack<>();
        Stack<Integer> help = new Stack<>();
        Stack<Integer> to = new Stack<>();
        from.push(3);
        from.push(2);
        from.push(1);


        exchange(from, help, to, from.size());



    }

    public static void exchange(
            Stack<Integer> from, Stack<Integer> help,
            Stack<Integer> to, int count) {
        if (count > 0) {
            exchange(from, to, help, count - 1);
            int biggest = (int)from.pop(); // cast to an int
            to.push(biggest);
            exchange(help, from, to, count - 1);
        }
    }

}
