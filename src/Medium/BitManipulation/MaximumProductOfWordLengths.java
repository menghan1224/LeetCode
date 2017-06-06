package Medium.BitManipulation;

/**
 * Created by 28479 on 2017/6/6.
 */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int array1[]=new int[words.length];
        for(int i=0;i<words.length;i++)
        {
            for(int j=0;j<words[i].length();j++)
            {
                array1[i]|=1<<(words[i].charAt(j)-'a');
            }
        }
        int maxlength=0;
        for(int i=0;i<words.length;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                if((array1[i]&array1[j])==0)
                {
                    int length=words[i].length()*words[j].length();
                    if(length>maxlength)
                    {
                        maxlength=length;
                    }
                }
            }
        }
        return maxlength;
    }
}
