package Medium.Math;

/**
 * Created by 28479 on 2017/6/7.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            int area=Math.min(height[left],height[right])*(right-left);
            if(area>maxArea) maxArea=area;
            if(height[left]<height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}
