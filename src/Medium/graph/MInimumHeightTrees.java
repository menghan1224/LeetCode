package Medium.graph;

import java.util.*;

/**
 * Created by 28479 on 2017/6/14.
 */
public class MInimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res=new ArrayList<>();
        Map<Integer,Node> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new Node(i));
        }
        for(int[] edge:edges){
            Node node1=map.get(edge[0]);
            Node node2=map.get(edge[1]);
            node1.neighbors.add(node2);
            node2.neighbors.add(node1);
            node1.degree++;
            node2.degree++;
        }
        Queue<Node> queue=new LinkedList<>();
        for(Node node:map.values()){
            if(node.degree==1) queue.offer(node);
        }
        while(n>2){
            int size=queue.size();
            for(int i=0;i<size;i++) {
                Node node = queue.poll();
                Node neighbor = node.neighbors.iterator().next();
                neighbor.neighbors.remove(node);
                map.remove(node.label);
                if (--neighbor.degree == 1)
                    queue.offer(neighbor);
                n--;
            }
        }
        for(int num:map.keySet())
            res.add(num);
        return res;
    }
    class Node{
        int label;
        int degree;
        Set<Node> neighbors;
        Node(int i){
            label=i;
            neighbors=new HashSet<>();
        }
    }
}
