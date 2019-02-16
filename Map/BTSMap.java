package Map;

public class BTSMap<K extends Comparable<K>,V> implements Map<K,V> {

    private class Node {
        public K key;
        public V val;
        public Node left, right;

        public Node(K key,V val) {
            this.key = key;
            this.val = val;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public void BSTMap(){
        root=null;
        size=0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public void add(K key,V val){
        root = add(root, key, val);
    }

    private Node add(Node node, K key,V val){
        if(node == null){
            size ++;
            return new Node(key,val);
        }

        if(key.compareTo(node.key) < 0)
            node.left = add(node.left, key,val);
        else if(key.compareTo(node.key) > 0)
            node.right = add(node.right, key,val);
        else //key.compareTp(node.key)==0
            node.val=val;

        return node;
    }

    //返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node,K key){
        if (node==null)
            return null;

        if (node.key.compareTo(key)==0)
            return node;
        else if (node.key.compareTo(key)<0)
            return getNode(node.left,key);
        else //key.compareTp(node.key)>0
            return getNode(node.right,key);
    }

    @Override
    public boolean contains(K key){
        return getNode(root,key)!=null;
    }

    @Override
    public V get(K key){
        Node node=getNode(root,key);
        return node==null?null:node.val;
    }

    @Override
    public void set(K key,V val){
        Node node=getNode(root,key);

        if (node==null)
            throw new IllegalArgumentException(key+"doesn't exist!");

        node.val=val;
    }



}
