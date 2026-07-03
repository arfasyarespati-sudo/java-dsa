
class MyArrayList {
    private int[] data;
    private int capacity;
    private int size;

    public MyArrayList() {
        capacity = 2;
        data = new int[capacity];
        size = 0;
    }

    public void add(int element) {
        if (size == capacity) {
            resize();
        }
        data[size] = element;
        size++;
    }

    private void resize() {
        capacity = capacity * 2;
        int[] temp = new int[capacity];

        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
        System.out.println("Array capacity " + capacity);
    }

    public int get(int index) {
        if (index >= 0 && index < size) {
            return data[index];
        }
        throw new IndexOutOfBoundsException("Indeks di luar jangkauan!");
    }

    public int getSize() {
        return size;
    }
}

public class dynamicArray {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(10);
        list.add(20);
        list.add(30); // Saat menambah data ke-3, fungsi resize() akan otomatis berjalan

        System.out.println("Data on index-2: " + list.get(2));
        System.out.println("Element total: " + list.getSize());
    }
}
