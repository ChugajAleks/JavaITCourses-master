package AtomicOperations;

/**
 * Created by aleks on 03.09.15.
 */
public class SynchronizedCounter {
    private int count;

    public synchronized void set(int value){
        this.count = value;
    }
    public synchronized int get(){
        return this.count;
    }
    public synchronized int increment(){
        this.count++;
        return this.count;
    }
    public synchronized int decrement(){
        this.count--;
        return this.count;
    }
}


