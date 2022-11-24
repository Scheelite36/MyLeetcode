package trees;
/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

请你实现 Trie 类：

Trie() 初始化前缀树对象。
void insert(String word) 向前缀树中插入字符串 word 。
boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 

示例：

输入
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
输出
[null, null, true, false, true, null, true]

解释
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 True
trie.search("app");     // 返回 False
trie.startsWith("app"); // 返回 True
trie.insert("app");
trie.search("app");     // 返回 True

提示：  

1 <= word.length, prefix.length <= 2000
word 和 prefix 仅由小写英文字母组成
insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/implement-trie-prefix-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Trie {
    int[][] trie;
    int[] count;
    int idx;
    public Trie() {
        trie = new int[2000*3*104][26];
        count = new int[2000*3*104];
        idx = 0;
    }
    
    public void insert(String word) {
        int p = 0;
        for (int i = 0; i < word.length(); i++) {
            int a = word.charAt(i) - 'a';
            if (trie[p][a] == 0) trie[p][a] = ++idx;
            p = trie[p][a];
        }
        count[p]++;
    }
    
    public boolean search(String word) {
        int p = 0;
        for (int i = 0; i < word.length(); i++) {
            int a = word.charAt(i) - 'a';
            if (trie[p][a] == 0) return false;
            p = trie[p][a];
        }
        return count[p] != 0;
    }
    
    public boolean startsWith(String prefix) {
        int p = 0;
        for (int i = 0; i < prefix.length(); i++) {
            int a = prefix.charAt(i) - 'a';
            if (trie[p][a] == 0) return false;
            p = trie[p][a];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 True
        trie.search("app");     // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app");     // 返回 True
    }
}