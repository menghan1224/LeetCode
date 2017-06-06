package Medium.BinaryTree;

import java.util.Stack;

/**
 * Created by 28479 on 2017/6/6.
 */
public class UniqueBinarySearchTree {
    public static void main(String[] args){
        String a="abc";
        Stack<String> s1=new Stack<String>();
        s1.push(a);
        a="";
        System.out.print(s1.pop());
    }
    public int numTrees(int n) {
        int res[]=new int[n+1];
        res[1]=1;
        res[0]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                res[i]+=res[j]*res[i-j-1];
            }
        }
        return  res[n];
    }
}
