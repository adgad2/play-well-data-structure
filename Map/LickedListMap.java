package Map;

public class LickedListMap<K,V> implements Map<K,V> {

    private class Node{
        public K key;
        public V val;
        public Node next;

        public Node(K key,V val,Node next){
            this.key=key;
            this.val=val;
            this.next=next;
        }

        public Node(K key){
            this(key,null,null);
        }

        public Node(){
            this(null,null,null);
        }

        @Override
        public String toString(){
            return key.toString()+":"+val.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LickedListMap(){
        dummyHead=new Node();
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

    private Node getNode(K key){
        Node cur=dummyHead.next;
        while (cur!=null){
            if (cur.equals(key)){
                return cur;
            }
            cur=cur.next;
        }

        return null;
    }

    @Override
    public boolean contains(K key){
        return getNode(key)!=null;
    }

    @Override
    public V get(K key){
        Node node=getNode(key);
        return node==null?null:node.val;
    }

    @Override
    public void add(K key,V val){
        Node node=getNode(key);
        if (node==null){
            dummyHead.next=new Node(key,val,dummyHead.next);
            size++;
        }else {
            node.val=val;
        }
    }

    @Override
    public void set(K key,V newVal){
        Node node=getNode(key);
        if (node==null){
            throw  new IllegalArgumentException(key+"doesn't exist!");
        }
        node.val=newVal;
    }

    @Override
    public V remove(K key){
        Node prev=dummyHead;
        while (prev.next!=null){
            if (prev.next.val.equals(key)){
                break;
            }
            prev=prev.next;
        }

        if (prev.next!=null){
            Node delNode=prev.next;
            prev.next=delNode.next;
            delNode.next=null;
            size--;
            return delNode.val;

        }
        return null;
    }

}
