// 双向链表+哈希表

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AllOne {
    Node root;
    Map<String, Node> nodes;

    public AllOne() {
        root = new Node();
        nodes = new HashMap<>();
        root.next = root;
        root.pre = root;
    }

    public void inc(String key) {
        if(nodes.containsKey(key)){
            Node cur = nodes.get(key);
            // 加1之后要移到后面的节点上
            Node next = cur.next;
            // 后面的节点不是要放的位置，需要增加新节点
            if(next == root || next.count > cur.count + 1){
                Node newNode = cur.insert(new Node(key, cur.count + 1));
                nodes.put(key, newNode);
            } else {
                next.keys.add(key);
                // 索引更新到新节点
                nodes.put(key, next);
            }
            // 当前节点中除掉key
            cur.keys.remove(key);
            if(cur.keys.isEmpty()){
                cur.remove();
            }
        } else {
            // 添加到链表头部
            if(root.next == root || root.next.count > 1){
                Node newNode = root.insert(new Node(key, 1));
                nodes.put(key, newNode);
            } else {
                root.next.keys.add(key);
                nodes.put(key, root.next);
            }
        }
    }

    public void dec(String key) {
        Node cur = nodes.get(key);
        if(cur.count == 1){
            nodes.remove(key);
        } else {
            Node pre = cur.pre;
            if(pre == root || pre.count < cur.count - 1){
                Node newNode = cur.pre.insert(new Node(key, cur.count - 1));
                nodes.put(key, newNode);
            } else {
                pre.keys.add(key);
                nodes.put(key, pre);
            }
        }
        cur.keys.remove(key);
        if(cur.keys.isEmpty()){
            cur.remove();
        }
    }

    public String getMaxKey() {
        return root.pre == null ? "" : root.pre.keys.iterator().next();
    }

    public String getMinKey() {
        return root.next == null ? "" : root.next.keys.iterator().next();
    }
}

// 每个节点上防治计数次数和该次数的字符串
class Node {
    Node pre;
    Node next;
    Set<String> keys;
    int count;

    public Node(){
        this("", 0);
    }

    public Node(String key, int count) {
        this.count = count;
        keys = new HashSet<>();
        keys.add(key);
    }

    public Node insert(Node node){
        node.pre = this;
        node.next = this.next;
        node.pre.next = node;
        node.next.pre = node;
        return node;
    }

    public void remove(){
        this.pre.next = this.next;
        this.next.pre = this.pre;
    }
}