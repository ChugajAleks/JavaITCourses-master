package ex.mech.InfOrNotInf;

import java.util.Arrays;

/**
 * User: Igor Russo
 * Date: 01.02.13
 * Time: 1:09
 */
public class TryCatch {

    public static void main(String[] args) {
        try {
            main(args);
        } catch (StackOverflowError e) {

            main(args);
        }
    }
}

/*
  tm
  tm
  tm
  tm            tms   cm        tms cm         tms
  tms   cms           tms  cms      tms  cms



*/