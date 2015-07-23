package proc.recursion.parser;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 23.01.13
 * Time: 0:26
 * To change this template use File | Settings | File Templates.
 */
public class Parser {

    public static void main(String[] args) {
        System.out.println(eval("(1+3)+1"));
        System.out.println(eval("123"));
        System.out.println(eval("4*2+1"));
        System.out.println(eval("2*3"));
        System.out.println(eval("2*(1+3)"));
        System.out.println(eval("1+(5-2*(13/6))"));
    }

    private static int eval(String expr) {
        return eval(expr, 0, expr.length());
    }

    private static int eval(String expr, int from, int to) {
        if (expr.charAt(from) == '(' && !Character.isDigit(expr.charAt(to-1))) {
            return eval(expr, from + 1, to - 1);
        } else if (expr.charAt(from) == '(' && Character.isDigit(expr.charAt(to-1))) {
            for (int i = expr.length()-1; i >= 0; i--) {
                if(expr.charAt(i) == ')'){
                    return eval(eval(expr, from + 1, i) + "" + expr.substring(i+1));
                }
            }
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