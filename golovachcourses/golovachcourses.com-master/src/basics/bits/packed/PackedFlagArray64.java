package basics.bits.packed;

public class PackedFlagArray64 {
    private long data;
    private final int size;

    public PackedFlagArray64(int size) {
        if (size < 1 || 64 < size) {
            throw new IllegalArgumentException();
        }
        this.size = size;
    }

    public void setFlag(int index, boolean value) {
        if (index < 0 || size <= index) {
            throw new IllegalArgumentException();
        }
        if (value) {
            data = data | (1L << index); // set bit to '1'
        } else {
            data = data & ~(1L << index); // set bit to '0'
        }
    }

    public boolean getFlag(int index) {
        if (index < 0 || size <= index) {
            throw new IllegalArgumentException();
        }
        return (data & (1L << index)) != 0;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("[");
        for (int k = 0; k < size; k++) {
            buffer.append(((data & (1L << k)) == 0) ? 0 : 1);
        }
        buffer.append("]");
        return buffer.toString();
    }
}