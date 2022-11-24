package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。\
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution42 {
    // 保存上一个最高的值。左右来回算的方法，自己想的，有点无章法，但是快
    int tt;
    int res;
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        forward(0, n-1, height);
        return res;
    }
    
    private void forward(int s, int e, int[] height) {
        // 往前一直找，找到比s位置高的就保存计算到的面积
        if(e-s<=1) return;
        tt = s;
        int temp = 0;
        for (int i = s+1; i<=e; i++){
            if (height[i] >= height[tt]) {
                // 计算面积
                res += temp;
                temp = 0;
                //存储新的高点
                tt= i;
            }else {
                temp += height[tt]-height[i];
            }
        }
        backward(tt, e, height);
    }

    private void backward(int s, int e, int[] height){
        if (e-s<=1) return;
        tt = e;
        int temp = 0;
        for (int i = e-1; i >= s; i--) {
            if (height[i] >= height[tt]) {
                // 计算面积
                res += temp;
                temp = 0;
                tt = i;
            }else {
                temp += height[tt]-height[i];
            }
        }
        forward(s, tt, height);
    }
}

class Solution42_1 {
    //单调栈 让栈内保存递减的高度的下标
    public int trap(int[] height) {
        int tt = 0;
        int[] stk = new int[20010];
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            // 碰到当前的比栈顶对应的值高的情况，就可能开始计算
            while (tt > 0 && height[i] > height[stk[tt]]) {
                int top = stk[tt];
                tt--;
                if (tt == 0) break;
                // 计算面积
                int h = Math.min(height[i], height[stk[tt]]) - height[top];
                res += (i-stk[tt]-1) * h;
            }
            stk[++tt] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution42_1 s = new Solution42_1();
        System.out.println(s.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}

class Solution42_2{
    public int trap(int[] height){
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int h = Math.min(height[i],height[stack.peek()])- height[top];
                res += (i-stack.peek()-1) * h;
            }
            stack.push(i);
        }
        return res;
    }
}
