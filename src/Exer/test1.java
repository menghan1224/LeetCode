package Exer;

/**
 * Created by menghan on 2017/10/1.
 */
public class test1 {
    public static void main(String[] args) {
        System.out.println(solution("acba"));
    }
    private static String solution(String line) {
      char[] res= line.toCharArray();
      int countA=0,countB=0,countC=0;
      for(char c:res){
          if(c=='a') countA++;
          else if(c=='b') countB++;
          else if(c=='c') countC++;
       }
       int index = 0;
        while(countA-->0) res[index++]='a';
        while(countB-->0) res[index++]='b';
        while(countC-->0) res[index++]='c';
        return new String(res);
    }

}
