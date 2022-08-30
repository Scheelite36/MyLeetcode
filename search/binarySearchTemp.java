package search;

public class binarySearchTemp {
    // 当[l,r]被划分为[l,mid] [mid+1,r]时候
    public int binarySearch1(int l, int r) {
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid))
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    // 当[l,r]被划分为[l,mid-1] [mid,r]时候
    public int binarySearch2(int l, int r) {
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid))
                l = mid;
            else
                r = mid - 1;
        }
        return l;
    }

    public boolean check(int mid) {
        // 用于判断是否满足条件的语句
        return true;
    }
}
