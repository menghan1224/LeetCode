package Hard.String;

import java.util.*;

/**
 * Created by menghan on 2017/7/1.
 */
public class WordLadderII {
    public static void main(String[] args){
        System.out.println(new WordLadderII().findLadders("hit","cog",Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
    List<List<String>> results;
    List<String> list;
    Map<String,List<String>> map;
    public List<List<String>> findLadders(String start, String end, List<String> dict) {
        results = new ArrayList<List<String>>();
        map=new HashMap<>();
        list=new ArrayList<>();
        if (dict.size() == 0)
            return results;
        if (!dict.contains(end)) return results;
        Queue<String> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        Set<String> unvisitied=new HashSet<>(dict);
        queue.offer(start);
        unvisitied.remove(start);
        int cur=1,next=0;
        boolean found=false;
        while(!queue.isEmpty()){
            String str=queue.poll();
            cur--;
            for(int i=0;i<str.length();i++){
                StringBuilder sb=new StringBuilder(str);
                for(char c='a';c<='z';c++){
                    sb.setCharAt(i,c);
                    String tmp=sb.toString();
                    if(unvisitied.contains(tmp)){
                        if(visited.add(tmp)){
                            next++;
                            queue.offer(tmp);
                        }
                        if(tmp.equals(end)){
                            found=true;
                        }
                        if(map.get(tmp)!=null){
                            map.get(tmp).add(str);
                        }else{
                            List<String> l=new ArrayList<>();
                            l.add(str);
                            map.put(tmp,l);
                        }

                    }
                }
            }
            if(cur==0){
                if(found) break;
                cur=next;
                next=0;
                unvisitied.removeAll(visited);
            }
        }
        backtrack(end,start);
        return results;
    }
    public void backtrack(String word,String start){
        if (word.equals(start)){
            list.add(0,start);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0,word);
        if (map.get(word)!=null) {
            for (String s : map.get(word))
                backtrack(s, start);
        }
        list.remove(0);
    }


}
