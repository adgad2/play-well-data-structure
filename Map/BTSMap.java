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

    //返回以node为根的二分搜索树的最小值所在的节点
    private Node minimun(Node node){
        if (node.left==null)
            return node;
        return minimun(node.left);
    }

    //从二分搜索树中删除最小值所在的节点，返回最小值
    private Node removeMin(Node node){
       if (node.left==null){
           Node rightNode=node.right;
           node.right=null;
           size--;
           return rightNode;
       }

       node.left=removeMin(node.left);
       return node;
    }

    //从集合中删除为key的节点
    @Override
    public V remove(K key){
        Node node=getNode(root,key);
        if (node!=null){
            remove(root,key);
            return node.val;
        }

        return null;

    }

    //删除掉以node为根的二分搜索树中键为key的节点，递归算法
    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node, K key) {
        if (node==null)
            return null;

        if (key.compareTo(node.key)<0){
            node.left=remove(node.left,key);
            return node;
        }
        else if (key.compareTo(node.key)>0){
            node.right=remove(node.right,key);
            return node;
        }else {//key.compareTo(node.key)==0

            if (node.left==null){
                
            }
        }
    }


}
