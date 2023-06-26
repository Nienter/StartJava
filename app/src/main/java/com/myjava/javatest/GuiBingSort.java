package com.myjava.javatest;

public class GuiBingSort {
    public static void main(String[] args) {
        int[] data = new int[]{2, 5, 5, 56, 3, 24, 5};
        int left = 0;
        int right = data.length - 1;
        MergeSort(data, left, right);
        for (int i:data
             ) {
            System.out.println(data[i]);
        }
    }

    private static void MergeSort(int[] data, int l, int r) {
        if (r - l + 1 == 1) {
            return;
        }
        int mid = l + (r - 1) / 2;
        MergeSort(data, l, mid);
        MergeSort(data, mid + 1, r);
        Sort(data, l, mid, r);
    }

    private static void Sort(int[] data, int l, int mid, int r) {
        int i = l;

        int j = mid + 1;
        int k = 0;
        int[] temp = new int[data.length];
        while (i <= mid && j <= r) {
            if (data[i] < data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = data[i++];
        }
        while (j <= r) {
            temp[k++] = data[j++];
        }
        int t = 0;
        int tempLeft = l;
        while (tempLeft <= r) {
            data[tempLeft++] = temp[t++];
        }

    }
}
