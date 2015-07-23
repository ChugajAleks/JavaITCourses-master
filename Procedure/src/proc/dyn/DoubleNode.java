package proc.dyn;

public class DoubleNode {
    public int value;
    public DoubleNode prev;
    public DoubleNode next;
    public DoubleNode(int value, DoubleNode prev, DoubleNode next){
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}
