package Example;

public class ThreadNameandSleep {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String threadname= Thread.currentThread().getName();
            System.out.println("Lambda running " +threadname);
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Lambda finished " +threadname);
        };

        Thread thread= new Thread(runnable,"The Thread" );
        thread.start();
        Thread thread2= new Thread(runnable,"The Thread2" );
        thread2.start();
    }
}
