package dp;
import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;
 /**
  * N 位同学站成一排，音乐老师要请最少的同学出列，使得剩下的 K 位同学排成合唱队形。

设K位同学从左到右依次编号为 1，2…，K ，他们的身高分别为 ，若存在 使得 且 ，则称这K名同学排成了合唱队形。
通俗来说，能找到一个同学，他的两边的同学身高都依次严格降低的队形就是合唱队形。
例子：
123 124 125 123 121 是一个合唱队形
123 123 124 122不是合唱队形，因为前两名同学身高相等，不符合要求
123 122 121 122不是合唱队形，因为找不到一个同学，他的两侧同学身高递减。


dp方法：

先找到每一个位置i左侧的最长上升子序列长度numL[i]：每一个位置左侧最长子序列长度等于其左侧比它小的所有位置的最长子序列长度中的最大值+1
再找到每一个位置i右侧的最长下降子序列长度numR[i]：每一个位置右侧最长子序列长度等于其右侧比它小的所有位置的最长子序列长度中的最大值+1
然后求出所有位置的最长序列长度=左侧最长子序列长度+右侧最长子序列长度-1（因为该位置被算了两次，所以减1）
然后用数目减去最长序列长度就是答案

另有二分查找法时间复杂度更佳
  */
class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        Deque<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }
        int[] numL = new int[n];
        int[] numR = new int[n];
        for (int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    numL[i]= Math.max(numL[i],numL[j]);
                }
            }
            numL[i]++;
        }
        for(int i=n-1;i>-1;i--){
            for(int j=n-1;j>i;j--){
                if(nums[i]>nums[j]){
                    numR[i] = Math.max(numR[i],numR[j]);
                }
            }
            numR[i]++;
        }
        int max = numR[0]+numL[0]-1;
        for(int i=0;i<n;i++){
            max = Math.max(numL[i]+numR[i]-1, max);
        }
        System.out.println(n-max);
    }
}