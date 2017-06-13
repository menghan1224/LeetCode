package Medium.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by menghan on 2017/6/12.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer>[] outNums=new Set[numCourses];
        for(int i=0;i<numCourses;i++)
            outNums[i]=new HashSet<Integer>();
        for(int[] edge:prerequisites){
            outNums[edge[1]].add(edge[0]);
        }
        int[] insize=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            Set<Integer> set=outNums[i];
            for(int num:set){
                insize[num]++;
            }
        }
        for(int i=0;i<numCourses;i++){
            int j=0;
            for(;j<numCourses;j++){
                if(insize[j]==0) break;
            }
            if(j==numCourses) return false;
            insize[j]=-1;
            for(int num:outNums[j]){
                insize[num]--;
            }
        }
        return true;
    }
}
