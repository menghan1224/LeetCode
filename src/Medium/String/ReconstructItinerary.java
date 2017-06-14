package Medium.String;

import java.util.*;

/**
 * Created by 28479 on 2017/6/14.
 */
public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res=new ArrayList<>();
        Map<String,Queue<String>> map=new HashMap<>();
        for(String[] ticket:tickets){
            if(map.get(ticket[0])==null){
                Queue<String> queue=new PriorityQueue<>(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });
                queue.offer(ticket[1]);
                map.put(ticket[0],queue);
            }else{
                map.get(ticket[0]).offer(ticket[1]);
            }
        }
        Stack<String> stack=new Stack<>();
        stack.push("JFK");
        while(!stack.isEmpty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
                String tmp = map.get(stack.peek()).poll();
                stack.push(tmp);
            }
            res.add(0,stack.pop());
        }
        return res;
    }
}
