package proc.recursion.parser;

/**
 * Created by pafnat on 20/05/14.
 */
public class Parser {
    public static void main(String[] args) {
        System.out.println(eval("123"));
        System.out.println(eval("2*3"));
        System.out.println(eval("2*(1+3)"));
        System.out.println(eval("1+(5-2*(13/6))"));
        /*
        System.out.println(">> 123 = " + Parser.eval("123"));
        System.out.println(">> 2*3 = " + Parser.eval("2*3"));
        System.out.println(">> (1+3)*2 = " + Parser.eval("(1+3)*2"));
        System.out.println(">> ((13/6)*2-5)+1 = " + Parser.eval("((13/6)*2-5)+1"));
        */

    }

    private static int eval(String expr) {
        return eval(expr, 0, expr.length());
    }

    private static int eval(String expr, int from, int to) {
        if (expr.charAt(from) == '(') {
            return eval(expr, from + 1, to - 1);
        } else {
            int pos = from;
            while (pos < to) {
                if (Character.isDigit(expr.charAt(pos))) {
                    pos++;
                } else {
                    int leftOperand = Integer.valueOf(expr.substring(from, pos));
                    char operation = expr.charAt(pos);
                    int rightOperand = eval(expr, pos + 1, to);
                    switch (operation) {
                        case '+':
                            return leftOperand + rightOperand;
                        case '-':
                            return leftOperand - rightOperand;
                        case '*':
                            return leftOperand * rightOperand;
                        case '/':
                            return leftOperand / rightOperand;
                    }
                }
            }
            return Integer.valueOf(expr.substring(from, to));
        }
    }
}