package searchMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 给定一个n个点m条边的有向图，图中可能存在重边和自环，边权可能为负数。

再给定k个询问，每个询问包含两个整数x和y，表示查询从点x到点y的最短距离，如果路径不存在，则输出“impossible”。

数据保证图中不存在负权回路。

输入格式
第一行包含三个整数n，m，k

接下来m行，每行包含三个整数x，y，z，表示点x和点y之间存在一条有向边，边长为z。

接下来k行，每行包含两个整数x，y，表示询问点x到点y的最短距离。

输出格式
共k行，每行输出一个整数，表示询问的结果，若询问两点间不存在路径，则输出“impossible”。

数据范围
1≤n≤2001≤n≤200
1≤k≤n21≤k≤n2
1≤m≤200001≤m≤20000
图中涉及边长绝对值均不超过10000。

输入样例：
3 3 2
1 2 1
2 3 2
1 3 1
2 1
1 3
输出样例：
impossible
1

作者：郡呈
链接：https://www.acwing.com/solution/content/6976/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Acwing854 {
    static final int N = 210;
    static int[][] dist = new int[N][N];
    static int n;
    static int m;
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
             int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            n = init[0];m = init[1]; int k=init[2];
            
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i==j) dist[i][j] = 0;
                    else dist[i][j] = Integer.MAX_VALUE >> 1;
                }
            }
            while(m-- > 0){
                int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
                dist[line[0]][line[1]] = line[2];
            }
            floyd();
            while(k-->0){
                int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
                if (dist[line[0]][line[1]] > Integer.MAX_VALUE >> 2) System.out.println("impossible");
                else System.out.println(dist[line[0]][line[1]]);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    static void floyd(){
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
    }
}
