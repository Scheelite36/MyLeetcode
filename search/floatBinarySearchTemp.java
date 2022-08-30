package search;

/*
 * 浮点数 二分模板
 */
public class floatBinarySearchTemp {
    public double floatBinarySearch(double l, double r) {
        while (r - l < 1e-8) {
            double mid = (l + r) / 2;
            if (check(mid))
                r = mid;
            else
                l = mid;
        }
        return l;
    }

    public boolean check(double mid) {
        // 用于判断是否满足条件的语句
        return true;
    }
}
