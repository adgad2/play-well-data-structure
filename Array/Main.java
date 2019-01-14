package Array;

public class Main {

    public static void main(String[] args){
        int[] arr=new int[]{3,2,2,5,7};
        int[] cnt = new int[arr.length];
        for (int ar:
             arr) {
            cnt[ar]+=0;
        }

        System.out.println(cnt.toString());
    }

}
