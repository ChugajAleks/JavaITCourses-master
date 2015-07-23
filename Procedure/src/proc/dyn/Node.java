package proc.dyn;

public class Node {
    public int value;
    public Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString()
    {
        return "value = " + value + ";\n next: " + next;
    }
}
