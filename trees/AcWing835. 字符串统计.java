package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 维护一个字符串集合，支持两种操作：
 * 
 * 1.I x 向集合中插入一个字符串 x；
 * 2.Q x 询问一个字符串在集合中出现了多少次。
 * 共有 N 个操作，输入的字符串总长度不超过 105，字符串仅包含小写英文字母。
 * 
 * 输入格式
 * 第一行包含整数 N，表示操作数。
 * 
 * 接下来 N 行，每行包含一个操作指令，指令为 I x 或 Q x 中的一种。
 * 
 * 输出格式
 * 对于每个询问指令 Q x，都要输出一个整数作为结果，表示 x 在集合中出现的次数。
 * 
 * 每个结果占一行。
 * 
 * 数据范围
 * 1≤N≤2∗104
 * 
 * 样例
 * 输入样例：
5
I abc
Q abc
Q ab
I ab
Q ab
 * 输出样例：
 * 1
 * 0
 * 1
 * 
 */
class AcWing835 {
    /**
     * 通过trie树来实现。根据字符串出现的每个字符构建树进行存储。
     */
    // int[m][n] m代表的trie树节点 n存储26个字母个数
    public static int[][] trie =  new int[10000][26];
    // 字符串最后一位 对应的trie节点 出现的个数
    public static int[] cnt = new int[10000];
    // 当前使用到的索引
    public static int idx = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        while ( m-- > 0){
            String[] lines = br.readLine().split(" ");
            if (lines[0].equals("I")) {
                insert(lines[1]);
            }else {
                System.out.print("\n" + query(lines[1]));
            } 
        }
    }

    public static void insert(String s){
        char[] chars = s.toCharArray();
        int p = 0;
        for (int i = 0; i < chars.length; i++) {
            int a = chars[i] - 'a';
            if (trie[p][a] == 0) trie[p][a] = ++ idx;
            p = trie[p][a];
        }
        cnt[p]++;
    }

    public static int query(String s){
        char[] chars = s.toCharArray();
        int p = 0;
        for (int i = 0; i < chars.length; i++) {
            int a = chars[i] - 'a';
            if (trie[p][a] == 0) return 0;
            p = trie[p][a];
        }
        return cnt[p];
    }
}