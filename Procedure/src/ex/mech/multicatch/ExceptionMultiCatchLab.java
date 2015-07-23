package ex.mech.multicatch;

import java.io.IOException;

/**
 * User: Igor Russo
 * Date: 01.02.13
 * Time: 1:01
 *
 * На месте каждого комментария можно:
        - оставить комментарий
        - вставить throw new NullPointerException();
        - вставить throw new RuntimeException();
        - вставить throw new IOException();
        - вставить throw new Error();
 */
public class ExceptionMultiCatchLab {
    public static void main(String[] args) throws Throwable {

        System.out.print(0);
        try {
            System.out.print(1);
            if (true) {/*...*/}
            System.out.print(2);
        } catch (NullPointerException e) {
            System.out.print(3);
            if (true) {/**/}
            System.out.print(4);
        } catch (RuntimeException e) {
            System.out.print(5);
            if (true) {/**/}
            System.out.print(6);
        } catch (Exception e) {
            System.out.print(7);
            if (true) {/**/}
            System.out.print(8);
        } finally {
            System.out.print(9);
            if (true) {/**/}
            System.out.print(10);
        }
        System.out.print(11);
    }
}
/*
  0129
  01291011
  01349
  013491011
  0139
  013910
  01569
  015691011
  0159
  015910
  01789
  017891011
  0179
  017910
  019
  01910

 */
