package hus.oop.sorteddatastructure;

public class MySortedArrayList extends MySortedAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private int[] data;
    private int size;

    /**
     * Hàm dựng để khởi tạo dữ liệu.
     */
    public MySortedArrayList() {
        this.data = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        data = new int[DEFAULT_CAPACITY];
    }

    @Override
    public int get(int index) {
        if (!checkBoundaries(index, size)) throw new IndexOutOfBoundsException();
        return data[index];
    }

    @Override
    public void add(int value) {
        if (size == data.length) {
            allocateMore();
        }
        int i = size - 1;
        while (i >= 0 && data[i] > value) {
            data[i + 1] = data[i];
            i--;
        }
        data[i + 1] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        if (!checkBoundaries(index, size)) throw new IndexOutOfBoundsException();
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    @Override
    public int binarySearch(int value) {
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (data[mid] == value) return mid;
            else if (data[mid] < value) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    @Override
    public boolean contains(int value) {
        return binarySearch(value) != -1;
    }

    private void allocateMore() {
        int[] newData = new int[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

}
