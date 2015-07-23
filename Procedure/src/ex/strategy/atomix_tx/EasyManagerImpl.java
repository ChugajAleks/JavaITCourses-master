package ex.strategy.atomix_tx;

/**
 * User: Igor Russo
 * Date: 03.02.13
 * Time: 16:24
 */
public class EasyManagerImpl implements EasyManager {
    public boolean transfer(EasyAccount[] a, int[] i) {
        for (int j = 0; j < i.length; j++) {
            try {
                a[j].change(i[j]);
            } catch (TryAgainEx tryAgainEx) {
                j-=1;
            } catch (ZedDeadBabyEx zedDeadBabyEx) {
                if(j>0)
                {
                    int[] amountsToRevert = new int[j];
                    for (int k = 0; k < j; k++) {
                        amountsToRevert[k] = -i[k];
                    }
                    transfer(a, amountsToRevert);
                }
                return false;
            }
        }
        return true;
    }
}
