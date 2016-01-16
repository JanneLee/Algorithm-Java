package com.algorithm.sort;

public class TestQuickSort {
    @SuppressWarnings("unchecked")
    private static int Partion(Object [] arr,int low,int high){
        Object pivotkey=arr[low];
        while(low<high){
            while(low<high&&((Comparable<Object>)arr[high]).compareTo((Comparable<Object>)pivotkey)>=0){
                --high;
            }
            arr[low]=arr[high];
            while(low<high&&((Comparable<Object>)pivotkey).compareTo((Comparable<Object>)arr[low])>=0){
                ++low;
            }
            arr[high]=arr[low];
        }
        arr[low]=pivotkey;
        return low;
    }
    
    public static void QuickSort(Object arr[],int low,int high){
        if(low<high){
            int pivot=Partion(arr, low, high);
            QuickSort(arr, low, pivot-1);
            QuickSort(arr, pivot+1, high);
        }
    }
    
    public static void main(String args[]){
//        Object arr[]={1,3,4,2,0,-5,6,7}; 
//        Object arr[]={1.1,3.3,4.2,2.2,0.1,-5.0,6.99999,7.0}; 
        Object arr[]={"how","are","you","i","am","fine","thanks","!"}; 
//        Object arr[]={"123","432","213","124","a123","432","23412","adfa"}; 
        QuickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}