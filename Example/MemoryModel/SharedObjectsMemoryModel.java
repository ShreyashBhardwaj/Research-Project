package Example.MemoryModel;

public class SharedObjectsMemoryModel {
    public static void main(String args[]){
        Runnable runnable = new MyRunnable();

        Thread thread1 = new Thread(runnable ,"Thread1");
        Thread thread2 = new Thread(runnable ,"Thread2");

        thread1.start();
        thread2.start();
    }
}
