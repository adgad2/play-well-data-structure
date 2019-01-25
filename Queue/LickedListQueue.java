package Queue;

import LinkedList.LinkedList;
import Stack.LinkedListStack;

public class LickedListQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e=e;
            this.next=next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }

    }

    private Node head,tail;
     private int size;

     public void LinkedListStack(){
         head=null;
         tail=null;
         size=0;
     }

    @Override
     public int getSize(){
         return size;
     }

     @Override
    public boolean isEmpty(){
         return  size==0;
     }


    @Override
    public void enqueue(E e){
         if (tail==null){
             tail=new Node(e);
             head=tail;
         } else {
             tail.next=new Node(e);
             tail=tail.next;
         }
         size++;
     }

     @Override
    public E dequeue(){
         if (isEmpty()){
             throw new IllegalArgumentException("cannot dequeue from an empty queue");
         }

         Node retNode=head;
         head=retNode.next;
         retNode.next=null;
         if (head==null)
             tail=null;
         size--;

         return retNode.e;
     }


     @Override
    public E getFront(){
         if (isEmpty()){
             throw new IllegalArgumentException("cannot dequeue from an empty queue");
         }

         return head.e;
     }

     @Override
    public String toString(){
         StringBuilder res=new StringBuilder();
         res.append("LickedQueue front:");
         for (Node i=head;i!=null;i=i.next){
             res.append(i.e);
             if (i.next!=null){
                 res.append("->");
             }
         }
         res.append(" end");
         return res.toString();
     }

    public static void main(String[] args) {
        LickedListQueue<Integer> queue = new LickedListQueue<Integer>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
