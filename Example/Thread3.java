package Example;

public class Thread3 {

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRunnable running");
            System.out.println("MyRunnable finished");
        }

    }

    public static void main(String[] args) {
        Thread thread= new Thread(new MyRunnable());
        thread.start();

    }
}
