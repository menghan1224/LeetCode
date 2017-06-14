package Medium.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 28479 on 2017/6/14.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        k--;
        int multi=1;
        List<Integer> indexList=new ArrayList<>();
        for(int i=1;i<=n;i++){
            multi*=i;
            indexList.add(i);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            multi/=n-i;
            int index=k/multi;
            int number=indexList.get(index);
            indexList.remove(index);
            sb.append(number);
            k=k%multi;

        }
        return sb.toString();
    }
}
