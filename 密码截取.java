import java.util.Scanner;

/**
 * 描述
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化
 * ABBA->12ABBA,ABA->ABAKK,123321->51233214
 * 。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 * 
 * 数据范围：字符串长度满足 1 \le n \le 2500 \1≤n≤2500
 * 输入描述：
 * 输入一个字符串（字符串的长度不超过2500）
 * 
 * 输出描述：
 * 返回有效密码串的最大长度
 * 
 * 示例1输入：ABBA输出：4
 * 
 * 示例2输入：ABBBA输出：5
 * 
 * 中心扩散方法：
 * 遍历每个数 判断是否为回文
 * ABA + ABBA
 */

class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int len1 = getSymLength(s, i, i);
            int len2 = getSymLength(s, i, i+1);
            max = Math.max(max, len1>len2?len1:len2);
        }
        System.out.println(max);
    }

    /**
     *返回回文总长度
     */
    public static int getSymLength(String s, int l, int r){
        while(l>=0 && r < s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
}
