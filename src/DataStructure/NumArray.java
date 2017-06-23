package DataStructure;

/**
 * Created by menghan on 2017/6/23.
 */
public class NumArray {
    SegmentTreeNode root;
    class SegmentTreeNode{
        int start;
        int end;
        public SegmentTreeNode(int start,int end){
            this.start=start;
            this.end=end;
        }
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;
    }
    public NumArray(int[] nums) {
        root=buildTree(0,nums.length-1,nums);
    }
    public SegmentTreeNode buildTree(int start,int end,int[] nums){
        if(start>end) return null;
        SegmentTreeNode node=new SegmentTreeNode(start,end);
        if(start==end) node.sum=nums[start];
        else{
            int mid=(start+end)/2;
            node.left=buildTree(start,mid,nums);
            node.right=buildTree(mid+1,end,nums);
            node.sum=node.left.sum+node.right.sum;
        }
        return node;
    }

    public void update(int i, int val) {
        updateVal(root,i,val);
    }
    public void updateVal(SegmentTreeNode root,int i,int val){
        if(root.start==root.end) root.sum=val;
        else{
            int mid=(root.start+root.end)/2;
            if(mid>=i) updateVal(root.left,i,val);
            else updateVal(root.right,i,val);
            root.sum=root.left.sum+root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return getSum(root,i,j);
    }
    public int getSum(SegmentTreeNode root,int i,int j){
        if(root.start==i&&root.end==j) return root.sum;
        int mid=(root.start+root.end)/2;
        if(i>mid) return getSum(root.right,i,j);
        else if(j<=mid) return getSum(root.left,i,j);
        else return getSum(root.left,i,mid)+getSum(root.right,mid+1,j);
    }
}
