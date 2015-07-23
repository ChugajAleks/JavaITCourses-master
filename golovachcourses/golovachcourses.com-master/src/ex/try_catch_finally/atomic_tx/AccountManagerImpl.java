package ex.try_catch_finally.atomic_tx;

public class AccountManagerImpl implements AccountManager {
/*
    @Override
    public boolean transfer(Account[] accounts, int[] deltas) {
        try {
            for (int k = 0; k < accounts.length; k++) {
                accounts[k].change(deltas[k]);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
*/

public boolean transfer(Account[] accounts, int[] deltas) {
    try {
        for (int k = 0; k < accounts.length; k++) {
            while (true) {
                try {
                    accounts[k].change(deltas[k]);
                    break;
                } catch (TryAgainException e) {
                    // NOP
                }
            }
        }
    } catch (BlockAccountException e) {
        return false;
    }
    return true;
}

}
