package Example;

public class VirtualThread {
    public static void main(String args[])
    {
        //Ex1: Create Runnable . Create and start a Virtual Thread
        Runnable runnable = () -> {
            for (int i =0; i<5;i++)
            {
                System.out.println("index "+i);
            }
        };

        Thread vThread1 = Thread.ofVirtual().start(runnable);

        //Ex2: Create but do not start
        Thread vThread2Unstart = Thread.ofVirtual().unstarted(runnable);

        vThread2Unstart.start();

        //how to Join a Virtual Thread
        try{
            vThread1.join();//vThread2Unstart.join()
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
