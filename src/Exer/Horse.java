package Exer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by menghan on 2017/10/17.
 */

public class Horse {
    public static void main(String[] args) {
        System.out.println(solution("1;2;0;0;1;2"));
    }
    static class Point{
        public int x;
        public int y;
        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    private static int n;
    private static int m;
    private static String solution(String line) {
        // 在此处理单行数据
        String[] strs = line.split(";");
        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        int initX = Integer.parseInt(strs[2]);
        int initY = Integer.parseInt(strs[3]);
        int tarX =Integer.parseInt(strs[4]);
        int tarY = Integer.parseInt(strs[5]);
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(initX,initY));
        boolean found = false;
        boolean[][] cache = new boolean[n+1][m+1];
        int parSize = 1;
        int childSize = 0;
        int depth=0;
        while(!found&&queue.size()>0){
            Point point = queue.poll();
            parSize--;
            int x = point.x;
            int y = point.y;
            if(x<0||x>n||y<0||y>m||cache[x][y]) {
                if(parSize==0){
                    depth++;
                    parSize=childSize;
                    childSize=0;
                }
                continue;
            }
            if(x==tarX&&y==tarY){
                found=true;
                break;
            }
            cache[x][y]=true;
            queue.add(new Point(x-2,y+1));
            queue.add(new Point(x-2,y-1));
            queue.add(new Point(x-1,y+2));
            queue.add(new Point(x-1,y-2));
            queue.add(new Point(x+1,y+2));
            queue.add(new Point(x+1,y-2));
            queue.add(new Point(x+2,y+1));
            queue.add(new Point(x+2,y-1));
            childSize+=8;
            if(parSize==0){
                depth++;
                parSize=childSize;
                childSize=0;
            }
        }
        return found==true?depth+"":"-1";

    }
//    public static void dfs(int x,int y,int ax,int ay,int steps){
//        if(steps>count) return;
//        if(x<0||y<0||x>n||y>m||cache[x][y]) return;
//        cache[x][y]=true;
//        if(x==ax&&y==ay&&steps<count) count=steps;
//        dfs(x+1,y+2,ax,ay,steps+1);
//        dfs(x-1,y+2,ax,ay,steps+1);
//        dfs(x+2,y+1,ax,ay,steps+1);
//        dfs(x-2,y+1,ax,ay,steps+1);
//        dfs(x+2,y-1,ax,ay,steps+1);
//        dfs(x-2,y-1,ax,ay,steps+1);
//        dfs(x+1,y-2,ax,ay,steps+1);
//        dfs(x-1,y-2,ax,ay,steps+1);
//        cache[x][y]=false;
//
//    }
}
