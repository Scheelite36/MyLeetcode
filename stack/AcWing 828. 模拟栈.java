package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个栈，栈初始为空，支持四种操作：

1.push x – 向栈顶插入一个数 x；
2.pop – 从栈顶弹出一个数；
3.empty – 判断栈是否为空；
4.query – 查询栈顶元素。
现在要对栈进行 M 个操作，其中的每个操作 3 和操作 4 都要输出相应的结果。

输入格式
第一行包含整数 M，表示操作次数。

接下来 M 行，每行包含一个操作命令，操作命令为 push x，pop，empty，query 中的一种。

输出格式
对于每个 empty 和 query 操作都要输出一个查询结果，每个结果占一行。

其中，empty 操作的查询结果为 YES 或 NO，query 操作的查询结果为一个整数，表示栈顶元素的值。

数据范围
1≤M≤100000,
1≤x≤109
所有操作保证合法。

样例
输入样例：

10
push 5
query
push 6
pop
query
pop
empty
push 4
query
empty
输出样例：

5
5
YES
4
NO

作者：Jiahaowen
链接：https://www.acwing.com/solution/content/136915/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class AcWing828 {
    static int[] stk = new int[10000];
    static int idx;
    static void push(int x){
        stk[idx++] = x;
    }
    static int pop(){
        return stk[--idx];
    }
    static boolean isEmpty(){
        return idx == 0;
    }
    static int query(){
        return stk[idx-1];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.valueOf(br.readLine());
        List<String> sout = new ArrayList<>();
        while (m-- > 0){
            String[] strs = br.readLine().split(" ");
            if (strs[0].equals("query")){
                sout.add(query()+"");
            }else if (strs[0].equals("empty")){
                String ans = isEmpty() ? "YES" : "NO";
                sout.add(ans);
            }else if (strs[0].equals("push")){
                push(Integer.valueOf(strs[1]));
            }else if (strs[0].equals("pop")){
                pop();
            }
        }
        for (String string : sout) {
            System.out.println(string);
        }
    }
}
