package com.igorrusso.learning.ibm.multithreading.introduction;

import java.util.Date;

/**
 * User: Igor Russo
 * Date: 11.08.13
 * Time: 13:13
 */
public class SyncExampleLockMethodEachThread {
    public static void main(String[] args) {
        Thingie thingie1 = new Thingie(),
                thingie2 = new Thingie();

        (new MyThread(thingie1)).start();
        (new MyThread(thingie2)).start();
    }

    public static class Thingie {
        private Date lastAccess;


        public synchronized void setLastAccess(Date lastAccess) {
            this.lastAccess = lastAccess;
        }
    }

    public static class MyThread extends Thread {
        private Thingie thingie;

        public MyThread(Thingie thingie) {
            this.thingie = thingie;
        }

        @Override
        public void run() {
            thingie.setLastAccess(new Date());
        }
    }

    /*
    ETC
     */
    public class PointSyncedByInstance {
        private int x;
        private int y;

        public synchronized void setXY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public class PointSyncedByLock {
        private int x;
        private int y;

        public void setXY(int x, int y) {
            synchronized (this) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
