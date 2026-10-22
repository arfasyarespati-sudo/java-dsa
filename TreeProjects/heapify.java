package TreeProjects;

public class heapify {
    private static final int MAX_SIZE = 100;
    private int[] heap;
    private int heapSize;

    // Konstruktor
    public heapify() {
        heap = new int[MAX_SIZE];
        heapSize = 0;
    }

    // Fungsi untuk menukar dua elemen dalam array berdasarkan indeks
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Fungsi insert (Heapify Up)
    public void insert(int val) {
        if (heapSize >= MAX_SIZE) {
            System.out.println("Heap penuh!");
            return;
        }

        heap[heapSize] = val;
        int curr = heapSize;
        heapSize++;

        while (curr > 0) {
            int parent = (curr - 1) / 2;
            if (heap[curr] > heap[parent]) {
                swap(curr, parent);
                curr = parent;
            } else {
                break;
            }
        }
    }

    // Fungsi extractMax (Heapify Down)
    public int extractMax() {
        if (heapSize <= 0) {
            return -1;
        }

        int maxVal = heap[0];
        heap[0] = heap[heapSize - 1];
        heapSize--;

        int curr = 0;
        while (true) {
            int left = 2 * curr + 1;
            int right = 2 * curr + 2;
            int largest = curr;

            if (left < heapSize && heap[left] > heap[largest]) {
                largest = left;
            }
            if (right < heapSize && heap[right] > heap[largest]) {
                largest = right;
            }

            if (largest != curr) {
                swap(curr, largest);
                curr = largest;
            } else {
                break;
            }
        }

        return maxVal;
    }

    // Fungsi untuk mencetak isi array heap
    public void printHeap() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        heapify maxHeap = new heapify();

        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(30);
        maxHeap.insert(15);

        System.out.print("Heap array: ");
        maxHeap.printHeap(); // Output: 30 20 5 10 15

        System.out.println("Extracted Max: " + maxHeap.extractMax()); // Output: 30

        System.out.print("Heap array after extraction: ");
        maxHeap.printHeap(); // Output: 20 15 5 10
    }
}
