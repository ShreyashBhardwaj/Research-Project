package Example;

public class Thread8 {
    public static void main(String[] args){
        Runnable runnable = ()-> {
            for (int i=0;i<5;i++)
            {sleep(1000);
             System.out.println("Running");}
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        /*
        *Now, when thread.join() is called, the main thread (which executes the main() method)
        * waits for the daemon thread to complete before continuing its own execution.
        * This means that the main thread will not exit until the daemon thread has finished executing its task.
        * The join() method in Java is used to ensure that a thread has completed its execution before the invoking thread
        * continues its own execution. When a thread calls join() on another thread, the invoking thread will wait
        * (or block) until the thread being joined completes its execution.
        * */

        try{
            thread.join();
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
/*
    In the provided Java code, the main() method creates a new thread with a Runnable object that contains a for loop. However, the thread is set as a daemon thread using thread.setDaemon(true); before it starts.

        When you set a thread as a daemon thread in Java, it means that this thread will not prevent the JVM from exiting when the program finishes executing its non-daemon threads. Daemon threads are typically used for background tasks that are not critical for the program's operation. When all non-daemon threads finish executing, the JVM exits regardless of whether any daemon threads are still running.

        In this code, the main thread (which executes the main() method) is a non-daemon thread. It starts a new thread (thread) and sets it as a daemon thread using thread.setDaemon(true);. Since the main thread is a non-daemon thread, it will continue its execution, but the daemon thread (thread) starts running concurrently.

        However, daemon threads automatically terminate when there are no more non-daemon threads running. In this case, the only non-daemon thread is the main thread. So, once the main thread finishes executing (which happens very quickly since it just starts the daemon thread and exits), the JVM will exit.

        The for loop inside the Runnable object is never given a chance to execute fully because the JVM exits as soon as the main thread finishes its execution. Therefore, the loop won't have time to iterate fully and print "Running" five times as intended.
*/