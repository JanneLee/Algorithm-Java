/**
* @FileName MergeSort.java
* @Package com.algorithm.sort
* @Description 
* @Author ali blog:http://www.cnblogs.com/accipiter
* @Date 1:06:31
* @Version V1.0.1
*/
package com.algorithm.sort;
/**
* @author lijianli
* @ClassName MergeSort
* @Description TODO
 */
public class MergeSort {
	/**
	* @Title Merge
	* @Description TODO
	* @param arr
	* @param low
	* @param mid
	* @param high 
	* @Return void
	* @Throws 
	* @user Administrator
	 */
    public void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] tmparr = new int[high - low + 1];
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
            	tmparr[k++] = arr[i++];
            } else {
            	tmparr[k++] = arr[j++];
            }
        }
        while (i <= mid) {
        	tmparr[k++] = arr[i++];
        }
        while (j <= high) {
        	tmparr[k++] = arr[j++];
        }
        for (k = 0, i = low; i <= high; i++, k++) {
            arr[i] = tmparr[k];
        }
    }
    /**
    * @Title MergeStep
    * @Description TODO
    * @param arr
    * @param len
    * @param length 
    * @Return void
    * @Throws 
    * @user Administrator
     */
    public void mergeStep(int[] arr, int len, int length) {
        int i;
        for (i=0;i+ 2*len-1<length;i+=2*len){
        	merge(arr,i, i+len-1, i+ 2*len-1);
        }
        if (i+len-1<length){
        	merge(arr,i, i+len-1,length-1);
        }
    }
    /**
    * @Title sort
    * @Description TODO
    * @param list
    * @return 
    * @Return int[]
    * @Throws 
    * @user Administrator
     */
    public int[] sort(int[] list) {
        for (int len = 1; len < list.length; len = 2 * len) {
        	mergeStep(list, len, list.length);
            System.out.print("len = " + len + ":\t");
            this.printAll(list);
        }
        return list;
    }
    /**
    * @Title printAll
    * @Description TODO
    * @param list 
    * @Return void
    * @Throws 
    * @user Administrator
     */
    public void printAll(int[] list) {
        for(int value : list){
            System.out.print(value + "\t");
        }
        System.out.println();
    }
    /**
    * @Title MSort
    * @Description 
    * @param arr
    * @param low
    * @param high 
    * @Return void
    * @Throws 
    * @user Administrator
     */
    public void mSort(int []arr,int low,int high){
    	if(low<high){
    		int mid=(low+high)/2;
    		mSort(arr,low,mid);
    		mSort(arr,mid+1,high);
    		merge(arr,low,mid,high);
    		this.printAll(arr);
    	}
    }
    public static void main(String[] args) {
        int[] array = { 8, 1, 7, 3, 1, 2, 6, 9, 5};
        MergeSort merge = new MergeSort();
        System.out.print("排序前:\t\t");
        merge.printAll(array);
//        merge.sort(array);
        merge.mSort(array,0,array.length-1);
        System.out.print("排序后:\t\t");
        merge.printAll(array);
    }
}
