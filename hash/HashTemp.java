package hash;

import java.util.Arrays;

class HashTemp1 {
    // 与链表的存储方式一致
    int[] e;
    int[] ne;
    // 存储对应e中的位置
    int[] hash;
    int idx;
    // 哈希表的范围 一般取大于插入操作的最小的质数
    int N = 100003;
    //拉链法
    //Arrays.fill(hash, -1);
    void insert(int x){
        int i = (x % N + N) % N;
        e[idx] = x;
        // 链表往尾部插入
        ne[idx] = hash[i];
        hash[i] = idx++;
    }

    int find(int x){
        int i = (x % N +N) %N;
        for (int j = hash[i]; j != -1; j = ne[j]) {
            if (e[j] == x) {
                return i;
            }
        }
        return -1;
    }
}

// 开放寻址法
class HashTemp2 {
    // 初始化存的就是特别大的树 不可能出现的题目中的数字 假设为0xfff
    int[] hash;
    // 2-3倍操作数中的小的质数
    int N = 200003;
    // find方法找到就直接存
    int find (int x){
        Arrays.fill(hash, 0xfff);
        // %N+N是为了使得负的余数变正的
        int i = (x % N + N) % N;
        while(hash[i] != 0xfff && hash[i] != x) {
            i++;
            // 溢出
            if (i == N) i = 0;
        }
        return i;
    }
}
