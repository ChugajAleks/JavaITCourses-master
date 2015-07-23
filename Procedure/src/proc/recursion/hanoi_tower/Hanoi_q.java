package proc.recursion.hanoi_tower;

import java.util.Arrays;
import java.util.Stack;

public class Hanoi_q {
    static Stack<Integer> f;
    static Stack<Integer> h;
    static Stack<Integer> t;
    public static void main(String[] args) {
        f = new Stack<>();
        h = new Stack<>();
        t = new Stack<>();
        /*f.push(3);*/
        f.push(2);
        f.push(1);
        exchange(f, h, t, f.size());
    }

    public static void exchange(
            Stack<Integer> from, Stack<Integer> help,
            Stack<Integer> to, int count) {
        String margin = "";
        for (int i = 0; i < f.size() - count ; i++ ){
            margin += "\t";
        }
        System.out.println(margin + "In " + f + "\t" + h + "\t" +  t + "\t" + f.size() + "; count = " + count);
        if (count > 0) {
            exchange(from, to, help, count-1);
            int biggest = from.pop();
            System.out.println(margin + "\tMoving disc " + biggest + "; " + checkStack(from) + " => " + checkStack(to));
            to.push(biggest);
            exchange(help, from, to, count-1);
        }
    }

    private static String checkStack(Stack<Integer> stack){
        String result = "noName";
        if(stack == f)result = "from";
        if(stack == h)result = "help";
        if(stack == t)result = "to";
        return result;
    }
}
