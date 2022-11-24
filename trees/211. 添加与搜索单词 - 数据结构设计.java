package trees;

import java.util.Arrays;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。

实现词典类 WordDictionary ：

WordDictionary() 初始化词典对象
void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 

示例：

输入：
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
输出：
[null,null,null,null,false,true,true,true]

解释：
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // 返回 False
wordDictionary.search("bad"); // 返回 True
wordDictionary.search(".ad"); // 返回 True
wordDictionary.search("b.."); // 返回 True
 

提示：

1 <= word.length <= 25
addWord 中的 word 由小写英文字母组成
search 中的 word 由 '.' 或小写英文字母组成
最多调用 104 次 addWord 和 search

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/design-add-and-search-words-data-structure
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class WordDictionary {
    static int[][] trie = new int[250000][26];
    static int idx = 0;
    static boolean[] isWord = new boolean[250000];
    public WordDictionary() {
        for (int i = 0; i < trie.length; i++) {
            Arrays.fill(trie[i], 0);
        }
        Arrays.fill(isWord, false);
        idx = 0;
    }
    
    public void addWord(String word) {
        int p = 0;
        for (int i = 0; i < word.length(); i++) {
            int a = word.charAt(i) - 'a';
            if (trie[p][a] == 0) trie[p][a] = ++idx;
            p = trie[p][a];
        }
        isWord[p] = true;
    }
    
    public boolean search(String word) {
        return dfs(0, 0, word);
    }
    
    
    public boolean dfs(int p, int index, String word){
        int n = word.length();
        if (index == n) return isWord[p];
        char c = word.charAt(index);
        if (c == '.'){
            for (int i = 0; i < 26; i++) {
                if (trie[p][i] !=0 && dfs(trie[p][i], index+1, word)) return true;
            }
            return false;
        }else {
            int i = c - 'a';
            if (trie[p][i] == 0) return false;
            return dfs(trie[p][i], index+1, word);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */