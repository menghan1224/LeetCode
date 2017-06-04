package Easy.Strings;

/**
 * Created by menghan on 2017/6/4.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String res=strs[0];
        for(int i=1;i<strs.length;i++)
        {
            int length=Math.min(res.length(),strs[i].length());
            res=res.substring(0,length);
            for(int j=0;j<length;j++)
            {
                if(res.charAt(j)!=strs[i].charAt(j)){
                    if(j==0) return "";
                    res=res.substring(0,j);
                    break;
                }
            }
        }
        return res;
    }
}
