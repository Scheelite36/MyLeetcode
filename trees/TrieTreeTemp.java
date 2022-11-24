package trees;

public class TrieTreeTemp {
        // int[m][n] m代表的trie树节点 n存储26个字母个数
        public int[][] trie =  new int[10000][26];
        // 字符串最后一位 对应的trie节点 出现的个数
        public int[] cnt = new int[10000];
        // 当前使用到的索引
        public int idx = 0;

        /**
         * trie树插入操作   
         * @param s
         */
        public void insert(char[] chars){
            int p = 0;
            // 依次存储每个字符
            for (int i = 0; i < chars.length; i++) {
                int a = chars[i] - 'a';
                if (trie[p][a] == 0) trie[p][a] = ++ idx;
                p = trie[p][a];
            }
            cnt[p]++;
        }
    
        /**
         * trie树查询操作
         * @param s
         * @return
         */
        public int query(char[] chars){
            int p = 0;
            for (int i = 0; i < chars.length; i++) {
                int a = chars[i] - 'a';
                if (trie[p][a] == 0) return 0;
                p = trie[p][a];
            }
            return cnt[p];
        }
}
