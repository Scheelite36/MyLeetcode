package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个队列，队列初始为空，支持四种操作：

(1) “push x” – 向队尾插入一个数x；

(2) “pop” – 从队头弹出一个数；

(3) “empty” – 判断队列是否为空；

(4) “query” – 查询队头元素。

现在要对队列进行M个操作，其中的每个操作3和操作4都要输出相应的结果。

输入格式
第一行包含整数M，表示操作次数。

接下来M行，每行包含一个操作命令，操作命令为”push x”，”pop”，”empty”，”query”中的一种。

输出格式
对于每个”empty”和”query”操作都要输出一个查询结果，每个结果占一行。

其中，”empty”操作的查询结果为“YES”或“NO”，”query”操作的查询结果为一个整数，表示队头元素的值。

数据范围
1≤M≤100000,
1≤x≤109,
所有操作保证合法。

样例
输入样例：
10
push 6
empty
query
pop
empty
push 3
push 4
pop
query
push 6
输出样例：
NO
6
YES
4

作者：薛定谔的狗
链接：https://www.acwing.com/solution/content/38298/
来源：AcWing
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class AcWing829 {
    static int[] q = new int[10000];
    static int idx;
    static int head;
    static void push(int x){
        q[idx++] = x;
    }
    static int pop(){
        return q[head++];
    }
    static boolean isEmpty(){
        return head == idx;
    }
    static int query(){
        return q[head];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.valueOf(br.readLine());
        List<String> ans = new ArrayList<>();
        while(m -- > 0){
            String[] strs = br.readLine().split(" ");
            if (strs[0].equals("push")) {
                push(Integer.valueOf(strs[1]));
            }else if (strs[0].equals("pop")){
                pop();
            }else if (strs[0].equals("empty")) {
                ans.add(isEmpty()?"YES":"NO");
            }else if (strs[0].equals("query")) {
                ans.add(query()+"");
            }
        }
        for (String string : ans) {
            System.out.println(string);
        }
    }
}
