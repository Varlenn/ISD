package main.lambda;

public class MyThread implements Runnable {

    private final Runnable r;
    private final String thread;

    public MyThread(Runnable r, String thread) {
        this.r = r;
        this.thread = thread;
    }

    @Override
    public void run() {
        System.out.println(thread + " стартовал...");
        r.run();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(thread + " финишировал...");
    }
}
