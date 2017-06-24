package Hard.Array;

/**
 * Created by menghan on 2017/6/24.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int maxleft=0;
        int maxright=0;
        int res=0;
        int a=0,b=height.length-1;
        while(a<=b){
            maxleft=Math.max(maxleft,height[a]);
            maxright=Math.max(maxright,height[b]);
            if(maxleft<maxright){
                res+=maxleft-height[a];
                a++;
            }
            else{
                res+=maxright-height[b];
                b--;
            }
        }
        return res;
    }
}
