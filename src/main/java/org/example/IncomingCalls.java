package org.example;

import java.util.concurrent.LinkedBlockingQueue;

public class IncomingCalls implements Runnable{
    private final LinkedBlockingQueue<Integer> callCenter;

    public IncomingCalls(LinkedBlockingQueue<Integer> callCenter){
        this.callCenter = callCenter;
    }

    public void run() {
        for (int i = 0; i < 25; i++) {
            try {
                System.out.println("Добавлен звонок " + i);
                callCenter.put(i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
