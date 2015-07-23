package ex.strategy.atomix_tx;

/**
 * User: Igor Russo
 * Date: 03.02.13
 * Time: 16:19
 */
public interface EasyAccount {
    public void change(int delta) throws TryAgainEx, ZedDeadBabyEx;
}
