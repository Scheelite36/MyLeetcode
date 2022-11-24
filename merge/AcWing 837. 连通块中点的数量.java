package merge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
给定一个包含 n 个点（编号为 1∼n）的无向图，初始时图中没有边。

现在要进行 m 个操作，操作共有三种：

C a b，在点 a 和点 b 之间连一条边，a 和 b 可能相等；
Q1 a b，询问点 a 和点 b 是否在同一个连通块中，a 和 b 可能相等；
Q2 a，询问点 a 所在连通块中点的数量；
输入格式
第一行输入整数 n 和 m。

接下来 m 行，每行包含一个操作指令，指令为 C a b，Q1 a b 或 Q2 a 中的一种。

输出格式
对于每个询问指令 Q1 a b，如果 a 和 b 在同一个连通块中，则输出 Yes，否则输出 No。

对于每个询问指令 Q2 a，输出一个整数表示点 a 所在连通块中点的数量

每个结果占一行。

数据范围
1≤n,m≤10^5

样例
输入样例：
5 5
C 1 2
Q1 1 2
Q2 1
C 2 5
Q2 5
输出样例：
Yes
2
3

作者：是一个一个一个CE自动机啊啊啊啊啊啊啊啊啊啊啊啊啊
链接：https://www.acwing.com/file_system/file/content/whole/index/content/6584028/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class AcWing837 {
    static final int N = 100000;
    static int[] p = new int[N];
    static int[] size = new int[N];
    static{
        for (int i = 0; i < N; i++) {
            p[i] = i;
            size[i] = 1;
        }
    }
    static int find(int a){
        if (p[a] != a) p[a] = find(p[a]);
        return p[a];
    }

    static void merge(int a, int b){
        int aa = find(a);
        int bb = find(b);
        if (aa == bb) return;
        p[aa] = bb;
        size[bb] += size[aa];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.valueOf(br.readLine().split(" ")[1]);
        while(m-- >0){
            String line = br.readLine();
            int a = Integer.valueOf(line.split(" ")[1]);
            if (line.startsWith("C")) {
                int b = Integer.valueOf(line.split(" ")[2]);
                // merge
                merge(a, b);
            }else if(line.startsWith("Q1")) {
                int b = Integer.valueOf(line.split(" ")[2]);
                if (find(a) == find(b)) System.out.println("Yes");
                else System.out.println("No");
            }else {
                System.out.println(size[find(a)]);
            }
        }   
    }
}
