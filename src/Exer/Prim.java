package Exer;

/**
 * Created by menghan on 2017/10/17.
 */
public class Prim {

    public static void main(String[] args) {
        System.out.println(Prim.solution("9;1,2,434;1,3,491;1,4,184;1,5,233;1,6,306;1,7,286;1,8,284;1,9,384;2,3,121;2,4,103;2,5,65;2,6,356;2,7,324;2,8,213;2,9,317;3,4,255;3,5,210;3,6,456;3,7,323;3,8,362;3,9,260;4,5,198;4,6,352;4,7,63;4,8,417;4,9,250;5,6,253;5,7,339;5,8,458;5,9,306;6,7,486;6,8,392;6,9,296;7,8,169;7,9,125;8,9,102"));
    }
    private static String solution(String line) {
        // 在此处理单行数据
        String[] strs = line.split(";");
        int k = Integer.parseInt(strs[0]);
        int[][] graph = new int[k][k];
        for(int i=1;i<strs.length;i++){
            String[] tmp = strs[i].split(",");
            int from = Integer.parseInt(tmp[0]);
            int to = Integer.parseInt(tmp[1]);
            int val = Integer.parseInt(tmp[2]);
            graph[from-1][to-1] = val;
            graph[to-1][from-1] =val;
        }

        for(int i = 0;i<graph.length;i++){
            graph[i][i]=-1;
        }
        // 返回处理后的结果
        int dis = PRIM(graph,0,9);
        return dis+"";
    }
    public static int PRIM(int [][] graph,int start,int n){
        int [][] mins=new int [n][2];//用于保存集合U到V-U之间的最小边和它的值，mins[i][0]值表示到该节点i边的起始节点
        //值为-1表示没有到它的起始点，mins[i][1]值表示到该边的最小值，
        //mins[i][1]=0表示该节点已将在集合U中
        for(int i=0;i<n;i++){//初始化mins

            if(i==start){
                mins[i][0]=-1;
                mins[i][1]=0;
            }else if( graph[start][i]!=-1){//说明存在（start，i）的边
                mins[i][0]=start;
                mins[i][1]= graph[start][i];
            }else{
                mins[i][0]=-1;
                mins[i][1]=Integer.MAX_VALUE;
            }
//          System.out.println("mins["+i+"][0]="+mins[i][0]+"||mins["+i+"][1]="+mins[i][1]);
        }
        int dis = 0;
        for(int i=0;i<n-1;i++){
            int minV=-1,minW=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){//找到mins中最小值，使用O(n^2)时间

                if(mins[j][1]!=0&&minW>mins[j][1]){
                    minW=mins[j][1];
                    minV=j;
                }
            }
            System.out.println("minV="+minV);
            mins[minV][1]=0;
            dis+=minW;
            System.out.println("最小生成树的第"+i+"条最小边=<"+(mins[minV][0]+1)+","+(minV+1)+">，权重="+minW);
            for(int j=0;j<n;j++){//更新mins数组
                if(mins[j][1]!=0){
                    if( graph[minV][j]!=-1&& graph[minV][j]<mins[j][1]){
                        mins[j][0]=minV;
                        mins[j][1]= graph[minV][j];
                    }
                }
            }
        }
        return dis;
    }
}

