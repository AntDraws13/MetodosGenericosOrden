package app;

import java.util.Arrays;

public class Arreglo<T extends Comparable<T>> {
    T[] arr;
    T[] UnOrderedArr;
    int size;

    public Arreglo(T[] arr) {
        this.arr = arr;
        this.size = arr.length;
        this.UnOrderedArr = Arrays.copyOf(arr, size);
    }

    public T[] getArr() {
        return arr;
    }


    public T[] getUnOrderedArr() {
        return UnOrderedArr;
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
            heapify(size, i);

        for (int i = size - 1; i >= 0; i--) {
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(i, 0);
        }
    }

    private void heapify(int n, int i) {
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
            heapify(n, largest);
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

    public void CombSort() {
        arr = Arrays.copyOf(UnOrderedArr, size);
        int gap = size;
        boolean swapped = true;
        while (gap != 1 || swapped == true) {
            gap = getNextGap(gap);
            swapped = false;
            for (int i = 0; i < size - gap; i++) {
                if (arr[i].compareTo(arr[i + gap]) > 0) {
                    // Swap arr[i] and arr[i+gap]
                    T temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;

                    // Set swapped
                    swapped = true;
                }
            }
        }
    }

    private int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        if (gap < 1)
            return 1;
        return gap;
    }

    public void GnomeSort() {
        arr = Arrays.copyOf(UnOrderedArr, size);
        int index = 0;
        while (index < size) {
            if (index == 0)
                index++;
            if (arr[index].compareTo(arr[index - 1]) > 0 || arr[index].compareTo(arr[index - 1]) == 0)
                index++;
            else {
                T temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }

    public void MergeSort() {
        arr = Arrays.copyOf(UnOrderedArr, size);
        MergeSort(0, size - 1);
    }

    private void merge(int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        T[] L = Arrays.copyOf(arr, n1);
        T[] R = Arrays.copyOf(arr, n2);

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) < 0 || L[i].compareTo(R[j]) == 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private void MergeSort(int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            MergeSort(l, m);
            MergeSort(m + 1, r);
            merge(l, m, r);
        }
    }

    public void CycleSort() {
        arr = Arrays.copyOf(UnOrderedArr, size);
        for (int cycle_start = 0; cycle_start <= size - 2; cycle_start++) {
            T item = arr[cycle_start];
            int pos = cycle_start;
            for (int i = cycle_start + 1; i < size; i++)
                if (arr[i].compareTo(item) < 0)
                    pos++;
            if (pos == cycle_start)
                continue;
            while (item == arr[pos])
                pos += 1;
            if (pos != cycle_start) {
                T temp = item;
                item = arr[pos];
                arr[pos] = temp;
            }
            while (pos != cycle_start) {
                pos = cycle_start;
                for (int i = cycle_start + 1; i < size; i++)
                    if (arr[i].compareTo(item) < 0)
                        pos += 1;
                while (item == arr[pos])
                    pos += 1;
                if (item != arr[pos]) {
                    T temp = item;
                    item = arr[pos];
                    arr[pos] = temp;
                }
            }
        }
    }
}
