package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 题目描述
维护一个集合，支持如下几种操作：

I x，插入一个数 x；
Q x，询问数 x 是否在集合中出现过；
现在要进行 N 次操作，对于每个询问操作输出对应的结果。

输入格式
第一行包含整数 N，表示操作数量。

接下来 N 行，每行包含一个操作指令，操作指令为 I x，Q x 中的一种。

输出格式
对于每个询问指令 Q x，输出一个询问结果，如果 x 在集合中出现过，则输出 Yes，否则输出 No。

每个结果占一行。

数据范围
1≤N≤10^5
−10^9≤x≤10^9

输入样例
5
I 1
I 2
I 3
Q 2
Q 5
输出样例
Yes
No
 */
class AcWing840 {
    static final int N = 100003;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int idx = 0;
    static int[] hash = new int[N];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        Arrays.fill(hash, -1);
        while(n-->0){
            String[] w = br.readLine().split(" ");
            int x = Integer.valueOf(w[1]);
            if (w[0].equals("I")) insert(x);
            else System.out.println(find(x)==-1?"No":"Yes");
        }
    }

    // 拉链法
    static void insert(int x){
        int i = (x % N + N ) % N;
        e[idx] = x;
        ne[idx] = hash[i];
        hash[i] = idx++;
    }

    static int find(int x) {
        int i = (x % N + N) % N;
        for (int j = hash[i]; j != -1; j = ne[j]) {
            if (e[j] == x) return i;
        }
        return -1;
    }

}

// 开放寻址法
class AcWing840_1 {
    static final int N = 200003;
    static int[] hash = new int[N];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        Arrays.fill(hash, Integer.MAX_VALUE);
        while(n-->0){
            String[] w = br.readLine().split(" ");
            int x = Integer.valueOf(w[1]);
            if (w[0].equals("I")) hash[find(x)] = x;
            else System.out.println(hash[find(x)]==Integer.MAX_VALUE?"No":"Yes");
        }
    }

    static int find(int x) {
        int i = (x % N + N) % N;
        while(hash[i]!= Integer.MAX_VALUE && hash[i]!= x){
            i++;
            if (i == N) i = 0;
        }
        return i;
    }

}