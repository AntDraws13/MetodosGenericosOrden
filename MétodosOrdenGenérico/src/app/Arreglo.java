package app;

import java.util.Arrays;
import java.util.Iterator;

public class Arreglo<T extends Comparable<T>> {
    T[] arr;
    T[] UnOrderedArr;
    int size;

    public Arreglo(T[] arr) {
        this.arr = arr;
        this.size = arr.length;
        this.UnOrderedArr = Arrays.copyOf(arr,size);
    }

    public T[] getArr() {
        return arr;
    }


    public T[] getUnOrderedArr() {
        return UnOrderedArr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    public void CocktailSort() {
        arr = Arrays.copyOf(UnOrderedArr, size);
        boolean swapped = true;
        int start = 0;
        int end = size;

        while (swapped) {

            swapped = false;

            for (int i = start; i < end - 1; ++i) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }

            if (swapped == false)
                break;

            swapped = false;
            end = end - 1;
            for (int i = end - 1; i >= start; i--) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            start = start + 1;
        }
        //arr = UnOrderedArr;
    }

    public void HeapSort() {
        arr = Arrays.copyOf(UnOrderedArr, size);
        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(arr, size, i);

        for (int i = size - 1; i >= 0; i--) {
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private void heapify(T arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // If left child is larger than root
        if (l < n && arr[l].compareTo(arr[largest]) > 0)
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r].compareTo(arr[largest]) > 0)
            largest = r;

        // If largest is not root
        if (largest != i) {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    public void InsertionSort() {
        arr = Arrays.copyOf(UnOrderedArr, size);
        for (int i = 1; i < size; ++i) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public void ShellSort() {
        arr = Arrays.copyOf(UnOrderedArr, size);
        for (int gap = size / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < size; i += 1) {
                T temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap].compareTo(temp) > 0; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
    }

    public void QuickSort() {
        arr = Arrays.copyOf(UnOrderedArr, size);
        sort(0, size - 1);
    }

    private void sort(int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(low, pi - 1);
            sort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        T pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0 || arr[j].compareTo(pivot) == 0) {
                i++;
                // swap arr[i] and arr[j]
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
