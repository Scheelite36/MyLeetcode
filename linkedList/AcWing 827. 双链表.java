package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
实现一个双链表，双链表初始为空，支持 5 种操作：

1.在最左侧插入一个数；
2.在最右侧插入一个数；
3.将第 k 个插入的数删除；
4.在第 k 个插入的数左侧插入一个数；
5.在第 k 个插入的数右侧插入一个数
6.现在要对该链表进行 M 次操作，进行完所有操作后，从左到右输出整个链表。

注意:题目中第 k 个插入的数并不是指当前链表的第 k 个数。例如操作过程中一共插入了 n 个数，则按照插入的时间顺序，这 n 个数依次为：第 1 个插入的数，第 2 个插入的数，…第 n 个插入的数。

输入格式
第一行包含整数 M，表示操作次数。

接下来 M 行，每行包含一个操作命令，操作命令可能为以下几种：

1.L x，表示在链表的最左端插入数 x。
2.R x，表示在链表的最右端插入数 x。
3.D k，表示将第 k 个插入的数删除。
4.IL k x，表示在第 k 个插入的数左侧插入一个数。
5.IR k x，表示在第 k 个插入的数右侧插入一个数。
输出格式
共一行，将整个链表从左到右输出。

数据范围
1≤M≤100000
所有操作保证合法。

样例
输入样例：
10
R 7
D 1
L 3
IL 2 10
D 3
IL 2 7
L 8
R 9
IL 4 7
IR 2 2
输出样例：
8 7 7 3 2 9

作者：Jiahaowen
链接：https://www.acwing.com/file_system/file/content/whole/index/content/6593311/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */
class AcWing827 {
    static int[] e = new int[10000];
    static int[] l = new int[10000];
    static int[] r = new int[10000];
    static int idx = 2; // 保留头两个作为头尾，所以从2开始使用
    static {
        r[0] = 1;
        l[1] = 0;
    }

    static void add(int k, int x){
        e[idx] = x;
        l[r[k]] = idx;
        r[idx] = r[k];
        r[k] = idx;
        l[idx] = k;
        idx++;
    }

    static void remove(int k){
        l[r[k]] = l[k];
        r[l[k]] = r[k];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.valueOf(br.readLine());
        while(m-- > 0){
            String[] strs = br.readLine().split(" ");
            if (strs[0].equals("R")){
                add(l[1],Integer.valueOf(strs[1]));
            }else if (strs[0].equals("D")) {
                remove(Integer.valueOf(strs[1])+1);
            }else if (strs[0].equals("L")) {
                add(0, Integer.valueOf(strs[1]));
            }else if (strs[0].equals("IR")) {
                add(Integer.valueOf(strs[1])+1, Integer.valueOf(strs[2]));
            }else if (strs[0].equals("IL")) {
                add(l[Integer.valueOf(strs[1])+1], Integer.valueOf(strs[2]));
            }
        }
        for (int i = r[0]; i != 1; i=r[i]) {
            System.out.print(e[i] + " ");
        }
    }
}
