package hus.oop.sorteddatastructure;

public abstract class MySortedAbstractList implements MySortedList {
    public boolean checkBoundaries(int index, int limit) {
        return index >= 0 && index < limit;
    }

    @Override
    public String toString() {
        int[] array = toArray();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
