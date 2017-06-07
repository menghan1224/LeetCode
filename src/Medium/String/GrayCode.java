package Medium.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 28479 on 2017/6/7.
 */
public class GrayCode {
    List<Integer> list=new ArrayList<>();
    public List<Integer> grayCode(int n) {
        if(n==0){
            list.add(0);
            return list;
        }
        List<Integer> sublist=grayCode(n-1);
        int k=1<<(n-1);
        for(int i=sublist.size()-1;i>=0;i--){
            list.add(k+sublist.get(i));
        }
        return list;
    }
}
