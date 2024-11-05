package org.caselab.task1;

import java.util.Scanner;

/*
 Вариант 1 - Работа с массивом
 Заполните массив случайным числами и выведите максимальное, минимальное и среднее значение.
 Для генерации случайного числа используйте метод Math.random().
 Также реализовать сортировку массива по возрастанию / убыванию любым алгоритмом.

 Требования:
 Необходимо использовать отдельные функции для подсчета каждого значения и сортировки
 Написать перегрузки функций для массива целочисленных и дробных значений
 Размер должен вводиться с консоли (смотри класс Scanner и его методы считывания с консоли).
 Если он 0 или меньше должно появляться сообщение об ошибке
 Пользователь может ввести границы генерации случайных чисел
 */


public class Main {

    static interface Comparable {
        boolean cmp(int left, int right);
        boolean cmp(float left, float right);
    }

    static Comparable asc = new Comparable() {
        @Override
        public boolean cmp(int left, int right) {
            return left <= right;
        }

        @Override
        public boolean cmp(float left, float right) {
            return left <= right;
        }
    };

    static Comparable desc = new Comparable() {
        @Override
        public boolean cmp(int left, int right) {
            return left >= right;
        }

        @Override
        public boolean cmp(float left, float right) {
            return left >= right;
        }
    };

    public static void quickSort(int[] arr, Comparable cmp) {
        quickSort(arr, 0, arr.length - 1, cmp);
    }

    public static void quickSort(int[] arr, int low, int high, Comparable cmp) {
        if (low < high) {
            int pivot = setPivot(arr, low, high, cmp);

            quickSort(arr, low, pivot - 1, cmp);
            quickSort(arr, pivot + 1, high, cmp);
        }
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1, asc);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = setPivot(arr, low, high, asc);

            quickSort(arr, low, pivot - 1, asc);
            quickSort(arr, pivot + 1, high, asc);
        }
    }

    static void swap(int[] arr, int i, int j) {
        if (arr == null || i == j) {
            return;
        }
        if (i < 0 || j < 0 || i > arr.length - 1 || j > arr.length - 1) {
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int setPivot(int[] arr, int low, int high) {
        return setPivot(arr, low, high, asc);
    }

    private static int setPivot(int[] arr, int low, int high, Comparable cmp) {
        int mid = low + (high - low) / 2;
        int pivot = arr[mid];

        swap(arr, mid, high);

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (cmp.cmp(arr[j], pivot)) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i + 1;
    }


    static int nextRandom(int low, int high) {
        return (int) (low + Math.random()*(high - low));
    }

    static void fillArrayWithRandom(int[] arr, int lowBound, int highBound) {
        for (int i=0; i<arr.length; i++) {
            arr[i] = nextRandom(lowBound, highBound);
        }
    }

    static int getMin(int[] arr) {
        int tmp = arr[0];
        for (int el: arr) {
            if (tmp < el) tmp = el;
        }
        return tmp;
    }

    static int getMax(int[] arr) {
        int tmp = arr[0];
        for (int el: arr) {
            if (tmp > el) tmp = el;
        }
        return tmp;
    }

    static float getMean(int[] arr) {
        float sum = 0;
        for (int el: arr) {
            sum += el;
        }
        return sum/arr.length;
    }

    public static void quickSort(float[] arr,  Comparable cmp) {
        quickSort(arr, 0, arr.length - 1, cmp);
    }

    public static void quickSort(float[] arr) {
        quickSort(arr, 0, arr.length - 1, asc);
    }

    public static void quickSort(float[] arr, int low, int high) {
        quickSort(arr, low, high, asc);
    }

    public static void quickSort(float[] arr, int low, int high, Comparable cmp) {
        if (low < high) {
            int pivot = setPivot(arr, low, high, cmp);

            quickSort(arr, low, pivot - 1, cmp);
            quickSort(arr, pivot + 1, high, cmp);
        }
    }

    static void swap(float[] arr, int i, int j) {
        if (arr == null || i == j) {
            return;
        }
        if (i < 0 || j < 0 || i > arr.length - 1 || j > arr.length - 1) {
            return;
        }
        float tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int setPivot(float[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        float pivot = arr[mid];

        swap(arr, mid, high);

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i + 1;
    }

    private static int setPivot(float[] arr, int low, int high, Comparable cmp) {
        int mid = low + (high - low) / 2;
        float pivot = arr[mid];

        swap(arr, mid, high);

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i + 1;
    }


    static float nextRandom(float low, float high) {
        return (float) (low + Math.random()*(high - low));
    }

    static void fillArrayWithRandom(float[] arr, float lowBound, float highBound) {
        for (int i=0; i<arr.length; i++) {
            arr[i] = nextRandom(lowBound, highBound);
        }
    }

    static float getMin(float[] arr) {
        float tmp = arr[0];
        for (float el: arr) {
            if (tmp < el) tmp = el;
        }
        return tmp;
    }

    static float getMax(float[] arr) {
        float tmp = arr[0];
        for (float el: arr) {
            if (tmp > el) tmp = el;
        }
        return tmp;
    }

    static float getMean(float[] arr) {
        float sum = 0;
        for (float el: arr) {
            sum += el;
        }
        return sum/arr.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N <= 0) {
            throw new RuntimeException("N should be grater then 0");
        }
        int low = sc.nextInt();
        int high = sc.nextInt();
        if (high <= low) {
            throw new RuntimeException("Low bound should be lower ther high");
        }
        int[] array = new int[N];
        fillArrayWithRandom(array, low, high);

        for (int el: array) {
            System.out.printf("%d ", el);
        }

        System.out.printf("\n min: %d, max: %d, mean: %f\n",
                getMin(array), getMax(array), getMean(array)
        );

        quickSort(array);

        for (int el: array) {
            System.out.printf("%d ", el);
        }

    }

}