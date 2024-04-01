package Example.MemoryModel;

public class MyRunnable implements Runnable{
    private int count = 0;

    @Override
    public void run(){
        for (int i=0;i<1_000_000;i++)
        {
            //synchronized (this){ we can use this code to ensure so that although shared the
            this.count++;
        //}
        }
        System.out.println(Thread.currentThread().getName()+":"+this.count);
    }

}
