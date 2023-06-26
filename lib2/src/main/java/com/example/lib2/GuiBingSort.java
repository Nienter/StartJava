package com.example.lib2;

public class GuiBingSort {
    public static void main(String[] args) {
        int[] data = new int[]{2, 5, 5, 56, 3, 24, 5};
        int left = 0;
        int right = data.length - 1;
        MergeSort(data, left, right);
       for (int i = 0; i<data.length;i++){
           System.out.println(data[i]);
       }
    }

    private static void MergeSort(int[] data, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2; //中间索引
            //向左递归进行分解
            //0 - mid 即是0 - 3 {8,4,5,7}
            MergeSort(data, left, mid);
            //向右递归进行分解
            //mid+1 - midright 即是4 - 7  {1,3,6,2}
            MergeSort(data, mid + 1, right);
            //进行合并
            merge(data,left,mid,right);
        }
    }

    private static void merge(int[] data, int l, int mid, int r) {
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
