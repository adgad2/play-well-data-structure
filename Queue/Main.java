package Queue;

import Stack.ArrayStack;

import java.util.Random;

public class Main {

    public static double timeTest(Queue<Integer> queue,int opCount){
        long startTime=System.nanoTime();

        Random random=new Random();
        for (int i=0;i<opCount;i++){
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
         for (int i=0;i<opCount;i++){
            queue.dequeue();
        }
        long endTime=System.nanoTime();

         return (endTime-startTime)/1000000000.0;
    }

    public static void main(String[] args){
        int opCount=100000;

        ArrayQueue<Integer> arrayQueue=new ArrayQueue<Integer>();
        double time1=timeTest(arrayQueue,opCount);
        System.out.println("time"+time1);

        LoopQueue<Integer> LoopQueue= new LoopQueue<Integer>();
        double time2=timeTest(LoopQueue,opCount);
        System.out.println(time2);
    }

}
