package linkedList;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.text.StyledEditorKit;

/**
 * 题目描述
 * 实现一个单链表，链表初始为空，支持三种操作：
 * 
 * 1.向链表头插入一个数；
 * 2.删除第 k 个插入的数后面的数；
 * 3.在第 k 个插入的数后插入一个数。
 * 现在要对该链表进行 M 次操作，进行完所有操作后，从头到尾输出整个链表。
 * 
 * 注意:题目中第 k 个插入的数并不是指当前链表的第 k 个数。例如操作过程中一共插入了 n 个数，则按照插入的时间顺序，这 n 个数依次为：第 1
 * 个插入的数，第 2 个插入的数，…第 n 个插入的数。
 * 
 * 输入格式
 * 第一行包含整数 M，表示操作次数。
 * 
 * 接下来 M 行，每行包含一个操作命令，操作命令可能为以下几种：
 * 
 * 1.H x，表示向链表头插入一个数 x。
 * 2.D k，表示删除第 k 个插入的数后面的数（当 k 为 0 时，表示删除头结点）。
 * 3.I k x，表示在第 k 个插入的数后面插入一个数 x（此操作中 k 均大于 0）。
 * 输出格式
 * 共一行，将整个链表从头到尾输出。
 * 
 * 样例
 * 输入样例：
 * 
 * 10
 * H 9
 * I 1 1
 * D 1
 * D 0
 * H 6
 * I 3 6
 * I 4 5
 * I 4 5
 * I 3 4
 * D 6
 * 输出样例：
 * 
 * 6 4 6 5
 * 
 * 作者：Jiahaowen
 * 链接：https://www.acwing.com/solution/content/136864/
 * 来源：AcWing
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class AcWing826 {
    int[] e = new int[10000];
    int[] ne = new int[10000];
    int head = -1;
    int idx;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int op = Integer.valueOf(br.readLine());
        AcWing826 a = new AcWing826();
        while(op-- > 0){
            String[] line = br.readLine().split(" ");
            if (line[0].equals("H")){
                a.addToHead(Integer.valueOf(line[1]));
            }else if (line[0].equals("I")){
                a.add(Integer.valueOf(line[1])-1, Integer.valueOf(line[2]));
            }else if (line[0].equals("D")){
                if (line[1].equals("0")){
                    a.head = a.ne[a.head];
                }else{
                    a.remove(Integer.valueOf(line[1]) - 1);
                }
                
            }
        }
        for (int i = a.head; i != -1; i = a.ne[i]) {
            System.out.print(a.e[i]+" ");
        }
    }

    void addToHead(int x){
        e[idx] = x;
        ne[idx] = head;
        head = idx;
        idx++;
    }

    void add(int k, int x){
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx;
        idx++;
    }

    void remove(int k){
        ne[k] = ne[ne[k]];
    }
}
