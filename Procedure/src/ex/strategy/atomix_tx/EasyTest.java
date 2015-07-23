package ex.strategy.atomix_tx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class EasyTest {

    public static void main(String[] args) {
        long q = System.nanoTime();
        for (int k = 0; k < 1000000; k++) {
            final Random rnd = new Random(k);
            EasyManager manager = new EasyManagerImpl();
            final AtomicBoolean zedDead = new AtomicBoolean(false);
            EasyAccountImpl[] accounts = {
                    new EasyAccountImpl(rnd, zedDead),
                    new EasyAccountImpl(rnd, zedDead),
                    new EasyAccountImpl(rnd, zedDead)};
            int[] money = {-1, -1, +2};
            boolean ok = manager.transfer(accounts, money);
            if (ok) {
                for (int i = 0; i < accounts.length; i++) {
                    if (accounts[i].getTotalChange() != money[i]) {
                        throw new AssertionError("FAIL commit: " + Arrays.toString(accounts));
                    }
                }
            } else {
                if (!zedDead.get()) {
                    throw new AssertionError("Zed alive but rollback!");
                }
                for (int i = 0; i < accounts.length; i++) {
                    if (accounts[i].getTotalChange() != 0) {
                        throw new AssertionError("FAIL rollback: " + Arrays.toString(accounts));
                    }
                }
            }
        }
        q = System.nanoTime() - q;
        System.out.println("OK! q  =" + q + "; mksec = " + (q/1000000) + "; sec = " + (q/1000000000));
    }
}

class EasyAccountImpl implements EasyAccount {
    private final Random rnd;
    private final AtomicBoolean zedDead;
    private int totalChange = 0;
    private List<Integer> history = new ArrayList<Integer>();
    private boolean imDead = false;

    EasyAccountImpl(Random rnd, AtomicBoolean zedDead) {
        this.rnd = rnd;
        this.zedDead = zedDead;
    }

    @Override
    public void change(int delta) throws TryAgainEx, ZedDeadBabyEx {
        if (imDead) {
            throw new ZedDeadBabyEx("This account totally dead!");
        }
        int r = rnd.nextInt(100);
        if (r == 0 && !zedDead.get()) {
            zedDead.set(true);
            imDead = true;
            throw new ZedDeadBabyEx("First time!");
        } else if (r < 50) {
            throw new TryAgainEx();
        } else {
            totalChange += delta;
            history.add(delta);
        }
    }

    int getTotalChange() {
        return totalChange;
    }

    @Override
    public String toString() {
        return "Acc[totalChange=" + totalChange + ", history=" + history + "]";
    }
}
