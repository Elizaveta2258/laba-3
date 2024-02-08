import java.util.Arrays;
import java.util.Scanner;

class Quicksort {
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
        quicksort(result, 0, result.length - 1);
        System.out.println("Упорядоченный массив: " + Arrays.toString(result));
    }

    public static void quicksort(int[] result, int low, int high) {
        if (result == null || result.length == 0)
            return;

        if (low >= high)//проверка завершения рекурсии
            return;

        int middle = low + (high - low) / 2;
        int opora = result[middle];

        int i = low, j = high;
        while (i <= j) {
            // выбор элементов больше или меньше опорного
            while (result[i] < opora) {
                i++;
            }

            while (result[j] > opora) {
                j--;
            }

            if (i <= j) {
                int temp = result[i];
                result[i] = result[j];
                result[j] = temp;
                i++;
                j--;
            }
        }
        // рекурсивный вызов для сортировки двух частей массива
        if (low < j) {
            quicksort(result, low, j);
        }

        if (high > i) {
            quicksort(result, i, high);
        }
    }
}