package com.example.lib2;

public class Fial {
    public static void main(String[] args) {
        Integer h = 45;
        int[] arr = {10, 2, 4, 4, 9, 11, 12, 23};
        //
//        insert(arr);
        new Fial().kuai(arr, 0, 7);
//        new Fial().quick(arr, 0, 5);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void test(float a) {
    }

    //bubble sort
    //冒泡排序的时间复杂度:最好情况是“O(n)”,最坏情况是“O(n2)
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
//                    temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
                }
            }
        }
    }


    //最好时间复杂度:最好情况是“O(n)”,最坏情况是“O(n2)
    public static void insert(int[] a) {
        for (int i = 1; i < a.length; i++)     //n-1此扫描，依次向前插入n-1个元素
        {
            int temp = a[i];       //每趟将a[i]插入到前面的排序子序列中
            int j;
            for (j = i - 1; j >= 0 && temp < a[j]; j--) {
                a[j + 1] = a[j];  //将前面较大的元素向后移动
            }
            a[j + 1] = temp;      //temp值到达插入位置

        }
    }

    public static void in(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
//                        swap( arr[j], arr[j-1]);
                }
            }
        }
    }


    //Insertion sort
    public static void insertionSort(int[] arr, int n) {
        int i, key, j;
        for (i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }


    //selection sort
    // 最坏情况是O(n2)

    public static void selectionSort(int[] arr) {
        int i, j, min, temp;
        for (i = 0; i < arr.length - 1; i++) {
            min = i;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }


    //quick sort  nlogn
    public static void quickSort(int[] arr, int left, int right) {
        int i = left, j = right;
        int pivot = arr[left];
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            //9,2,5,4 ,10,11,12,23
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
                for (int l = 0; l < arr.length; l++) {
                    System.out.print(arr[l] + ",");
                }
                System.out.println("****");
            }
        }
        if (left < j) {
            quickSort(arr, left, j);
        }
        if (i < right) {
            quickSort(arr, i, right);
        }
    }

    void quick(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while ((i < j) && (arr[j] > pivot)) {
                j--;
            }
            while ((i < j) && (arr[i] < pivot)) {
                i++;
            }
            if ((arr[i] == arr[j]) && (i < j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //1,4,2,3,5,6
        if (i - 1 > start) quick(arr, start, i - 1);
        if (j + 1 < end) quick(arr, j + 1, end);
    }


    public void quc(int[] qu, int left, int right) {
        if (left > right) {
            return;
        }
        int p = qu[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (qu[j] >= p && i < j) {
                j--;
            }
            while (qu[i] <= p && i < j) {
                i++;
            }
            if (i < j) {
                int temp = qu[i];
                qu[i] = qu[j];
                qu[j] = temp;
            }
        }
        //{10,2,5,4 ,9,11,12,23}
        qu[left] = qu[i];
        qu[i] = p;
        quc(qu, left, i - 1);
        quc(qu, i + 1, right);
    }

    public void kuai(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int pro = arr[left];
        while (i != j) {
            while (arr[j] >= pro && i < j) {
                j--;
            }
            while (arr[i] <= pro && i < j) {
                i++;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = pro;
        kuai(arr, left, i - 1);
        kuai(arr, j + 1, right);
    }

}
