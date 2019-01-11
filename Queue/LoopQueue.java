package Queue;

public class LoopQueue implements Queue<E> {
    private E[] data;
    private int front,tail,size;

    public LoopQueue(int capacity){
        data=(E[])new Object[capacity+1];
        front=tail=size=0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }

    @Override
    public boolean isEmpty(){
        return front==tail;
    }

    @Override
    public int getSize(){
        return size;
    }
    
}
