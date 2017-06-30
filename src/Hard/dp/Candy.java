package Hard.dp;

/**
 * Created by menghan on 2017/6/29.
 */
public class Candy {
    public int candy(int[] ratings) {
        if(ratings.length==0) return 0;
        int res=1;
        int prev=1,length=0,beforeDes=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>=ratings[i-1]){
                if(ratings[i]==ratings[i-1]){
                    prev=1;
                    res+=prev;
                    beforeDes=prev;
                    length=0;
                }else {
                    res += ++prev;
                    beforeDes = prev;
                    length = 0;
                }
            }else{
                length++;
                if(beforeDes<=length) res++;
                res+=length;
                prev=1;
            }
        }
        return res;
    }
}
