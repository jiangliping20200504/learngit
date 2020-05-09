package com.example.demo.utils;

import java.util.Arrays;
import java.util.Collections;

/***
 *  Arrays.sort();----基本类型数据使用快速排序法，对象数组使用归并排序
 *  Collections.sort();-----归并排序，稳定排序
 * @ java八大排序
 *
 * */
public class SortUtil {

    /***
     * 1  插入排序
     *  在要排序的一组数中，假设前面(n-1)[n>2]个数已经是排好顺序的，现在要把第n个数插到前面的有序数中，
     *  使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序
     *
     * */
    public static  void insertSort(int[] data){
        int temp;
        for(int i=1; i<data.length; i++){
            temp = data[i];// 取第i个数，插入前边的有序的序列
            int j;
            for(j = i-1;j>=0;j--){
//                从第i-1的位置上开始比较
                if(data[j] > temp){
                    data[j+1] = data[j];//若前面的数大，则往后挪一位
                }else {
                    break;// 要插入的数比较大
                }
            }
            data[j+1] = temp;//找到这个位置，插入数据
        }
    }

    /***
     * 2  希尔排序-----非稳定排序算法
     *  也称递减增量排序算法，是插入排序的一种更高级的改进版本
     *  对有序序列在插入时采用交换法
     *
     * */
    public static void shellSort(int[] arr){
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共gap组，每组有个元素), 步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    //对交换式的希尔排序进行优化->移位法
    public static void shellSort2(int[] arr) {
        // 增量gap, 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }
            }
        }
    }

    /***
     * 3  简单选择
     *  对于给定的一组记录，经过第一轮比较后得到最小记录，然后将该记录的位置与第一个记录的位置交换；接着对不包括第一个记录以外的其他
     *  记录进行第二次比较，得到最小记录并与第二个位置记录交换；重复该过程，直到进行比较的记录只剩下一个为止
     *
     *
     * */
    public static void selectSort(int[] array){
        int len = array.length;
        for(int i=0; i<len; i++){
//            确定每次开始的位置
            int min = array[i];//设定数字为最小值
            int flag = i;
            for(int j=i+1; j<len; j++){
//                把最小值放到min，从开始数字向后一个个和min比较，再把最小值存放到min
                if(min > array[j]){
                    min = array[j];
                    flag = j;
                }
            }
            if(flag != i){
                array[flag] = array[i];
                array[i] = min;
            }
        }
    }

    /***
     * 4  堆排序
     *
     * */
    public static void heapSort(int[] array){
    }

    /***
     * 4  堆排序
     *  将待排序的序列构造成一个大顶堆(从大到小排要构造成小顶堆)。此时，整个序列的最大值就是堆顶的根节点，
     *  将他和末尾元素交换，然后将剩余的length-1个节点序列重新构造成新的堆。
     *  重复执行，便能得到一个有序序列。
     * */
    public static void heapSort(int []a,int len){
        int i;
        for(i=len/2;i>=0;i--){ /*把a[]构造成一个大顶堆*/
            heapAdjust(a,i,len);
        }
        for(i=len;i>0;i--){
            swap(a,0,i); /*交换堆顶最大元素和堆尾最小元素*/
            heapAdjust(a,0,i-1);  /*把交换后的堆a[0,i-1]，再次构造成大顶顶，使堆顶元素为最大值*/
        }
    }
    static void heapAdjust(int []a,int start,int len){
        int temp,j;
        temp=a[start];
        for(j=2*start;j<=len;j*=2){   /*从index最大的有孩子的节点开始筛选，堆排*/
            if(j<len&&a[j]<a[j+1])    /*是index=j的元素为较大的元素*/
                j++;
            if(temp>=a[j])
                break;
            a[start]=a[j];            /*将较大元素赋值给父节点*/
            start=j;
        }
        a[start]=temp;
    }
    static void swap(int a[],int low,int high){
        int temp=a[low];
        a[low]=a[high];
        a[high]=temp;
    }

    /***
     * 5  冒泡排序
     * 将序列中从头到尾所有元素两两比较，将最大的放在最后面
     * 将剩余序列中所有元素再次两两比较，将最大的放在最后面
     * 重复第二步，直到只剩下一个数
     *
     * */
    public static void bubbleSort(int[] array){
        for(int i=0; i<array.length;i++){//第i冒泡，一次冒泡，会确定一个最大值
            for(int j=0; j<array.length-i-1; j++){
                int temp = array[j];
                if(array[j] > array[j+1]){
                    array[j] =  array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    /***
     * 6  快排
     * @low 0  错误示范
     * @high array.length-1
     *
     * */
    public static void quickSort(int[] array, int low, int high){
        if(low >= high){
            return;
        }
        int left = low;
        int right = high;
        int pivot = array[left];//设立基准点
        while (left < right){
            while (left < right && array[right]>pivot)//从右到左，大数位置不变
                right --;
            array[left] = array[right];//把小数移到左边
            while (left<right && array[left]<pivot)//从左到右，小数位置不变
                left++;
            array[right] = array[left];//把大数移到右边
        }
        array[left] = pivot;
        quickSort(array, low, left-1);
        quickSort(array,left+1,high);
    }
    /***
     * 7 归并排序
     *  分而治之
     * @start 0
     * @end array.length-1
     *
     * */
    public static void mergeSort(int[] array, int start, int end){
        int mid = (start + end) / 2;
        if(start < end){//当子序列中只有一个元素时结束递归
            mergeSort(array, start, mid);
            mergeSort(array, mid+1, end);
            merge(array,start,mid,end);
        }
    }
//  两路归并算法，两个排好序的子序列合并为一个子序列
    private static void merge(int[] array, int left, int mid, int right){
        int[] tmp = new int[right-left+1];//辅助数组
        int p1 = left;//p1 左指针
        int p2 = mid+1;//p2是右指针
        int k=0;
        while (p1 <= mid && p2 <= right){
            if(array[p1] <= array[p2])
                tmp[k++] = array[p1++];
            else
                tmp[k++] = array[p2++];
        }
        while (p1<=mid)
            tmp[k++] = array[p1++];//把左边剩余的数移入数组
        while (p2<=right)
            tmp[k++] = array[p2++];//把右边剩余的数移入数组
//        复制回原数组
        for(int i=0; i<tmp.length; i++)
            array[i+left] = tmp[i];
    }

    /***
     * 8  基数排序
     *
     *
     * */

    /***
     * 6  快排
     * @low 0
     * @high array.length-1
     *
     * */
    public static void quickSort2(int[] array, int start, int end){
        if(start >= end){
            return;
        }
        int partition = divide(array, start, end);
        quickSort2(array, start, partition-1);
        quickSort2(array,partition+1,end);
    }
    public static int divide(int[] array, int start, int end){
//        每次以最右边元素作为基准
        int base = array[end];
//        start一旦等于end，就说明左右两个指针合并到了同一位置，可以结束此次循环
        while (start < end){
            while (start<end && array[start]<=base){
                start++;
            }
            if(start<end){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                end--;
            }
            while (start<end && array[end]>=base){
                end--;
            }
            if(start < end){
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
            }
        }
        return end;
    }

    /***
     * 6  快排
     * @low 0
     * @high array.length-1
     *
     * */
    public static void quickSort3(int[] array, int low, int high){
        if(low >= high){
            return;
        }
        int left = low;
        int right = high;
        int pivot = array[left];//设立基准点
        while (left < right){
            while (left < right && array[right]>pivot)//从右到左，大数位置不变
                right --;
            if(left < right){//把小数移到左边
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
            }
            while (left<right && array[left]<pivot)//从左到右，小数位置不变
                left++;
            if(left<right){//把大数移到右边
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                right--;
            }
        }
        array[left] = pivot;
        quickSort3(array, low, left-1);
        quickSort3(array,left+1,high);
    }

    public static void queryChildIndex(String source, String child,int oldRes){
        char[] sourceArr = source.toCharArray();
        char[] childArr = child.toCharArray();
        int res = -1;
        for(int j=0; j< sourceArr.length; j++){
            if(childArr[0] == sourceArr[j]){
                res = j;
                break;
            } else{
                continue;
            }
        }
        if(res != -1){
            boolean flag = true;
            if(res+childArr.length <= sourceArr.length){
                for(int z=res; z<res+childArr.length; z++){
                    if(sourceArr[z] == childArr[z-res]){
                    }else {
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    System.out.println("res=" + (res + oldRes) );
                }else {
                    queryChildIndex(source.substring(res+1), child, res);
                }
            }else {
                System.out.println("res=" + -1 );
            }
        }else {
            System.out.println("res=" + res );
        }
    }

}
