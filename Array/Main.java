package Array;

public class Main {

    public static void main(String[] args){
        Array<Integer> arr=new Array<Integer>(10);

        for (int i=0;i<10;i++){
            arr.addLast(i);
        }

        System.out.println(arr);

        arr.remove(1);
        arr.remove(1);
        arr.remove(1);
        arr.remove(1);
        arr.remove(1);

        System.out.println(arr);
    }

}
