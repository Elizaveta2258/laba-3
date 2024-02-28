import java.util.Arrays;
import java.util.Scanner;

class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[15];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 15 элементов массива:");
        for (int i = 0; i < 15; i++) {
            array[i] = scanner.nextInt();
        }
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] == array[j]) {
                    for (int k = j; k < n - 1; k++) {
                        array[k] = array[k + 1];
                    }
                    n--;
                    j--;
                }
            }
        }
        int[] result = Arrays.copyOf(array, n);
        mergeSort(result, 0, result.length - 1);
        System.out.println("Упорядоченный массив: " + Arrays.toString(result));
    }

    public static void mergeSort(int[] result, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(result, left, mid);
            mergeSort(result, mid + 1, right);
            merge(result, left, mid, right);
        }
    }

    public static void merge(int[] result, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArr[i] = result[left + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rightArr[j] = result[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                result[k] = leftArr[i];
                i++;
            } else {
                result[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            result[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            result[k] = rightArr[j];
            j++;
            k++;
        }
    }
}