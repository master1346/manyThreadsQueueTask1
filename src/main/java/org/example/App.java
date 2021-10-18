package org.example;

public class App 
{
    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();

        Thread mainThread = new Thread(() -> {
            Thread incomingCAll = new Thread(() -> {
                for (int i = 1; i < 20; i++) {
                    callCenter.addCall(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                callCenter.editCycle();
            });

            Thread answerCall = new Thread(() -> {
                while(callCenter.cycle || !(callCenter.clientCallCenter.isEmpty())) {
                    callCenter.getCall();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            incomingCAll.start();
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
                answerCall.start();
        });

        mainThread.start();
    }
}
