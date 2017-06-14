package Medium.String;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 28479 on 2017/6/14.
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict=new HashSet<>();
        dict.addAll(wordDict);
        boolean[] res=new boolean[s.length()];
        for(int i=0;i<s.length();i++){
            if(dict.contains(s.substring(0,i+1))) res[i]=true;
        }
        for(int i=0;i<s.length();i++){
            for(int j=0;j<i;j++){
                if(res[j]&&dict.contains(s.substring(j+1,i+1)))
                    res[i]=true;
            }
        }
        return res[res.length-1];
    }
}
