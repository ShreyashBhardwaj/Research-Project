package Example;

import java.util.ArrayList;
import java.util.List;

//TO show it it possible to create a lot of Virtual Threads
//Virtual Threads are preview feature in Java 19 so in order to be able to use them yoiu have to use Preview Features in Java.
public class VirtualThread2 {
        public static void main(String args[]){
            List<Thread> vThreads = new ArrayList<>();

            int vThreadCount = 100_000;

            for (int i = 0; i<vThreadCount;i++){
                int vThreadIndex = i;
                Thread vThread = Thread.ofVirtual().start(()->{
                    int result = 1;
                    for (int j=0;j<10;j++)
                    {
                        result*=(j+1);
                    }
                    System.out.println("Result [" +vThreadIndex+"]:"+result);
                });
                vThreads.add(vThread);
            }

            for (int i=0;i<vThreads.size();i++){
                try {
                    vThreads.get(i).join();
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }

            }
        }
}

