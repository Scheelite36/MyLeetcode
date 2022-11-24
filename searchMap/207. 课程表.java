package searchMap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi]
 * ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 * 
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 *  
 * 
 * 提示：
 * 
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution207 {
    final int N = 5010;
    int[] h = new int[N], ne = new int[N], e= new int[N], d =new int[N];
    int idx= 0;
    boolean[] isVisited = new boolean[N];
    List<Integer> list = new ArrayList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Arrays.fill(h, -1);
        for (int[] pr : prerequisites) {
            add(pr[0], pr[1]);
            d[pr[1]]++;
        }
        return bfs(numCourses);
    }

    boolean bfs(int n){
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (d[i] == 0){
                q.offer(i);
            }
        }
        if (q.isEmpty()) return false;

        while(!q.isEmpty()){
            int t = q.poll();
            list.add(t);
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if(--d[j]==0) q.offer(j);
            }
        }
        return list.size() == n;
    }

    void add(int a, int b){
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static void main(String[] args) {
        Solution207 s = new Solution207();
        s.canFinish(2, new int[][]{{1,0}});
    }
}
