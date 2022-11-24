package hash;

public class StringHashTemp {
    public static void main(String[] args) {
            // 经验数字避免碰撞 N也可以是字符串长度
    final int P = 131, N = 100010;
    // 对应这P的幂
    // 把字符串看作是P进制的数字
    long[] p = new long[N];
    // 表示到索引位置的字符串的hash值
    long[] h = new long[N];
    String s = "dsfasfdf";
    
    // 构造数组
    p[0] = 1;
    for(int i=1; i <= s.length(); i++){
        p[i] = p[i-1]*P;
        h[i] = h[i-1]*P + s.charAt(i-1);
    }

    }
    
    // 计算第l个字符到第r个字符的hash
    long getHash(long[] p, long[] h, int l, int r){
        return h[r] - h[l-1]*p[r-l+1];
    }
}