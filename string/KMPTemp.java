package string;

public class KMPTemp {
    char[] s;
    char[] p;
    int n = s.length;
    int m = p.length;
    int[] next;

    // s[]是长文本，p[]是模式串，n是s的长度，m是p的长度
    // 求模式串的Next数组：
    void getNext() {
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && p[i] != p[j + 1])
                j = next[j];
            if (p[i] == p[j + 1])
                j++;
            next[i] = j;
        }
    }

    void pattern() {
        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && s[i] != p[j + 1])
                j = next[j];
            if (s[i] == p[j + 1])
                j++;
            if (j == m) {
                j = next[j]; // 跳到next数组 为可能的下一次匹配做准备
                // 匹配结束的逻辑
            }
        }
    }
}
