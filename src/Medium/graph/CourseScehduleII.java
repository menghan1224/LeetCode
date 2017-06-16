package Medium.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by 28479 on 2017/6/16.
 */
public class CourseScehduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set[] outset = new Set[numCourses];
        int[] res = new int[numCourses];
        int index = 0;
        for (int i = 0; i < outset.length; i++)
            outset[i] = new HashSet<>();
        for (int[] edge : prerequisites) {
            outset[edge[1]].add(edge[0]);
        }
        int[] insize = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            Set temp = outset[i];
            Iterator<Integer> iter = temp.iterator();
            while (iter.hasNext()) {
                insize[iter.next()]++;
            }
        }
        for (int i = 0; i < numCourses; i++) {
            int j = 0;
            for (; j < numCourses; j++) {
                if (insize[j] == 0) break;
            }
            if (j == numCourses) return new int[0];
            insize[j] = -1;
            res[index++] = j;
            Set st = outset[j];
            Iterator<Integer> it = st.iterator();
            while (it.hasNext()) {
                insize[it.next()]--;
            }
        }
        return res;
    }
}
