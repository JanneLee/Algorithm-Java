package com.algorithm.sort;

import java.util.Arrays;

/**
 *
 * @author lijianli
 * @date 2019/12/24
 */
public class InplaceMergeSort {

    public static void main(String[] args) {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 49, 34, 12, 64, 5, 4, 62, 99};
//        int a[]={4,5,2,4,6,8,1};
        mergeSort(a,0,a.length-1);
        System.out.println("arr:"+ Arrays.toString(a));
    }

    private static void mergeSort(int arr[],int low,int high){
        if(low<high){
            int mid=(low+high)>>1;
            System.out.println("mid>>>>>"+mid);
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        while (i < j && j <= high) {
            // 先找到第一个数组中比第二个数组第一个数大的第一个值
            while (i < j && arr[i] <= arr[j]) {
                i++;
            }
            // 然后再找到第二个数组中比a[i]大的第一个值
            int index = j;
            while (j <= high && arr[i] >= arr[j]) {
                j++;
            }
            // 此时a[left...i-1]均小于a[middle+1...j-1],交换位置并将i前移j-1-middle-1位即可，然后重复
            swapAdjacentBlocks(arr, i, index-i, j-index);
            i += j - index;
        }
    }

    private static void swapAdjacentBlocks(int arr[], int bias, int oneSize, int anotherSize) {
        reverse(arr, bias, bias + oneSize - 1);
        reverse(arr, bias + oneSize, bias + oneSize + anotherSize - 1);
        reverse(arr, bias, bias + oneSize + anotherSize - 1);
    }

    private static void reverse(int[] arr, int low, int high) {
        int i=low,j=high;
        while (i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
