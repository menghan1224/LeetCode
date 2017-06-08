package Medium.BinaryTree;

/**
 * Created by 28479 on 2017/6/8.
 */
public class ValidPreorderSerializationOfBinaryTree {
    int i=0;
    public boolean isValidSerialization(String preorder) {
        String[] res=preorder.split(",");
        int count=0;
        for(int i=0;i<res.length-1;i++){
            if(res[i].equals("#")){
                if(count>0) count--;
                else return false;
            }
            else count++;
        }
        return count==0&&res[res.length-1].equals("#");

    }
}
