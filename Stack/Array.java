package Stack;

public class Array<E> { //<>里指存放E这种数据类型

    private E[] data;
    private int size;//有多少个有效元素

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity){
        data =(E[]) new Object[capacity];
        size=0;
    }

    //无参数的构造函数，默认容量为10
    public Array(){
        this(10);
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

    public void addLast(E e){
        add(size,e);
    }

    public void addFirst(E e){
        add(0,e);
    }

    //在index这个位置插入一个新元素e
    public void add(int index,E e){
        if (size==data.length){
            throw new IllegalArgumentException("AddLast failed.Array is full");
        }

        if (index < 0 || index > size){
            throw new IllegalArgumentException("AddLast failed.Require index>=0 and index <= size.");
        }

        for (int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }


        data[index]=e;
        size++;
    }

    //获取索引的index的元素
    public E get(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("AddLast failed.Index is Illegal");
        return data[index];
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }


    //修改索引的index的元素为e
    public void see(int index,E e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("AddLast failed.Index is Illegal");
        data[index]=e;
    }


    //查找数组中是否有元素e
    public boolean contains(E e){
        for (int i=0;i<size;i++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    //查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e){
         for (int i=0;i<size;i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //删除数组中index位置的元素，并返回删除的元素
    public E remove(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("AddLast failed.Index is Illegal");
        E ret=data[index];
        for (int i=index+1;i<size;i++)
            data[i-1]=data[i];
        size--;
        data[size]=null;//loitering objects !=memory leak
        return ret;
    }
    //从数组中删除第一个元素，并返回删除的元素
    public E removeFirst(){
        return  remove(0);
    }

    //从数组中删除最后一个元素，并返回删除的元素
    public E removeLast(){
        return  remove(size-1);
    }

    //从数组中删除元素e
    public void removeElement(E e){
        int index=find(e);
        if (index!=-1){
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size=%d ,capacity=%d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size) {
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }


}
