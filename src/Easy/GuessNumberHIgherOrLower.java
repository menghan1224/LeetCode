package Easy;

/**
 * Created by 28479 on 2017/6/3.
 */
public class GuessNumberHIgherOrLower {
    public int guessNumber(int n) {
        return guessnum(1,n);
    }
    public int guessnum(int begin,int end){
        int mid=begin+(end-begin)/2;
        if(guess(mid)==0) return mid;
        else if(guess(mid)==-1) return guessnum(begin,mid-1);
        else return guessnum(mid+1,end);
    }
    int guess(int num){
        return 0;
    }
}
