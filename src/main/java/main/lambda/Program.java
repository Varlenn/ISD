package main.lambda;

public class Program {

    public Program() {
        final MyThread myThread = new MyThread(()-> {
            System.out.println("Пример потока");
            new Thread(new MyThread(() -> {}, "Мой поток")).start();
        }, "Главный поток");
        new Thread(myThread).start();
    }
}
