package Array;

public class Main {

    public static void main(String[] args){
        Array<Integer> arr=new Array<Integer>(20);

        for (int i=0;i<10;i++){
            arr.addLast(i);
        }

        arr.remove(2);

        System.out.println(arr);
    }

}
