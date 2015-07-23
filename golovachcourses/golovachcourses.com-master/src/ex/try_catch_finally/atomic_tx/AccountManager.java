package ex.try_catch_finally.atomic_tx;

public interface AccountManager {

    public boolean transfer(Account[] accounts, int[] deltas);

}
