package EjerciciosAlgoritmos;

public class MedianaEnStream {
    private int[] maxHeap;
    private int[] minHeap;
    private int maxHeapSize;
    private int minHeapSize;

    public MedianaEnStream(int capacity) {
        maxHeap = new int[capacity];
        minHeap = new int[capacity];
        maxHeapSize = 0;
        minHeapSize = 0;
    }

    public void addNumber(int num) {
        if (maxHeapSize == 0 || num <= maxHeap[0]) {
            insertMaxHeap(num);
        } else {
            insertMinHeap(num);
        }

        if (maxHeapSize > minHeapSize + 1) {
            insertMinHeap(extractMaxHeap());
        } else if (minHeapSize > maxHeapSize) {
            insertMaxHeap(extractMinHeap());
        }
    }

    public double findMedian() {
        if (maxHeapSize == minHeapSize) {
            return (maxHeap[0] + minHeap[0]) / 2.0;
        } else {
            return maxHeap[0];
        }
    }

    private void insertMaxHeap(int num) {
        maxHeap[maxHeapSize] = num;
        int i = maxHeapSize;
        while (i > 0 && maxHeap[i] > maxHeap[(i - 1) / 2]) {
            int temp = maxHeap[i];
            maxHeap[i] = maxHeap[(i - 1) / 2];
            maxHeap[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
        maxHeapSize++;
    }

    private int extractMaxHeap() {
        int max = maxHeap[0];
        maxHeap[0] = maxHeap[--maxHeapSize];
        int i = 0;
        while (i * 2 + 1 < maxHeapSize) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            int largest = left;
            if (right < maxHeapSize && maxHeap[right] > maxHeap[left]) {
                largest = right;
            }
            if (maxHeap[i] >= maxHeap[largest]) {
                break;
            }
            int temp = maxHeap[i];
            maxHeap[i] = maxHeap[largest];
            maxHeap[largest] = temp;
            i = largest;
        }
        return max;
    }

    private void insertMinHeap(int num) {
        minHeap[minHeapSize] = num;
        int i = minHeapSize;
        while (i > 0 && minHeap[i] < minHeap[(i - 1) / 2]) {
            int temp = minHeap[i];
            minHeap[i] = minHeap[(i - 1) / 2];
            minHeap[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
        minHeapSize++;
    }

    private int extractMinHeap() {
        int min = minHeap[0];
        minHeap[0] = minHeap[--minHeapSize];
        int i = 0;
        while (i * 2 + 1 < minHeapSize) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            int smallest = left;
            if (right < minHeapSize && minHeap[right] < minHeap[left]) {
                smallest = right;
            }
            if (minHeap[i] <= minHeap[smallest]) {
                break;
            }
            int temp = minHeap[i];
            minHeap[i] = minHeap[smallest];
            minHeap[smallest] = temp;
            i = smallest;
        }
        return min;
    }

    public static void main(String[] args) {
        MedianaEnStream medianaEnStream = new MedianaEnStream(100);
        int[] numeros = {1, 3, 2, 4, 5};
        for (int num : numeros) {
            medianaEnStream.addNumber(num);
            System.out.println("Mediana actual: " + medianaEnStream.findMedian());
        }
    }
}