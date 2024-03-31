package Example;
//TO Stop a thread never use the stop function but rather this as the stop func is deprecated
public class ThreadStopping {

        public static class StopppableRunnable implements Runnable{
            private boolean stopRequested = false;
            public synchronized void requestStop(){
                this.stopRequested = true;
            }
            public synchronized boolean isStopRequested(){
                return this.stopRequested;
            }
            /*Synchornized means that only one thread can call either requestStop or isStopRequested at the same time
            within the same StoppableRunnable interfaces but if 2 threads are the funcitons in two seperate
            StoppableRunnable Interfaces then it is fine
             */
            private void sleep(long millis){
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }
            @Override
            public void run() {
                System.out.println("StoppableRunnable is Running");
                while (!isStopRequested()) {
                    sleep(1000);
                    System.out.println("....");
                }
                System.out.println("StoppableRunnable stopped");

            }
        }

        public static void main(String[] args)
        {
            StopppableRunnable stopppableRunnable = new StopppableRunnable();
            Thread thread = new Thread(stopppableRunnable, "1");
            thread.start();

            try {
                Thread.sleep(5000);
                // Main Thread sleeps not the above one?
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("Requesting stop");
            stopppableRunnable.requestStop();
            System.out.println("Stop Requested");
        }
}
