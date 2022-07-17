package search;

import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayList;
import java.util.List;
/**
1、给出n个同学的身高，在不改变所有人的相对位置的情况下从中剔除几位，使得剩下的k*位同学的身高排序是形如：T1<T2<......<Ti-1Ti+1>......>TK 。

2、不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等

3、求最少的出队人数

借助求解最长递增子序列的优化思想，借助二分查找来求解。
用一个count数组记录以i为终点的从左向右和从右向左的子序列元素个数。

*/
class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }
        int[] numL = new int[n]; // 保存左边最长子序 （动态变化）
        int[] numR = new int[n]; // 保存右边最长子序
        numL[0] = nums[0];
        numR[0] = nums[n-1];
        int[] count = new int[n]; // 保存每个点左右最长字序内数字数量之和
        int index =1;
        // 从左边开始查找 保存最长字序 并记录该位置最长字序中数字数量
        for(int i=1;i<n;i++){
            if (nums[i]>numL[index-1]){
                count[i] = index;
                numL[index++] = nums[i];
            }else{
                // 二分查找第一个比nums[i]大的数 之后替换
                int left = getFirstBiggerOne(numL, nums[i], index-1);
                numL[left] = nums[i];
                count[i] = left;
            }
        }
        index = 1;
        for(int i=n-2;i>-1;i--){
            if(nums[i]>numR[index-1]){
                count[i] += index;
                numR[index++] = nums[i];
            }else{
                int left = getFirstBiggerOne(numR, nums[i], index-1);
                numR[left] = nums[i];
                count[i] += left;
            }
        }
        int max = 1;
        for (int c: count){
            max = Math.max(max, c);
        }
        System.out.println(n-max-1); //-1减去本身
    }
    /**
    * arr 目标arr n目标值 i arr右边界
    二分查找找到第一个最大的数
    */
    public static int getFirstBiggerOne(int[] arr, int n, int i){
        int mid=0,left=0,right=i;
        while(left<right){
            mid = (left+right)/2;
            if(arr[mid]>=n){ 
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
