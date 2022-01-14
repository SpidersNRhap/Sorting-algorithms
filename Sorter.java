public class Sorter<E extends Comparable<E>> {
    public E[] arr;

    public Sorter(E[] arr) {
        this.arr = arr; 
    }

    public void swap(int i, int j) {
        E temp = arr [i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void insertionSort() {
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            while (j > 0 && arr[j].compareTo(arr[j - 1]) < 0) {
                swap(j - 1, j--);
            }
        }
    }

    public void selectionSort() {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            swap(min, i);
        }
    }

    public void mergeSort() {
        mergeSort(arr);
    }

    private void mergeSort(E[] arr) {
        if (arr.length > 1) {
            int middle = arr.length / 2;
            @SuppressWarnings ("unchecked")
            E[] left = (E[]) new Comparable[middle];
            @SuppressWarnings ("unchecked")
            E[] right = (E[]) new Comparable[arr.length - middle];
            for (int i = 0; i < middle; i++) {
                left[i] = arr[i];
            }
            for (int i = middle; i < arr.length; i++) {
                right[i - middle] = arr[i];
            }
            mergeSort(left);
            mergeSort(right);
            merge(left, right, arr);
        }
    }
    
    private void merge(E[] left, E[] right, E[] arr) {
        int leftIndex = 0;
        int rightIndex = 0;
        int i = 0;
        while (i < arr.length && leftIndex < left.length && rightIndex < right.length) {
            arr[i++] = left[leftIndex].compareTo(right[rightIndex]) < 0 ? left[leftIndex++] : right[rightIndex++];
        }
        while (leftIndex < left.length) {
            arr[i++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            arr[i++] = right[rightIndex++];
        }
    }

    public boolean isSorted() {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public void bubbleSort() {
        boolean isSorted;
        do {
            isSorted = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    isSorted = false;
                    swap(j, j + 1);
                }
            }
        } while (!isSorted);
    }

    public int search(E n) {
        return search(0, arr.length, n);
    }

    private int search(int l, int r, E n) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (n.compareTo(arr[mid]) > 0) {
                return search(mid + 1, r, n);
            } else if ((n.compareTo(arr[mid]) < 0)) {
                return search(l, mid - 1, n);
            } else {
                return mid;
            }
        }
        return -1;
    }

    public String toString() {
        String s = "[";
        for (E object : arr) {
            s += object.toString() + ", ";
        }
        s = s.substring(0, s.length() - 2) + "]";
        return s;
    }
}