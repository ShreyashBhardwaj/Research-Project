package Example;
// Java threads access memory and how the memory is organised in JVM with relation to threads
public class SeperateObjectsorMemoryModel {
    public static void main(String args[]){
        Runnable runnable1 = new MyRunnable();
        Runnable runnable2 = new MyRunnable();

        Thread thread1 = new Thread(runnable1 , "One");
        Thread thread2 = new Thread(runnable2 , "Two");

        thread1.start();
        thread2.start();

    }
}
