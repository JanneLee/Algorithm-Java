/**
* @FileName MergeSort.java
* @Package com.algorithm.sort
* @Description 
* <li>二路归并排序，它相对与快排序和堆排序来说，是稳定的排序方法，时间复杂度o(nlnn),空间复杂度为o(n)</li>
* @Author ali blog:http://www.cnblogs.com/accipiter
* @Date 上午1:06:31
* @Version V1.0.1
*/
package com.algorithm.sort;
/**
* @ClassName MergeSort
* @Description TODO
* @Date 下午11:14:51
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
        int i = low; // i是第一段序列的起始
        int j = mid + 1; // j是第二段序列的起始
        int k = 0; // k是临时存放合并序列的起始
        int[] tmparr = new int[high - low + 1]; // tmparr是临时合并序列
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
        int i = 0;
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
    * <li>纯递归实现二路归并排序</li>
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
