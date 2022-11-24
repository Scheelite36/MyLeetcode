package merge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 题目描述
一共有 n 个数，编号是 1∼n，最开始每个数各自在一个集合中。

现在要进行 m 个操作，操作共有两种：

1.M a b，将编号为 a 和 b 的两个数所在的集合合并，如果两个数已经在同一个集合中，则忽略这个操作；
2.Q a b，询问编号为 a 和 b 的两个数是否在同一个集合中；
输入格式
第一行输入整数 n 和 m。

接下来 m 行，每行包含一个操作指令，指令为 M a b 或 Q a b 中的一种。

输出格式
对于每个询问指令 Q a b，都要输出一个结果，如果 a 和 b 在同一集合内，则输出 Yes，否则输出 No。

每个结果占一行。

数据范围
1≤n,m≤10^5

输入样例
4 5
M 1 2
M 3 4
Q 1 2
Q 1 3
Q 3 4
输出样例
Yes
No
Yes


作者：芒叉味阿米
链接：https://www.acwing.com/file_system/file/content/whole/index/content/6913995/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class AcWing836 {
    static final int N = 10000;
    static int[] p = new int[N];

    static {
        for (int i = 0; i < N; i++) {
           p[i] = i; 
        }
    }

    /**
     * 求根节点+短路优化
     * @param a
     * @return
     */
    static int find(int a){
        if (p[a] != a) p[a] = find(p[a]);
        return p[a];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.valueOf(br.readLine().split(" ")[1]);
        while (m -- > 0){
            String line = br.readLine();
            int a = Integer.valueOf(line.split(" ")[1]);
            int b = Integer.valueOf(line.split(" ")[2]);
            if (line.startsWith("Q")) {
                if (find(a) == find(b)) System.out.println("Yes");
                else System.out.println("No");
            }else {
                // merge
                p[find(a)] = find(b);
            }
        }
    }
}
