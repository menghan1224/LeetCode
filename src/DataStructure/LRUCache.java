package DataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by menghan on 2017/7/1.
 */
public class LRUCache {
    Map<Integer,Node> map;
    int capacity;
    int num;
    Node head;
    Node tail;
    class Node{
        int key;
        int val;
        Node pre;
        Node next;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.pre=head;
        this.num=0;
        this.map=new HashMap<>();
    }
    public void addToHead(Node node){
        node.next=head.next;
        node.next.pre=node;
        head.next=node;
        node.pre=head;
    }
    public void deleteNode(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
    public int get(int key) {
        if(map.get(key)!=null){
            Node node=map.get(key);
            deleteNode(node);
            addToHead(node);
            return node.val;
        }
        else return -1;
    }

    public void put(int key, int value) {
        if(map.get(key)!=null){
            Node node=map.get(key);
            node.val=value;
            deleteNode(node);
            addToHead(node);
        }else{
            if(num>=capacity){
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                num--;
            }
            Node node=new Node(key,value);
            map.put(key,node);
            addToHead(node);
            num++;
        }
    }
}
