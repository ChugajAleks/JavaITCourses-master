package basics.bits.packed;

public class PackedFlagArray {
    private long[] data;
    private final int size;

    public PackedFlagArray(int size) {
        if (size < 1) {
            throw new IllegalArgumentException();
        }
        this.data = new long[size / 64 + (size % 64 > 0 ? 1 : 0)];
        this.size = size;
    }

    public void setFlag(int index, boolean value) {
        // тут тело метода setFlag
        if (index < 0 || size <= index) {
            throw new IllegalArgumentException();
        }

        // find a position in data array to set flag
        int arrayIndex = 0;
        index++;
        if (index % 64 != 0) { // == not a first bit
            arrayIndex = index / 64 + (index % 64 > 0 ? 1 : 0) - 1;
        }

        System.out.println("arrayIndex = " + arrayIndex);

        if (value) {
                data[arrayIndex] = data[arrayIndex] | (1L << index);
        } else {
                data[arrayIndex] = data[arrayIndex] & ~(1L << index);
        }

    }
    public boolean getFlag(int index) {
        // тут тело метода getFlag
        if (index < 0 || size <= index) {
            throw new IllegalArgumentException();
        }

        // find a position in data array to get flag
        int arrayIndex = 0;
        index++;
        if (index % 64 != 0) {
            arrayIndex = index / 64 + (index % 64 > 0 ? 1 : 0) - 1;
        }

        // and if current bit=1 return true
        return (data[arrayIndex] & (1L << index)) != 0;

    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("[");

        for (int i=0; i<data.length; i++) {

            buffer.append("(");
            for (int k = 1; k <= 64; k++) {
                buffer.append(((data[i] & (1L << k)) == 0) ? 0 : 1);
            }
            buffer.append(")");

        }

        buffer.append("]");

        return buffer.toString();
    }


}


