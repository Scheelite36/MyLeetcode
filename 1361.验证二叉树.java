import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1361 lang=java
 *
 * [1361] 验证二叉树
 */

// @lc code=start
class Solution {
    // 并查集用的集合列表
    private List<Integer> p = new ArrayList<>();
    // 用于统计不相交的连通分支个数
    private int con;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // 用于标记各个孩子的父节点
        int[] father = new int[n];
        // 初始化
        Arrays.fill(father, -1);
        // 初始化并查集集合状态 (每个都是自己的父节点，然后进行合并 查找关系)
        for (int i = 0; i < n; i++)
            p.add(i);
        // 初始化分支数
        con = n;
        // 遍历所有节点
        for (int i = 0; i < n; i++) {
            // 如果节点存在两个孩子，而且两个孩子相同，那么显然是错误的二叉树
            if (leftChild[i] == rightChild[i] && leftChild[i] != -1)
                return false;
            // 合并两个孩子
            if (!merge(father, i, leftChild[i]) || !merge(father, i, rightChild[i]))
                return false;
        }
        // 如果最后所有的节点组成一个连通分支，才是一棵树
        if (con == 1)
            return true;
        return false;

    }

    // 和并父亲和孩子节点，并判断逻辑
    private boolean merge(int[] father, int f, int c) {
        // 孩子是空的，直接返回
        if (c == -1)
            return true;
        // 孩子之前有爸爸了，就是错的
        if (father[c] != -1)
            return false;
        // 并查集查找两个集合的根
        int a = find(f);
        int b = find(c);
        // 如果孩子和父亲已经存在于一个集合中，那么说明会产生环，返回错误
        if (a == b)
            return false;
        // 合并两个集合
        p.set(a, b);
        // 标记孩子的父亲是谁
        father[c] = f;
        // 连通分支数减一
        con--;
        return true;
    }

    // 并查集通用方法，找集合的根元素
    private int find(int x) {
        if (p.get(x) != x)
            p.set(x, find(p.get(x)));
        return p.get(x);
    }
}
// @lc code=end
