package prefixSum;
/**
 * 差分 前缀和逆运算
 * A数组 a1 。。。 an
 * B 数组 b1 。。。 bn
 * A是B数组的前缀和 B是A的差分
 * 
 */
public class differenceTemp {
    // 给A区间[l, r]中的每个数加上c：B[l] += c, B[r + 1] -= c

    // 二维差分
    // 给以(x1, y1)为左上角，(x2, y2)为右下角的子矩阵中的所有元素加上c：
    // 差分数组的处理
    // S[x1,y1] += c;
    // S[x2+1,y1] -= c;
    // S[x1,y2+1] -= c;
    // S[x2+1,y2+1] += c;
}
