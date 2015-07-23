package ex.try_catch_finally.atomic_tx;

public interface Account {

    public void change(int delta) throws TryAgainException, BlockAccountException;

}
