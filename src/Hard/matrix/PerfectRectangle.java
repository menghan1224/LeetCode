package Hard.matrix;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by menghan on 2017/6/28.
 */
public class PerfectRectangle {
    Map<String,Integer> map=new HashMap<>();
    public boolean isRectangleCover(int[][] rectangles) {
        int lx=Integer.MAX_VALUE,ly=Integer.MAX_VALUE,rx=Integer.MIN_VALUE,ry=Integer.MIN_VALUE;
        int sum=0;
        for(int[] rectangle:rectangles){
            lx=Math.min(lx,rectangle[0]);
            ly=Math.min(ly,rectangle[1]);
            rx=Math.max(rx,rectangle[2]);
            ry=Math.max(ry,rectangle[3]);
            if(!isValid(rectangle[0]+" "+rectangle[3],1)) return false;
            if(!isValid(rectangle[0]+" "+rectangle[1],2)) return false;
            if(!isValid(rectangle[2]+" "+rectangle[1],4)) return false;
            if(!isValid(rectangle[2]+" "+rectangle[3],8)) return false;
            sum+=(rectangle[2]-rectangle[0])*(rectangle[3]-rectangle[1]);
        }
        int cnt=0;
        for(Integer i:map.values()){
            if(i==1||i==4||i==8||i==2) cnt++;
        }
        int area=(rx-lx)*(ry-ly);
        return cnt==4&&area==sum;
    }
    public boolean isValid(String str,int num){
        Integer i=map.get(str);
        if(i==null) i=0;
        if((i&num)!=0) return false;
        i|=num;
        map.put(str,i);
        return true;
    }
}
