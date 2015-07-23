package ex.strategy.atomix_tx;

/**
 * User: Igor Russo
 * Date: 03.02.13
 * Time: 16:21
 */
public interface EasyManager {
    public boolean transfer(EasyAccount[] accounts, int[] money);
}
