public class Array{

    private int[] data;
    private int size;//有多少个有效元素

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity){
        data = new int[capacity];
        size=0;
    }

    //无参数的构造函数，默认容量为10
    public Array(){
        this(capacity: 10);
    }

    //获取数组中的元素个数
    public int getSize(){
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    //返回数组是否为空
    public boolean isEmpty(){
        return size==0;
    }

    public void addLast(int e){
        data[size]=e;
        size++
    }

}