package app;

import java.util.Iterator;

public class Arreglo<T extends Comparable<T>> implements Iterable<T>{
    T[] arr;
    T[] array;
    int size;

    public Arreglo(T[] arr) {
        this.arr = arr;
        this.size = arr.length;
        this.array = this.arr;
    }

    public T[] getArr() {
        return array;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    public void CocktailSort(){
        boolean swapped = true;
        int start = 0;
        int end = size;

        while (swapped) {

            swapped = false;

            for (int i = start; i < end - 1; ++i) {
                if (arr[i].compareTo(arr[i+1]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = true;
                }
            }

            if (swapped == false)
                break;

            swapped = false;
            end = end - 1;
            for (int i = end - 1; i >= start; i--) {
                if (arr[i].compareTo(arr[i+1])>0) {
                    T temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = true;
                }
            }
            start = start + 1;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i<size;
            }

            @Override
            public T next() {
                return arr[i++];
            }

        };
    }
}
