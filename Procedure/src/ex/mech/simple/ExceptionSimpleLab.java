package ex.mech.simple;

public class ExceptionSimpleLab {
    public static void main(String[] args) {

        System.out.print(0);
        try {
            System.out.print(1);
            if (true) {throw new Error();}
            System.out.print(2);
        } catch (RuntimeException e) {
            System.out.print(3);
            if (true) {throw new Error();}
            System.out.print(4);
        } finally {
            System.out.print(5);
            if (true) {throw new RuntimeException();}
            System.out.print(6);
        }
        System.out.print(7);
    }
}
      /*

0125
012567
01345
0134567
0135
01356
015
0156


            */