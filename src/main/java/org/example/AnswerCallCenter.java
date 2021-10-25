package org.example;

import java.util.concurrent.LinkedBlockingQueue;

public class AnswerCallCenter implements Runnable{
    private final LinkedBlockingQueue<Integer> callCenter;

    public AnswerCallCenter(LinkedBlockingQueue<Integer> callCenter){
        this.callCenter = callCenter;
    }

    public void run(){
        try {
            while (true) {
                    System.out.println("Принят звонок " + callCenter.take());
                    Thread.sleep(1000);
                if(callCenter.peek() == null){
                    break;
                }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
